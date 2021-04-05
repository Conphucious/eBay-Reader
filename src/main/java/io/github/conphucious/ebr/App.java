package io.github.conphucious.ebr;

import io.github.conphucious.ebr.controller.FetchController;
import io.github.conphucious.ebr.controller.ItemController;

public class App {
	public static void main(String[] args) {
		// tray icon application?
//		FetchController fc = new FetchController();
//		fc.addItem("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055");
//		fc.addItem("https://www.ebay.com/itm/Latest-Model-MacBook-Pro-13-M1-8-Core-CPU-8GB-RAM-256GB-SSD-Touch-Bar/164773795191?hash=item265d489577:g:Y2kAAOSwGe9gV-Ru");
//		fc.addItem("https://www.ebay.com/itm/Apple-Mac-Pro-2013-6-Core-3-5GHz-D300-32GB-256GB-SSD-MD878LL-A-1-YR-WARRANTY/224381017976?_trkparms=aid%3D111001%26algo%3DREC.SEED%26ao%3D1%26asc%3D20160908105057%26meid%3De71841772f6740ab8fcf3199e0df77fc%26pid%3D100675%26rk%3D3%26rkt%3D15%26mehot%3Dpp%26sd%3D303458337289%26itm%3D224381017976%26pmt%3D1%26noa%3D1%26pg%3D2380057%26brand%3DApple&_trksid=p2380057.c100675.m4236&_trkparms=pageci%3Ad0b35716-8b84-11eb-ab29-82e532ed2dae%7Cparentrq%3A5d0ca0091780aaf30ad8fbfaffda52d4%7Ciid%3A1");
//		fc.addItem("https://www.ebay.com/itm/X-Keys-SE-usb-macro-keyboard-P-I-Engineering-Free-Shipping/303458337289?_trkparms=aid%3D111001%26algo%3DREC.SEED%26ao%3D1%26asc%3D20160908105057%26meid%3Dd9336e9113e1427da3230767ab9c23c9%26pid%3D100675%26rk%3D2%26rkt%3D15%26mehot%3Dnone%26sd%3D224381017976%26itm%3D303458337289%26pmt%3D1%26noa%3D1%26pg%3D2380057&_trksid=p2380057.c100675.m4236&_trkparms=pageci%3Abffd29a8-8b86-11eb-ae73-26a9612085a5%7Cparentrq%3A5d194df31780a0f33fe1e1b2ffb5601c%7Ciid%3A1");
//		fc.fetchInfo();

		ItemController it = new ItemController();
		it.processItem("https://www.ebay.com/itm/373502015055?ViewItem=&vxp=mtr&item=373502015055");
		it.processItem("https://www.ebay.com/itm/1984-Porsche-944/373522209539?hash=item56f7a89b03:g:cl8AAOSwVx5gN-0-");
		it.processItem("https://www.ebay.com/itm/Natural-Loose-Gemstone-8-to-10-cts-each-Certified-Emeralds-Pair-Best-Offer/273669445007?_trkparms=ispr%3D1&hash=item3fb7f8558f:g:tUkAAOSwmYxcSCwC&amdata=enc%3AAQAFAAACcBaobrjLl8XobRIiIML1V4Imu%252Fn%252BzU5L90Z278x5ickkY3FSd4Ad8xn3oRtkVexxrIiCXPaVtcI0ZeRAjyAnMHMueHvVngS4uDNfWhjCcML3xicZpakTlJ5qArOOemPbGtesWiMmRwIGlWQX22DhypOnHYO%252F1KxKrw4LauQdasncJNUiVNQ9UNNApNbRG0hFltvqyZf9Y95hAcqVj4JkbzAoG%252BaV7Z%252BhAMILTeCeD236poRS8dxJKo5v9hYRz1saFbeD8TaDKsNcmfaThn9wiAg%252F2SjDpXUmR1aQaOb4%252BafYGqa94VKekHvYpRrkg5NG9SSVxlLpjZ46yRjbLe%252BDHIvPjoEccSS5XsxbIOmcmTEsww%252BUfOmVC4d%252Bf67mLfIelftIb1oy3dIAVKr%252Bjpop%252FjR6Dvk5%252B5l2w7vrmAQEdZnV7UHFIp6f8PNCtzed8WpAE5We7nD3Oc7%252F2AOY1Tm8FEsrZrnXgKKnLgHFohokfCrn8oIyRgBMnEKdH0JXkq%252FMN3fF0jWkB%252Bfi%252Fp8bRh2GAIF3w6tAMvJmtaLCbCI1Z5n89MrxlvjGLqRrjjzDUMxhd%252F%252BEqNs8gPoIAVz0KJKFt0QvoobDG0Vc6EICEelRPqyhmil1VYcG%252BEEH55tMYdQ95I4ip6FhFeLFZmbk4486IPoM1vQnqPBWiapxrFJG4h%252FjQG5xUQejZsqHXFuuIouyRyWgiqQSXdYyF81fFJ73h22KBBlIMoPzHVGtObjSLcMc39EOPJDORWxkRGdkd1qp%252BXxDWrC36QghRLZqmfmAkWhDlEB4ZwyqHkZgaRYMdMMath20nOYyRn1T3xGAIRlH0A%253D%253D%7Ccksum%3A273669445007ff54a66ab17a40d1be801ea21a2bde13%7Campid%3APL_CLK%7Cclp%3A2334524");
		it.processItem("https://www.ebay.com/itm/4K-UHD-Slipcovers-4K-ONLY-Buy-3-Get-1-Free/233857722021?_trkparms=ispr%3D1&hash=item367301a6a5:g:gJEAAOSw~TRf~n3W&amdata=enc%3AAQAFAAACcBaobrjLl8XobRIiIML1V4Imu%252Fn%252BzU5L90Z278x5ickkai8xCwosGKpC0NWj85e%252FB2EPHsBb2stiAYKSmLzUFt3fdIQ1VRifn0i%252BCrBa8H5H76%252B7InjwjchspFOTTpN2LZt8j1Af4j9sDTqKrKN3pZsCLbcL5iNi1m6xmN%252B%252Fg0a5BNJXE5WkaGhIUanHde5gMA26caTwphN30%252F8QMF2NTX00vGrOurY%252BtgdnwsjKA5sn1LkfisduqTdlc1jcyEb5GieNto%252F1SeP5rkaVJFkYmev%252B47kv60b9dUZ6B9aB%252Bntc%252FOAsnEyDXy2VDJmGs69pVWrdYLPtCdC4JwsVKTWA8J7swJhMpVrI%252BhJc78tnnV4LBayoZu8R266pjyoP6aZvVVFvZMekR5iNO7NU6eKxNOTRFviUeZrwAiCOVAZ2gFIxi06oNDUMVtA3gekxzzpBuLgyI6mMF13NPuvfNfXXmN%252BVYALRwPY20qBsHRNQhZ83EygdrPfAs7nzKIDxm53wpJD0OQ8O9sGU7JVgXsiKlkVW5xKhYmF1A5snV5qT4A98RwZRbMJtqwRcaZVqtJDQHKR%252B3rRDtfzwLumOWYceC2OP89izWyFOr7Ro15aIM%252BIHPOORRworigGbPlRtvb1lewX7DUIv32piwjIJkdzXZcUwhIO7DdJxV4aM2w4iU9WwWWgq3zZ5ms5yT%252FdQ79hZy%252BouzDezsZeiERUvZvZdXgpAWT6nUauD2b%252FnF6pU7XwGdkyWMOwZOWhl37ZZCkq4IXQR7ADiAiqHrhlHVKl%252Bqi3gAQc2lH1UaY%252F9bYqGyAU%252F8u%252BCokXDh9It13nePilmYA%253D%253D%7Ccksum%3A2338577220216b5220b5e7c447fcaa07f1f2dff89385%7Campid%3APL_CLK%7Cclp%3A2334524");
	}
}
