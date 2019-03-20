import java.sql.SQLException;
import java.util.Scanner;


public class CreateExerciseCtrl extends DBConn {

    private Scanner scanner;
    private Exercise exercise;

    public CreateExerciseCtrl() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
        this.scanner = new Scanner(System.in);
    }

    private void createMachineExercise(String eName, int performance, int kg, int sets, WorkoutMachine workoutMachine) {
        exercise = new MachineExercise(eName, performance, kg, sets, workoutMachine);
    }

    private void createExerciseWithoutMachine(String eName, int performance, String description) {
        exercise = new ExerciseWithoutMachine(eName, performance, description);
    }

    public static void main(String args[]) {
        CreateExerciseCtrl cec = new CreateExerciseCtrl();
        cec.addExercise();
    }

    public void addExercise() {
        String s;
        System.out.println("If you want to log an exercise with machine write 'machine', else write 'body': ");
        s = scanner.nextLine();
        if (s.equals("machine")) {
            addMachineExercise();
        } else {
            addExerciseWithoutMachine();
        }
        scanner.close();
    }

    private void addExerciseWithoutMachine() {
        String eName;
        String description;
        int performance;
        System.out.println("What is the name of the exercise you did?");
        eName = scanner.nextLine();
        System.out.println("Could you describe the exercise?");
        description = scanner.nextLine();
        System.out.println("On a scale from 1 to 10, how well did you feel you performed?");
        performance = scanner.nextInt();

        createExerciseWithoutMachine(eName, performance, description);
        exercise.save(conn);
    }

    private void addMachineExercise() {
        String machinename;
        String description;
        String eName;
        int performance;
        int kg;
        int sets;
        WorkoutMachine wm;

        System.out.println("What is the name of the machine you used?");
        machinename = scanner.nextLine();
        System.out.println("Can you give a short description of the machine?");
        description = scanner.nextLine();
        System.out.println("Sweet. Now, what is the name of the exercise you did?");
        eName = scanner.nextLine();
        System.out.println("On a scale from 1 to 10, how well did you feel you performed?");
        performance = scanner.nextInt();
        System.out.println("How many kgs?");
        kg = scanner.nextInt();
        System.out.println("How many sets?");
        sets = scanner.nextInt();

        wm = new WorkoutMachine(machinename, description);
        wm.createWorkoutMachine(conn);
        createMachineExercise(eName, performance, kg, sets, wm);
        exercise.save(conn);  //Adds exercise's subclasses to DB
    }
}