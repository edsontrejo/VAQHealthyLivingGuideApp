/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;


import Environment.Classes.Exercise.MuscleTypeE;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class MuscleMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button tricepButton;
    @FXML
    private Button bicepButton;
    @FXML
    private Button backButton;
    @FXML
    private Button glutesButton;
    @FXML
    private Button lowerLegsButton;
    @FXML
    private Button shouldesButton;
    @FXML
    private Button foreArmsButton;
    @FXML
    private Button chestButton;
    @FXML
    private Button absButton;
    @FXML
    private Button upperLegsButton;
    @FXML
    private Parent rootNode;

    private Map<MuscleTypeE, Button> buttons;

    public MuscleMenuController() {
       
       // root.getChildrenUnmodifiable().
        //Init();
        
    }

   

    public Button GetButton(MuscleTypeE muscleType) {
        return buttons.get(muscleType);
    }
    
    public void SetRoot(Parent node)
    {
        rootNode = node;
    }
    public Parent GetRoot()
    {
        return rootNode;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons = new HashMap<MuscleTypeE, Button>();        
        buttons.put(MuscleTypeE.Triceps, tricepButton);
        buttons.put(MuscleTypeE.Biceps, bicepButton);
        buttons.put(MuscleTypeE.Back, backButton);
        buttons.put(MuscleTypeE.Glutes, glutesButton);
        buttons.put(MuscleTypeE.LowerLegs, lowerLegsButton);
        buttons.put(MuscleTypeE.Shoulders, shouldesButton);
        buttons.put(MuscleTypeE.ForeArms, foreArmsButton);
        buttons.put(MuscleTypeE.Chest, chestButton);
        buttons.put(MuscleTypeE.Abs, absButton);
        buttons.put(MuscleTypeE.UpperLegs, upperLegsButton);
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/ExerciseMuscleMenu.fxml"));
    }

}
