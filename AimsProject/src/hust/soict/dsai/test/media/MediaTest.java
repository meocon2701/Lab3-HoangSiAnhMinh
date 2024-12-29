package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class MediaTest {

	public MediaTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc(1, "Lion", "Something", 20.5f, null, null);
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		Book book = new Book(3, "Book title", "Book Category", 3, null);
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for(Media m : mediae) {
			System.out.println(m.toString());
		}
	}
	
}
