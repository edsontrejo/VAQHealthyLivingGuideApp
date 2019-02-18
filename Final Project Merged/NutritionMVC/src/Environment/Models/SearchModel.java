/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Models;

import Environment.Database.Database;
import Environment.MainApplication;
import java.sql.*;
import java.sql.ResultSet;


/**
 *
 * @author yessi
 */
public class SearchModel {

    static Database myDatabase = MainApplication.getDatabase();
    static Connection connection = myDatabase.getMyConnection();

    private String imageName;
    private String foodName;
    private int foodGroup;
    private double serving;
    private double calories;
    private double totalFat;
    private double cholesterol;
    private double sodium;
    private double potassium;
    private double carbohydrates;
    private double proteins;
    
    
    public SearchModel(String imageName, String foodName, int foodGroup, double serving, double calories, double totalFat
                        , double cholesterol, double sodium, double potassium, double carbohydrates, double proteins) {
        this.imageName = imageName;
        this.foodName = foodName;
        this.foodGroup = foodGroup;
        this.serving = serving;
        this.calories = calories;
        this.totalFat = totalFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
    }
    
    public SearchModel() {
        // hard-coded for testing
    }
    
    /**
     * @param n
     * @return the imageName
     */
    public String getImageName(String n) {
        String i = "Not in database";
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getString("image"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param imageName the imageName to set
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @param n
     * @return the foodGroup
     */
    public int getFoodGroup(String n) {
        int i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getInt("groupId"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param foodGroup the foodGroup to set
     */
    public void setFoodGroup(int foodGroup) {
        this.foodGroup = foodGroup;
    }

    /**
     * @param n
     * @return the serving
     */
    public double getServing(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("serving size"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param serving the serving to set
     */
    public void setServing(double serving) {
        this.serving = serving;
    }

    /**
     * @param n
     * @return the calories
     */
    public double getCalories(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("calories"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * @param n
     * @return the totalFat
     */
    public double getTotalFat(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("fats"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param totalFat the totalFat to set
     */
    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    /**
     * @param n
     * @return the cholesterol
     */
    public double getCholesterol(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("cholesterol"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param cholesterol the cholesterol to set
     */
    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    /**
     * @param n
     * @return the sodium
     */
    public double getSodium(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("sodium"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param sodium the sodium to set
     */
    public void setSodium(double sodium) {
        this.sodium = sodium;
    }
    
    /**
     * @param n
     * @return the potassium
     */
    public double getPotassium(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("potassium"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param potassium the potassium to set
     */
    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    /**
     * @param n
     * @return the carbohydrates
     */
    public double getCarbohydrates(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("carbohydrates"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param carbohydrates the carbohydrates to set
     */
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * @param n
     * @return the proteins
     */
    public double getProteins(String n) {
        double i = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE name = '" + n + "'"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next()){
                    i = (set.getDouble("proteins"));
                    System.out.println(i);
                }
            }
        }catch(SQLException e){ System.out.println("Food "+ n + " is not in the database");};
        return i;
    }

    /**
     * @param proteins the proteins to set
     */
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }
    
}