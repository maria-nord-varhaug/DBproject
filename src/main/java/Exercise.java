import java.sql.Connection;

public abstract class Exercise extends ActiveDomainObject {

    protected String eName;   //I think we need to be able to access these through subclasses?
    protected int performance;
    protected int exerciseID;

    public Exercise(String eName, int performance) {
        this.eName = eName;
        this.performance = performance;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public int getPerformance() {
        return performance;
    }

    public String geteName() {
        return eName;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    @Override
    public void initialize(Connection conn) {

    }

    @Override
    public void refresh(Connection conn) {

    }

    @Override
    public void save(Connection conn) {

    }
}
