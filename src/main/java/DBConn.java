import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

    private String username = "root"; //This is the username to my DB; change to what your is
    private String password = "VItrenger1kkeDB!";


    private DBConn() {
    }

    public static void main(String[] args) {
        DBConn conn = new DBConn();
        conn.connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();    //Format: IP:portnumber/dbname
            //I have a database called workoutournal
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workoutjournal?autoReconnect=true&useSSL=false", username, password);
            System.out.println("Database connected!");

        } catch (Exception e) {
            throw new RuntimeException("Unable to connect", e);
        }
    }


}