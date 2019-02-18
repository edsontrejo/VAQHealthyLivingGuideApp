/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

/**
 *
 * @author dark_
 */
public class Food {
    private int id;
    private String name;
    private double servingsize;
    private int groupId;
    private String image;
    private double calories = 0;
    private double fats = 0;
    private double cholesterol = 0;
    private double sodium = 0;
    private double potassium = 0;
    private double carbohydrates = 0;
    private double proteins = 0;
    
    public Food(int id, String name, double servingsize ,int groupId, String image, double calories, double fats, double cholesterol, double sodium, double potassium, double carbohydrates, double proteins){
        this.id = id;
        this.name = name;
        this.servingsize = servingsize;
        this.groupId = groupId;
        this.image = image;
        this.calories = calories;
        this.fats = fats;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
    }
    
    public Food(int id, String name, double servingsize, int groupId, String image){
        this.id = id;
        this.name = name;
        this.servingsize = servingsize;
        this.groupId = groupId;
        this.image = image;
    }

    public Food() {
        this.id = -1;
        this.name = "Unknown";
        this.servingsize = 0;
        this.groupId = -1;
        this.image = "Undefined";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
       /**
     * @return the servingsize
     */
    public double getServingSize() {
        return servingsize;
    }

    /**
     * @param servingsize
     */
    public void setServingSize(double servingsize) {
        this.servingsize = servingsize;
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
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the calories
     */
    public double getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * @return the fats
     */
    public double getFats() {
        return fats;
    }

    /**
     * @param fats the fats to set
     */
    public void setFats(double fats) {
        this.fats = fats;
    }

    /**
     * @return the cholesterol
     */
    public double getCholesterol() {
        return cholesterol;
    }

    /**
     * @param cholesterol the cholesterol to set
     */
    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    /**
     * @return the sodium
     */
    public double getSodium() {
        return sodium;
    }

    /**
     * @param sodium the sodium to set
     */
    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    /**
     * @return the potassium
     */
    public double getPotassium() {
        return potassium;
    }

    /**
     * @param potassium the potassium to set
     */
    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    /**
     * @return the carbohydrates
     */
    public double getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * @param carbohydrates the carbohydrates to set
     */
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * @return the proteins
     */
    public double getProteins() {
        return proteins;
    }

    /**
     * @param proteins the proteins to set
     */
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }
}
