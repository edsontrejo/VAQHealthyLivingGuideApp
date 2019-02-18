package Profile.Personal1;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.DatabaseManager;
import TabManager.TabManager;
import static Utility.Utility.isValidDate;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class PersonalController implements Initializable {

    
    //Personal Fields
    ArrayList<String> states = new ArrayList<String>(Arrays.asList(
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkanasa",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "GEorgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisana",
            "Maine",
            "Maryland",
            "Massachussetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Misouri",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carloina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming"
    ));
    
    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField zipTF;
    @FXML
    private ComboBox sexCB;
    @FXML
    private TextField addressTF;
    @FXML
    private ComboBox stateCB;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField birthdayMonthTF;
    @FXML
    private TextField birthdayDayTF;
    @FXML
    private TextField birthdayYearTF;
    @FXML 
    ImageView profileIV;
   
    
    private File imageFile;
    private static final int MAX_TF_SIZE = 30;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stateCB.setItems(FXCollections.observableList(states));
        sexCB.setItems(FXCollections.observableArrayList(new ArrayList<String>(Arrays.asList("Male","Female"))));
        stateCB.getSelectionModel().select(0);
        sexCB.getSelectionModel().select(0);
        SetupHandlers();
        DisplayPersonal();

    }    

    @FXML
    private void OpenMedical() throws IOException {
        TabManager.getInstance().OpenProfileMedical();
    }
    @FXML
    private void OpenHome() throws IOException
    {
         TabManager.getInstance().OpenHome();
    }
    @FXML
    private void OpenExercise(MouseEvent event) throws IOException {
        TabManager.getInstance().OpenProfileExercise();
    }
    @FXML
    private void OpenExport(MouseEvent event) throws IOException {
        TabManager.getInstance().OpenProfileExport();
    }
    
    
    @FXML
    public void SavePersonal()
    {
        if (fNameTF.getText() != null)
            VAQ_Health.profile.personal.setFname(fNameTF.getText());
        if (lNameTF.getText() != null)
            VAQ_Health.profile.personal.setlName(lNameTF.getText());
        if (addressTF.getText() != null)
            VAQ_Health.profile.personal.setAddress(addressTF.getText());
        if (cityTF.getText() != null)
            VAQ_Health.profile.personal.setCity(cityTF.getText());
        if (stateCB.getSelectionModel().getSelectedItem().toString() != null)
            VAQ_Health.profile.personal.setState(stateCB.getSelectionModel().getSelectedItem().toString());
        if (zipTF.getText() != null)
            VAQ_Health.profile.personal.setZipCode(zipTF.getText());
        if (sexCB.getSelectionModel().getSelectedItem().toString() != null)
            VAQ_Health.profile.personal.setSex(sexCB.getSelectionModel().getSelectedItem().toString());
        if (emailTF.getText() != null)
            VAQ_Health.profile.personal.setEmail(emailTF.getText());
        if (isValidDate(birthdayYearTF.getText()+ "-" + birthdayMonthTF.getText()+ "-" + birthdayDayTF.getText()))
            VAQ_Health.profile.personal.setBirthday(java.sql.Date.valueOf(
                    birthdayYearTF.getText()
                    + "-" + birthdayMonthTF.getText()
                    + "-" + birthdayDayTF.getText()
            ));
         
      if (imageFile != null)
            VAQ_Health.profile.imagePath = imageFile.getAbsolutePath();
      
        DatabaseManager.UpdatePersonal(VAQ_Health.profile);
        System.out.println(VAQ_Health.profile);
        
    }

    private void DisplayPersonal() {
         if (VAQ_Health.profile.personal.getFname() != null)
         {
             fNameTF.setText(VAQ_Health.profile.personal.getFname());
         }
         if (VAQ_Health.profile.personal.getlName()!= null)
         {
             lNameTF.setText(VAQ_Health.profile.personal.getlName());
         }
         if (VAQ_Health.profile.personal.getAddress()!= null)
         {
             addressTF.setText(VAQ_Health.profile.personal.getAddress());
         }
         if (VAQ_Health.profile.personal.getCity()!= null)
         {
             cityTF.setText(VAQ_Health.profile.personal.getCity());
         }
         if (VAQ_Health.profile.personal.getState()!= null)
         {
             //stateTF.setText(VAQ_Health.profile.personal.getState());
         }
         if (VAQ_Health.profile.personal.getZipCode()!= null)
         {
             zipTF.setText(VAQ_Health.profile.personal.getZipCode());
         }
         if (VAQ_Health.profile.personal.getEmail()!= null)
         {
             emailTF.setText(VAQ_Health.profile.personal.getEmail());
         }
         
        if (VAQ_Health.profile.personal.getBirthday()!= null)
        {
            Date date = VAQ_Health.profile.personal.getBirthday();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            birthdayMonthTF.setText(Integer.toString(month));
            birthdayYearTF.setText(Integer.toString(year));
            birthdayDayTF.setText(Integer.toString(day));
        }
        
         
         if (VAQ_Health.profile.profileImage != null)
         {
            profileIV.setImage(VAQ_Health.profile.profileImage);
         }
    }
    
    public void UploadProfilePic() {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                       
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                profileIV.setImage(image);
                imageFile = file;
            } catch (IOException ex) {
               // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }

    private void SetupHandlers() {
        
        fNameTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > MAX_TF_SIZE )
                   fNameTF.setText(oldValue);
            }
        });
        lNameTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > MAX_TF_SIZE )
                   lNameTF.setText(oldValue);
            }
        });
        zipTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > 5 )
                   zipTF.setText(oldValue);
            }
        });
        emailTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > MAX_TF_SIZE )
                   emailTF.setText(oldValue);
            }
        });
        addressTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > MAX_TF_SIZE )
                   addressTF.setText(oldValue);
            }
        });
        cityTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (newValue.length() > MAX_TF_SIZE )
                   cityTF.setText(oldValue);
            }
        });
        birthdayMonthTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               boolean isAcceptable = true;
                if (newValue.length() > 0)
                    try {
                        Integer.parseInt(newValue);
                        if (Integer.parseInt(newValue) > 12)
                            isAcceptable = false;
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
               if (!isAcceptable || newValue.length() > 2)
                   birthdayMonthTF.setText(oldValue);
            }
        });
        birthdayYearTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               boolean isAcceptable = true;
                if (newValue.length() > 0)
                    try {
                        Integer.parseInt(newValue);
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
               if (!isAcceptable || newValue.length() > 4)
                   birthdayYearTF.setText(oldValue);
            }
        });
        birthdayDayTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean isAcceptable = true;
                if (newValue.length() > 0)
                    try {
                        Integer.parseInt(newValue);
                        if (Integer.parseInt(newValue) > 32)
                            isAcceptable = false;
                    } catch (Exception e) {
                        isAcceptable = false;
                    }
               if (!isAcceptable || newValue.length() > 2)
                   birthdayDayTF.setText(oldValue);
            }
        });
    }
   

    
}
