import java.sql.Connection;
import java.sql.DriverManager;

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
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();    //Format: IP:portnumber/dbname
            //I have a database called workoutournal
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workoutjournal?autoReconnect=true&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
            System.out.println("Database connected!");

        } catch (Exception e) {
            throw new RuntimeException("Unable to connect", e);
        }
    }


}