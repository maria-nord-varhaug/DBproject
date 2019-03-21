import models.ExerciseCategory;

import java.sql.SQLException;
import java.util.Scanner;

public class ExerciseCategoryCtrl extends DBConn{
    private Scanner scanner;
    private ExerciseCategory ec;

    public ExerciseCategoryCtrl() {
        connect();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
    }

    public ExerciseCategory addCategory(Scanner scanner) {
        String name;
        System.out.println("What is the name of the exercise category?");
        name = scanner.nextLine();
        ExerciseCategory newEC = new ExerciseCategory(name);
        newEC.save(conn);
        return newEC;
    }

    public void showCategories(Scanner scanner) {
        String name;
        System.out.println("Here are the existing categories: ");


    }

    public void addExerciseToCategory(Scanner scanner) {
        String s;
        showCategories(scanner);
        System.out.println("What category should the exercise be in?");
        System.out.println("If you want to make a new category, write 'y', else 'n': ");
        s = scanner.nextLine();
        if (s.equals("y")) {
            ec = addCategory(scanner);
        } else {

        }
    }
}
