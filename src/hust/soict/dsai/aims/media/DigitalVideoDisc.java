package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Biến tĩnh đếm số lượng DVD
    private static int nbDigitalVideoDiscs = 0;

    // Constructor với chỉ tiêu đề
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0, 0, null);  // Tăng nbDigitalVideoDiscs và gán id
    }

    // Constructor với tiêu đề, thể loại và chi phí
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);  // Tăng nbDigitalVideoDiscs và gán id
    }

    // Constructor với tiêu đề, thể loại, đạo diễn và chi phí
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director);  // Tăng nbDigitalVideoDiscs và gán id
    }

    // Constructor với tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);  // Tăng nbDigitalVideoDiscs và gán id
    }

    // Phương thức kiểm tra tiêu đề có khớp không
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }


    @Override
    public void play() {
        System.out.println(" Playing DVD: " + this.getTitle());
        System.out.println(" DVD length: " + this.getLength() + " minutes");
    }


    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() +
                " - " + getLength() + " minutes: " + getCost() + " $";
    }
}
