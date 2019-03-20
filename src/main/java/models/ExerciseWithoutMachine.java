package models;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ExerciseWithoutMachine extends Exercise {

    private String description;

    public ExerciseWithoutMachine(String eName, int performance, String description) {
        super(eName, performance);
        this.description = description;
    }

    @Override
    public void save(Connection conn) {  //Lagrer machineexercise
        try {
            super.save(conn);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ExerciseWithoutMachine VALUES (?, ?)");
            stmt.setInt(1, exerciseID);
            stmt.setString(2, description);
            stmt.execute();
            conn.commit();
        } catch (Exception e) {
            System.out.println("DB error during insert of Exercisewithoutmachine=" + e);
        }
    }
}
