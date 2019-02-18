/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseMenu;

import Exercise.Exercise;
import Exercise.Exercise.MuscleTypeE;
import Exercise.ExerciseDisplay.ExerciseDisplayController;
import ExerciseMuscleMenu.MuscleMenuController;
import ExerciseSearch.ExerciseSearchController;
import RoutineExerciseSlot.RoutineExerciseSlotController;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane contentPane;
    @FXML
    private ImageView muscleMenuButton;
    @FXML
    private ImageView downB;
    @FXML
    private ImageView backButton;
    
    private MuscleMenuController muscleMenuController;
    private ExerciseSearchController exerciseSearchController;
    private ExerciseDisplayController exerciseDisplayController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadControllers();
        SetHandlers();
        SetContent(muscleMenuController.GetRoot());
    } 
    
    

    private void LoadControllers() {
        Parent root = null;
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(getClass().getResource("/ExerciseMuscleMenu/ExerciseMuscleMenu.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        muscleMenuController = (MuscleMenuController) loader.getController();
        muscleMenuController.SetRoot(root);

        try {
            loader = new FXMLLoader(getClass().getResource("/ExerciseSearch/ExerciseSearch.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        exerciseSearchController = (ExerciseSearchController) loader.getController();
        exerciseSearchController.SetRoot(root);
        exerciseSearchController.setMenuController(this);
        
        try {
            loader = new FXMLLoader(getClass().getResource("/Exercise/ExerciseDisplay/ExerciseDisplay.fxml"));
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        exerciseDisplayController = (ExerciseDisplayController) loader.getController();
        exerciseDisplayController.SetRoot(root);
        
    }

    private void SetHandlers() {
        backButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                TabManager.getInstance().OpenHome();
            }
        });
        downB.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SwapView(exerciseDisplayController.GetRoot(),exerciseSearchController.GetRoot(),0,-1);
                downB.setDisable(true);
                downB.setVisible(false);
                muscleMenuButton.setDisable(false);
                if (!muscleMenuButton.isVisible())
                    muscleMenuButton.setVisible(true);
            }
        });
        muscleMenuButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                SwapView(exerciseSearchController.GetRoot(),muscleMenuController.GetRoot(),-1,0);
                muscleMenuButton.setVisible(false);
                muscleMenuButton.setDisable(true);
            }
        });
        for (MuscleTypeE muscleType : MuscleTypeE.values()) {
            muscleMenuController.GetButton(muscleType).setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    OpenSearchList(muscleType);
                    muscleMenuButton.setVisible(true);
                    muscleMenuButton.setDisable(false);
                }
            });
        }
    }

    private void SetContent(Node node) {
        contentPane.setCenter(node);
    }
    
    public void OpenExerciseDisplay(Exercise exercise)
    {
         exerciseDisplayController.setExercise(exercise);
         exerciseDisplayController.UpdateView();
         SwapView(exerciseSearchController.GetRoot(),exerciseDisplayController.GetRoot(),0,1);
         downB.setVisible(true);
         downB.setDisable(false);
        muscleMenuButton.setVisible(false);
        muscleMenuButton.setDisable(true);
    }
    
    public void OpenMuscleMenu()
    {
       
    }
    
    public void SwapView(Node node1, Node node2, int x, int y)
    {
        TranslateTransition tt = new TranslateTransition(Duration.millis(400), node1);
        tt.setByX(1000f *x);
        tt.setByY(1000f *y);
        tt.setCycleCount(1);
        tt.setAutoReverse(true);

        tt.setOnFinished(new EventHandler() {
            @Override
            public void handle(Event event) {
                SetContent(node2);
                node2.translateXProperty().set(x*-1000f);
                 node2.translateYProperty().set(y*-1000f);
                TranslateTransition tt = new TranslateTransition(Duration.millis(300), node2);
                tt.setByX(x*1010f);
                tt.setByY(y*1010f);
                tt.setCycleCount(1);
                tt.setAutoReverse(true);
                tt.setOnFinished(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        TranslateTransition tt = new TranslateTransition(Duration.millis(100), node2);
                        tt.setByX(x*-10f);
                        tt.setByY(y*-10f);
                        tt.setCycleCount(1);
                        tt.setAutoReverse(true);
                        tt.play();
                    }
                });
                tt.play();

            }
        });
        tt.play();
    }
    public void OpenSearchList(MuscleTypeE muscleType)
    {
        exerciseSearchController.FilterList(muscleType);
        SwapView(muscleMenuController.GetRoot(),exerciseSearchController.GetRoot(),1,0);

    }
    
 

}
