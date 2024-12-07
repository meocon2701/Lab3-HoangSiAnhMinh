package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Phương thức thêm media vào giỏ hàng
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(" Added: " + media.getTitle());
        } else {
            System.out.println(" Media already exists in the cart: " + media.getTitle());
        }
    }
    // Phương thức xóa media khỏi giỏ hàng theo tiêu đề
    public void removeMediaByTitle(String title) {
        Media mediaToRemove = null;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToRemove = media;  // Tìm thấy media có tiêu đề khớp
                break;
            }
        }

        if (mediaToRemove != null) {
            itemsOrdered.remove(mediaToRemove);  // Xóa media
            System.out.println(" The media \"" + title + "\" has been removed from the cart.");
        } else {
            System.out.println(" No media found with title: " + title);
        }
    }
    // Phương thức xóa tất cả media khỏi giỏ hàng
    public void clearCart() {
        itemsOrdered.clear();  // Xóa tất cả các phần tử trong giỏ hàng
        System.out.println(" The cart has been cleared.");
    }





    // Phương thức xóa media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println(" The media \"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println(" The media \"" + media.getTitle() + "\" is not in the cart.");
        }
    }

    // Tính tổng chi phí
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // Hiển thị nội dung giỏ hàng
    public void displayCart() {
        System.out.println(" Items in the Cart:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println(" Total cost: " + totalCost() + " $");
    }

    // Kiểm tra giỏ hàng có trống không
    public boolean isEmpty() {
        return itemsOrdered.isEmpty();
    }

    // Tìm kiếm media theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(" Found: " + media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" No media found with title: " + title);
        }
    }

    // Tìm kiếm media theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(" Found: " + media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" No media found with ID: " + id);
        }
    } public void displaySortedByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println(" Giỏ hàng sắp xếp theo giá (giảm dần) và tiêu đề (bảng chữ cái):");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
    }
    // Hiển thị theo tiêu đề sau đó giá
    public void displaySortedByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println(" Giỏ hàng sắp xếp theo tiêu đề (bảng chữ cái) và giá (giảm dần):");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
    }

}
