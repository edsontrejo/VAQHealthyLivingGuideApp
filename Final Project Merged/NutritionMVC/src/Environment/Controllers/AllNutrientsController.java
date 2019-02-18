package Environment.Controllers;

import Environment.Classes.Food;
import Environment.Classes.FoodGroup;
import Environment.MainApplication;
import Environment.Models.AllNutrientsModel;
import Environment.Views.AllNutrientsView;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class AllNutrientsController {
    private AllNutrientsView View;
    private AllNutrientsModel Model;
    
    private ArrayList<Food> FoodsPicked = new ArrayList<>();
    
    public AllNutrientsController(){
        this.View = new AllNutrientsView();
        this.Model = new AllNutrientsModel();
        attachEvents();
    }

    private void attachEvents()
    {
        handleretrieveFoodGroups();
    }
    
    public void handleretrieveFoodGroups()
    {
        ArrayList<FoodGroup> foodGroups = AllNutrientsModel.retrieveAllGroups();
        
        for(FoodGroup _group : foodGroups)
            _group.setFoods(AllNutrientsModel.retrieveFoodsByGroupId(_group.getGroupId()));
        
        int totalGroups = AllNutrientsModel.retrieveTotalGroups();
        int totalFoods = AllNutrientsModel.retrieveTotalFoods();
        View.setFoodGroups(foodGroups);
        View.setTotalGroups(totalGroups);
        View.setTotalFoods(totalFoods);
        
        View.getAddFood().addEventHandler(ActionEvent.ACTION, (e)-> {
            Model.addFoodtoList(MainApplication.profile.id, View.getFoodsPicked().getId(), 1.3);
        });
        
        
        
        View.updateView();
    }
    
    /**
     * @return the View
     */
    public AllNutrientsView getView() {
        return View;
    }

    /**
     * @param View the View to set
     */
    public void setView(AllNutrientsView View) {
        this.View = View;
    }

    /**
     * @return the Model
     */
    public AllNutrientsModel getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(AllNutrientsModel Model) {
        this.Model = Model;
    }
}