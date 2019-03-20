package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Machine extends ActiveDomainObject {
    private String name;
    private String mDescription;
    private int machineID;

    public Machine(String name, String mDescription) {
        this.name = name;
        this.mDescription = mDescription;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }


    public void initialize(Connection conn) {

    }

    public void refresh(Connection conn) {

    }

    public void save(Connection conn) {
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO Machine(MDescription, Name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
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

    public void list(Connection conn) {

    }
}
