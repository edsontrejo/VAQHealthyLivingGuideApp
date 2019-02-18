package Environment.Classes;

/**
 *
 * @author ^.^
 */
public class ExerciseRoutine {
    public Exercise exercise;
    public Double workOutTime;
    public boolean isCompleted;
    
    public ExerciseRoutine(Exercise exercise, Double workOutTime)
    {
        this.exercise = exercise;
        this.workOutTime = workOutTime;
    }

    public ExerciseRoutine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public String toString() {
        return exercise.getName();
    }
}
