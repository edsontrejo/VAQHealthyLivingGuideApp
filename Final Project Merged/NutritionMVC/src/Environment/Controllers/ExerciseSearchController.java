/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Exercise;
import Environment.Classes.Exercise.MuscleTypeE;
import Environment.Models.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseSearchController implements Initializable {

    LoginModel Model;
    
    /**
     * @return the menuController
     */
    public ExerciseController2 getMenuController() {
        return menuController;
    }

    /**
     * @param menuController the menuController to set
     */
    public void setMenuController(ExerciseController2 menuController) {
        this.menuController = menuController;
    }

    /**
     * @return the exerciseList
     */
    @FXML
    private TextField searchTF;
    
    public ArrayList<Exercise> getMainExerciseList() {
        return mainExerciseList;
    }

    /**
     * @param exerciseList the exerciseList to set
     */
    public void setMainExerciseList(ArrayList<Exercise> exerciseList) {
        this.mainExerciseList = exerciseList;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button rightArrowButton;
    @FXML
    private Button leftArrowButton;
    @FXML
    private VBox slotVBox;
    @FXML
    TextField pageIndexTF;
    
    private Parent rootNode;
    private ArrayList<Exercise> mainExerciseList;
    private ArrayList<ArrayList<Exercise>> pages;
    private int MAX_PAGE_SIZE = 5;
    private int currentPageIndex = 0;
    private ExerciseController2 menuController;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Model = new LoginModel();
        mainExerciseList = Model.GetExerciseList();
        pages = new ArrayList<ArrayList<Exercise>>();
        pages = CreatePages(mainExerciseList);
        DisplayPage(pages.get(currentPageIndex));
        SetHandlers();
    } 
    
    public void FilterList(MuscleTypeE muscleType)
    {
        ArrayList<Exercise> filteredList = new ArrayList();
        for (Exercise exercise : mainExerciseList)
        {
            if (exercise.getMuscleTypeE().equals(muscleType))
               filteredList.add(exercise);
        }
        pages = CreatePages(filteredList);
        DisplayPage(pages.get(currentPageIndex));
    }
    
    public void SetNameFilter(String searchFilter)
    {
        slotVBox.getChildren().clear();
        ArrayList <Exercise> filteredList = new ArrayList<>();
        ArrayList <Exercise> exerciseList = new ArrayList();
        
        for (ArrayList<Exercise> exercises : pages)
        {
            for (Exercise exercise : exercises)
            {
                exerciseList.add(exercise);
            }
        }
        for (Exercise exercise : exerciseList)
        {
            if (exercise.getName().toLowerCase().startsWith(searchFilter.toLowerCase()))
                filteredList.add(exercise);
        }
        DisplayPage(filteredList);   
    }
    
      public void SetRoot(Parent node)
    {
        rootNode = node;
    }
    public Parent GetRoot()
    {
        return rootNode;
    }

    
    private void DisplayPage(ArrayList<Exercise> exerciseList) {
        slotVBox.getChildren().clear();
        for (int i=0; i < exerciseList.size(); i++)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/ExerciseSearchSlot.fxml"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(ExerciseSearchController.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            }
            ExerciseSearchSlotController exerciseSSC = (ExerciseSearchSlotController) loader.getController();
            exerciseSSC.SetExercise(exerciseList.get(i));
            exerciseSSC.UpdateView();
            exerciseSSC.getSlotPane().setOnMouseClicked(new EventHandler() {
                @Override
                public void handle(Event event) {
                   menuController.OpenExerciseDisplay(exerciseSSC.GetExercise());
                }
            });
            slotVBox.getChildren().add(root);
        }
        UpdatePageIndex();
        
    }
    private void UpdatePageIndex()
    {
        Integer currentPageNum = currentPageIndex+1;
        Integer totalPages = pages.size();
        pageIndexTF.setText(currentPageNum.toString() + "/" + totalPages.toString());
    }
            
    
    public ArrayList<Exercise> GetCurrentPage()
    {
       int numSlots = Math.min(mainExerciseList.size()-currentPageIndex, MAX_PAGE_SIZE);
       if (numSlots ==1)
           return null;
       ArrayList<Exercise> exerciseL = new ArrayList();
       for (int i =0; i< numSlots; i++)
       {
           exerciseL.add(mainExerciseList.get(i));
       }
       return exerciseL;       
    }
    public boolean NextPage(int dir)
    {
        if ( dir == 1)
        {
            if (pages.size()-1 == currentPageIndex)
                return false;
            currentPageIndex++;
        }
        else
        {
            if ((currentPageIndex-1) < 0)
                return false;
            currentPageIndex--;
        }      
        return true;   
    }
    private void SetHandlers() {
        searchTF.textProperty().addListener(new ChangeListener<String>() {      
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   currentPageIndex = 0;
                   SetNameFilter(newValue);
                }
            });
        
        leftArrowButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
               if (!NextPage(-1))
                    return;
                DisplayPage(pages.get(currentPageIndex));
            }
        });
        
        rightArrowButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (!NextPage(1))
                    return;
                DisplayPage(pages.get(currentPageIndex));
            }
        });
    }

    private ArrayList<ArrayList<Exercise>> CreatePages(ArrayList<Exercise> exerciseList) {
       ArrayList<ArrayList<Exercise>> newPages = new ArrayList();
       ArrayList<Exercise> page = new ArrayList();
       int slotCt = 0;
       
       for (Exercise e : exerciseList)
       {
           page.add(e);
           slotCt++;
           if (slotCt >= MAX_PAGE_SIZE)
           {
               newPages.add((ArrayList<Exercise>) page.clone());
               page.clear();
               slotCt = 0;
           }
       }
       if (page.size() > 0)
           newPages.add(page);           
       currentPageIndex = 0;
       return newPages;
    }
    
}
