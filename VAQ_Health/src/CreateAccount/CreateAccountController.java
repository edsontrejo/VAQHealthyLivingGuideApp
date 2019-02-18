/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateAccount;

import TabManager.TabManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import Database.DatabaseManager;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class CreateAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    TabManager profileController = new TabManager();
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
    }    
    
    @FXML
    private void OpenSignIn() throws IOException
    {
        profileController.OpenLogin();
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
            if (!DatabaseManager.UsernameExists(username))
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
       DatabaseManager.AddUser(username, password, email);
       
    }
    
}
