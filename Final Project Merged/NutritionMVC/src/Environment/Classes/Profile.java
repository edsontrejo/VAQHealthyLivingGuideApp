/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */
public class Profile {
    public Personal personal = new Personal();
    public Medical medical = new Medical();
    public ExerciseProfile exerciseProfile = new ExerciseProfile();
    public WeeklyRoutine currentWeeklyRoutine = new WeeklyRoutine();
    public ArrayList<WeeklyRoutine> weeklyRoutineList = new ArrayList<>();
    public String username;
    public String password;
    public String imagePath;
    public Image profileImage;
    public boolean logged = false;
    public int id;
    
    @Override
    public String toString()
    {      
        return personal.toString();
    }
}

