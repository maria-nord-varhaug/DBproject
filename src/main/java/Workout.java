import java.sql.*;
import java.util.List;


public class Workout extends ActiveDomainObject {

    //Variabler som vi også har i sql filen
    private int workoutID;
    private Date workoutDate;
    private Time workoutTime;
    private int duration;
    private int performance;
    private int personalShape;
    private String note;


    //Variabler nødvendige for usecasene. kommer itilegg til sql variablene
    private List<Exercise> exercises;


    public Workout(Date workoutDate, Time workoutTime, int duration, int personalShape, int performance, String note, List<Exercise> exercises) {
        this.workoutDate = workoutDate;
        this.workoutTime = workoutTime;
        this.duration = duration;
        this.personalShape = personalShape;
        this.note = note;
        this.exercises = exercises;
    }


    public void createWorkout(Connection conn) {
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO Workout(WDate, WTime, Duration, PersonalShape, Note) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setDate(1, workoutDate);
            stmt.setTime(2, workoutTime);
            stmt.setInt(3, duration);
            stmt.setInt(4, personalShape);
            stmt.setString(6, note);

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            workoutID = rs.getInt(1);
            System.out.println(workoutID);
        } catch (Exception e) {
            System.out.println("Failed to create workout=" + e);
        }
    }

    //Metoder nødvendig for usecasene
    public String getNote(){ return note; }

    public int getWorkoutID() {
        return workoutID;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public Time getWorkoutTime() {
        return workoutTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getPersonalShape() {
        return personalShape;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void addExercises(Exercise exercise){
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise){ exercises.remove(exercise);}

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setWorkoutDate(Date workoutDate) {
        this.workoutDate = workoutDate;
    }

    public void setWorkoutTime(Time workoutTime) {
        this.workoutTime = workoutTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPersonalShape(int personalShape){
        this.personalShape = personalShape;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void initialize(Connection conn) {

    }

    public void refresh(Connection conn) {

    }

    public void save(Connection conn) {

    }
}