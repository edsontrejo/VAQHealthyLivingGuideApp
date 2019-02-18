/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class CreateAccountController implements Initializable {

    LoginModel Model;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    TextField usernameTF;
    @FXML
    TextField passwordTF;
    @FXML
    TextField emailTF;
    @FXML
    Label errorL;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Model = new LoginModel();
    }    
    
    @FXML
    private void OpenSignIn() throws IOException
    {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/Login.fxml")));
    }
    @FXML 
    private void Create()
    {
       String username = usernameTF.getText();
       String password = passwordTF.getText();
       String email = emailTF.getText();
       
       if (username.isEmpty() || password.isEmpty())
       {
           errorL.setText("Username/Password have to be ...");
           return;
       }
       
        try {
            if (!Model.UsernameExists(username))
            {
                System.out.println("Username Available");  
            }
            else
            {
                errorL.setText("Username already exits");
                System.out.println("Username already exits");
                return;
            }} catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }       
        errorL.setText("Account Created");
        errorL.setTextFill(Color.GREEN);
       Model.AddUser(username, password, email);
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml"));
    }
}
