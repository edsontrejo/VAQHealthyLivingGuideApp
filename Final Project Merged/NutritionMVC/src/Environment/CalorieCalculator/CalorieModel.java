/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.CalorieCalculator;

import Environment.Classes.Category;
import Environment.Classes.Nutrient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import Environment.*;
import Environment.Database.Database;
import java.sql.*;

/**
 *
 * @author xwc981
 */
public class CalorieModel {
    //
    //The basic food groups are:
    //breads, cereals, rice, pasta, noodles and other grains
    //vegetables and legumes
    //fruit
    //milk, yoghurt, cheese and/or alternatives
    //lean meat, fish, poultry, eggs, nuts and legumes.

    static Database myDatabase = MainApplication.getDatabase();
    static Connection connection = myDatabase.getMyConnection();
    
    private ObservableList<Category> foodCategories   = FXCollections.observableArrayList();
    private ObservableList<Nutrient> foodNutrients    = FXCollections.observableArrayList();
    private ObservableList<Nutrient> userPlate        = FXCollections.observableArrayList();

    public CalorieModel() {
        // hard-coded for testing
        foodNutrients.clear();
    }

    public void addNutrientToPlate(Nutrient n) {
        // add only unique items..
        int found = getPlate().indexOf(n);
        if (getPlate().indexOf(n) != -1) 
        {
            // warn and return
            return;
        }
        else
            getPlate().add(n);
    }

    ObservableList<Nutrient> getCategoryChoices(Category selectedCat) {
        // get the nutrients from database based on the cat selected
        
        /*
        "Grains" "Vegetables & fruits" "Dairy" "Meats" "Fats, spreads and oils" "Foods and drinks high in fat"
        */
        
        //GRAINS
        if (selectedCat.getName().equalsIgnoreCase("Grains-Breads")) {
            getMyNutrients().clear();
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 2"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Grains-Breads", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    System.out.println("Could not retrieve Grains-Breads food group");
            }
            System.out.println("Uploaded Grains-Breads Category");
        //VEGTABLES       
        } else if (selectedCat.getName().equalsIgnoreCase("Vegetables & fruits")) {
            getMyNutrients().clear();
             try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 1"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Vegetables & fruits", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    exc.printStackTrace();
            }
            System.out.println("Uploaded Vegetables Category");
        //Dairy    
        } else if (selectedCat.getName().equalsIgnoreCase("Dairy")) {
            getMyNutrients().clear();
             try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 3"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Dairy", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    exc.printStackTrace();
            }
            System.out.println("Uploaded Fruits Category");
        //Meats
        } else if (selectedCat.getName().equalsIgnoreCase("Meats")){
            getMyNutrients().clear();
             try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 4"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Meats", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    exc.printStackTrace();
            }
            System.out.println("Uploaded Oils and Sweets Category");
        //Fats   
        } else if (selectedCat.getName().equalsIgnoreCase("Fats, spreads and oils")) {
            getMyNutrients().clear();
             try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 5"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Fats, spreads and oils", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    exc.printStackTrace();
            }
            System.out.println("Uploaded Dairy Category");
        //unhealthy    
        } else if (selectedCat.getName().equalsIgnoreCase("Foods and drinks high in fat")) {
            getMyNutrients().clear();
             try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM vaqnutri.foods WHERE groupId = 6"))
            {
                try (ResultSet set = statement.executeQuery())
                {
                    while(set.next()){
                        getMyNutrients().add(new Nutrient(set.getString("image"), set.getString("name"), "Foods and drinks high in fat", set.getString("groupId"),
                                          "grams", Double.parseDouble(set.getString("calories")),
                                          Double.parseDouble(set.getString("serving size")), Double.parseDouble(set.getString("fats")), Double.parseDouble(set.getString("cholesterol")), 
                                          Double.parseDouble(set.getString("sodium")), Double.parseDouble(set.getString("potassium")), Double.parseDouble(set.getString("carbohydrates")), 
                                          Double.parseDouble(set.getString("proteins"))));
                    }
                }
            } catch (SQLException exc) {
                    exc.printStackTrace();
            }
            System.out.println("Uploaded Meats Category");    
        }
        return (this.getMyNutrients());
    }

    public void removeNutrientFromPlate(Nutrient n) {
        int found = getPlate().indexOf(n);
        if (getPlate().indexOf(n) != -1) {
            getPlate().remove(found);
        }
        for (int i = 0; i < getPlate().size(); i++) 
        {
            if (n.getName().compareToIgnoreCase(getPlate().get(i).getName())==0)
            {
                getPlate().remove(i);
            }    
        }
    }

    public void removeAllNutrientsFromPlate() {
        getPlate().clear();
    }

    public ObservableList<PieChart.Data> getPlateData(boolean catFlag) {
        //
        //cat flag arraanges nutrients by categories
        ObservableList<PieChart.Data> pieChartData1  = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> pieChartData2  = FXCollections.observableArrayList();
        
        ObservableList<Category> foodCategories  = RetrieveFoodCategories();
        
        if(getPlate() != null && getPlate().size()!=0)
        {
            FXCollections.sort(getPlate());
            if (catFlag ==false)
            {
                for (int i = 0; i < getPlate().size(); i++) {
                    pieChartData1.add(new PieChart.Data(getPlate().get(i).getName(), getPlate().get(i).getActualCalories()));
                }
                return pieChartData1;
            }
            else
            {
                // inefficient..switch to hashing once working...
                for (int i = 0; i < getPlate().size(); i++) 
                {
                    String cat = getPlate().get(i).getCategory();
                    for (int j = 0; j < foodCategories.size(); j++) {
                        if(foodCategories.get(j).getName().compareTo(cat)==0)
                        {
                            foodCategories.get(j).setCategoriyCalories
                                    ((int) (foodCategories.get(j).getCategoriyCalories()+getPlate().get(i).getActualCalories()));
                        }
                             
                    }
                       
                }
                //
                for (int i = 0; i < foodCategories.size(); i++) 
               {  
                   pieChartData2.add(new PieChart.Data(foodCategories.get(i).getName(), foodCategories.get(i).getCategoriyCalories()));
               }  
                return pieChartData2;
            }
            
        }
        return null;
    }

    public ObservableList<Category> RetrieveFoodCategories() {
        foodCategories.clear();

        /*
        "Grains" "Vegetables & fruits" "Dairy" "Meats" "Fats, spreads and oils" "Foods and drinks high in fat"
        */
        
        // Get & populate from database
        foodCategories.add(new Category(2, "Grains-Breads",0));
        foodCategories.add(new Category(1, "Vegetables & fruits",0));
        foodCategories.add(new Category(3, "Dairy",0));
        foodCategories.add( new Category(4,"Meats",0));
        foodCategories.add(new Category(5, "Fats, spreads and oils",0));
        foodCategories.add(new Category(6, "Foods and drinks high in fat",0));
        return foodCategories;
    }

    /**
     * @return the myCategories
     */
    public ObservableList<Category> getMyCategories() {
        return RetrieveFoodCategories();
    }

    /**
     * @param myCategories the myCategories to set
     */
    public void setMyCategories(ObservableList<Category> myCategories) {
        this.foodCategories = myCategories;
    }

    Nutrient gerNutrientChoices(Nutrient n1) {
        return n1;
    }

    /**
     * @return the plate
     */
    public ObservableList<Nutrient> getPlate() {
        return userPlate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(ObservableList<Nutrient> plate) {
        this.userPlate = plate;
    }

    /**
     * @return the myNutrients
     */
    public ObservableList<Nutrient> getMyNutrients() {
        return foodNutrients;
    }

    /**
     * @param myNutrients the myNutrients to set
     */
    public void setMyNutrients(ObservableList<Nutrient> myNutrients) {
        this.foodNutrients = myNutrients;
    }

}
