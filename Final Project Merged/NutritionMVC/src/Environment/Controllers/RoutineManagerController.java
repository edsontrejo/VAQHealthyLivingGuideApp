/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.WeeklyRoutine;
import Environment.MainApplication;
import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
        
        routineCB.getItems().clear();
        for (WeeklyRoutine weeklyRoutine : MainApplication.profile.weeklyRoutineList) {
            routineCB.getItems().add(weeklyRoutine);
         }
       
        saveButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                MainApplication.profile.currentWeeklyRoutine = (WeeklyRoutine) routineCB.getSelectionModel().getSelectedItem();
                promptL.setText("Updated");
            }
        });
    }    
    
    @FXML
    private void OpenManager() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    private void OpenHome() throws IOException
    {
       TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
     @FXML
    private void OpenCreate() throws IOException
    {
       TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
     public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineManager.fxml"));
    }
}
