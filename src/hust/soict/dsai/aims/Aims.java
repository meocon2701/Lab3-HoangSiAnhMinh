package hust.soict.dsai.aims;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;


public class Aims {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
            anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
            anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
            anOrder.addDigitalVideoDisc(dvd3);
        /*anOrder.addDigitalVideoDisc(dvd1,dvd2,dvd3);
        hust.soict.dsai.aims.disc.DigitalVideoDisc[] dv = {dvd1,dvd2,dvd3};
        anOrder.addDigitalVideoDisc(dv);


        System.out.println(" Total Cost is: ");*/
        System.out.println(" DVD 1 ID: " + dvd1.getId());  // Sẽ in: DVD 1 ID: 1
        System.out.println(" DVD 2 ID: " + dvd2.getId());  // Sẽ in: DVD 2 ID: 2
        System.out.println(" DVD 3 ID: " + dvd3.getId());  // Sẽ in: DVD 3 ID: 3

        System.out.println(anOrder.totalCost());
            anOrder.removeDigitalVideoDisc(dvd1);
            System.out.println(anOrder.totalCost());
        


    }
}
