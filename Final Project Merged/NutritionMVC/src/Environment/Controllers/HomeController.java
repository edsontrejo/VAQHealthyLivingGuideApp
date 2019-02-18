package Environment.Controllers;

import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void OpenProfile() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Profile_Personal.fxml")));
    }
    
    @FXML
    public void OpenExercise() throws IOException
    {
         TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/ExerciseHome.fxml")));
    }
    @FXML
    private void OpenRoutine() throws IOException
    {
         TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineHome.fxml")));
    }
    
    @FXML
    private void Logout() throws IOException
    {
          TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Login.fxml")));
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Home.fxml"));
    }
    
}