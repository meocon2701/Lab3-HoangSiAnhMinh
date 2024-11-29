package hust.soict.dsai.test.CartTest;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
public class CartTest { public static void main(String[] args) {
Cart cart = new Cart();
//Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
            "Animation", "Roger Allers", 87, 19.95f);
    cart.addDigitalVideoDisc(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); cart.addDigitalVideoDisc(dvd2);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); cart.addDigitalVideoDisc(dvd3);
 cart.print();
    // Tìm kiếm DVD theo ID
    cart.searchByTitle("Star Wars");  // Tìm DVD theo tiêu đề
    cart.searchById(4);
    cart.searchByTitle("minh");
    cart.searchById(1);


//To-do: Test the search methods here
}

    public static class StoreTest {
        public static void main(String[] args) {
            // Tạo cửa hàng với tối đa 5 DVD
            Store store = new Store(5);

            // Tạo các DVD mẫu
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Jungle Book", "Animation", "Jon Favreau", 118, 19.99f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Fairy Tale", "Kenneth Branagh", 105, 15.99f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Jon Favreau", 120, 20.99f);
            DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 18.99f);
            DigitalVideoDisc dvd5 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 14.99f);

            // Thêm DVD vào cửa hàng
            store.addDVD(dvd1);
            store.addDVD(dvd2);
            store.addDVD(dvd3);
            store.addDVD(dvd4);
            store.addDVD(dvd5);

            // In ra tất cả DVD trong cửa hàng
            store.printItemsInStore();

            // Thử thêm một DVD khi cửa hàng đã đầy
            DigitalVideoDisc dvd6 = new DigitalVideoDisc("Wreck-It Ralph", "Animation", "Rich Moore", 101, 17.99f);
            store.addDVD(dvd6);  // Cửa hàng đã đầy nên DVD này không thể thêm vào

            // Xóa một DVD khỏi cửa hàng
            store.removeDVD(dvd2);
            store.removeDVD(dvd6);  // DVD này không có trong cửa hàng

            // In lại tất cả DVD trong cửa hàng
            store.printItemsInStore();
        }
    }
}