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

    public void addWorkout(Scanner scanner) {
        Date date;
        Time time;
        int duration;
        int personalshape;
        String note;
        String answer;
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
        answer = scanner.nextLine();
        CreateExerciseCtrl exerciseCtrl = new CreateExerciseCtrl();

        while (answer.equals("Y")) {
            //exerciseList.add(exerciseCtrl.addExercise(scanner));
            int exerciseID = exerciseCtrl.addExercise(scanner).getExerciseID();  //prøver å lage øvelsene først
            workout.createWorkoutExerciseConnection(conn, exerciseID);
            System.out.println("Did you do any exercises you want to log? If you do write 'Y'");
            answer = scanner.nextLine();
        }


        try {
            conn.commit();
        } catch (Exception e) {
            System.out.println("problem commiting stuff=" + e);
        }

        System.out.println("All clear!");
        scanner.close();
    }


}
