package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorByTitleCost;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private double cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(int id, String title, String category, double cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public boolean equals(Object o) {
    	try {
    		if (o instanceof Media) {
    			if (this.title == ((Media)o).title) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		}
    		else {
    			return false;
    		}
    	}
    	catch (NullPointerException n) {
    		return false;
    	}
    }
	
	@Override
	public String toString() {
		return "Media" + " - " + this.getId() + "-" + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + " $";
	}
	
	public boolean isMatch(String checkTitle) {
		if(this.getTitle().equals(checkTitle)) {
			return true;
		}
		return false;
	}
}
