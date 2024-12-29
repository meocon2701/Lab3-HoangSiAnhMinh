package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{

	private String title;
	private int length;
	
	public void play() throws PlayerException{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Track) {
			Track t = (Track) obj;
			return title == t.getTitle() && length == t.getLength();
		} else {
			return false;
		}
	}

}
