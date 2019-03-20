import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise extends ActiveDomainObject {

    protected String eName;   //I think we need to be able to access these through subclasses?
    protected int performance;
    protected int exerciseID;

    public Exercise(String eName, int performance) {
        this.eName = eName;
        this.performance = performance;
    }

    public void createExercise(Connection conn) {  //We need to create an exercise first in order to create the subclasses

    }


    @Override
    public void initialize(Connection conn) {

    }

    @Override
    public void refresh(Connection conn) {

    }

    @Override
    public void save(Connection conn) {
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO Exercise (EName, Performance) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, eName);
            stmt.setInt(2, performance);
            stmt.executeUpdate();

            //This fetches the newly inserted ID :))
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            exerciseID = rs.getInt(1);
            System.out.println(exerciseID);
        } catch (Exception e) {
            System.out.println("Failed to create/update exercise=" + e);
            e.printStackTrace();
        }
    }

    @Override
    public void list(Connection conn) {
        // Not used here
    }

}
