/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Export;


import Profile.Converter.SaveProfile;
import TabManager.TabManager;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button ExportButton = new Button();
    @FXML
    ImageView pdfImage;
    @FXML
    AnchorPane pdfBackgroundAP;
    @FXML
    AnchorPane htmlBackgroundAP;
    @FXML
    AnchorPane xmlBackgroundAP;
    @FXML
    TextArea folderTA; 
    @FXML
    AnchorPane emailPane;
    @FXML
    private Label errorL;
    
    String directoryPath;
    TabManager profileController = new TabManager();
    boolean pdfClicked,htmlClicked,xmlClicked;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }

    @FXML
    public void ClickPDF() {
        pdfClicked = !pdfClicked;
        HighLightPDF(pdfClicked,pdfBackgroundAP);
    }
    public void ClickHTML() {
        htmlClicked = !htmlClicked;
        HighLightPDF(htmlClicked,htmlBackgroundAP);
    }
    public void ClickXML() {
        xmlClicked = !xmlClicked;
        HighLightPDF(xmlClicked,xmlBackgroundAP);
    }
    public void SelectFolder()
    {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory
                = directoryChooser.showDialog(VAQ_Health.mainStage);

        if (selectedDirectory != null) {
           directoryPath = selectedDirectory.getAbsolutePath();
           folderTA.setText(directoryPath);
        } 
    }

    public void HighLightPDF(boolean highLight, AnchorPane aPane) {
        //Fade Transistion
        FadeTransition ft = new FadeTransition(Duration.millis(300), aPane);
        if (highLight) {
            ft.setFromValue(0);
            ft.setToValue(1);
        } else {
            ft.setFromValue(1);
            ft.setToValue(0);
        }
        ft.setCycleCount(1);
        //Scale Transition
        ScaleTransition st = new ScaleTransition(Duration.millis(250), aPane);
        st.setFromX(1f);
        st.setFromY(1f);
        st.setToX(1.05f);
        st.setToY(1.05f);
        //PLAY
        st.play();
        ft.play();
    }

    @FXML
    public void UnClickPDF() {

    }

    @FXML
    public void Export() {
        if (directoryPath == null || directoryPath.equals("") )
        {
            errorL.setText("Directory not set");
            return;
        }
        if (pdfClicked)
            SaveProfile.PDF(directoryPath);
        if (htmlClicked)
            SaveProfile.HTML(directoryPath);
        if (xmlClicked)
            SaveProfile.XML(directoryPath);
    }

    @FXML
    public void OpenHome() throws IOException {
        profileController.OpenHome();
    }
      @FXML
    public void OpenPersonal() throws IOException
    {
        profileController.OpenProfilePersonal();
    }
    @FXML
    public void OpenMedical() throws IOException
    {
        profileController.OpenProfileMedical();
    }
    @FXML
    public void OpenExercise() throws IOException
    {
        profileController.OpenProfileExercise();
    }

}
