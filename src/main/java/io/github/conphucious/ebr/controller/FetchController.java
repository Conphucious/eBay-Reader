package io.github.conphucious.ebr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.conphucious.ebr.model.ItemType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.github.conphucious.ebr.model.Item;

public class FetchController {
	
	private List<Item> itemList;
	
	public FetchController() {
		itemList = new ArrayList<>();
	}
	
	public void addItem(String url) {
		// add after each?
		Item item = fetchInfo(url);
		itemList.add(item);
	}
	
	public Item fetchInfo(String url) {
		Item item = new Item(url);
		try {
			Document document = Jsoup.connect(item.getLink()).get();
			Elements titleElement = document.select("span[id=\"vi-lkhdr-itmTitl\"]");
			Elements timeLeftElement = document.select("span[id=\"vi-cdown_timeLeft\"]");
			Elements dateEndElement = document.select("span[class=\"vi-tm-left\"]");
			Element priceElement = document.getElementById("prcIsum_bidPrice");

			// Set ItemType based on if other selectors exist
			ItemType type = null;
			if (priceElement == null) {
				priceElement = document.getElementById("prcIsum");
				Elements bestOfferElement = document.select("div[class=\"lbl\"]");
				type = bestOfferElement.text().isEmpty() ? ItemType.BUY : ItemType.BEST_OFFER;
			} else {
				type = ItemType.BID;
			}

			// Set price element based on bid/buy
			priceElement = priceElement == null ? document.getElementById("prcIsum") :  priceElement;

			// Get end date + time and convert from long to date
			Pattern pattern = Pattern.compile("(?<=timems=\")(.*)(?=\")");
	        Matcher matcher = pattern.matcher(dateEndElement.html());
	        Date dateEnd = null;
	        while(matcher.find()) {
	        	long timeMs = Long.parseLong(matcher.group());
	        	dateEnd = new Date(timeMs);
	        }


	        item.setTitle(titleElement.text());
	        item.setTimeLeft(timeLeftElement.text());
	        item.setDateEnd(dateEnd);
	        item.setPrice(priceElement.text());
			
	        System.out.println(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public void fetchInfo() {
		
	}
	
}
