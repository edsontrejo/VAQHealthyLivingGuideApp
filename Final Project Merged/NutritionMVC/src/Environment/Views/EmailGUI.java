/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Views;

import Environment.Controllers.jEmailController;
import Environment.Models.jEmailModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JacobS
 */
public class EmailGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
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
        //this information ought to be gleaned from outside the program

        
        Scene scene = new Scene(root, 650, 450);
        
        primaryStage.setTitle("Email GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
