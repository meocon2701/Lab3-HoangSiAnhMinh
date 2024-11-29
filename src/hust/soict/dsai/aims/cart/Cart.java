package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;
    private DigitalVideoDisc[] dvdList;


    public Cart() {
        itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }


    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println(" The disc \"" + disc.getTitle() + "\" has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println(" The cart is almost full!");
            }
        } else {
            System.out.println(" The cart is full! Cannot add more discs.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        for (DigitalVideoDisc disc : discs) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println(" The disc \"" + disc.getTitle() + "\" has been added.");
                if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
                    System.out.println(" The cart is almost full!");
                }
            } else {
                System.out.println(" The cart is full! Cannot add more discs.");
                break; // Dừng việc thêm DVD nếu giỏ hàng đã đầy
            }
        }
    }/*
    public void addDigitalVideoDisc(hust.soict.dsai.aims.disc.DigitalVideoDisc[] dvdList) {
        for (hust.soict.dsai.aims.disc.DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc); // Gọi phương thức cũ để thêm từng DVD vào giỏ
        }
        System.out.println(" Multiple discs have been added.");
    }*/


    // Phương thức xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {

                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println(" \"" + disc.getTitle() + "\" has been removed.");
                return; // Thoát khỏi phương thức
            }
        }
        System.out.println(" The disc is not in the cart.");
    }

    // Phương thức tính tổng giá
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        double totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". " + dvd.toString());  // In thông tin DVD
            totalCost += dvd.getCost();  // Cộng dồn giá của từng DVD vào tổng giá trị
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("*****************************************************");
    }
    public void searchById(int id) {
        boolean found = false;  // Biến kiểm tra nếu DVD được tìm thấy

        // Duyệt qua giỏ hàng để tìm DVD theo ID
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println(" Found DVD: " + itemsOrdered[i].toString());
                found = true;
                break;  // Dừng vòng lặp nếu tìm thấy DVD
            }
        }

        // Nếu không tìm thấy DVD có ID khớp
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println(" Found DVD: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No match found for title: " + title);
        }
    }
}

    