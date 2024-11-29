package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private String title;
    private String category;
    private String director;
    private int length ;
    private float cost;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " minutes: " + cost + " $";
    }

    // Phương thức isMatch() kiểm tra nếu tiêu đề DVD khớp với tiêu đề tìm kiếm
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++;  // Tăng số lượng DVD
        this.id = nbDigitalVideoDiscs;  // Gán id cho DVD mới
    }

    public DigitalVideoDisc(String title, String category,  float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Tăng số lượng DVD
        this.id = nbDigitalVideoDiscs;  // Gán id cho DVD mới
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Tăng số lượng DVD
        this.id = nbDigitalVideoDiscs;  // Gán id cho DVD mới
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Tăng số lượng DVD
        this.id = nbDigitalVideoDiscs;  // Gán id cho DVD mới

    }

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
