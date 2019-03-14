import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testerino extends ActiveDomainObject {

    private int machineID;
    private String mDescription;
    private String name;

    @Override
    public void initialize(Connection conn) {  //Example fetching data from DB
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Machine");
            while (rs.next()) {
                machineID = rs.getInt("MachineID");
                mDescription = rs.getString("MDescription");
                name = rs.getString("Name");
                System.out.println("ID: " + machineID + "\n  " + mDescription + "\n name: " + name + "\n\n---**---\n");
            }

        } catch (Exception e) {
            System.out.println("db error during select of avtale= " + e);
            return;
        }
    }

    @Override
    public void refresh(Connection conn) {
        initialize(conn);
    } //not this either

    @Override
    public void save(Connection conn) {
        try {
            Statement stmt = conn.createStatement();  //this is how insertion works
            stmt.executeUpdate("insert into Machine (MDescription, Name) values ('Morsomt Apparat','Apparat')");
        } catch (Exception e) {
            System.out.println("db error during insert of Machine=" + e);
            return;
        }
    }

}
