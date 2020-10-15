package lab1;

public class Main {
    public static void main(String[] args) {
        // obiecte
        Song song1 = new Song();
        song1.setArtist("Florin Salam");
        song1.setTitle("Saint Tropez");
        song1.setYear(2013);
        System.out.println("Title = " + song1.getTitle());
        System.out.println("Artist = " + song1.getArtist());
        System.out.println("Year = " + song1.getYear());

        Song song2 = new Song();
        song2.setArtist("Liviu Guta");
        song2.setYear(2011);
        song2.setTitle("Buna dimineata");
        song2.showData();

        // strings
        String s1 = new String("Dristor");
        String s2 = "cu de toate";
        System.out.println(s1.length() + " " + s2.length());

        // arrays
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Song[] songs = new Song[3];
        for (int i = 0; i < songs.length; i++) {
            songs[i] = new Song();
        }

        songs[0].setArtist("Ed Sheeran");
        songs[0].setYear(2017);
        songs[0].setTitle("Perfect");

        songs[1].setTitle("After Hours");
        songs[1].setYear(2020);
        songs[1].setArtist("The Weeknd");

        songs[2].setTitle("Lucid Dreams");
        songs[2].setYear(2018);
        songs[2].setArtist("Juice WRLD");
    }

}
