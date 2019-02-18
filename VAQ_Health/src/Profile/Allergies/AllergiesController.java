/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Allergies;

import vaq_health.*;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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
    
    TabManager profileController = new TabManager();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    public void OpenMedical() throws IOException
    {
        profileController.OpenProfileMedical();
    }
    @FXML
    public void OpenHome() throws IOException
    {
         profileController.OpenHome();
    }
    @FXML
    public void OpenPersonal() throws IOException
    {
         profileController.OpenProfilePersonal();
    }
    
    //@FXML
//    public void SaveButtion()
//    {
//        VAQ_Health.profile.allergies.setDairyA(dairy.isSelected());
//        VAQ_Health.profile.allergies.setSoyA(soy.isSelected());
//        VAQ_Health.profile.allergies.setEggsA(eggs.isSelected());
//        VAQ_Health.profile.allergies.setPeanutsA(peanuts.isSelected());
//        VAQ_Health.profile.allergies.setFishA(fish.isSelected());
//        VAQ_Health.profile.allergies.setWheatA(wheat.isSelected());
//        VAQ_Health.profile.allergies.setSesameA(sesame.isSelected());
//        VAQ_Health.profile.allergies.setGlutenI(gluten.isSelected());
//        VAQ_Health.profile.allergies.setLactoseI(lactose.isSelected());
//        VAQ_Health.profile.allergies.setFructoseI(fructose.isSelected());
//        VAQ_Health.profile.allergies.setHistaminesI(histamines.isSelected());
//        VAQ_Health.profile.allergies.setNitritesI(nitrites.isSelected());
//        VAQ_Health.profile.allergies.setNightshadesI(nightshades.isSelected());
//        VAQ_Health.profile.allergies.setFructansI(fructans.isSelected());
//        
//        System.out.println(VAQ_Health.profile.allergies);
//    }
}
