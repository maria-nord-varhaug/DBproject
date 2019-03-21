package models;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MachineExercise extends Exercise {

    private int machineID;
    private int kg;
    private int sets;

    public MachineExercise(String eName, int performance, int kg, int sets, Machine machine) {
        super(eName, performance);
        this.kg = kg;
        this.sets = sets;
        this.machineID = machine.getMachineID();
    }

    @Override
    public void save(Connection conn) {  //Lagrer machineexercise
        try {
            super.save(conn);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Machineexercise VALUES (?, ?, ?, ?)");
            System.out.println("exerciseID: " + exerciseID + "\nkg: " + kg + "\nsets: " + sets + "\nmachineID: " + machineID);
            stmt.setInt(1, exerciseID);
            stmt.setInt(2, kg);
            stmt.setInt(3, sets);
            stmt.setInt(4, machineID);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("DB error during insert of machineexercise=" + e);
        }
    }
}
