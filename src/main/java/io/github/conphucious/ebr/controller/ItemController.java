package io.github.conphucious.ebr.controller;

import io.github.conphucious.ebr.model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemController {
    public Item processItem(String url) {
        Item item = new Item(url);
        try {
            Document document = Jsoup.connect(item.getUrl()).get();
            String title = getTitle(document);
            ItemStatus itemStatus = getStatus(document);
            ItemType itemType = getType(document);

            // set price based on if it ended
            String itemPrice = (itemStatus == ItemStatus.ENDED) ? getPriceEnded(document) : getPrice(document, itemType);

            // If time left is empty or locale.time_left_none then we don't need to check for date. Maybe add available then instead?
            String timeLeft = getTimeLeft(document);
            Date endDate = getEndDate(document);

            item.setTitle(title);
            item.setItemStatus(itemStatus);
            item.setItemType(itemType);
            item.setPrice(itemPrice);
            item.setTimeLeft(timeLeft);
            item.setDateEnd(endDate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;
    }

    private String getTitle(Document document) {
        Element title = document.getElementById(Identifier.ITEM_TITLE);
        return title.text().replace(Identifier.ITEM_TITLE_REMOVE_PREFIX, "");
    }

    /**
     * Determines ItemStatus
     *
     * @param document
     * @return ItemStatus
     * @see io.github.conphucious.ebr.model.ItemStatus
     */
    private ItemStatus getStatus(Document document) {
        Element statusElement = document.getElementById(Identifier.ITEM_STATUS);
        return statusElement == null ? ItemStatus.IN_PROGRESS : ItemStatus.ENDED;
    }

    private ItemType getType(Document document) {
        ItemType itemType = null;

        // Check if this is a BID
        Element priceElement = document.getElementById(Identifier.ITEM_TYPE_BID_ID);
        if (priceElement == null) {
            // Check if this is a BEST_OFFER or BUY -> Assume if not BEST_OFFER then it's BUY.
            Element bestOfferElement = document.getElementById(Identifier.ITEM_TYPE_BEST_OFFER_ID);
            itemType = bestOfferElement == null ? ItemType.BUY : ItemType.BEST_OFFER;
        } else {
            itemType = ItemType.BID;
        }

        return itemType;
    }

    private String getPrice(Document document, ItemType itemType) {
        Element priceElement = null;

        if (itemType == ItemType.BEST_OFFER) {
            priceElement = document.getElementById(Identifier.ITEM_PRICE_BEST_OFFER_ID);
        } else if (itemType == ItemType.BUY) {
            priceElement = document.getElementById(Identifier.ITEM_PRICE_BUY_ID);
        } else if (itemType == ItemType.BID) {
            priceElement = document.getElementById(Identifier.ITEM_PRICE_BID_ID);
        }

        return priceElement.text();
    }

    private String getPriceEnded(Document document) {
        Elements pricesElement = document.getElementsByClass(Identifier.ITEM_PRICE_ENDED_CLASS);
        return pricesElement.text();
    }

    private String getTimeLeft(Document document) {
        String timeLeftElement = document.select(Identifier.SELECT_ELEMENTS_TIME_LEFT).text();
        return timeLeftElement.isEmpty() ? Locale.TIME_LEFT_NONE : timeLeftElement;
    }

    private Date getEndDate(Document document) {
        Date dateEnd = null;

        Elements dateEndElement = document.select(Identifier.SELECT_ELEMENTS_DATE_END);
        Pattern pattern = Pattern.compile(Identifier.REGEX_ITEM_DATE);

        Matcher matcher = pattern.matcher(dateEndElement.html());
        while (matcher.find()) {
            long timeMs = Long.parseLong(matcher.group());
            dateEnd = new Date(timeMs);
        }

        return dateEnd;
    }
}
