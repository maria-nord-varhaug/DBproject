
public class MachineExercise extends Exercise {

    WorkoutMachine workoutMachine;
    private int kg;
    private int sets;

    MachineExercise(String eName, int performance, int kg, int sets, WorkoutMachine workoutMachine) {
        super(eName, performance);
        this.kg = kg;
        this.sets = sets;
        this.workoutMachine = workoutMachine;
    }
}
