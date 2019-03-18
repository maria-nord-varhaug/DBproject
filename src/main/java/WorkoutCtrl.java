import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
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

    private void createWorkout(Date workoutDate, Time workoutTime, int duration, int personalShape, String note, List<Exercise> exercises) {
        //workout = new Workout(workoutDate, workoutTime, duration, personalshape, note, exercises);
    }

    public static void main(String[] args) {
        WorkoutCtrl wc = new WorkoutCtrl();
        wc.addWorkout();

    }

    public void addWorkout() {
        Date date;
        Time time;
        int duration;
        int personalshape;
        String note;
        System.out.println("Okay, what date did you perform the workout you want to log? Write it in format yyyy-MM-dd");
        System.out.println("Example: 2019-02-01");
        date = java.sql.Date.valueOf(scanner.nextLine());
        System.out.println("What time did you workout? On the form hh:mm");
        time = java.sql.Time.valueOf(scanner.nextLine() + ":00");
        System.out.println("Now, how long did your workout last (in minutes)? ");
        duration = scanner.nextInt();
        System.out.println("On a scale from 1 to 10, how was your shape during the workout? ");
        personalshape = scanner.nextInt();
        System.out.println("Do you have any additional comments you want to add?");
        note = scanner.nextLine();
        //List<Exercise> exerciseList = new ArrayList<Exercise>();
        //createWorkout(date, time, duration, personalshape, note, exerciseList);

        String querystring = "Did you do any exercises you want to log? If you do write 'Y'";
        System.out.println(querystring);
        //System.out.println(date.toString()+time.toString()+duration+personalshape+note); //test
        String answer = scanner.nextLine();

        while (answer.equals("Y")) {
            //TODO: create exercise
            //
            System.out.println(querystring);
            answer = scanner.nextLine();
        }
    }
}
