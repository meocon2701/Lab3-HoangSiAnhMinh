package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Thay mảng itemsInStore[] bằng ArrayList<Media> để chứa các đối tượng Media
    private ArrayList<Media> itemsInStore;

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<Media>();  // Khởi tạo danh sách chứa các Media
    }
    public void removeMediaByTitle(String title) {
        Media mediaToRemove = getMediaByTitle(title);  // Tìm kiếm media theo tiêu đề
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);  // Xóa media nếu tìm thấy
            System.out.println(" The media \"" + title + "\" has been removed from the store.");
        } else {
            System.out.println(" No media found with title: " + title);
        }
    }
    // Phương thức thêm media vào cửa hàng (bất kỳ loại Media nào: DVD, Book, CD)
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println(" The media \"" + media.getTitle() + "\" has been added to the store.");
    }
    // Phương thức xóa media khỏi cửa hàng theo tiêu đề


    // Phương thức xóa media khỏi cửa hàng

    // Phương thức trả về tất cả media trong cửa hàng
    public ArrayList<Media> getAllMedia() {
        return itemsInStore;  // Trả về danh sách media trong cửa hàng
    }
    // Phương thức in danh sách các Media trong cửa hàng
    public void printItemsInStore() {
        System.out.println("**********************STORE**********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("**************************************************");
    }
    public Media getMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;  // Trả về Media nếu tiêu đề khớp
            }
        }
        return null;  // Trả về null nếu không tìm thấy Media với tiêu đề đó
    }

    // Phương thức để hiển thị tất cả Media trong store


}
