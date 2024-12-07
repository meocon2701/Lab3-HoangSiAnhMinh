import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();  // Khởi tạo Store
        Cart cart = new Cart();    // Khởi tạo giỏ hàng

        // Thêm một số Media mẫu vào store
        // DVD

        store.addMedia(new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 105, 19.99f));
        store.addMedia(new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 24.99f));
        store.addMedia(new DigitalVideoDisc("The Notebook", "Romance", "Nick Cassavetes", 123, 14.99f));

// Book


        store.addMedia(new Book(3, "Code Complete", "Programming", 45.99f));
        store.addMedia(new Book(4, "Refactoring", "Programming", 41.99f));

// CD with Tracks
        CompactDisc jazzCD = new CompactDisc(1, "Jazz Essentials", "Jazz", 14.99f, "Miles Davis", "Various Artists");
        jazzCD.addTrack(new Track("So What", 9));

        store.addMedia(jazzCD);

        CompactDisc classicalCD = new CompactDisc(2, "Classical Favorites", "Classical", 18.99f, "Wolfgang Amadeus Mozart", "Various Artists");

        classicalCD.addTrack(new Track("Requiem", 45));
        store.addMedia(classicalCD);

        CompactDisc hipHopCD = new CompactDisc(3, "Hip Hop Beats", "Hip-Hop", 22.49f, "Kanye West", "Various Artists");

        hipHopCD.addTrack(new Track("Power", 5));
        store.addMedia(hipHopCD);

// Hiển thị tất cả các media trong cửa hàng


        // Menu chính
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();  // Đọc dòng trống còn lại

            switch (choice) {
                case 1:
                    store.printItemsInStore();
                    storeMenu(sc, store, cart);
                    break;
                case 2:
                    updateStoreMenu(sc, store);
                    break;
                case 3:
                    cartMenu(sc, cart, store);
                    break;
                case 0:
                    System.out.println(" Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }

    // Hiển thị menu chính
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Menu cửa hàng
    public static void storeMenu(Scanner sc, Store store, Cart cart) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Đọc dòng trống còn lại

            switch (choice) {
                case 1:
                    seeMediaDetails(sc, store, cart);
                    break;
                case 2:
                    addMediaToCart(sc, store, cart);
                    break;
                case 3:
                    playMedia(sc, store);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }

    // Xem chi tiết media
    public static void seeMediaDetails(Scanner sc, Store store, Cart cart) {
        System.out.print(" Enter the title of the media: ");
        String title = sc.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            media.displayInfo();
            mediaDetailsMenu(sc, media, cart);
        } else {
            System.out.println(" Media not found.");
        }
    }

    // Menu chi tiết media
    public static void mediaDetailsMenu(Scanner sc, Media media, Cart cart) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = sc.nextInt();
        sc.nextLine();  // Đọc dòng trống còn lại

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println(" Media added to cart.");
                break;
            case 2:
                media.Playable();
                break;
            case 0:
                break;
            default:
                System.out.println(" Invalid choice. Please try again.");
        }
    }

    // Thêm media vào giỏ hàng
    public static void addMediaToCart(Scanner sc, Store store, Cart cart) {
        System.out.print(" Enter the title of the media to add to cart: ");
        String title = sc.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println(" Media added to cart.");
        } else {
            System.out.println(" Media not found.");
        }
    }

    // Phát media
    public static void playMedia(Scanner sc, Store store) {
        System.out.print(" Enter the title of the media to play: ");
        String title = sc.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {  // Kiểm tra xem media có triển khai Playable hay không
                Playable playable = (Playable) media;  // Ép kiểu sang Playable
                playable.play();  // Gọi phương thức play()
            } else {
                System.out.println(" This media cannot be played.");
            }
        } else {
            System.out.println(" Media not found.");
        }
    }

    // Menu cập nhật Store
    public static void updateStoreMenu(Scanner sc, Store store) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = sc.nextInt();
        sc.nextLine();  // Đọc dòng trống còn lại

        switch (choice) {
            case 1:
                System.out.print(" Enter the title of the media: ");
                String title = sc.nextLine();
                System.out.print(" Enter the ID of the media: ");
                String id = sc.nextLine();
                System.out.print(" Enter the cost of the media: ");
                float cost = sc.nextFloat();
                sc.nextLine();  // Đọc dòng trống còn lại

                System.out.println(" Select type (1-Book, 2-DVD, 3-CD): ");
                int type = sc.nextInt();
                sc.nextLine();

                Media newMedia;
                if (type == 1) {
                    newMedia = new Book(Integer.parseInt(id), title, "Unknown", cost);
                } else if (type == 2) {
                    newMedia = new DigitalVideoDisc(title, "Unknown", cost);
                } else if (type == 3) {
                    newMedia = new CompactDisc(Integer.parseInt(id), title, "Unknown", cost, "Unknown", "Unknown");
                } else {
                    System.out.println(" Invalid type. Media not added.");
                    return;
                }
                store.addMedia(newMedia);
                System.out.println(" Media added to store.");
                break;

            case 2:
                System.out.print(" Enter the title of the media to remove: ");
                String removeTitle = sc.nextLine();
                store.removeMediaByTitle(removeTitle);
                System.out.println(" Media removed from store.");
                break;

            case 0:
                break;

            default:
                System.out.println(" Invalid choice. Please try again.");
        }
    }

    // Menu giỏ hàng
    public static void cartMenu(Scanner sc, Cart cart, Store store) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print(" Please choose a number: 0-1-2-3-4-5: ");
        int choice = sc.nextInt();
        sc.nextLine();  // Đọc dòng trống còn lại

        switch (choice) {
            case 1:
                System.out.print(" Enter title to filter: ");
                String filterTitle = sc.nextLine();
                cart.searchByTitle(filterTitle);
                break;
            case 2:
                System.out.println(" Sort by (1-Title, 2-Cost): ");
                int sortChoice = sc.nextInt();
                sc.nextLine();
                if (sortChoice == 1) {
                    cart.displaySortedByTitle();
                } else if (sortChoice == 2) {
                    cart.displaySortedByCost();
                } else {
                    System.out.println(" Invalid choice.");
                }
                break;
            case 3:
                System.out.print(" Enter title to remove: ");
                String removeFromCart = sc.nextLine();
                cart.removeMediaByTitle(removeFromCart);
                break;
            case 4:
                System.out.print(" Enter title to play: ");
                String playTitle = sc.nextLine();
                Media media = store.getMediaByTitle(playTitle);
                if (media != null) {
                    //media.play();
                } else {
                    System.out.println(" Media not found.");
                }
                break;
            case 5:
                placeOrder(cart);
                break;
            case 0:
                return;
            default:
                System.out.println(" Invalid choice. Please try again.");
        }
    }

    // Đặt hàng
    public static void placeOrder(Cart cart) {
        System.out.println("1 Order placed successfully!");
        cart.clearCart();
    }
}
