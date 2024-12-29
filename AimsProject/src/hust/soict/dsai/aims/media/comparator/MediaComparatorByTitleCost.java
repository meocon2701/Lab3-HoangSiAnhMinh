package hust.soict.dsai.aims.media.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
    public int compare(Media o1, Media o2){
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int Comp = title1.compareTo(title2);
        if (Comp != 0) {
            return Comp;
        }
        Double cost1 = o1.getCost();
        Double cost2 = o2.getCost();
        return cost1.compareTo(cost2);
    }

}
