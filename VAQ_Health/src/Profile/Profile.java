/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

import Disease.Disease;
import Exercise.ExerciseProfile;
import Profile.Medical.Medical;
import Profile.Personal1.Personal;
import Profile.Personal1.Personal;
import Profile.Personal1.Personal;
import Routine.WeeklyRoutine;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */
public class Profile {
    public Personal personal = new Personal();
    public Medical medical = new Medical();
    public ExerciseProfile exerciseProfile = new ExerciseProfile();
    public WeeklyRoutine currentWeeklyRoutine = null;
    public ArrayList<WeeklyRoutine> weeklyRoutineList = new ArrayList<>();
    public String username;
    public String password;
    public String imagePath;
    public Image profileImage;
    public int id;
    
    @Override
    public String toString()
    {      
        return personal.toString();
    }
}
