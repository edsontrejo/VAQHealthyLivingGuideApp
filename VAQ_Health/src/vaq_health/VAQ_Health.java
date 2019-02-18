/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaq_health;

import Database.DatabaseManager;
import Profile.Profile;
import Routine.ExerciseRoutine;
import Routine.WeeklyRoutine;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ^.^
 */
public class VAQ_Health extends Application {
    
   static public Stage mainStage;
   static public Scene mainScene;
   static public Profile profile = new Profile();
   
   
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
            
        Scene scene = new Scene(root);
        stage.setScene(scene);
        mainScene = scene;
        stage.show();
        mainStage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
