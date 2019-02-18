/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.CalorieCalculator;

import Environment.Classes.Category;
import Environment.Classes.Nutrient;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Toggle;

/**
 *
 * @author xwc981
 */
public class CalorieController {
    CalorieModel userModel; 
    CalorieView  userView;
    Category category;
    Nutrient nutrient;

    public CalorieController(CalorieModel userModel, CalorieView userView) 
    {
        this.userModel = userModel;
        this.userView  = userView;
        setupHandlers();
    }
    
    public CalorieController() 
    {
        this.userModel = new CalorieModel();
        this.userView  = new CalorieView();
        setupHandlers();
    }
    
    public void setupHandlers()
    {
	// When Category is selected, update the nutirents
	userView.getCategoriesComboBox().valueProperty().addListener(new ChangeListener<Category>() {
            @Override 
            public void changed(ObservableValue ov, Category c, Category c1) {                
                category = c1;   
                if ( category != null){
		    System.out.println("Catgory changed to:" + category.toString());
                    // get model to get nutirents of the category captured.
                    ObservableList<Nutrient> myNutrients = userModel.getCategoryChoices(c1);
                    userView.reDrawCalorieView2(myNutrients);
                }
		
            }    
        });
	    
	// When nutrient is selected, update the nutirent calories/portions/etc.
	userView.getCategoryChoices().valueProperty().addListener(new ChangeListener<Nutrient>() {
            @Override 
            public void changed(ObservableValue ov, Nutrient n, Nutrient n1) {                
                nutrient = n1; 
                if ( nutrient != null){
		System.out.println("nutrient changed to:" + nutrient.toString());
                    // get model to get nutirents of the category captured.
                    Nutrient myNutrient = userModel.gerNutrientChoices(n1);
                    userView.reDrawCalorieView3(myNutrient);
                }
		
            }    
        });
        userView.getPortionSlider().valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                   //do the math for nutrient calories, based on portion calories and unit
                    Nutrient currentN = userView.getCurrentNutrient();
                    if(currentN != null)
                    {
                        double totalCalories = (double) ((new_val.intValue() / currentN.getBasePortion()) * currentN.getBaseCalories()); 
                        userView.getTotalCalories().setText((Double.toString(totalCalories))); 
                        currentN.setActualCalories(totalCalories);
                    }
                    else
                    {
                       // userView.getTotalCalories().setText(Integer.toString(new_val.intValue()));    
                    }
            }
        });        
       
       userView.getClearPlateBtn().setOnAction(new EventHandler<ActionEvent> ()
       {
           @Override
           public void handle(ActionEvent event) {
               userModel.removeAllNutrientsFromPlate();
               userView.reDrawCalorieView();
	   
           }
       });
       
       userView.getClearNutrientBtn().setOnAction(new EventHandler<ActionEvent> ()
       {
           @Override
           public void handle(ActionEvent event) {
           //
           // update plate nutrients
           Nutrient currentNut= userView.getCurrentNutrient();
           if(currentNut !=null)
                userModel.removeNutrientFromPlate(currentNut);
           
           //data updates the view with the retrieved data
	   ObservableList<PieChart.Data> pieData = userModel.getPlateData(userView.isIsFoodCategories());
           
           if(pieData != null && pieData.size()!=0)
           {
                Platform.runLater(()-> userView.reDrawCalorieView1(pieData));
	   //userView.reDrawCalorieView(pieData);
           //userView.getCategoryChoices().valueProperty().set(null);
           }
	   
           if(pieData.size()==0)
           {
                Platform.runLater(()-> userView.reDrawCalorieView());
           }
	   
           userView.setCurrentNutrient(null);
	   userView.getCategoryChoices().valueProperty().set(null);

           }
       });
       
       userView.getAddtoPlateBtn().setOnAction(new EventHandler<ActionEvent> ()
       {
           @Override
           public void handle(ActionEvent event) {
           //
           // update plate nutrients
           Nutrient currentNut= userView.getCurrentNutrient();
              
           if(currentNut !=null){
              userModel.addNutrientToPlate(currentNut);
           }
           
           //data updates the view with the retrieved data
	   ObservableList<PieChart.Data> pieData = userModel.getPlateData(userView.isIsFoodCategories());
           if(pieData != null && pieData.size()!=0)
           {
                Platform.runLater(()-> userView.reDrawCalorieView1(pieData));
           
	   //userView.reDrawCalorieView(pieData);
           //userView.getCategoryChoices().valueProperty().set(null);
           }
	   
           }
       });
        // Attach handler
        userView.getPlateDisplaygroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (userView.getPlateDisplaygroup().getSelectedToggle() != null) {
                    if (userView.getPlateDisplaygroup().getSelectedToggle().getUserData().toString().equalsIgnoreCase("foodCategories"))
                    {
                        //plate is food categories
                        userView.setIsFoodCategories(true);
 
                    } else {
                        //plate is food items
                        userView.setIsFoodCategories(false);
                        
                    }
                    //data updates the view with the retrieved data
                    ObservableList<PieChart.Data> pieData = userModel.getPlateData(userView.isIsFoodCategories());
                    if(pieData != null && pieData.size()!=0)
                    {
                         Platform.runLater(()-> userView.reDrawCalorieView1(pieData));
                    //userView.reDrawCalorieView(pieData);
                    //userView.getCategoryChoices().valueProperty().set(null);
                    }
                }
            }
        });       
        
    }
    
    /**
     * @return the Model
     */
    public CalorieModel getModel() {
        return userModel;
    }

    /**
     * @param userModel the Model to set
     */
    public void setModel(CalorieModel userModel) {
        this.userModel = userModel;
    }

    /**
     * @return the View
     */
    public CalorieView getView() {
        return userView;
    }

    /**
     * @param userView the View to set
     */
    public void setView(CalorieView userView) {
        this.userView = userView;
    }
  
}
