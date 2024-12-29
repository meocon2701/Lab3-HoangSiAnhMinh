package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		this(title, null, null, 0, 0);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, length, director);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, director, 0, cost);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		this(title, category, null, 0, cost);
	}
	
	public void play() throws PlayerException{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DigitalVideoDisc) {
			DigitalVideoDisc d = (DigitalVideoDisc) obj;
			return this.getTitle() == d.getTitle() && this.getCategory() == d.getCategory() && this.getDirector() == d.getDirector() 
					&& this.getLength() == d.getLength() && this.getCost() == d.getCost();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
	}
	
	public boolean isMatch(String checkTitle) {
		if(this.getTitle().equals(checkTitle)) {
			return true;
		}
		return false;
	}
}
