/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Views;

import Environment.Classes.Exercise.ExerciseTypeE;
import Environment.Classes.ExerciseRoutine;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutinePieChart extends PieChart {

    /**
     * Initializes the controller class.
     */
    
    
    public RoutinePieChart(ArrayList<ExerciseRoutine> exerciseRoutines,int sizeX,int sizeY) {
        // TODO
        
        this.setMaxSize(sizeX,sizeY);
        int numCardio = 0,numBalance = 0,numStrength = 0,numFlexibility = 0;
        for (ExerciseRoutine exerciseRoutine : exerciseRoutines)
        {
            if (exerciseRoutine.exercise.getType() == ExerciseTypeE.CARDIO)
                numCardio++;
            else if (exerciseRoutine.exercise.getType() == ExerciseTypeE.BALANCE)
                numBalance++;
            else if (exerciseRoutine.exercise.getType() == ExerciseTypeE.STRENGTH)
                numStrength++;
            else if (exerciseRoutine.exercise.getType() == ExerciseTypeE.FLEXIBILITY)
                numFlexibility++;               
        }
        
         ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data(ExerciseTypeE.CARDIO.toString(), numCardio),
                new PieChart.Data(ExerciseTypeE.FLEXIBILITY.toString(), numFlexibility),
                new PieChart.Data(ExerciseTypeE.BALANCE.toString(), numBalance),
                new PieChart.Data(ExerciseTypeE.STRENGTH.toString(), numStrength));
         
         this.setData(pieChartData);
         
    } 
    
    public void addData(ExerciseRoutine exerciseRoutine) {
        
        for (Data d : this.getData()) {
            if (d.getName().equals(exerciseRoutine.exercise.getType().toString())) {
                d.setPieValue(d.getPieValue() + 1);
                return;
            }
        }
    }  
    
}
