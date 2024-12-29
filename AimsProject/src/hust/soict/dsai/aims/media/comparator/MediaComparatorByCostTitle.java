package hust.soict.dsai.aims.media.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	@Override
    public int compare(Media o1, Media o2){
        Double cost1 = o1.getCost();
        Double cost2 = o1.getCost();
        int Comp = cost1.compareTo(cost2);
        if (Comp != 0) {
            return Comp;
        }
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        return title1.compareTo(title2);
    }

}
