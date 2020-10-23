package lab2;

public class Main {

    public static void editYear(Song song, int year) {
        song.setYear(year);
    }

    public static void createNewSong(Song song, int year) {
        song = new Song(song.getArtist(), song.getTitle(), year);
    }

    public static void main(String[] args) {
        // obiecte
        Song song1 = new Song("Florin Salam", "Saint Tropez", 2013);
        Song song2 = new Song("Liviu Guta", "Buna dimineata", 2011);
        Song song3 = new Song();

        System.out.println(song1);
        System.out.println(song2);
        System.out.println(song3);

        Song song4 = song1;
        System.out.println("\nBefore");
        System.out.println(song1);
        System.out.println(song4);

        song4.setTitle("M-as certa cu tine iar");
        song4.setYear(2020);

        System.out.println("\nAfter");
        System.out.println(song1);
        System.out.println(song4);

        System.out.println("\nEditing year - the reference is the same and value changed");
        System.out.println(song2);
        editYear(song2, 2012);
        System.out.println(song2);

        System.out.println("\nEditing year - the value is not changed");
        System.out.println(song2);
        createNewSong(song2, 2016);
        System.out.println(song2);
    }
}
