import java.sql.SQLException;
import java.util.Scanner;


public class CreateExerciseCtrl extends DBConn {

    private Scanner sc;
    private Exercise e;

    public CreateExerciseCtrl() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
        this.sc = new Scanner(System.in);
    }

    public static void main(String args[]) {

        CreateExerciseCtrl cec = new CreateExerciseCtrl();
        cec.addExercise();
        /*int a;
        float b;
        String s;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        s = in.nextLine();
        System.out.println("You entered string " + s);

        System.out.println("Enter an integer");
        a = in.nextInt();
        System.out.println("You entered integer " + a);

        System.out.println("Enter a float");
        b = in.nextFloat();
        System.out.println("You entered float " + b);*/
    }

    private void createMachineExercise(String eName, int performance, int kg, int sets, WorkoutMachine workoutMachine) {
        e = new MachineExercise(eName, performance, kg, sets, workoutMachine);
    }

    private void createExerciseWithoutMachine(String eName, int performance, String description) {
        e = new ExerciseWithoutMachine(eName, performance, description);
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
        machinename = sc.nextLine();
        System.out.println("Can you give a short description of the machine?");
        description = sc.nextLine();
        wm = new WorkoutMachine(machinename, description);
        System.out.println("Sweet. Now, what is the name of the exercise you did?");
        eName = sc.nextLine();
        System.out.println("On a scale from 1 to 10, how well did you feel you performed?");
        performance = sc.nextInt();
        System.out.println("How many kgs?");
        kg = sc.nextInt();
        System.out.println("How many sets?");
        sets = sc.nextInt();
        createMachineExercise(eName, performance, kg, sets, wm);
    }

    private void addExerciseWithoutMachine() {
        String eName;
        String description;
        int performance;
        System.out.println("What is the name of the exercise you did?");
        eName = sc.nextLine();
        System.out.println("Could you describe the exercise?");
        description = sc.nextLine();
        System.out.println("On a scale from 1 to 10, how well did you feel you performed?");
        performance = sc.nextInt();
        createExerciseWithoutMachine(eName, performance, description);
    }

    public void addExercise() {
        String s;
        System.out.println("If you want to log an exercise with machine write 'm', else write 'e': ");
        s = sc.nextLine();
        if (s.equals("m")) {
            addMachineExercise();
        } else {
            addExerciseWithoutMachine();
        }
        sc.close();
    }

    public void addToDB() {
        //avtale.save(conn);
        try {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("db error during commit of LagAvtaleCtrl=" + e);
            return;
        }
    }
}
