package Environment.Controllers;

import Environment.Core.Tools;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class PersonalController implements Initializable {
    LoginModel Model;
    private Tools tools = MainApplication.getTools();
    
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
        Model = new LoginModel();
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
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    private void OpenHome() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    private void OpenExercise(MouseEvent event) throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    private void OpenExport(MouseEvent event) throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    
    
    @FXML
    public void SavePersonal()
    {
        if (fNameTF.getText() != null)
            MainApplication.profile.personal.setFname(fNameTF.getText());
        if (lNameTF.getText() != null)
            MainApplication.profile.personal.setlName(lNameTF.getText());
        if (addressTF.getText() != null)
            MainApplication.profile.personal.setAddress(addressTF.getText());
        if (cityTF.getText() != null)
            MainApplication.profile.personal.setCity(cityTF.getText());
        if (stateCB.getSelectionModel().getSelectedItem().toString() != null)
            MainApplication.profile.personal.setState(stateCB.getSelectionModel().getSelectedItem().toString());
        if (zipTF.getText() != null)
            MainApplication.profile.personal.setZipCode(zipTF.getText());
        if (sexCB.getSelectionModel().getSelectedItem().toString() != null)
            MainApplication.profile.personal.setSex(sexCB.getSelectionModel().getSelectedItem().toString());
        if (emailTF.getText() != null)
            MainApplication.profile.personal.setEmail(emailTF.getText());
        if (tools.isValidDate(birthdayYearTF.getText()+ "-" + birthdayMonthTF.getText()+ "-" + birthdayDayTF.getText()))
            MainApplication.profile.personal.setBirthday(java.sql.Date.valueOf(
                    birthdayYearTF.getText()
                    + "-" + birthdayMonthTF.getText()
                    + "-" + birthdayDayTF.getText()
            ));
         
      if (imageFile != null)
            MainApplication.profile.imagePath = imageFile.getAbsolutePath();
      
        Model.UpdatePersonal(MainApplication.profile);
        System.out.println(MainApplication.profile);
        
    }

    private void DisplayPersonal() {
         if (MainApplication.profile.personal.getFname() != null)
         {
             fNameTF.setText(MainApplication.profile.personal.getFname());
         }
         if (MainApplication.profile.personal.getlName()!= null)
         {
             lNameTF.setText(MainApplication.profile.personal.getlName());
         }
         if (MainApplication.profile.personal.getAddress()!= null)
         {
             addressTF.setText(MainApplication.profile.personal.getAddress());
         }
         if (MainApplication.profile.personal.getCity()!= null)
         {
             cityTF.setText(MainApplication.profile.personal.getCity());
         }
         if (MainApplication.profile.personal.getState()!= null)
         {
             //stateTF.setText(MainApplication.profile.personal.getState());
         }
         if (MainApplication.profile.personal.getZipCode()!= null)
         {
             zipTF.setText(MainApplication.profile.personal.getZipCode());
         }
         if (MainApplication.profile.personal.getEmail()!= null)
         {
             emailTF.setText(MainApplication.profile.personal.getEmail());
         }
         
        if (MainApplication.profile.personal.getBirthday()!= null)
        {
            Date date = MainApplication.profile.personal.getBirthday();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            birthdayMonthTF.setText(Integer.toString(month));
            birthdayYearTF.setText(Integer.toString(year));
            birthdayDayTF.setText(Integer.toString(day));
        }
        
         
         if (MainApplication.profile.profileImage != null)
         {
            profileIV.setImage(MainApplication.profile.profileImage);
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
   
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Profile_Personal.fxml"));
    }
    
}
