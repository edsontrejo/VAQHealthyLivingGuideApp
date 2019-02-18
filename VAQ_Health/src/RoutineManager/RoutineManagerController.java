/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoutineManager;

import Routine.WeeklyRoutine;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineManagerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox routineCB;
    @FXML
    private Button saveButton;
    @FXML
    private Label promptL;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        for (WeeklyRoutine weeklyRoutine : VAQ_Health.profile.weeklyRoutineList)
        {
            routineCB.getItems().add(weeklyRoutine);
        }
         
        saveButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                VAQ_Health.profile.currentWeeklyRoutine = (WeeklyRoutine) routineCB.getSelectionModel().getSelectedItem();
                promptL.setText("Updated");
            }
        });
    }    
    
    @FXML
    private void OpenManager() throws IOException
    {
        TabManager.getInstance().OpenRoutineCreator();
    }
    @FXML
    private void OpenHome() throws IOException
    {
       TabManager.getInstance().OpenRoutineHome();
    }
     @FXML
    private void OpenCreate() throws IOException
    {
       TabManager.getInstance().OpenRoutineCreator();
    }
}
