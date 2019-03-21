package models;

import java.sql.*;
import java.util.List;


public class Workout extends ActiveDomainObject {

    //Variabler som vi også har i sql filen
    private int workoutID;
    private Date workoutDate;
    private Time workoutTime;
    private int duration;
    private int personalShape;
    private String note;



    //Variabler nødvendige for usecasene. kommer itilegg til sql variablene
    private List<Exercise> exercises;


    public Workout(Date workoutDate, Time workoutTime, int duration, int personalShape, String note, List<Exercise> exercises) {
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
            stmt.setString(5, note);
            stmt.executeUpdate();  //Why is this duplicate it isn't here at all wtf

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            workoutID = rs.getInt(1);
            System.out.println(workoutID);
        } catch (Exception e) {
            System.out.println("Failed to create workout=" + e);
        }
    }

    public void createWorkoutExerciseConnection(Connection conn, int exerciseID) {
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO workoutexercise VALUES (?,?)");
            stmt.setInt(1, exerciseID);
            stmt.setInt(2, this.workoutID);
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            System.out.println("failed to insert into workoutexercise");
        }
    }

    public static void viewWorkouts(Connection conn, int n) {
        try {
            Object[][] table;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select workoutid, note, wdate, wtime from workout order by wdate desc, wtime desc limit " + n);
            table = new String[n + 1][4];
            table[0] = new String[]{"workoutid:", "note:", "workoutdate: ", "workouttime: "};
            int index = 1;

            while (rs.next()) {
                String workoutid = Integer.toString(rs.getInt("workoutid"));
                String note = rs.getString("note");
                String wdate = rs.getDate("wdate").toString();
                String wtime = rs.getTime("wtime").toString();
                table[index] = new String[]{workoutid, note, wdate, wtime};
                System.out.println(index);
                index++;
            }

            for (Object[] row : table) {
                System.out.format("%15s%15s%15s%15s\n", row);
            }
        } catch (Exception e) {
            System.out.println("there was a problem fetching workouts=" + e);
        }
    }

    public static void viewExerciseResult(Connection conn, String exercisename, Date startdate, Date enddate) {
        try {

            Statement testerino = conn.createStatement();
            ResultSet heiho = testerino.executeQuery("select COUNT(*) wdate from workout inner join workoutexercise on workout.WorkoutID = workoutexercise.WorkoutID natural join exercise where wdate<=\"" + enddate + "\" and wdate>=\"" + startdate + "\" and ename = \"" + exercisename + "\";");
            heiho.next();
            int antallting = heiho.getInt(1);

            Object[][] table;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select wdate, performance from workout inner join workoutexercise on workout.WorkoutID = workoutexercise.WorkoutID natural join exercise where wdate<=\"" + enddate + "\" and wdate>=\"" + startdate + "\" and ename = \"" + exercisename + "\";");

            table = new String[antallting + 1][];
            table[0] = new String[]{"workoutdate:", "performance:"};
            int index = 1;

            while (rs.next()) {
                String wdate = rs.getDate("wdate").toString();
                String performance = Integer.toString(rs.getInt("performance"));
                table[index] = new String[]{wdate, performance};
                System.out.println(index);
                index++;
            }

            for (Object[] row : table) {
                System.out.format("%15s%15s\n", row);
            }
        } catch (Exception e) {
            System.out.println("something is wrong when fetching data from resultthing=" + e);
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

    public void list(Connection conn) {

    }
}