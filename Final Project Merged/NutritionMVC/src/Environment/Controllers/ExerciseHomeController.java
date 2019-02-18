/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Exercise;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import org.controlsfx.control.CheckListView;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseHomeController implements Initializable {

    LoginModel Model;
    /**
     * Initializes the controller class.
     */
    @FXML
    CheckListView exerciseCCB;
    ArrayList<Exercise> exerciseList = new ArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Model = new LoginModel();
         exerciseList = Model.GetExerciseList();
         for (Exercise exercise : exerciseList) {
            exerciseCCB.getItems().add(exercise);
        }
         //exerciseCCB.isEditable() = false;
    }   
    

    @FXML
    public void OpenExercises() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Exercise.fxml")));
    }
    @FXML
    public void OpenHome() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Home.fxml")));
    }
    @FXML
    public void OpenRoutine() throws IOException
    {
         TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineHome.fxml")));
    }
    
}
