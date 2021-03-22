package io.github.conphucious.ebr;

import io.github.conphucious.ebr.controller.FetchController;

public class App {
	public static void main(String[] args) {
		FetchController fc = new FetchController();
		fc.fetchInfo();
//		fc.fetchInfo();
//		fc.addItem("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055");
	}
}
