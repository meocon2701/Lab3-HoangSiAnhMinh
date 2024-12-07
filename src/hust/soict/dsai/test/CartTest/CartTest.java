package hust.soict.dsai.test.CartTest;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các đối tượng DVD và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // In giỏ hàng
        cart.displayCart();

        // Tìm kiếm DVD theo title và ID
        cart.searchByTitle("Star Wars");  // Tìm DVD theo tiêu đề
        cart.searchById(4);  // Tìm DVD theo ID không tồn tại
        cart.searchByTitle("minh");  // Tìm DVD theo tiêu đề không có
        cart.searchById(1);  // Tìm DVD theo ID không có
    }
}
