/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

import Exercise.Exercise;

/**
 *
 * @author ^.^
 */
public class ExerciseRoutine {
    public Exercise exercise;
    public Double workOutTime;
    public boolean isCompleted;
    
    public ExerciseRoutine(Exercise exercise, Double workOutTime)
    {
        this.exercise = exercise;
        this.workOutTime = workOutTime;
    }

    public ExerciseRoutine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public String toString() {
        return exercise.getName();
    }
}
