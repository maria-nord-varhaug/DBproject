import models.ExerciseCategory;

import java.sql.SQLException;
import java.util.Scanner;

public class ExerciseCategoryCtrl extends DBConn{
    private Scanner scanner;
    private ExerciseCategory ec = new ExerciseCategory();

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
        ExerciseCategory newEC = new ExerciseCategory();
        newEC.setName(name);
        newEC.save(conn);
        return newEC;
    }

    public void addExerciseToCategory(Scanner scanner, int exerciseID) {
        String s;
        System.out.println("Here are the existing categories: ");
        ExerciseCategory.listCategories(conn);
        System.out.println("What category should the exercise be in?");
        System.out.println("If you want to make a new category, write 'y', else 'n': ");
        s = scanner.nextLine();
        int categoryID;
        if (s.equals("y")) {
            ec = addCategory(scanner);
            categoryID = ec.getExerciseCategoryID();
        } else {
            System.out.println("Which category do you want to add the exercise to (write ID): ");
            categoryID = Integer.parseInt(scanner.nextLine());
            System.out.println("catID: " + categoryID);

        }
        ec.createExCatConnection(conn, exerciseID, categoryID);

    }
}
