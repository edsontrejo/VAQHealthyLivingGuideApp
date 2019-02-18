/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Exercise;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseSearchSlotController implements Initializable {

    /**
     * @return the slotPane
     */
    public AnchorPane getSlotPane() {
        return slotPane;
    }

    /**
     * @param slotPane the slotPane to set
     */
    public void setSlotPane(AnchorPane slotPane) {
        this.slotPane = slotPane;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    Label exerciseNameL;
    @FXML
    Label typeL;
    @FXML
    Label equipmentL;
    @FXML
    Label mainMuscleL;
    @FXML
    Label metL;
    @FXML
    ImageView exerciseIV;
    @FXML
    private AnchorPane slotPane;
    
    private Exercise exercise;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        exerciseIV.setPreserveRatio(true);
        exerciseIV.setFitHeight(100);
        exerciseIV.setFitWidth(300);
    }    
    public void SetExercise(Exercise e)
    {
        exercise = e; 
    }
    public Exercise GetExercise()
    {
        return exercise;
    }
    
    public void UpdateView()
    {
        exerciseNameL.setText(this.exercise.getName());
        typeL.setText("Type : " + exercise.getType().toString());
        metL.setText("MET : " + exercise.getMet().toString());
        equipmentL.setText("Equipment : " + exercise.getEquipment().toString());
        mainMuscleL.setText("Main Muscle : " + exercise.getMuscleTypeE().toString());
        exerciseIV.setImage(exercise.getImage());
    }
}
