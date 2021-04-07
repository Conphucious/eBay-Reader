package io.github.conphucious.ebr.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@RequiredArgsConstructor
public class Item {
    @NonNull
    private String url;
    private String title;
    private ItemStatus itemStatus;
    private ItemType itemType;
    private String price;
    private String timeLeft;
    private Date dateEnd;
}
