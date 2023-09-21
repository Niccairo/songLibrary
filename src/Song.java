public class Song {
    private String  title;
    private String musicalGenre;
    private String album;
    private Double lenghtOfTheSong;

    public Song(String title, String musicalGenre, String album, Double lenghtOfTheSong) {
        this.title = title;
        this.musicalGenre = musicalGenre;
        this.album = album;
        this.lenghtOfTheSong = lenghtOfTheSong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Double getLenghtOfTheSong() {
        return lenghtOfTheSong;
    }

    public void setLenghtOfTheSong(Double lenghtOfTheSong) {
        this.lenghtOfTheSong = lenghtOfTheSong;
    }
}