package Environment.Controllers;

import Environment.Classes.Exercise;
import Environment.Classes.ExerciseRoutine;
import Environment.Classes.WeeklyRoutine;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import Environment.Tabs.TabManager;
import Environment.Views.RoutinePieChart;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineController implements Initializable {
    LoginModel Model;
    /**
     * Initializes the controller class.
     */
    @FXML
    ComboBox routineCB;
    @FXML
    ListView exerciseLV = new ListView();
    @FXML
    ListView mondayRoutineLV = new ListView();
    @FXML
    ListView tuesdayRoutineLV = new ListView();
    @FXML
    ListView wednesdayRoutineLV = new ListView();
    @FXML
    ListView thursdayRoutineLV = new ListView();
    @FXML
    ListView fridayRoutineLV = new ListView();
    @FXML
    ListView saturdayRoutineLV = new ListView();
    @FXML
    ListView sundayRoutineLV = new ListView();
    @FXML
    ImageView imageV = new ImageView();
    @FXML
    TextArea routineNameTA = new TextArea();
    @FXML
    TabPane weekTabPane;
    @FXML
    AnchorPane pieChartPane;
    @FXML 
    TextArea searchBar;
    @FXML
    private Label promptL;
    private final int MAX_ROUTINES = 15;

    ListView currentDayLV;
    String currentDay = "Monday";

    ArrayList<Exercise> exerciseList = new ArrayList<>();
    RoutinePieChart routinePieChart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Model = new LoginModel();
        // TODO
//        TranslateTransition transition = new TranslateTransition();
//        transition.setDuration(Duration.seconds(10));
//        transition.setNode(imageV);
//        transition.setToX(100);
//        transition.play();

        ImageView imageCopyV = new ImageView();
        imageCopyV.setImage(imageV.getImage());
        exerciseList = Model.GetExerciseList();
        for (Exercise exercise : exerciseList) {
            exerciseLV.getItems().add(exercise);
        }
        
        for (WeeklyRoutine weeklyRoutine : MainApplication.profile.weeklyRoutineList)
        {
            routineCB.getItems().add(weeklyRoutine);
        }
       
        routineCB.valueProperty().addListener(new ChangeListener<WeeklyRoutine>() {
            @Override
            public void changed(ObservableValue<? extends WeeklyRoutine> observable, WeeklyRoutine oldValue, WeeklyRoutine newValue) {
                DisplayRoutine();
            }

        });
        
        routinePieChart = new RoutinePieChart(MainApplication.profile.currentWeeklyRoutine.monday,300,300);
        pieChartPane.setMaxSize(20,20);
        pieChartPane.getChildren().add(routinePieChart);
        searchBar.textProperty().addListener(new ChangeListener<String>() {
               
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   search(newValue);
                }
            });
    }
    
    private void search(String newValue) {                     
        String value = newValue.toLowerCase();
        ObservableList<Exercise> subentries = FXCollections.observableArrayList();
        for (Iterator it = exerciseList.iterator(); it.hasNext();) {
            Exercise entry = (Exercise) it.next();
            if (entry.getName().toLowerCase().startsWith(value)){
                subentries.add(entry);
            }
        }
        exerciseLV.getItems().clear();
        exerciseLV.setItems(subentries);
    }
    

    @FXML
    public void OpenRoutineHome() throws IOException {
        TabManager.setPage(FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/CreateAccount.fxml")));
    }

    @FXML
    private void AddExercise() {
        
        if (exerciseLV.getSelectionModel().isEmpty()) {
            return;
        }
        if (currentDayLV.getItems().size() > MAX_ROUTINES)
        {
            promptL.setText("Limit Reached");
            return;
        }
        ExerciseRoutine exerciseRoutine;
        exerciseRoutine = new ExerciseRoutine((Exercise)exerciseLV.getSelectionModel().getSelectedItem(),60.0);
        currentDayLV.getItems().add(exerciseRoutine);
        routinePieChart.addData(exerciseRoutine);
        
    }

    @FXML
    private void RemoveExercise() {

        if (currentDayLV.getSelectionModel().isEmpty()) {
            return;
        }
        if (currentDayLV.getItems().size() <= MAX_ROUTINES)
        {
            promptL.setText("");
            return;
        }
        currentDayLV.getItems().remove(currentDayLV.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void CreateRoutine() {

        if (routineNameTA.getText().isEmpty()) {
            return;
        }
        ObservableList<WeeklyRoutine> routineList = FXCollections.observableList(routineCB.getItems());
        for (WeeklyRoutine routine : routineList) {
            if (routine.getName().equals(routineNameTA.getText())) {
                System.out.println("Routine name already exists");
                return;
            }
        }

        WeeklyRoutine newWeekRoutine = new WeeklyRoutine();
        ObservableList<ExerciseRoutine> mondayList = FXCollections.observableList(mondayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> tuesdayList = FXCollections.observableList(tuesdayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> wednesdayList = FXCollections.observableList(wednesdayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> thursdayList = FXCollections.observableList(thursdayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> fridayList = FXCollections.observableList(fridayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> saturdayList = FXCollections.observableList(saturdayRoutineLV.getItems());
        ObservableList<ExerciseRoutine> sundayList = FXCollections.observableList(sundayRoutineLV.getItems());

        newWeekRoutine.setName(routineNameTA.getText());

        for (ExerciseRoutine er : mondayList) {
            newWeekRoutine.monday.add(er);
        }
        for (ExerciseRoutine er : tuesdayList) {
            newWeekRoutine.tuesday.add(er);
        }
        for (ExerciseRoutine er : wednesdayList) {
            newWeekRoutine.wednesday.add(er);
        }
        for (ExerciseRoutine er : thursdayList) {
            newWeekRoutine.thursday.add(er);
        }
        for (ExerciseRoutine er : fridayList) {
            newWeekRoutine.friday.add(er);
        }
        for (ExerciseRoutine er : saturdayList) {
            newWeekRoutine.saturday.add(er);
        }
        for (ExerciseRoutine er : sundayList) {
            newWeekRoutine.sunday.add(er);
        }

        routineCB.getItems().add(newWeekRoutine);
        MainApplication.profile.weeklyRoutineList.add(newWeekRoutine);
        Model.AddWeeklyRoutine(newWeekRoutine);
    }

    @FXML
    private void DisplayRoutine() {

        if (routineCB.getSelectionModel().isEmpty()) {
            return;
        }

        System.out.println("Displaying Routine");

        WeeklyRoutine routine = (WeeklyRoutine) routineCB.getSelectionModel().getSelectedItem();

        ObservableList<ExerciseRoutine> mondayList = FXCollections.observableList((ArrayList) routine.monday.clone());
        ObservableList<ExerciseRoutine> tuesdayList = FXCollections.observableList((ArrayList) routine.tuesday.clone());
        ObservableList<ExerciseRoutine> wednesdayList = FXCollections.observableList((ArrayList) routine.wednesday.clone());
        ObservableList<ExerciseRoutine> thursdayList = FXCollections.observableList((ArrayList) routine.thursday.clone());
        ObservableList<ExerciseRoutine> fridayList = FXCollections.observableList((ArrayList) routine.friday.clone());
        ObservableList<ExerciseRoutine> saturdayList = FXCollections.observableList((ArrayList) routine.saturday.clone());
        ObservableList<ExerciseRoutine> sundayList = FXCollections.observableList((ArrayList) routine.sunday.clone());

        mondayRoutineLV.setItems(mondayList);
        tuesdayRoutineLV.setItems(tuesdayList);
        wednesdayRoutineLV.setItems(wednesdayList);
        thursdayRoutineLV.setItems(thursdayList);
        fridayRoutineLV.setItems(fridayList);
        saturdayRoutineLV.setItems(saturdayList);
        sundayRoutineLV.setItems(sundayList);

    }

    @FXML
    void wdTabChanged() {

        currentDay = weekTabPane.getSelectionModel().getSelectedItem().getText();

        switch (currentDay) {
            case "Monday":
                currentDayLV = mondayRoutineLV;
                break;
            case "Wednesday":
                currentDayLV = wednesdayRoutineLV;
            case "Tuesday":
                currentDayLV = tuesdayRoutineLV;
                break;
            case "Thursday":
                currentDayLV = thursdayRoutineLV;
                break;
            case "Friday":
                currentDayLV = fridayRoutineLV;
                break;
            case "Saturday":
                currentDayLV = saturdayRoutineLV;
                break;
            case "Sunday":
                currentDayLV = sundayRoutineLV;
        }
    }
    
    public Parent getView() throws IOException{
        return FXMLLoader.load(this.getClass().getResource("/Environment/FXMLs/RoutineCreator.fxml"));
    }

}
