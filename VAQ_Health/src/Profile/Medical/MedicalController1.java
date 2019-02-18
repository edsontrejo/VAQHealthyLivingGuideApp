/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Medical;

import Database.DatabaseManager;
import Disease.Disease;
import Profile.Allergies.Allergy;
import Profile.Profile;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckListView;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class MedicalController1 implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    TextField weightTF = new TextField();
    @FXML
    TextField heightTF = new TextField();
    @FXML
    TextField heightInchesTF = new TextField();
    @FXML
    CheckListView allergyCLV;
    @FXML
    CheckListView diseaseCLV;
    @FXML
    TextArea diseaseTA;
    @FXML
    TextArea allergyTA;
    
    Profile profile;
    
    ArrayList<Allergy> allergyList;
    ArrayList<Disease> diseaseList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profile = VAQ_Health.profile;
        allergyList = DatabaseManager.GetAllergyList();
        diseaseList = DatabaseManager.GetDiseaseList();
        allergyTA.setWrapText(true);
        diseaseTA.setWrapText(true);
        DisplayMedicalProfile();
        SetupHandlers();
    }

    private void DisplayMedicalProfile() {
       

        //Allergy
        for (Allergy allergy : allergyList) {

            allergyCLV.getItems().add(allergy);
        }
        for (int i = 0; i < VAQ_Health.profile.medical.allergyList.size(); i++) {
             allergyCLV.getCheckModel().check(VAQ_Health.profile.medical.allergyList.get(i));
        }
        if (allergyList.size() > 0)
        {
            allergyCLV.getSelectionModel().clearAndSelect(0);                   
            allergyTA.setText(allergyList.get(0).getDescription());
        }

        //Disease
        for (Disease disease : diseaseList) {

            diseaseCLV.getItems().add(disease);
        }
        for (int i = 0; i < VAQ_Health.profile.medical.diseaseList.size(); i++) {
            diseaseCLV.getCheckModel().check(VAQ_Health.profile.medical.diseaseList.get(i));
        }
        
        if (diseaseList.size() > 0)
        {
            diseaseCLV.getSelectionModel().clearAndSelect(0);                   
            diseaseTA.setText(diseaseList.get(0).getDiscription());
        }
        
        //Weight & Height
        weightTF.setText(profile.medical.getWeight());
        heightTF.setText(profile.medical.getHeight());
        heightInchesTF.setText(profile.medical.getHeightInches());

    }

    @FXML
    public void OpenPersonal() throws IOException {
        TabManager.getInstance().OpenProfilePersonal();
    }

    @FXML
    public void OpenExercise() throws IOException {
        TabManager.getInstance().OpenProfileExercise();
    }

    @FXML
    public void OpenHome() throws IOException {
        TabManager.getInstance().OpenHome();
    }

    @FXML
    public void OpenExport() throws IOException {
        TabManager.getInstance().OpenProfileExport();
    }
    
    @FXML
    public void SaveMedical() {
        if (weightTF.getText() != null) {
            VAQ_Health.profile.medical.setWeight(weightTF.getText());
        }
        if (heightTF.getText() != null) {
            VAQ_Health.profile.medical.setHeight(heightTF.getText());
        }
        if (heightInchesTF.getText() != null) {
            VAQ_Health.profile.medical.setHeightInches(heightInchesTF.getText());
        }
       

        for (int i = 0; i < allergyList.size(); i++) {
            Allergy allergy = allergyList.get(i);
            if (VAQ_Health.profile.medical.allergyList.contains(allergy))
            {
                 if (!allergyCLV.getCheckModel().isChecked(i))
                    VAQ_Health.profile.medical.allergyList.remove(allergy);   
            }
            else if (allergyCLV.getCheckModel().isChecked(i))
                VAQ_Health.profile.medical.allergyList.add(allergy);     
                
            System.out.println("Allergy: " + allergyCLV.getCheckModel().getItem(i).toString() + ":   " + allergyCLV.getCheckModel().isChecked(i));
        }
        
        for (int i = 0; i < diseaseList.size(); i++) {
            Disease disease = diseaseList.get(i);
            if (VAQ_Health.profile.medical.diseaseList.contains(disease))
            {
                 if (!diseaseCLV.getCheckModel().isChecked(i))
                    VAQ_Health.profile.medical.diseaseList.remove(disease);   
            }
            else if (diseaseCLV.getCheckModel().isChecked(i))
                VAQ_Health.profile.medical.diseaseList.add(disease);     
                
            System.out.println("Disease: " + diseaseCLV.getCheckModel().getItem(i).toString() + ":   " + diseaseCLV.getCheckModel().isChecked(i));
        }
        
        System.out.println(VAQ_Health.profile.medical);
        DatabaseManager.UpdateMedical(VAQ_Health.profile);
    }

    private void SetupHandlers() {
       diseaseCLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Disease>() {
            @Override
            public void changed(ObservableValue<? extends Disease> observable, Disease oldValue, Disease disease) {
                 diseaseTA.setText(disease.getDiscription());
            }
        });
        
        allergyCLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Allergy>() {
            @Override
            public void changed(ObservableValue<? extends Allergy> observable, Allergy oldValue, Allergy allergy) {
                 allergyTA.setText(allergy.getDescription());
            }
        });
        
        weightTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean isAcceptable = true;
                if (newValue.length() > 0) {
                    try {
                        Integer.parseInt(newValue);
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
                }
                if (!isAcceptable || newValue.length() > 3) {
                    weightTF.setText(oldValue);
                }
            }
        });

        heightTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean isAcceptable = true;
                if (newValue.length() > 0) {
                    try {
                        Integer.parseInt(newValue);
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
                }
                if (!isAcceptable || newValue.length() > 2) {
                    heightTF.setText(oldValue);
                }
            }
        });
        heightInchesTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean isAcceptable = true;
                if (newValue.length() > 0) {
                    try {
                        if (Integer.parseInt(newValue) > 12)
                            isAcceptable = false;
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
                }
                if (!isAcceptable || newValue.length() > 2) {
                    heightInchesTF.setText(oldValue);
                }
            }
        });

    }

}
