/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseHome;

import Database.DatabaseManager;
import Exercise.Exercise;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import org.controlsfx.control.CheckListView;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    CheckListView exerciseCCB;
    ArrayList<Exercise> exerciseList = new ArrayList();
    TabManager profileController = new TabManager();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         exerciseList = DatabaseManager.GetExerciseList();
         for (Exercise exercise : exerciseList) {
            exerciseCCB.getItems().add(exercise);
        }
         //exerciseCCB.isEditable() = false;
    }   
    

    @FXML
    public void OpenExercises() throws IOException
    {
        profileController.OpenExercises();
    }
    @FXML
    public void OpenHome() throws IOException {
        profileController.OpenHome();
    }
    @FXML
    public void OpenRoutine() throws IOException
    {
         profileController.OpenRoutineHome();
    }
    
}
