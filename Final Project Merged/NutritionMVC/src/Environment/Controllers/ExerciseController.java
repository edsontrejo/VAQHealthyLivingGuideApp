/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static Environment.Classes.Exercise.ExerciseTypeE.CARDIO;
import Environment.Classes.Equipment;
import Environment.Classes.Exercise;
import Environment.Classes.Exercise.ExerciseTypeE;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.util.Iterator;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.controlsfx.control.CheckComboBox;

/**
 * FXML Controller class
 *
 * @author Stephen
 */
public class ExerciseController implements Initializable {

    LoginModel Model;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    ListView exerciseLV;
    @FXML
    Label nameLabel;
    @FXML
    TextArea discriptionTA;
    @FXML
    ImageView typeImageV;
    @FXML
    ComboBox workoutTimeCB;
    @FXML
    Label caloriesL;
    @FXML
    Label metL;
    @FXML
    CheckComboBox exerciseEquipCCB;
    @FXML
    CheckComboBox exerciseTypeCCB;
    @FXML
    TextArea searchBar;

    Exercise selectedExercise;
    Image balanceImage = new Image("resources/images/balance.png");
    Image cardioImage = new Image("resources/images/cardio.png");
    Image strengthImage = new Image("resources/images/strength.png");
    ;
    Image flexibilityImage = new Image("resources/images/flexibility.png");
    ;
    ArrayList<Exercise> exerciseList = new ArrayList<>();
    List<String> timeOpts = Arrays.asList("10m", "20m", "30m", "40m", "50m", "60m");
    Connection myConnection;
    Statement myStmt;
    ResultSet myRs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Model = new LoginModel();
        exerciseTypeCCB.getItems().add(ExerciseTypeE.BALANCE.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.CARDIO.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.FLEXIBILITY.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.STRENGTH.toString());
        exerciseTypeCCB.getCheckModel().checkAll();
        exerciseList = Model.GetExerciseList();
        
        if (exerciseList.size() > 0) {
            System.out.println(exerciseList.get(0).getName());
        }

        ArrayList<Equipment> equipList = Model.GetEquipmentList();
        for (Equipment equipment : equipList) {
            exerciseEquipCCB.getItems().add(equipment);
        }
        for (int i = 0; i < MainApplication.profile.exerciseProfile.equipmentList.size(); i++) {
             exerciseEquipCCB.getCheckModel().check(MainApplication.profile.exerciseProfile.equipmentList.get(i));
        }
         if (exerciseList.size() > 0)
        {
            exerciseLV.getSelectionModel().clearAndSelect(0);                   
            nameLabel.setText(exerciseList.get(0).getName());
            discriptionTA.setText(exerciseList.get(0).getDescription());
            metL.setText(String.valueOf(exerciseList.get(0).getMet()));
                switch (exerciseList.get(0).getType()) {
                    case CARDIO:
                        typeImageV.setImage(cardioImage);
                        break;
                    case BALANCE:
                        typeImageV.setImage(balanceImage);
                        break;
                    case STRENGTH:
                        typeImageV.setImage(strengthImage);
                        break;
                    case FLEXIBILITY:
                        typeImageV.setImage(flexibilityImage);
                }
                
               searchBar.textProperty().addListener(new ChangeListener<String>() {
               
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   search(oldValue,newValue);
                }
            });
            
        }
        
        //Get rid of exercises that require equipment the user doesnt have
        UpdateExerciseList();

        discriptionTA.setWrapText(true);
        workoutTimeCB.setItems(FXCollections.observableList(timeOpts));
        workoutTimeCB.getSelectionModel().selectFirst();

        //EVENT HANDLERS
        workoutTimeCB.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                SetCalories();
            }
        });
        exerciseLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Exercise>() {

            @Override
            public void changed(ObservableValue<? extends Exercise> observable, Exercise oldValue, Exercise newValue) {
                selectedExercise = newValue;
                nameLabel.setText(selectedExercise.getName());
                discriptionTA.setText(selectedExercise.getDescription());
                metL.setText(String.valueOf(selectedExercise.getMet()));
                switch (selectedExercise.getType()) {
                    case CARDIO:
                        typeImageV.setImage(cardioImage);
                        break;
                    case BALANCE:
                        typeImageV.setImage(balanceImage);
                        break;
                    case STRENGTH:
                        typeImageV.setImage(strengthImage);
                        break;
                    case FLEXIBILITY:
                        typeImageV.setImage(flexibilityImage);
                }

                DisplayExercise(selectedExercise);
            }
        });

        exerciseEquipCCB.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                UpdateExerciseList();
            }
        });
        
        exerciseTypeCCB.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                UpdateExerciseList();
            }
        });
        

    }

    private void UpdateExerciseList() {
        ObservableList<Equipment> equipL = exerciseEquipCCB.getCheckModel().getCheckedItems();
        ObservableList<ExerciseTypeE> exerciseTypeList = exerciseTypeCCB.getCheckModel().getCheckedItems();
        ArrayList<Exercise> filterdList = new ArrayList();
        for (int i = 0; i < exerciseList.size(); i++) {
            if (exerciseList.get(i).getEquipment() != null 
                    && (!equipL.contains(exerciseList.get(i).getEquipment())
                    || !exerciseTypeList.contains(exerciseList.get(i).getType().toString()))) {
              System.out.println("User doesnt have equipment: " + exerciseList.get(i).getEquipment().toString());
              System.out.println("User doesnt want exerciseType : " + exerciseList.get(i).getType().toString());
            }
            else
                filterdList.add(exerciseList.get(i));
        }
        exerciseLV.setItems(FXCollections.observableList(filterdList));
    }

    public void SetCalories() {
        double t = 0;
        switch (workoutTimeCB.getSelectionModel().getSelectedItem().toString()) {
            case "10m":
                t = 10;
                break;
            case "20m":
                t = 20;
                break;
            case "30m":
                t = 30;
                break;
            case "40m":
                t = 40;
                break;
            case "50m":
                t = 50;
                break;
            case "60m":
                t = 60;
                break;
        }
        t /= 60;
        double caloriesBurned = Exercise.CaloriesBurned(selectedExercise.getMet(), t, 70);
        DecimalFormat dec = new DecimalFormat("#0.00");

        caloriesL.setText(dec.format(caloriesBurned));
    }
    
    
    public void search(String oldVal, String newVal) {
    String value = newVal.toLowerCase();
    ObservableList<Equipment> equipL = exerciseEquipCCB.getCheckModel().getCheckedItems();
    ObservableList<ExerciseTypeE> exerciseTypeList = exerciseTypeCCB.getCheckModel().getCheckedItems();
    ObservableList<Exercise> subentries = FXCollections.observableArrayList();
        for (Iterator it = exerciseList.iterator(); it.hasNext();) {
            Exercise entry = (Exercise) it.next();
            if (entry.getName().toLowerCase().startsWith(value) 
                    && entry.getEquipment() != null && equipL.contains(entry.getEquipment())
                    && exerciseTypeList.contains(entry.getType().toString())
                    ) {
                 subentries.add(entry);
            }            
        }
    exerciseLV.getItems().clear();
    exerciseLV.setItems(subentries);
    
  }

    public void DisplayExercise(Exercise exercise) {
        SetCalories();
    }

    public void OpenHome() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Home.fxml")));
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Exercise.fxml"));
    }

}
