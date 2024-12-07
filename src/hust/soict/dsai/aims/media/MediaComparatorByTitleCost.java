package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // So sánh theo tiêu đề
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());

        // Nếu tiêu đề giống nhau, so sánh theo giá
        if (titleComparison == 0) {
            return Float.compare(media1.getCost(), media2.getCost());
        }
        return titleComparison;
    }
}
