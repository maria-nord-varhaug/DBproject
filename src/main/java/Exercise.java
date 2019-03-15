
public class Exercise {

    protected String eName;
    protected int performance;
    protected int exerciseID;

    public Exercise(String eName, int performance) {
        this.eName = eName;
        this.performance = performance;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
}
