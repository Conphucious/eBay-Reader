package io.github.conphucious.ebr.model;

public class Identifier {
    // ITEM TITLE
    public static final String ITEM_TITLE = "itemTitle";
    public static final String ITEM_TITLE_REMOVE_PREFIX = "Details about ";

    // ITEM STATUS HTML ID
    public static final String ITEM_STATUS = "w1-5-_msg";

    // ITEM PRICE HTML ID
    public static final String ITEM_PRICE_BID_ID = "prcIsum_bidPrice";
    public static final String ITEM_PRICE_BUY_ID = "prcIsum";
    public static final String ITEM_PRICE_BEST_OFFER_ID = "mm-saleDscPrc";
    public static final String ITEM_PRICE_ENDED_CLASS = "notranslate vi-VR-cvipPrice";

    // ITEM TYPES HTML ID
    public static final String ITEM_TYPE_BID_ID = "prcIsum_bidPrice";
    public static final String ITEM_TYPE_BEST_OFFER_ID = "boBtn_btn";


    // SELECT FROM JSOUP DOCUMENT
    public static final String SELECT_ELEMENTS_TITLE = "boBtn_btn";
    public static final String SELECT_ELEMENTS_TIME_LEFT = "span[id=\"vi-cdown_timeLeft\"]";
    public static final String SELECT_ELEMENTS_DATE_END = "span[class=\"vi-tm-left\"]";

    // REGEXP PATTERNS
    public static final String REGEX_ITEM_DATE = "(?<=timems=\")(.*)(?=\")";
}
