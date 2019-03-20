import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExerciseCategory {

/*CREATE TABLE ExerciseCategory(
	ExerciseCategoryID INTEGER NOT NULL AUTO_INCREMENT,
	ECName VARCHAR(100),
	CONSTRAINT ExerciseCategory_PK PRIMARY KEY(ExerciseCategoryID));*/


    private String name;
    private int exerciseCategoryID;

    public ExerciseCategory(String n){
        this.name=n;
    }

    public void setExerciseCategoryID(int ecid){
        this.exerciseCategoryID=ecid;
    }

    public void save(Connection conn){
        try{
            PreparedStatement stmt;
            stmt=conn.prepareStatement("INSERT INTO ExerciseCategory VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,name);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            setExerciseCategoryID(rs.getInt(1));
            System.out.println(exerciseCategoryID);
        }
        catch(Exception e){
            System.out.println("Failed to create exercise category = "+e);
        }

    }


}
