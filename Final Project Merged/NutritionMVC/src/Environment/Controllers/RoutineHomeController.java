/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Exercise;
import Environment.Classes.ExerciseRoutine;
import Environment.MainApplication;
import Environment.Tabs.TabManager;
import Environment.Views.RoutinePieChart;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    VBox mondayVBox = new VBox();
    @FXML
    VBox tuesdayVBox = new VBox();
    @FXML
    VBox wednesDayVBox = new VBox();
    @FXML
    VBox thursdayVBox = new VBox();
    @FXML
    VBox fridayVBox = new VBox();
    @FXML
    VBox saturdayVBox = new VBox();
    @FXML
    VBox sundayVBox = new VBox();
    @FXML
    AnchorPane exerciseSlotTemplate;
    @FXML
    Label WeeklyRoutineNameL;
    @FXML
    Label currentDayL;
    @FXML
    AnchorPane pieChartPane;
    boolean isMondayOpen, isTuesdayOpen, isThursdayOpen, isWednesDayOpen, isFridayOpen, isSaturdayOpen, isSundayOpen;
    @FXML
    ProgressIndicator mondayProgressIndicator;
    @FXML
    ProgressIndicator tuesdayProgressIndicator;
    @FXML
    ProgressIndicator wednesdayProgressIndicator;
    @FXML
    ProgressIndicator thursdayProgressIndicator;
    @FXML
    ProgressIndicator fridayProgressIndicator;
    @FXML
    ProgressIndicator saturdayProgressIndicator;
    @FXML
    ProgressIndicator sundayProgressIndicator;
    @FXML
    Label caloriesBurnedL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mondayVBox.setSpacing(5);
        WeeklyRoutineNameL.setText(MainApplication.profile.currentWeeklyRoutine.getName());
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        currentDayL.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
        UpdateProgressIndicators();      
        pieChartPane.getChildren().add(new RoutinePieChart(new ArrayList<ExerciseRoutine>(),300,300));
        UpdateCaloriesBurned();
    }

    @FXML
    private void ViewSunday() {
        if (!isSundayOpen && MainApplication.profile.currentWeeklyRoutine != null) {

            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.sunday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            //DatabaseManager.UpdateWeeklyRoutine(MainApplication.profile);
                            UpdateProgressIndicators();
                        }
                    });
                    sundayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sundayVBox.getChildren().remove(1, sundayVBox.getChildren().size());
        }
        isSundayOpen = !isSundayOpen;
        
        
    }

    @FXML
    private void ViewSaturday() {
        if (!isSaturdayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.saturday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    saturdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            saturdayVBox.getChildren().remove(1, saturdayVBox.getChildren().size());
        }
        isSaturdayOpen = !isSaturdayOpen;
    }

    @FXML
    private void ViewFriday() {
        if (!isFridayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.friday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    fridayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            fridayVBox.getChildren().remove(1, fridayVBox.getChildren().size());
        }
        isFridayOpen = !isFridayOpen;
    }

    @FXML
    private void ViewThursday() {
        if (!isThursdayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.thursday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    thursdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            thursdayVBox.getChildren().remove(1, thursdayVBox.getChildren().size());
        }
        isThursdayOpen = !isThursdayOpen;
    }

    @FXML
    private void ViewWednesday() {
        if (!isWednesDayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.wednesday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    wednesDayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            wednesDayVBox.getChildren().remove(1, wednesDayVBox.getChildren().size());
        }
        isWednesDayOpen = !isWednesDayOpen;
    }

    @FXML
    private void ViewTuesday() {
        if (!isTuesdayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.tuesday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    tuesdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tuesdayVBox.getChildren().remove(1, tuesdayVBox.getChildren().size());
        }
        isTuesdayOpen = !isTuesdayOpen;
    }

    @FXML
    private void ViewMonday() {
        if (!isMondayOpen && MainApplication.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.monday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Environment/FXMLs/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    mondayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mondayVBox.getChildren().remove(1, mondayVBox.getChildren().size());
        }
        isMondayOpen = !isMondayOpen;

    }

    @FXML
    private void OpenHome() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }

    @FXML
    private void OpenCreator() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineCreator.fxml")));
    }

    @FXML
    private void OpenManager() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineManager.fxml")));
    }

    private void UpdateProgressIndicators() {

        double nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        mondayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.monday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.tuesday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        tuesdayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.tuesday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.wednesday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        wednesdayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.wednesday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.thursday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        thursdayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.thursday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.friday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        fridayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.friday.size());
        
        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.saturday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        saturdayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.saturday.size());
        
        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.sunday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        sundayProgressIndicator.setProgress(nCompletedExercises / MainApplication.profile.currentWeeklyRoutine.sunday.size());
        UpdateCaloriesBurned();
        

    }

    private void UpdateCaloriesBurned() {
        double caloriesBurned = 0;
        double userWeight = 100;
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.tuesday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.wednesday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.thursday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.friday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.saturday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.sunday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : MainApplication.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        caloriesBurnedL.setText(Double.toString(caloriesBurned));
    }
    
    public Parent getView() throws IOException {
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineHome.fxml"));
    }
}
