package Environment.Models;

import Environment.Classes.Food;
import Environment.Classes.FoodGroup;
import Environment.Classes.Nutrient;
import Environment.Database.Database;
import Environment.MainApplication;
import static Environment.Models.AllNutrientsModel.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class MyItemsModel {
    static Database instance = MainApplication.getDatabase();
    
    static Connection connection = instance.getMyConnection();
    
    private ObservableList<Food> userPlate        = FXCollections.observableArrayList();
    
    public static ArrayList<Food> retrieveFoodList(int profileId){
        ArrayList<Food> _foodlist = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM userfoods WHERE userId = ?"))
        {
            statement.setInt(1, profileId);
            
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next())
                    _foodlist.add(retrieveFoodById(set.getInt("foodId")));
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve all foods list");
        }
        
        return _foodlist;
    }
    
    public static Food retrieveFoodById(int foodId){
        Food _food = new Food();
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM foods WHERE id = ?"))
        {
            statement.setInt(1, foodId);
            
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next())
                    _food = new Food(set.getInt(1), set.getString(2), set.getDouble(5) ,set.getInt(3), set.getString(4), set.getDouble(6), set.getDouble(7), set.getDouble(8), set.getDouble(9), set.getDouble(10), set.getDouble(11), set.getDouble(12));
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve food id = " + foodId);
        }
        
        return _food;
    }
    
     public static ArrayList<FoodGroup> retrieveAllGroups(){
        ArrayList<FoodGroup> _foodgroups = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM food_groups"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next())
                    _foodgroups.add(new FoodGroup(set.getInt("id"), set.getString("name"), set.getString("cssid")));
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve all food groups");
        }
        
        return _foodgroups;
    }


    /**
     * @return the plate
     */
    public ObservableList<Food> getPlate() {
        return userPlate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(ObservableList<Food> plate) {
        this.userPlate = plate;
    }
}
