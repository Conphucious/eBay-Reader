package io.github.conphucious.ebr.controller;

import io.github.conphucious.ebr.model.Identifier;
import io.github.conphucious.ebr.model.Item;
import io.github.conphucious.ebr.model.ItemStatus;
import io.github.conphucious.ebr.model.ItemType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

public class ItemController {


    public Item processItem(String url) {
        Item item = new Item(url);
        try {
            Document document = Jsoup.connect(item.getLink()).get();
            ItemStatus itemStatus = getStatus(document);

            if (itemStatus == ItemStatus.ENDED) {
                System.out.println("ENDED"); // item type stays null
                return null;


            } else if (itemStatus == ItemStatus.IN_PROGRESS) {
            }

            ItemType itemType = getType(document);
            String itemPrice = getPrice(document, itemType);
            System.out.println(itemPrice);



        } catch (IOException e) {
        }


        return null;
    }

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
        System.out.println(itemType);
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

    private Date[] getDates(Document document) {

        return null;
    }



}
