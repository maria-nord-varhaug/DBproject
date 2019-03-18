import java.sql.SQLException;
import java.util.Scanner;

public class WorkoutCtrl extends DBConn {
    private Scanner scanner;
    //private Workout workout;

    public WorkoutCtrl() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
        this.scanner = new Scanner(System.in);
    }

    private void createWorkout() {

    }

}
