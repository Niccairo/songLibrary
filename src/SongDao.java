import java.sql.*;

public class SongDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/song_library";
    private static final String USER = "root";
    private static final String PASS = "Totti10totti";

    public void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();

        String createTable = ""
                + "CREATE TABLE song ( "
                + "song_id int NOT NULL AUTO_INCREMENT,"
                + "title varchar(100) ,"
                + "musical_genre varchar(100),"
                + "album varchar(100) ,"
                + "length double,"
                + "PRIMARY KEY (song_id)  );";

        statement.executeUpdate(createTable);
        connection.close();
        System.out.println("Table song created");
    }

    public void insertSong(Song song) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();

        String insertQuery = ""
                + "INSERT INTO song "
                + "(title, musical_genre, album, length) "
                + "VALUES ( '" + song.getTitle() + "', '" + song.getMusicalGenre() + "', '" + song.getAlbum() + "', '" + song.getLenghtOfTheSong() + "');";

        statement.executeUpdate(insertQuery);
        connection.close();
        System.out.println("Populated song table ");
    }

    public void printAllSongs() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String printQuery = "SELECT * FROM song;";
        ResultSet resultSet = statement.executeQuery(printQuery);
        int i = 0;
        while(resultSet.next()){
            i += 1;
            System.out.println( i + " Title = " + resultSet.getString("title"));
            System.out.println( i + " Musical Genre = " + resultSet.getString("musical_genre"));
            System.out.println( i + " Album = " + resultSet.getString("album"));
            System.out.println( i + " Length = " + resultSet.getString("length"));
        }
        connection.close();
    }

    public void updateSong(Song song, Integer SongId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String updateSong = ""
                + "UPDATE song "
                + "SET title = '" + song.getTitle() + "', musical_genre = '" + song.getMusicalGenre() + "', album = '" + song.getAlbum() +  "', `length`= '" + song.getLenghtOfTheSong()+ "' "
                + "WHERE song_id= '" + SongId +  "';";

        statement.executeUpdate(updateSong);
        connection.close();
        System.out.println("Song with ID " + SongId + " updated");
    }

    public void deleteSong(Integer SongId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String deleteQuery = ""
                + "DELETE FROM song "
                + "Where song_id = '" + SongId +  "' ;";

        statement.executeUpdate(deleteQuery);
        connection.close();
        System.out.println("Song with ID " + SongId + "deleted" );
    }

    public void deleteAllSong() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String completeDeleteQuery = ""
                + "TRUNCATE song;";

        statement.executeUpdate(completeDeleteQuery);
        connection.close();
        System.out.println("Table cleaned completely");
    }
}