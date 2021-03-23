package io.github.conphucious.ebr.model;

import java.util.Date;

public class Item {
	private String title;
	private String timeLeft;
	private Date dateEnd;
	private String price;
	private String link;
	private ItemType type;
	
	public Item(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(String timeLeft) {
		this.timeLeft = timeLeft;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", timeLeft=" + timeLeft + ", dateEnd=" + dateEnd
				+ ", price=" + price + ", link=" + link + "]";
	}
}
