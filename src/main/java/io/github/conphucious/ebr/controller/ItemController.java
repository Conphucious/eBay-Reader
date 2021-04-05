package io.github.conphucious.ebr.controller;

import io.github.conphucious.ebr.model.Identifiers;
import io.github.conphucious.ebr.model.Item;
import io.github.conphucious.ebr.model.ItemStatus;
import io.github.conphucious.ebr.model.ItemType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ItemController {


    public Item processItem(String url) {
        Item item = new Item(url);
        try {
            Document document = Jsoup.connect(item.getLink()).get();
            ItemStatus itemStatus = getStatus(document);

            if (itemStatus == ItemStatus.ENDED) {
                return null;
            } else if (itemStatus == ItemStatus.IN_PROGRESS) {
                ItemType itemType = getType(document);
            }

            ItemType itemType = getType(document);
            System.out.println(itemType);



        } catch (IOException e) {
        }


        return null;
    }

    private ItemStatus getStatus(Document document) {
        Element statusElement = document.getElementById(Identifiers.ITEM_STATUS_IDENTIFIER);
        return statusElement == null ? ItemStatus.IN_PROGRESS : ItemStatus.ENDED;
    }

    private ItemType getType(Document document) {
        ItemType itemType = null;

        // Check if this is a BID
        Element priceElement = document.getElementById(Identifiers.ITEM_TYPE_BID_IDENTIFIER);
        if (priceElement == null) {
            // Check if this is a BUY or BEST OFFER (+ BUY)
            Elements bestOfferElement = document.select("div[class=\"lbl\"]");
            itemType = bestOfferElement.text().isEmpty() ? ItemType.BUY : ItemType.BEST_OFFER;
        } else {
            itemType = ItemType.BID;
        }

        return itemType;
    }



}
