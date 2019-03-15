
public class ExerciseWithoutMachine extends Exercise {

    private int exerciseID;
    private String description;

    public ExerciseWithoutMachine(String eName, int performance, String description) {
        super(eName, performance);
        this.description = description;
    }

}
