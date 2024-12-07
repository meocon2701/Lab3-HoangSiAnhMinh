package hust.soict.dsai.aims.media;



import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class TestPolymorphism {
    public static void main(String[] args) {
        // Tạo một ArrayList chứa các đối tượng Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // Thêm một số đối tượng Media vào danh sách
        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.99f));
        mediaList.add(new CompactDisc(1, "Greatest Hits", "Pop", 15.99f, "John Doe", "Queen"));
        mediaList.add(new Book(2, "Effective Java", "Programming", 45.5f));

        // Lặp qua danh sách và in thông tin bằng phương thức toString()
        System.out.println("Thông tin các Media:");
        for (Media media : mediaList) {
            System.out.println(media.toString()); // Hành vi đa hình
        }
    }
}
