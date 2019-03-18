import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
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

    private void createWorkout(Date date, Time time, int duration, int personalshape, String note) {
        //workout = new Workout(date, time, duration, personalshape, note);
    }

    public void addWorkout() {
        Date date;
        Time time;
        int duration;
        int personalshape;
        String note;

    }
}
