/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Equipment;
import Environment.Classes.Exercise;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckListView;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseProfileController implements Initializable {

    LoginModel Model;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    CheckListView equipmentCCB;
    @FXML
    CheckComboBox exerciseTypeCCB;
    @FXML
    ImageView equipmentIV;
    @FXML
    Label primaryMuscleL;
    @FXML
    TextArea descriptionTA;
    ArrayList<Equipment> equipmentList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Model = new LoginModel();
        equipmentList = Model.GetEquipmentList();
        exerciseTypeCCB.getItems().add(Exercise.ExerciseTypeE.BALANCE.toString());
        exerciseTypeCCB.getItems().add(Exercise.ExerciseTypeE.CARDIO.toString());
        exerciseTypeCCB.getItems().add(Exercise.ExerciseTypeE.FLEXIBILITY.toString());
        exerciseTypeCCB.getItems().add(Exercise.ExerciseTypeE.STRENGTH.toString());
        
        exerciseTypeCCB.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                UpdateExerciseList();
            }
        });
        for (Equipment equipment : equipmentList) {         
            equipmentCCB.getItems().add(equipment);
        }
       
        equipmentCCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipment>() {
             @Override
             public void changed(ObservableValue<? extends Equipment> observable, Equipment oldValue, Equipment equipment) {
                 equipmentIV.setImage(equipment.getImage());
                 descriptionTA.setText(equipment.getDescription());
                 primaryMuscleL.setText("Primary Muscle : " + equipment.getPrimaryMuscle() +"\nSecondary Muscle : " + equipment.getSecondaryMuscle());
             }
           
        });   
         DisplayExerciseProfile();
    }  
    
    private void UpdateExerciseList() {
        ObservableList<Exercise.ExerciseTypeE> exerciseTypeList = exerciseTypeCCB.getCheckModel().getCheckedItems();
        ArrayList<Equipment> filterdList = new ArrayList();
        for (int i = 0; i < equipmentList.size(); i++) {
            if (exerciseTypeList.contains(equipmentList.get(i).getType().toString())) {
                filterdList.add(equipmentList.get(i));
            }
            
        }
        equipmentCCB.getItems().clear();
        equipmentCCB.setItems(FXCollections.observableList(filterdList));
    }
    
    private void DisplayExerciseProfile() {

        for (int i = 0; i < MainApplication.profile.exerciseProfile.equipmentList.size(); i++) {
             equipmentCCB.getCheckModel().check(MainApplication.profile.exerciseProfile.equipmentList.get(i));
        }
//        if (equipmentList.size() > 0){
//            equipmentCCB.getSelectionModel().select(0);                   
//        }
    }
    
    @FXML
    public void Save()
    {
        for (int i = 0; i < equipmentList.size(); i++) {
            Equipment equipment = equipmentList.get(i);
            if (MainApplication.profile.exerciseProfile.equipmentList.contains(equipment))
            {
                 if (!equipmentCCB.getCheckModel().isChecked(i))
                    MainApplication.profile.exerciseProfile.equipmentList.remove(equipment);   
            }
            else if (equipmentCCB.getCheckModel().isChecked(i))
                MainApplication.profile.exerciseProfile.equipmentList.add(equipment);     
                
            System.out.println("Equipment: " + equipmentCCB.getCheckModel().getItem(i).toString() + ":   " + equipmentCCB.getCheckModel().isChecked(i));
        }
        Model.UpdateExerciseProfile(MainApplication.profile);
    }
    
     @FXML
    public void OpenPersonal() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    public void OpenHome() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    public void OpenMedical() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    public void OpenProfileExport() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/ExerciseProfile.fxml"));
    }
}
