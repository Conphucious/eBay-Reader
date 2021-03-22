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
		Item item = fetchInfo(url);
		itemList.add(item);
	}
	
	public Item fetchInfo(String url) {
		Item item = new Item(url);
		try {
			Document document = Jsoup.connect("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055").get();
			
			Element price = document.getElementById("prcIsum_bidPrice");
			Element timeLeft = document.getElementById("vi-cdown_timeLeft");
			Elements timeMs = document.getElementsByClass("timeMs");
			
			System.out.println(price.wholeText() + "_" + timeLeft.wholeText() + "_" + timeLeft.text());
			
			for (Element e : timeMs) {
				System.out.println(e.wholeText());
			}
			
			item.setTitle(document.title());
//			item.setPrice(price);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public void fetchInfo() {
		try {
			Document document = Jsoup.connect("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055").get();
			Element price = document.getElementById("prcIsum_bidPrice");
			Elements tl = document.select("span[id=\"vi-cdown_timeLeft\"]");
			Elements dl = document.select("span[class=\"vi-tm-left\"]");
			Elements title = document.select("span[id=\"vi-lkhdr-itmTitl\"]");
			Element desc = document.getElementById("motorSellerProvidedTitle");
			
			Pattern pattern = Pattern.compile("(?<=timems=\")(.*)(?=\")");

	        Matcher matcher = pattern.matcher(dl.html());
	        while(matcher.find()) {
	        	System.out.println(matcher.start() + "_" + matcher.end() + "> " + matcher.group());
	        	long timeMs = Long.parseLong(matcher.group());
	        	Date d = new Date(timeMs);
	        	System.out.println(d);
	        }
			
			
			System.out.println(title.text() + "_" + desc.text() + "_" + price.wholeText() + "_" + tl.text() + "_" + dl.text());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
