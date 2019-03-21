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
        this.scanner = new Scanner(System.in);
    }

    private void addCategory(){
        String name;
        System.out.println("Hva er navnet på øvelseskategorien?");
        name = scanner.nextLine();
        ExerciseCategory ec = new ExerciseCategory(name);
        ec.save(conn);
    }
}
