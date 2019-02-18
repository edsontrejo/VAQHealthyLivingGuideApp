/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Core.SaveProfile;
import Environment.Models.jEmailModel;
import Environment.Tabs.TabManager;
import Environment.Views.jEmailView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    boolean pdfClicked,htmlClicked,xmlClicked;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          jEmailModel model = new jEmailModel();
        model.setHost("smtp.gmail.com");
        model.setPassword("utrgvcssw");
        model.setPort("465");
        model.setSubject("Sending File");
        model.setToAddress("");
        model.setUserName("softwareengineeringutrgv@gmail.com");
        model.setMessage("File sent.");
        model.setFile("bla.txt");
        jEmailView root = new jEmailView();
        jEmailController controller = new jEmailController(root, model);
        emailPane.getChildren().add(root);
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
        File selectedDirectory = directoryChooser.showDialog(new Stage());

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
    public void Export() throws IOException {
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
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
      @FXML
    public void OpenPersonal() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    public void OpenMedical() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    @FXML
    public void OpenExercise() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Export.fxml"));
    }

}
