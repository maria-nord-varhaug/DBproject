package models;

import java.sql.*;

public class ExerciseCategory extends ActiveDomainObject {

/*CREATE TABLE models.ExerciseCategory(
	ExerciseCategoryID INTEGER NOT NULL AUTO_INCREMENT,
	ECName VARCHAR(100),
	CONSTRAINT ExerciseCategory_PK PRIMARY KEY(ExerciseCategoryID));*/


    private String name;
    private int exerciseCategoryID;

    public void setName(String name) {
        this.name = name;
    }

    public void setExerciseCategoryID(int exerciseCategoryID) {
        this.exerciseCategoryID = exerciseCategoryID;
    }

    public int getExerciseCategoryID() {
        return exerciseCategoryID;
    }

    @Override
    public void initialize(Connection conn) {

    }

    @Override
    public void refresh(Connection conn) {

    }

    public void save(Connection conn){
        try{
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO ExerciseCategory(ECName) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,name);
            stmt.executeUpdate();
            conn.commit();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            setExerciseCategoryID(rs.getInt(1));
            System.out.println(exerciseCategoryID);
        } catch (Exception e) {
            System.out.println("Failed to create exercise category = "+e);
        }


    }

    public static void listCategories(Connection conn) {
        try {
            Object[][] table;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) catNumber FROM exercisecategory;");
            rs.next();
            int number = rs.getInt(1);

            rs = stmt.executeQuery("SELECT * FROM exercisecategory;");
            table = new String[number + 1][4];
            table[0] = new String[]{"categoryID:", "name:"};
            int index = 1;

            while (rs.next()) {
                String categoryID = Integer.toString(rs.getInt("ExerciseCategoryID"));
                String name = rs.getString("ECName");
                table[index] = new String[]{categoryID, name};
                System.out.println(index);
                index++;
            }

            for (Object[] row : table) {
                System.out.format("%15s%15s\n", row);
            }
        } catch (Exception e) {
            System.out.println("there was a problem fetching workouts=" + e);
        }
    }

    public void createExCatConnection(Connection conn, int exID, int catID) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO exerciseincategory(ExerciseID, ExerciseCategoryID) " +
                    "VALUES(?, ?);");
            stmt.setInt(1, exID);
            stmt.setInt(2, catID);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.err.println("Could not insert exercise into category");
            e.printStackTrace();
        }

    }

    @Override
    public void list(Connection conn) {

    }

    public static void listExInCat(Connection conn, int categoryID) {
        try {
            Statement spm = conn.createStatement();
            ResultSet rs = spm.executeQuery("SELECT EName FROM exercise NATURAL JOIN exerciseincategory WHERE exercisecategoryID = " + categoryID);
            System.out.println("Exercises: ");
            while (rs.next()) {
                String categoryname = rs.getString(1);
                System.out.println(categoryname);
            }
        } catch (Exception e) {
            System.out.println("something went wring with query5=" + e);
        }
    }


}
