package lab2;

import java.util.Objects;

public class Song {
    private String artist;
    private String title;
    private int year;

    public Song(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    public Song(Song song) {
        this.artist = song.artist;
        this.title = song.title;
        this.year = song.year;
    }

    public Song() {
        this("The Weeknd", "In Your Eyes", 2020);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void showData() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Year: " + year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return year == song.year &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, title, year);
    }

    @Override
    public String toString() {
        return "Artist: " + artist + '\n' +
                "Title: " + title + '\n' +
                "Year: " + year;
    }
}
