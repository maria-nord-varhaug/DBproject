public class WorkoutMachine {
    private String name;
    private String mDescription;
    private int machineID;

    public WorkoutMachine(String name, String mDescription) {
        this.name = name;
        this.mDescription = mDescription;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getName() {
        return name;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
