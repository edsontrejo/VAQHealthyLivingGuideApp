/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise.Equipment;

import Exercise.Exercise.ExerciseTypeE;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */
public class Equipment {

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
     * @return the primaryMuscle
     */
    public String getPrimaryMuscle() {
        return primaryMuscle;
    }

    /**
     * @param primaryMuscle the primaryMuscle to set
     */
    public void setPrimaryMuscle(String primaryMuscle) {
        this.primaryMuscle = primaryMuscle;
    }

    /**
     * @return the secondaryMuscle
     */
    public String getSecondaryMuscle() {
        return secondaryMuscle;
    }

    /**
     * @param secondaryMuscle the secondaryMuscle to set
     */
    public void setSecondaryMuscle(String secondaryMuscle) {
        this.secondaryMuscle = secondaryMuscle;
    }

    public Equipment() {
        this.name = "None";
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
     * @return the type
     */
    public ExerciseTypeE getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ExerciseTypeE type) {
        this.type = type;
    }
    
    private String name;
    private ExerciseTypeE type;
    private String description;
    private Image image;
    private String primaryMuscle;
    private String secondaryMuscle;
    
    
    public Equipment(String n,ExerciseTypeE e)
    {
        this.name = n;
        type = e;
    }
    public Equipment(String n)
    {
        this.name = n;
    }
    
       @Override
    public String toString() {
        return getName();
    }

    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Equipment)) {
            return false;
        }

        Equipment equipment = (Equipment) o;

        return equipment.name.equals(name);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }
    
  
    
}
