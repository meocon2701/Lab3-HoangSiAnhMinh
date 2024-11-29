package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int qtyInStore;

    // Constructor
    public Store(int maxSize) {
        itemsInStore = new DigitalVideoDisc[maxSize];  // Khởi tạo mảng chứa DVD
        qtyInStore = 0;  // Số DVD hiện tại trong cửa hàng
    }

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println(" The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full! Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];  // Dịch các DVD sau vị trí đã xóa lên
                }
                itemsInStore[qtyInStore - 1] = null;  // Xóa DVD cuối cùng trong mảng
                qtyInStore--;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                return;
            }
        }
        System.out.println(" The DVD is not in the store.");
    }

    // Phương thức in danh sách các DVD trong cửa hàng
    public void printItemsInStore() {
        System.out.println("**********************STORE**********************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("**************************************************");
    }
}
