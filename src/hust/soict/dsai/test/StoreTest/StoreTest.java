package hust.soict.dsai.test.StoreTest;

import hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng với dung lượng tối đa là 5 DVD
        Store store = new Store(5);

        // Tạo một số DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Action", "anh minh", 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "anh minh", 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "anh minh", 9.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Action", "anh minh", 19.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "anh minh", 14.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "anh minh", 17.99f);

        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd5);

        // In danh sách DVD hiện tại trong cửa hàng
        store.printItemsInStore();

        // Thử thêm DVD khi cửa hàng đã đầy
        System.out.println("\nAttempting to add a DVD when the store is full:");
        store.addDVD(dvd6);

        // Xóa một DVD khỏi cửa hàng
        System.out.println("\nRemoving DVD 'Inception' from the store:");
        store.removeDVD(dvd2);

        // In lại danh sách DVD sau khi xóa
        store.printItemsInStore();

        // Thử xóa một DVD không tồn tại trong cửa hàng
        System.out.println("\nAttempting to remove a DVD that is not in the store:");
        store.removeDVD(dvd6);  // DVD này chưa được thêm vào cửa hàng
    }
}
