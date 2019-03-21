import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExerciseCategoryCtrl exCon = new ExerciseCategoryCtrl();
        exCon.addExerciseToCategory(scanner, 5);
    }
}
