package Environment.Controllers;

import Environment.Classes.WeeklyRoutine;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class LoginController implements Initializable {

    LoginModel Model;
    
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
        Model = new LoginModel();
        password = "";  
    }

    @FXML
    private void OpenCreateAccount() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }

    private void OpenHome() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Home.fxml")));
    }

    @FXML
    private void Login() throws IOException {
        if (usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
            return;
        }
        if (Model.UserExists(usernameTF.getText(), passwordTF.getText())) {
            RetreiveProfile();
            OpenHome();

        } else {
            errorL.setText("Incorrect username/password");
        }
    }

    private void RetreiveProfile() {
        MainApplication.profile = Model.GetProfile(usernameTF.getText());
        MainApplication.profile.logged = true;
        MainApplication.profile.username = usernameTF.getText();
        MainApplication.profile.password = password;
        MainApplication.profile.weeklyRoutineList = Model.GetUserWeeklyRoutines(MainApplication.profile.id);
        MainApplication.profile.currentWeeklyRoutine = Model.GetUserCurrentWeeklyRoutine(MainApplication.profile.id);
        MainApplication.profile.weeklyRoutineList.forEach((WeeklyRoutine wr) -> {
            wr.monday.forEach((er) -> {
                System.out.println(er.exercise);
            });
        });
        TabManager.drawMenu();

    }

    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Login.fxml"));
    }
    
}

