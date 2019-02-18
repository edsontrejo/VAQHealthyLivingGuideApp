/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import TabManager.TabManager;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.xml.bind.DatatypeConverter;
import Database.DatabaseManager;
import Routine.WeeklyRoutine;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField usernameTF;
    @FXML
    TextField passwordTF;
    @FXML
    Label errorL;
    String password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        password = "";  
    }

    @FXML
    private void OpenCreateAccount() throws IOException {
        TabManager.getInstance().OpenCreateAccount();
    }

    private void OpenHome() throws IOException {
        TabManager.getInstance().OpenHome();
    }

    @FXML
    private void Login() throws IOException {
        if (usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
            return;
        }
        if (DatabaseManager.UserExists(usernameTF.getText(), passwordTF.getText())) {
            RetreiveProfile();
            OpenHome();

        } else {
            errorL.setText("Incorrect username/password");
        }
    }

    private void RetreiveProfile() {
        VAQ_Health.profile = DatabaseManager.GetProfile(usernameTF.getText());
        VAQ_Health.profile.username = usernameTF.getText();
        VAQ_Health.profile.password = password;
        VAQ_Health.profile.weeklyRoutineList = DatabaseManager.GetUserWeeklyRoutines(VAQ_Health.profile.id);
        VAQ_Health.profile.currentWeeklyRoutine = DatabaseManager.GetUserCurrentWeeklyRoutine(VAQ_Health.profile.id);
        VAQ_Health.profile.weeklyRoutineList.forEach((WeeklyRoutine wr) -> {
            wr.monday.forEach((er) -> {
                System.out.println(er.exercise);
            });
        });
    }

}
