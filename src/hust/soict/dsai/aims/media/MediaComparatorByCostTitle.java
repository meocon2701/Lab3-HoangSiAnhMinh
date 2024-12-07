package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // So sánh theo giá giảm dần
        int costComparison = Float.compare(media2.getCost(), media1.getCost());

        // Nếu giá giống nhau, so sánh theo tiêu đề
        if (costComparison == 0) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
        return costComparison;
    }
}
