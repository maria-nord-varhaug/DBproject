import models.Exercise;
import models.Workout;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutCtrl extends DBConn {

    public WorkoutCtrl() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkoutCtrl wc = new WorkoutCtrl();
        wc.addWorkout(scanner);
    }

    private void addWorkout(Scanner scanner) {
        Date date;
        Time time;
        int duration;
        int personalshape;
        String note;
        List<Exercise> exerciseList = new ArrayList<Exercise>();

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
        note = scanner.nextLine();

        Workout workout = new Workout(date, time, duration, personalshape, note, exerciseList);
        workout.createWorkout(conn);


        System.out.println("Did you do any exercises you want to log? If you do write 'Y'");
        String answer = scanner.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            CreateExerciseCtrl exerciseCtrl = new CreateExerciseCtrl();
            System.out.println("How many exercises do you want to log?");
            int ans = scanner.nextInt();
            for (int i = 0; i < ans; i++) {
                int exerciseID = exerciseCtrl.addExercise(scanner).getExerciseID();  //prøver å lage øvelsene først
                workout.createWorkoutExerciseConnection(conn, exerciseID);
            }
        }
        try {
            conn.commit();
        } catch (Exception e) {
            System.out.println("problem commiting stuff=" + e);
        }

        System.out.println("All clear!");
        scanner.close();
    }

    public void pickYourChoose(Scanner scanner) {
        System.out.println("Write 'w' for logging a workout, else you will be directed to show stuff");
        String toughchoice = scanner.nextLine();
        if (toughchoice.equals('w')) {
            addWorkout(scanner);
        } else {
            System.out.println("Write 'last' if you want to see recent workouts you've done, or 'result' if you want to see how well you have performed in the same exercise over a specific time interval");
            toughchoice = scanner.nextLine();
            if (toughchoice.equals("last")) {
                System.out.println("How many workouts do you want to view?");
                int number = scanner.nextInt();
                Workout.viewWorkouts(conn, number);
            } else if (toughchoice.equals("result")) {
                System.out.println("What is the name of the exercise you want to look at?");
                String exercisename = scanner.nextLine();
                System.out.println("What is the date of the start of the time interval you want to look at?");
                System.out.println("Format is: yyyy-mm-dd, for example: 1998-02-02 or 1998-05-01");
                Date startdate = java.sql.Date.valueOf(scanner.nextLine());
                System.out.println("What is the date of the end of the time interval you want to look at?");
                Date enddate = java.sql.Date.valueOf(scanner.nextLine());

                Workout.viewExerciseResult(conn, exercisename, startdate, enddate);
            }
        }
    }


}
