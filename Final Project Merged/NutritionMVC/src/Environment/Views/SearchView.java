/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author yessi
 */
public class SearchView extends VBox{

    private Label header = new Label("Search");
    HBox HeaderBox = new HBox();
    
    private Image image;
    private ImageView iv;
    
    private String ImageName;
    private Label nameLabel= new Label("Name: ");
    private TextField nameText = new TextField("") ;
    private Label groupLabel= new Label("Food Group: ");
    private TextField groupText = new TextField("");
    private Label servingLabel= new Label("Serving: ");
    private TextField servingText = new TextField("");
    private Label caloriesLabel= new Label("Calories: ");
    private TextField caloriesText = new TextField("");
    private Label totalFatLabel= new Label("Total Fat: ");
    private TextField totalFatText = new TextField("");
    private Label cholesterolLabel= new Label("Cholesterol: ");
    private TextField cholesterolText = new TextField("");
    private Label sodiumLabel = new Label("Sodium: ");
    private TextField sodiumText = new TextField("");
    private Label potassiumLabel= new Label("Potassium: ");
    private TextField potassiumText = new TextField("");
    private Label carbohydratesLabel= new Label("Carbohydrates: ");
    private TextField carbohydratesText = new TextField("");
    private Label proteinsLabel= new Label("Proteins: ");
    private TextField proteinsText = new TextField("");
    
    GridPane Nutrition_Facts = new GridPane();
    GridPane Search = new GridPane();
    
    private Button update = new Button("Search");
    
    public SearchView() 
    {
        Nutrition_Facts.add(servingLabel, 0, 0);
        Nutrition_Facts.add(servingText, 1, 0);
        Nutrition_Facts.add(caloriesLabel, 0, 1);
        Nutrition_Facts.add(caloriesText, 1, 1);
        Nutrition_Facts.add(totalFatLabel, 0, 2);
        Nutrition_Facts.add(totalFatText, 1, 2);
        Nutrition_Facts.add(cholesterolLabel, 0, 3);
        Nutrition_Facts.add(cholesterolText, 1, 3);
        Nutrition_Facts.add(sodiumLabel, 0, 4);
        Nutrition_Facts.add(sodiumText, 1, 4);
        Nutrition_Facts.add(potassiumLabel, 0, 5);
        Nutrition_Facts.add(potassiumText, 1, 5);
        Nutrition_Facts.add(carbohydratesLabel, 0, 6);
        Nutrition_Facts.add(carbohydratesText, 1, 6);
        Nutrition_Facts.add(proteinsLabel, 0, 7);
        Nutrition_Facts.add(proteinsText, 1, 7);
        
        Search.setHgap(10);
        Search.setVgap(10);
        Search.setPadding(new Insets(0, 10, 0, 10)); 
        Search.addRow(1, nameLabel, nameText);
        Search.addRow(2, update);
        
        Font myFont = Font.font("Verdana", FontWeight.BOLD,  62);
        header.setFont(myFont);
        header.setTextFill(Color.WHITE);
        HeaderBox.setAlignment(Pos.CENTER);
        HeaderBox.getChildren().add(header);
        HeaderBox.setStyle("-fx-background-color: #cc7000;");
        
        this.getChildren().addAll(HeaderBox,Search);

    }
    
    public void updateFood(String ImageName, String name, int group, int serving, int calories, int totalFat, int cholesterol
                            , double sodium, double potassium, int carbohydrates, int protein)
    {
        setImageName(ImageName);
        getNameText().setText(name);
        getGroupText().setText(Integer.toString(group));
        getServingText().setText(Integer.toString(serving));
        getCaloriesText().setText(Integer.toString(calories));
        getTotalFatText().setText(Integer.toString(totalFat));
        getCholesterolText().setText(Integer.toString(cholesterol));
        getSodiumText().setText(Double.toString(sodium));
        getPotassiumText().setText(Double.toString(potassium));
        getCarbohydratesText().setText(Integer.toString(carbohydrates));
        getProteinsText().setText(Integer.toString(protein));
    }
    
    public void updateSearchView ()
    {      
        if(getImageName().equals("Not in database")){
            Label NotFound = new Label("Not found!");
            Nutrition_Facts.getChildren().clear();
            Search.getChildren().clear();
            Search.addRow(1, getNameLabel(), getNameText());
            Search.addRow(2, update);
            Search.addRow(3, NotFound);
            this.getChildren().clear();
            this.getChildren().addAll(HeaderBox,Search);
        }else{
        image = new Image("/resources/images/foods/" + getImageName());
        System.out.println(getImageName());
        iv = new ImageView(image);
        iv.setFitHeight(225);
        iv.setFitWidth(175);
        
            Nutrition_Facts.getChildren().clear();
            Nutrition_Facts.add(getServingLabel(), 0, 0);
            Nutrition_Facts.add(getServingText(), 1, 0);
            Nutrition_Facts.add(getCaloriesLabel(), 0, 1);
            Nutrition_Facts.add(getCaloriesText(), 1, 1);
            Nutrition_Facts.add(getTotalFatLabel(), 0, 2);
            Nutrition_Facts.add(getTotalFatText(), 1, 2);
            Nutrition_Facts.add(getCholesterolLabel(), 0, 3);
            Nutrition_Facts.add(getCholesterolText(), 1, 3);
            Nutrition_Facts.add(getSodiumLabel(), 0, 4);
            Nutrition_Facts.add(getSodiumText(), 1, 4);
            Nutrition_Facts.add(getPotassiumLabel(), 0, 5);
            Nutrition_Facts.add(getPotassiumText(), 1, 5);
            Nutrition_Facts.add(getCarbohydratesLabel(), 0, 6);
            Nutrition_Facts.add(getCarbohydratesText(), 1, 6);
            Nutrition_Facts.add(getProteinsLabel(), 0, 7);
            Nutrition_Facts.add(getProteinsText(), 1, 7);
            Nutrition_Facts.setGridLinesVisible(true);
        
            Search.getChildren().clear();
            Search.addRow(1, getNameLabel(), getNameText());
            Search.addRow(2, update);
            Search.addRow(3, getGroupLabel(), getGroupText());
            Search.addRow(4, iv, Nutrition_Facts);
            
            this.getChildren().clear();
            this.getChildren().addAll(HeaderBox,Search);
        }
    }
    
    /**
     * @return the ImageName
     */
    public String getImageName() {
        return ImageName;
    }

    /**
     * @param ImageName the ImageName to set
     */
    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }
    
    /**
     * @return the nameLabel
     */
    public Label getNameLabel() {
        return nameLabel;
    }

    /**
     * @param nameLabel the nameLabel to set
     */
    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * @return the nameText
     */
    public TextField getNameText() {
        return nameText;
    }

    /**
     * @param nameText the nameText to set
     */
    public void setNameText(TextField nameText) {
        this.nameText = nameText;
    }
    
    
    /**
     * @return the groupLabel
     */
    public Label getGroupLabel() {
        return groupLabel;
    }

    /**
     * @param groupLabel the groupLabel to set
     */
    public void setGroupLabel(Label groupLabel) {
        this.groupLabel = groupLabel;
    }

    /**
     * @return the groupText
     */
    public TextField getGroupText() {
        return groupText;
    }

    /**
     * @param groupText the groupText to set
     */
    public void setGroupText(TextField groupText) {
        this.groupText = groupText;
    }

    /**
     * @return the servingLabel
     */
    public Label getServingLabel() {
        return servingLabel;
    }

    /**
     * @param servingLabel the servingLabel to set
     */
    public void setServingLabel(Label servingLabel) {
        this.servingLabel = servingLabel;
    }

    /**
     * @return the servingText
     */
    public TextField getServingText() {
        return servingText;
    }

    /**
     * @param servingText the servingText to set
     */
    public void setServingText(TextField servingText) {
        this.servingText = servingText;
    }

    /**
     * @return the caloriesLabel
     */
    public Label getCaloriesLabel() {
        return caloriesLabel;
    }

    /**
     * @param caloriesLabel the caloriesLabel to set
     */
    public void setCaloriesLabel(Label caloriesLabel) {
        this.caloriesLabel = caloriesLabel;
    }

    /**
     * @return the caloriesText
     */
    public TextField getCaloriesText() {
        return caloriesText;
    }

    /**
     * @param caloriesText the caloriesText to set
     */
    public void setCaloriesText(TextField caloriesText) {
        this.caloriesText = caloriesText;
    }

    /**
     * @return the totalFatLabel
     */
    public Label getTotalFatLabel() {
        return totalFatLabel;
    }

    /**
     * @param totalFatLabel the totalFatLabel to set
     */
    public void setTotalFatLabel(Label totalFatLabel) {
        this.totalFatLabel = totalFatLabel;
    }

    /**
     * @return the totalFatText
     */
    public TextField getTotalFatText() {
        return totalFatText;
    }

    /**
     * @param totalFatText the totalFatText to set
     */
    public void setTotalFatText(TextField totalFatText) {
        this.totalFatText = totalFatText;
    }

    /**
     * @return the cholesterolLabel
     */
    public Label getCholesterolLabel() {
        return cholesterolLabel;
    }

    /**
     * @param cholesterolLabel the cholesterolLabel to set
     */
    public void setCholesterolLabel(Label cholesterolLabel) {
        this.cholesterolLabel = cholesterolLabel;
    }

    /**
     * @return the cholesterolText
     */
    public TextField getCholesterolText() {
        return cholesterolText;
    }

    /**
     * @param cholesterolText the cholesterolText to set
     */
    public void setCholesterolText(TextField cholesterolText) {
        this.cholesterolText = cholesterolText;
    }
    
    /**
     * @return the sodiumLabel
     */
    public Label getSodiumLabel() {
        return sodiumLabel;
    }

    /**
     * @param sodiumLabel the sodiumLabel to set
     */
    public void setSodiumLabel(Label sodiumLabel) {
        this.sodiumLabel = sodiumLabel;
    }

    /**
     * @return the sodiumText
     */
    public TextField getSodiumText() {
        return sodiumText;
    }

    /**
     * @param sodiumText the sodiumText to set
     */
    public void setSodiumText(TextField sodiumText) {
        this.sodiumText = sodiumText;
    }

    /**
     * @return the potassiumLabel
     */
    public Label getPotassiumLabel() {
        return potassiumLabel;
    }

    /**
     * @param potassiumLabel the potassiumLabel to set
     */
    public void setPotassiumLabel(Label potassiumLabel) {
        this.potassiumLabel = potassiumLabel;
    }

    /**
     * @return the potassiumText
     */
    public TextField getPotassiumText() {
        return potassiumText;
    }

    /**
     * @param potassiumText the potassiumText to set
     */
    public void setPotassiumText(TextField potassiumText) {
        this.potassiumText = potassiumText;
    }

    /**
     * @return the carbohydratesLabel
     */
    public Label getCarbohydratesLabel() {
        return carbohydratesLabel;
    }

    /**
     * @param carbohydratesLabel the carbohydratesLabel to set
     */
    public void setCarbohydratesLabel(Label carbohydratesLabel) {
        this.carbohydratesLabel = carbohydratesLabel;
    }

    /**
     * @return the carbohydratesText
     */
    public TextField getCarbohydratesText() {
        return carbohydratesText;
    }

    /**
     * @param carbohydratesText the carbohydratesText to set
     */
    public void setCarbohydratesText(TextField carbohydratesText) {
        this.carbohydratesText = carbohydratesText;
    }

    /**
     * @return the proteinsLabel
     */
    public Label getProteinsLabel() {
        return proteinsLabel;
    }

    /**
     * @param proteinsLabel the proteinsLabel to set
     */
    public void setProteinsLabel(Label proteinsLabel) {
        this.proteinsLabel = proteinsLabel;
    }

    /**
     * @return the proteinsText
     */
    public TextField getProteinsText() {
        return proteinsText;
    }

    /**
     * @param proteinsText the proteinsText to set
     */
    public void setProteinsText(TextField proteinsText) {
        this.proteinsText = proteinsText;
    }

    

    /**
     * @return the update
     */
    public Button getUpdateButton() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(Button update) {
        this.update = update;
    }
    
}