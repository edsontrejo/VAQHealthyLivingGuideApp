/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class AllergiesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    CheckBox dairy = new CheckBox();
    @FXML
    CheckBox soy = new CheckBox();;
    @FXML
    CheckBox eggs = new CheckBox();;
    @FXML
    CheckBox peanuts = new CheckBox();;
    @FXML
    CheckBox fish = new CheckBox();;
    @FXML
    CheckBox wheat = new CheckBox();;
    @FXML
    CheckBox sesame = new CheckBox();;
    @FXML
    CheckBox gluten = new CheckBox();;
    @FXML
    CheckBox lactose = new CheckBox();;
    @FXML
    CheckBox fructose = new CheckBox();;
    @FXML
    CheckBox sulfites = new CheckBox();;
    @FXML  
    CheckBox histamines = new CheckBox();;
    @FXML
    CheckBox nitrites = new CheckBox();;
    @FXML
    CheckBox nightshades = new CheckBox();;
    @FXML
    CheckBox fructans = new CheckBox();;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void OpenMedical() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Profile_Medical1.fxml")));
    }
    
    @FXML
    public void OpenHome() throws IOException
    {
            TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Home.fxml")));
    }
    
    @FXML
    public void OpenPersonal() throws IOException
    {
         TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Profile_Personal.fxml")));
    }
    
    //@FXML
//    public void SaveButtion()
//    {
//        MainApplication.profile.allergies.setDairyA(dairy.isSelected());
//        MainApplication.profile.allergies.setSoyA(soy.isSelected());
//        MainApplication.profile.allergies.setEggsA(eggs.isSelected());
//        MainApplication.profile.allergies.setPeanutsA(peanuts.isSelected());
//        MainApplication.profile.allergies.setFishA(fish.isSelected());
//        MainApplication.profile.allergies.setWheatA(wheat.isSelected());
//        MainApplication.profile.allergies.setSesameA(sesame.isSelected());
//        MainApplication.profile.allergies.setGlutenI(gluten.isSelected());
//        MainApplication.profile.allergies.setLactoseI(lactose.isSelected());
//        MainApplication.profile.allergies.setFructoseI(fructose.isSelected());
//        MainApplication.profile.allergies.setHistaminesI(histamines.isSelected());
//        MainApplication.profile.allergies.setNitritesI(nitrites.isSelected());
//        MainApplication.profile.allergies.setNightshadesI(nightshades.isSelected());
//        MainApplication.profile.allergies.setFructansI(fructans.isSelected());
//        
//        System.out.println(MainApplication.profile.allergies);
//    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Allergies.fxml"));
    }
}
