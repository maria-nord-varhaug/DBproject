import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateExerciseCtrl ec = new CreateExerciseCtrl();
        ec.addExercise(scanner);
    }
}
