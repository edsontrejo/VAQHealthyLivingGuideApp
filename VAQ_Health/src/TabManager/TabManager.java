/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vaq_health.VAQ_Health;
import vaq_health.VAQ_Health;
import vaq_health.VAQ_Health;

/**
 *
 * @author ^.^
 */
public class TabManager {
     static private TabManager instance;
     public static TabManager getInstance() {
      if(instance == null) {
         instance = new TabManager();
      }
      return instance;
   }
    public void OpenProfileMedical() throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Medical/Profile_Medical1.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenProfilePersonal()throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Personal1/Profile_Personal.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenProfileExercise()throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/Profile/Exercise/ExerciseProfile.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    public void OpenExerciseHome() throws IOException
    {
          OpenExercises();
//        Parent root = FXMLLoader.load(getClass().getResource("/ExerciseHome/ExerciseHome.fxml"));
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("/ExerciseHome/ExerciseHome.css").getPath());
//        VAQ_Health.mainStage.setScene(scene);
//        VAQ_Health.mainScene = scene;
//        VAQ_Health.mainStage.show(); 
    }
    
    public void OpenHome() 
    {
        Parent root;
         try {
             root = FXMLLoader.load(getClass().getResource("/Home/Home.fxml"));
         } catch (IOException ex) {
             Logger.getLogger(TabManager.class.getName()).log(Level.SEVERE, null, ex);
             return;
         }
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenCreateAccount() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/CreateAccount/CreateAccount.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show(); 
    }
    
    public void OpenLogin() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show(); 
    }

    public void OpenExercises() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ExerciseMenu/menu.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene); 
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenRoutineHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RoutineHome/RoutineHome.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }
    public void OpenRoutineCreator() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RoutineCreator/RoutineCreator.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }
    
    public void OpenRoutineManger() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RoutineManager/RoutineManager.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }
    
    public void OpenProfileExport() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Profile/Export/Export.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }

}
