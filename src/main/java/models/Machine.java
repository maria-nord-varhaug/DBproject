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

    public void initialize(Connection conn) {

    }

    public void refresh(Connection conn) {

    }

    public void save(Connection conn) {
        try {
            PreparedStatement hjelp;
            hjelp = conn.prepareStatement("INSERT INTO Machine(MDescription, Name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            hjelp.setString(1, mDescription);
            hjelp.setString(2, name);
            hjelp.executeUpdate();
            conn.commit();
            ResultSet resultatset = hjelp.getGeneratedKeys();
            resultatset.next();

            machineID = resultatset.getInt(1);
            //System.out.println(machineID);
        } catch (Exception e) {
            System.out.println("Failed to create/update machine=" + e);
            e.printStackTrace();
        }
    }

    public void list(Connection conn) {

    }
}
