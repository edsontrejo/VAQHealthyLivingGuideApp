/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

import Environment.Classes.Equipment;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */


public class Exercise {

    /**
     * @return the muscleTypeE
     */
    public MuscleTypeE getMuscleTypeE() {
        return muscleTypeE;
    }

    /**
     * @param muscleTypeE the muscleTypeE to set
     */
    public void setMuscleTypeE(MuscleTypeE muscleTypeE) {
        this.muscleTypeE = muscleTypeE;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

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

    /**
     * @return the difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the type
     */
    public ExerciseTypeE getType() {
        return exerciseType;
    }

    /**
     * @param type the type to set
     */
    public void setType(ExerciseTypeE type) {
        this.exerciseType = type;
    }

    /**
     * @return the equipment
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * @return the met
     */
    public Double getMet() {
        return met;
    }

    /**
     * @param met the met to set
     */
    public void setMet(Double met) {
        this.met = met;
    }
    
    public enum ExerciseTypeE {
        CARDIO,
        BALANCE,
        FLEXIBILITY,
        STRENGTH
    }  
    public enum MuscleTypeE{
        Triceps,
        Biceps,
        Back,
        Glutes,
        LowerLegs,
        Shoulders,
        Chest,
        ForeArms,
        Abs,
        UpperLegs
    }
    
    private String name;
    private String difficulty;
    private String description;
    private Image image;
    private ExerciseTypeE exerciseType;
    private MuscleTypeE muscleTypeE;
    private Equipment equipment;
    private Double met;
    
    @Override
    public String toString()
    {
        return getName();
    }
  
    
    // met = metabolic equivalent
    public static double CaloriesBurned(Double met, double hrs,double weightKG)
    {
        if (hrs < 1)
            return met * weightKG*hrs;
        else
            return met * weightKG/hrs;       
    }
    
    public double PoundsToKG(double lb)
    {
       return lb/100; 
    }
}
