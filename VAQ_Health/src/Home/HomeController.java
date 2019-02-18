/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
        TabManager.getInstance().OpenProfilePersonal();
    }
    
    @FXML
    public void OpenExercise() throws IOException
    {
         TabManager.getInstance().OpenExerciseHome();
    }
    @FXML
    private void OpenRoutine() throws IOException
    {
         TabManager.getInstance().OpenRoutineHome();
    }
    
    @FXML
    private void Logout() throws IOException
    {
          TabManager.getInstance().OpenLogin();
    }
    
}
