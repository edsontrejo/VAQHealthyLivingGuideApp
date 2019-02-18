package Environment.Classes;

import java.util.ArrayList;

/**
 *
 * @author ^.^
 */
public class WeeklyRoutine {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public ArrayList<ExerciseRoutine> monday = new ArrayList();
    public ArrayList<ExerciseRoutine> tuesday = new ArrayList();
    public ArrayList<ExerciseRoutine> wednesday = new ArrayList();
    public ArrayList<ExerciseRoutine> thursday = new ArrayList();
    public ArrayList<ExerciseRoutine> friday = new ArrayList();
    public ArrayList<ExerciseRoutine> saturday = new ArrayList();
    public ArrayList<ExerciseRoutine> sunday = new ArrayList();

    @Override
    public String toString() {
        return getName();
    }

}
