import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkoutMachine {
    private String name;
    private String mDescription;
    private int machineID;

    public WorkoutMachine(String name, String mDescription) {
        this.name = name;
        this.mDescription = mDescription;
    }


    public void createWorkoutMachine(Connection conn) {  //We need to create an exercise first in order to create the subclasses
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO Machine (MDescription, Name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, mDescription);
            stmt.setString(2, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            machineID = rs.getInt(1);
            System.out.println(machineID);
        } catch (Exception e) {
            System.out.println("Failed to create exercise=" + e);
        }
    }

}
