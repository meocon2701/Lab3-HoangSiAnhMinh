package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store_1 = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 =  new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		// Test addDVD
		store_1.addMedia(dvd1);
		store_1.addMedia(dvd2);
		store_1.print();
		
		// Test removeDVD
		store_1.removeMedia(dvd1);
		store_1.print();
		
		store_1.removeMedia(dvd1);
	}
}
