package Environment.Models;

import Environment.Classes.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Environment.Database.Database;
import Environment.MainApplication;
import Environment.Classes.FoodGroup;

public class AllNutrientsModel {
    static Database instance = MainApplication.getDatabase();
    
    static Connection connection = instance.getMyConnection();
    
    public static FoodGroup retrieveGroup(int Id)
    {    
        FoodGroup _foodgroup = new FoodGroup();
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM food_groups WHERE id = ? LIMIT 1"))
        {
            statement.setInt(1, Id);

            try (ResultSet set = statement.executeQuery())
            {
                if (set.next())
                {
                    _foodgroup.setGroupId(set.getInt("id"));
                    _foodgroup.setName(set.getString("name"));
                    _foodgroup.setCssid(set.getString("address"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Could not find food_group id = " + Id);
        }
        
        return _foodgroup; 
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
    
    public static boolean userHasFood(int profileId, int foodId){
        int alreadyExists = 0;
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM userfoods WHERE userId = ? AND foodId = ?"))
        {
            statement.setInt(1, profileId);
            statement.setInt(2, foodId);
            
            try (ResultSet set = statement.executeQuery())
            {
                if (set.next())
                    alreadyExists = set.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve count of food groups");
        }
        
        return (alreadyExists <= 0);
    }
    
    public void addFoodtoList(int profileId, int foodId, double amount){
        
        if(userHasFood(profileId, foodId))
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO userfoods (userId, foodId, amount) VALUES (?, ?, ?)")){
                statement.setInt(1, profileId);
                statement.setInt(2, foodId);
                statement.setDouble(3, amount);

                statement.executeUpdate();
                System.out.println("Food inserted");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        else
            try(PreparedStatement statement = connection.prepareStatement("UPDATE userfoods SET amount = ? WHERE userId = ? AND foodId = ?")){
                statement.setDouble(1, amount);
                statement.setInt(2, profileId);
                statement.setInt(3, foodId);
                
                statement.executeUpdate();
                System.out.println("Food updated");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
    }
    
    public static ArrayList<Food> retrieveFoodsByGroupId(int groupId){
        ArrayList<Food> _foods = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM foods WHERE groupId = ?"))
        {
            statement.setInt(1, groupId);
            
            try (ResultSet set = statement.executeQuery())
            {
                while(set.next())
                    _foods.add(new Food(set.getInt(1), set.getString(2), set.getDouble(5) ,set.getInt(3), set.getString(4), set.getDouble(6), set.getDouble(7), set.getDouble(8), set.getDouble(9), set.getDouble(10), set.getDouble(11), set.getDouble(12)));
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve all foods from group " + groupId);
        }
        
        return _foods;
    }
    
    public static int retrieveTotalGroups(){
        int totalGroups = 0;
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM food_groups"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                if (set.next())
                    totalGroups = set.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve count of food groups");
        }
        
        return totalGroups;
    }
    
    public static int retrieveTotalFoods(){
        int totalFoods = 0;
        
        try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM foods"))
        {
            try (ResultSet set = statement.executeQuery())
            {
                if (set.next())
                    totalFoods = set.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve count of foods");
        }
        
        return totalFoods;
    }
}
