import java.sql.SQLException;

public class Ctrl extends DBConn {
    public Testerino testerino;

    public Ctrl() {
        connect();
        testerino = new Testerino();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagAvtaleCtrl=" + e);
            return;
        }
    }

    public static void main(String[] args) {
        Ctrl c = new Ctrl();
        c.insertIntoMachineTable();
    }

    public void insertIntoMachineTable() {
        testerino.initialize(conn);
        try {
            conn.commit();
            System.out.println("Changes have been made and committed");
        } catch (SQLException e) {
            System.out.println("db error during commit of LagAvtaleCtrl=" + e);
            return;
        }
    }
}
