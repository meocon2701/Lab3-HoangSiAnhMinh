package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Getter cho director
    public String getDirector() {
        return director;
    }
}
