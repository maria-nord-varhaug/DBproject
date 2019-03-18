/*Etter at active domain object er lagt, så HUSK å la Workout klassen extende ActiveDomainObject*/

import java.sql.Date;
import java.sql.Time;
import java.util.List;


public class Workout {

    //Variabler som vi også har i sql filen
    private int workoutID;
    private Date workoutDate;
    private Time workoutTime;
    private int duration;
    private int personalShape;
    private int performance;
    private String note;


    //Variabler nødvendige for usecasene. kommer itilegg til sql variablene
    private List<Exercise> exercises;


    public Workout(Date workoutDate, Time workoutTime, int duration, int personalShape, int performance, String note, List<Exercise> exercises) {
        this.workoutDate = workoutDate;
        this.workoutTime = workoutTime;
        this.duration = duration;
        this.personalShape = personalShape;
        this.performance = performance;
        this.note = note;
        this.exercises = exercises;
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

    public int getPerformance() {
        return performance;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void addExercises(Exercise exercise){
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise){ exercises.remove(exercise);}

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

    public void setPerformance(int performance){
        this.performance = performance;
    }

    public void setNote(String note) {
        this.note = note;
    }
}