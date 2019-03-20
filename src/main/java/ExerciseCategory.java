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

    public void ExerciseCategory(String n){
        this.name=n;
    }

    public void createExerciseCategory(Connection conn){
        try{
            PreparedStatement stmt;
            stmt=conn.prepareStatement("INSERT INTO ExerciseCategory ()");

        }
        catch(Exception e){

        }

    }


}
