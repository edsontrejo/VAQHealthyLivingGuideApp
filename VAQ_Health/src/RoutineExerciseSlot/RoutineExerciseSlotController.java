/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoutineExerciseSlot;

import Exercise.Exercise;
import Routine.ExerciseRoutine;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineExerciseSlotController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label exerciseNameL;
    @FXML
    ImageView exerciseIV;
    @FXML
    Label metL;
    @FXML 
    Label typeL;
    @FXML
    Label difficultyL;
    @FXML
    TextArea descriptionTA;
    @FXML
    public Button completeButton;
    @FXML
    AnchorPane backgroundPane;
    @FXML
    Label equipmentL;
    @FXML
    Label workOutTimeL;
    @FXML
    Label expectedCaloriedBurnedL;
    public int index;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void SetExercise(ExerciseRoutine exerciseRoutine)
    {
        exerciseNameL.setText(exerciseRoutine.exercise.getName());
        exerciseIV.setImage(exerciseRoutine.exercise.getImage());
        typeL.setText(exerciseRoutine.exercise.getType().toString());
        metL.setText(Double.toString(exerciseRoutine.exercise.getMet()));
        difficultyL.setText(exerciseRoutine.exercise.getDifficulty());
        descriptionTA.setText(exerciseRoutine.exercise.getDescription());
        if (exerciseRoutine.exercise.getEquipment() != null)
            equipmentL.setText(exerciseRoutine.exercise.getEquipment().getName());
        workOutTimeL.setText(exerciseRoutine.workOutTime.toString());
    }
    
    public void Done()
    {
        backgroundPane.setStyle("-fx-background-color: #90EE90");
    
    }
    
}
