package io.github.conphucious.ebr;

import io.github.conphucious.ebr.controller.FetchController;

public class App {
	public static void main(String[] args) {
		FetchController fc = new FetchController();
//		fc.fetchInfo();
//		fc.fetchInfo();
		fc.addItem("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055");
		fc.addItem("https://www.ebay.com/itm/Latest-Model-MacBook-Pro-13-M1-8-Core-CPU-8GB-RAM-256GB-SSD-Touch-Bar/164773795191?hash=item265d489577:g:Y2kAAOSwGe9gV-Ru");
		fc.addItem("https://www.ebay.com/itm/Apple-Mac-Pro-2013-6-Core-3-5GHz-D300-32GB-256GB-SSD-MD878LL-A-1-YR-WARRANTY/224381017976?_trkparms=aid%3D111001%26algo%3DREC.SEED%26ao%3D1%26asc%3D20160908105057%26meid%3De71841772f6740ab8fcf3199e0df77fc%26pid%3D100675%26rk%3D3%26rkt%3D15%26mehot%3Dpp%26sd%3D303458337289%26itm%3D224381017976%26pmt%3D1%26noa%3D1%26pg%3D2380057%26brand%3DApple&_trksid=p2380057.c100675.m4236&_trkparms=pageci%3Ad0b35716-8b84-11eb-ab29-82e532ed2dae%7Cparentrq%3A5d0ca0091780aaf30ad8fbfaffda52d4%7Ciid%3A1");
	}
}
