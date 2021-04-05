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
                System.out.println("ENDED");
                // item type stays null
                return null;
            } else if (itemStatus == ItemStatus.IN_PROGRESS) {
                ItemType itemType = getType(document);
            }

            ItemType itemType = getType(document);
            String itemPrice = getPrice(document, itemType);
            System.out.println(itemPrice);



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
            // Check if this is a BEST_OFFER or BUY
            Element bestOfferElement = document.getElementById(Identifiers.ITEM_TYPE_BEST_OFFER_IDENTIFIER);
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
            priceElement = document.getElementById(Identifiers.ITEM_PRICE_BEST_OFFER_IDENTIFIER);
        } else if (itemType == ItemType.BUY) {
            priceElement = document.getElementById(Identifiers.ITEM_PRICE_BUY_IDENTIFIER);
        } else if (itemType == ItemType.BID) {
            priceElement = document.getElementById(Identifiers.ITEM_PRICE_BID_IDENTIFIER);
        }
        return priceElement.text();
    }



}
