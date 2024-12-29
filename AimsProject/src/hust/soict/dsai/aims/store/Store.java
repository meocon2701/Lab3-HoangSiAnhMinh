package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public List<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("The media has been added");
	}
	
	public void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media has been removed from the store");
		} else {
			System.out.println("The media is not in the store");
		}
	}
	
	public Media searchInStore(String title) {
        for (Media m: itemsInStore){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }
	
	public Media getMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }
	
	public void print() {
		int index = 0;
		System.out.println("***********************Store***********************");
		System.out.println("Store Items:");
		
		for(Media item : itemsInStore) {
			if(item != null) {
				index++;
				System.out.println(index + ". " + item);
			}
		}
        System.out.println("***************************************************");
		
	}
}
