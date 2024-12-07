package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm track vào danh sách
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println(" Added track: " + track.getTitle());
        } else {
            System.out.println(" Track already exists: " + track.getTitle());
        }
    }


    // Xóa track khỏi danh sách
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println(" Track not found: " + track.getTitle());
        }
    }

    // Tính tổng độ dài của CD
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    // Triển khai phương thức play() từ Playable
    @Override
    public void play() {
        System.out.println(" Playing CD: " + getTitle());
        System.out.println("  Artist: " + artist);
        System.out.println(" Total length: " + getLength() + " minutes");

        // Lặp qua từng track và phát chúng
        for (Track track : tracks) {
            track.play();  // Phát từng track
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory()).append(" - Artist: ").append(artist)
                .append(" - Director: ").append(getDirector()).append(" - Total length: ").append(getLength())
                .append(" minutes - Cost: ").append(getCost()).append(" $\nTracks:\n");
        for (Track track : tracks) {
            sb.append(track.toString()).append("\n");
        }
        return sb.toString();
    }
}
