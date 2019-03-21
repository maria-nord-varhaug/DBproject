import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConn {

    private String username = "java"; //This is the username to my DB; change to what your is
    private String password = "123";
    protected Connection conn;


    public DBConn() {
    }

    public static void main(String[] args) {
        //DBConn conn = new DBConn();
        //conn.connect();
    }

    public void connect() {
        try {
            //I have a database called workoutournal. Format: IP:portnumber/dbname
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workoutjournal" +
                            "?autoReconnect=true" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useUnicode=true" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    username, password);
            System.out.println("Database connected!");


        } catch (SQLException sqlE) {
            throw new RuntimeException("Unable to connect", sqlE);
        }
    }


}