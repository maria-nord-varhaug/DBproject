import java.sql.Connection;
import java.sql.PreparedStatement;

public class MachineExercise extends Exercise {

    private int workoutMachineID;
    private int kg;
    private int sets;

    MachineExercise(String eName, int performance, int kg, int sets, WorkoutMachine workoutMachine) {
        super(eName, performance);
        this.kg = kg;
        this.sets = sets;
        this.workoutMachineID = 15;
    }

    @Override
    public void save(Connection conn) {  //Lagrer machineexercise
        try {
            createExercise(conn);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Machineexercise VALUES (?, ?, ?, ?)");
            stmt.setInt(1, exerciseID);
            stmt.setInt(2, kg);
            stmt.setInt(3, sets);
            stmt.setInt(4, workoutMachineID);
            stmt.execute();
            conn.commit();
        } catch (Exception e) {
            System.out.println("DB error during insert of machineexercise=" + e);
        }
    }
}
