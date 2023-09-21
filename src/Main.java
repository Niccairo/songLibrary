import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Song thunderstruck = new Song("Thunderstruck","Rock","The Razor Edge", 4.50);
        Song fireYourGuns = new Song("Fire Your Guns","Rock","The Razor Edge", 2.50);
        SongDao songDao = new SongDao();
        try {
            songDao.createTable();
            songDao.insertSong(thunderstruck);
            songDao.insertSong(fireYourGuns);
            songDao.updateSong(fireYourGuns,2);
            songDao.deleteSong(2);
            songDao.deleteAllSong();
            songDao.printAllSongs();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}