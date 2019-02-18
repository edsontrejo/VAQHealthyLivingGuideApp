/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Models.SearchModel;
import Environment.Views.SearchView;
import javafx.event.ActionEvent;

/**
 *
 * @author yessi
 */
public class SearchController {
    SearchModel foodModel; 
    SearchView foodView;

    public SearchController(SearchModel foodModel, SearchView foodView) 
    {
        this.foodModel = foodModel;
        this.foodView = foodView;
        setupHandlers();
    }
    
    public SearchController() 
    {
        this.foodModel = new SearchModel();
        this.foodView  = new SearchView();
        setupHandlers();
    }
    
    public void setupHandlers()
    {
       foodView.getUpdateButton().setOnAction((ActionEvent event) -> {
           //
           //view gave me name
           String name = getsearchname();
           
           //name gave me data
           String ImageName = getsearchimagename(name);
           int group = getsearchfoodgroup(name);
           double serving = getsearchserving(name);
           double calories = getsearchcalories(name);
           double totalFat = getsearchtotalfat(name);
           double cholesterol = getsearchcholesterol(name);
           double sodium = getsearchsodium(name);
           double potassium = getsearchpotassium(name);
           double carbohydrates = getsearchcarbohydrates(name);
           double proteins = getsearchproteins(name);
           
           
           /*
           foodGroup;
           */
           
           //data updates the view
           foodView.setImageName(ImageName);
           if(group == 1){
                   foodView.getGroupText().setText("Vegetables, salads, fruits");
           }else if(group == 2){
                   foodView.getGroupText().setText("Wholemeal cereals and breads");
           }else if(group == 3){
                   foodView.getGroupText().setText("Milk, yogurt and cheese");
           }else if(group == 4){
                   foodView.getGroupText().setText("Meat, poultry, fish, eggs");
           }else if(group == 5){
                   foodView.getGroupText().setText("Fats, spreads and oils");
           }else if(group == 6){
                   foodView.getGroupText().setText("Foods and drinks high in fat");
           }
           foodView.getServingText().setText(Double.toString(serving));
           foodView.getCaloriesText().setText(Double.toString(calories));
           foodView.getTotalFatText().setText(Double.toString(totalFat));
           foodView.getCholesterolText().setText(Double.toString(cholesterol));
           foodView.getSodiumText().setText(Double.toString(sodium));
           foodView.getPotassiumText().setText(Double.toString(potassium));
           foodView.getCarbohydratesText().setText(Double.toString(carbohydrates));
           foodView.getProteinsText().setText(Double.toString(proteins));
           //
           foodView.updateSearchView();
       });
        
    }
    
    public String getsearchname()
    {
       String name = foodView.getNameText().getText();
       return name;
    }
    
    public String getsearchimagename(String name)
    {
       String ImageName = foodModel.getImageName(name);
       return ImageName;
    }
    
    public int getsearchfoodgroup(String name)
    {
       int group = foodModel.getFoodGroup(name);
       return group;
    }
    
    public double getsearchserving(String name)
    {
       double serving = foodModel.getServing(name);
       return serving;
    }
    
    public double getsearchcalories(String name)
    {
       double calories = foodModel.getCalories(name);
       return calories;
    }
    
    public double getsearchtotalfat(String name)
    {
       double totalFat = foodModel.getTotalFat(name);
       return totalFat;
    }
    
    public double getsearchcholesterol(String name)
    {
       double cholesterol = foodModel.getCholesterol(name);
       return cholesterol;
    }
    
    public double getsearchsodium(String name)
    {
       double sodium = foodModel.getSodium(name);
       return sodium;
    }
    
    public double getsearchpotassium(String name)
    {
       double potassium = foodModel.getPotassium(name);
       return potassium;
    }
    
    public double getsearchcarbohydrates(String name)
    {
       double carbohydrates = foodModel.getCarbohydrates(name);
       return carbohydrates;
    }
    
    public double getsearchproteins(String name)
    {
       double proteins = foodModel.getProteins(name);
       return proteins;
    }
    
    /**
     * @return the Model
     */
    public SearchModel getModel() {
        return foodModel;
    }

    /**
     * @param SearchModel the Model to set
     */
    public void setModel(SearchModel foodModel) {
        this.foodModel = foodModel;
    }

    /**
     * @return the View
     */
    public SearchView getView() {
        return foodView;
    }

    /**
     * @param View the View to set
     */
    public void setView(SearchView foodView) {
        this.foodView = foodView;
    }
    
}