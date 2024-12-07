package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private final String title;
    private final int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Triển khai phương thức play() từ Playable
    @Override
    public void play() {
        if (length > 0) {
            System.out.println(" Playing track: " + title);
            System.out.println(" Track length: " + length + " minutes");
        } else {
            System.out.println(" Cannot play track: " + title + " (invalid length)");
        }
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // So sánh chính nó
        }
        if (obj == null || !(obj instanceof Track)) {
            return false; // Null hoặc không phải là Track
        }

        Track other = (Track) obj;
        return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
    }

    @Override
    public String toString() {
        return "Track - " + title + ": " + length + " minutes";
    }
}