package io.github.conphucious.ebr.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Item {
    private String title;
    private String timeLeft;
    private Date dateEnd;
    private String price;
    private String link;
    private ItemType type;
    private ItemStatus status;

    public Item(String link) {
        this.link = link;
    }

}
