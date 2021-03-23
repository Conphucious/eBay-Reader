package io.github.conphucious.ebr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//			Document document = Jsoup.connect("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055").get();


			Document document = Jsoup.connect("https://www.ebay.com/itm/Latest-Model-MacBook-Pro-13-M1-8-Core-CPU-8GB-RAM-256GB-SSD-Touch-Bar/164773795191?hash=item265d489577:g:Y2kAAOSwGe9gV-Ru").get();
			Element price = document.getElementById("prcIsum_bidPrice");
			Elements tl = document.select("span[id=\"vi-cdown_timeLeft\"]");
			Elements dl = document.select("span[class=\"vi-tm-left\"]");
			Elements title = document.select("span[id=\"vi-lkhdr-itmTitl\"]");
			
			// Get end date + time and convert from long to date
			Pattern pattern = Pattern.compile("(?<=timems=\")(.*)(?=\")");
	        Matcher matcher = pattern.matcher(dl.html());
	        Date dateEnd = null;
	        while(matcher.find()) {
	        	System.out.println(matcher.start() + "_" + matcher.end() + "> " + matcher.group());
	        	long timeMs = Long.parseLong(matcher.group());
	        	dateEnd = new Date(timeMs);
	        }
	        
	        // need to account for if it's: BID, BUY WITH OFFER, BUY
	        
	        item.setTitle(title.text());
	        item.setTimeLeft(tl.text());
	        item.setDateEnd(dateEnd);
	        item.setPrice(price.text());
			
	        System.out.println(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public void fetchInfo() {
		
	}
	
}
