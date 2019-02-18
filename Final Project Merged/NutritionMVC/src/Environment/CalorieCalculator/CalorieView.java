/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.CalorieCalculator;

import Environment.Classes.Category;
import Environment.Classes.Nutrient;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author xwc981
 */
public class CalorieView extends VBox{
    
// Top Part is the nutrients panel
     Label label1 = new Label("Calorie Calculator");
     
     Button addtoPlateBtn = new Button("Add to Plate");
     Button clearPlateBtn = new Button("Clear Plate");
     private Button clearNutrientBtn = new Button("Clear Food Choice");
     
     Label caloriesPerPortionUnitLabel = new Label("Calories/Portion-unit: ");
     Label portionLabel = new Label("Portion: ");
     Label totalCaloriesabel = new Label("Portion Calories:");
     TextField caloriesPerPortionUnit  = new TextField();
     
     
     private TextField portion  = new TextField();
     private TextField totalCalories  = new TextField();
     private Slider portionSlider        = new Slider();
     Slider totalCaloriesSlider = new Slider();  

     Label label2 = new Label("Food Categories/Choices:");
     ComboBox categoriesComboBox = new ComboBox();
     ComboBox categoryChoices    = new ComboBox();
     
     GridPane nutrientGrid = new GridPane();
     PieChart plateChart   = new PieChart();

     //Plate & current food selection
     private ObservableList<Category> foodCategories = FXCollections.observableArrayList();
     private Nutrient currentNutrient;
     
    HBox buttonsBox = new HBox();
    private ToggleGroup plateDisplaygroup = new ToggleGroup();
    private boolean isFoodCategories = true;

    public CalorieView() 
    {
	//set insets
        this.setPadding(new Insets(0, 10, 10, 10));
        this.setBorder(new Border(new BorderStroke(Color.NAVY, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(5))));
        
	// Categories Panel
	Font myFont = Font.font("Verdana", FontWeight.BOLD, 62);
        label1.setFont(myFont);
        label1.setTextFill(Color.WHITE);
        //label1.setWrapText(true);
	VBox vblabel = new VBox();
	vblabel.setAlignment(Pos.CENTER);
        vblabel.setStyle("-fx-background-color: #cc7000;");
	vblabel.getChildren().addAll(label1);
	
	myFont = Font.font("Verdana", FontPosture.ITALIC, 30);
        label2.setFont(myFont);
        label2.setTextFill(Color.web("#0870a3"));
        label2.setWrapText(true);
	
	caloriesPerPortionUnitLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
	portionLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, USE_PREF_SIZE));
	totalCaloriesabel.setFont(Font.font("Verdana", FontPosture.ITALIC, USE_PREF_SIZE));
	
	// Need Drop Down List
	foodCategories.clear();
        //"Grains" "Vegetables & fruits" "Dairy" "Meats" "Fats, spreads and oils" "Foods and drinks high in fat"
	// Get & populate from database
	foodCategories.add( new Category(1,"Vegetables & fruits",0));
        foodCategories.add( new Category(2,"Grains-Breads",0));
	foodCategories.add( new Category(3,"Dairy",0));
        foodCategories.add( new Category(4,"Meats",0));
	foodCategories.add( new Category(5,"Fats, spreads and oils",0));
	foodCategories.add( new Category(6,"Foods and drinks high in fat",0 ));
        categoriesComboBox.getItems().addAll(foodCategories);
	categoriesComboBox.setPromptText("Food Categories");
	
	// Need Drop Down List
        categoryChoices.getItems().addAll("");
	categoryChoices.setPromptText("Category Choices");
	
	// Will display without editing
	caloriesPerPortionUnit.setFont((Font.font("Veranda", FontWeight.BOLD, FontPosture.ITALIC, USE_PREF_SIZE)));	
	caloriesPerPortionUnit.setStyle("-fx-text-inner-color: green");

	nutrientGrid.addRow(0, categoriesComboBox, categoryChoices);
	nutrientGrid.addRow(1, caloriesPerPortionUnitLabel, caloriesPerPortionUnit);
	nutrientGrid.addRow(2, portionLabel,portionSlider);
        portionSlider.setMin(0);
        portionSlider.setMax(1000);
        portionSlider.setValue(00);
        portionSlider.setShowTickLabels(true);
        portionSlider.setShowTickMarks(true);
        portionSlider.setMajorTickUnit(100);
        portionSlider.setMinorTickCount(50);
        portionSlider.setBlockIncrement(10);
        nutrientGrid.addRow(3, totalCaloriesabel, totalCalories);
        
        buttonsBox.getChildren().addAll(addtoPlateBtn,clearNutrientBtn,clearPlateBtn);
	//nutrientGrid.addRow(4,buttonsBox);
        
	Separator separator1 = new Separator();
        separator1.setMinSize(20, 20);
        separator1.setOrientation(Orientation.HORIZONTAL);
	
	Separator separator2 = new Separator();
        separator2.setMinSize(20, 20);
        separator2.setOrientation(Orientation.HORIZONTAL);
        
	plateChart.setData(getChartData());        
        boolean flag=true;
        plateChart.setClockwise(flag);
        plateChart.setStartAngle(90);
        plateChart.setLabelLineLength(10);
        plateChart.setLegendSide(Side.TOP);
	plateChart.setTitle("You Plate Portions");
	
         // Food Items Vs. Food Categories choice 
        GridPane plateCalTypeGP = new GridPane();
        plateCalTypeGP.setVgap(5);
        plateCalTypeGP.setHgap(5);
        plateCalTypeGP.setPadding(new Insets(5, 5, 5, 5));
        RadioButton rb1 = new RadioButton("Categories");
        rb1.setUserData("foodCategories");
        rb1.setToggleGroup(plateDisplaygroup);
        rb1.setSelected(true);
        
        RadioButton rb2 = new RadioButton("Food Items");
        rb2.setToggleGroup(plateDisplaygroup);
        rb2.setUserData("foodItems");
        rb2.setSelected(false);

        plateCalTypeGP.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2))));
        plateCalTypeGP.add(new Label("Plate Type Mode:"), 0, 0);
        plateCalTypeGP.add(rb1, 0, 1);
        plateCalTypeGP.add(rb2, 1, 1);
        
	//
	this.getChildren().addAll(vblabel, label2,nutrientGrid,buttonsBox,plateCalTypeGP, separator2,plateChart);
    }
    
     public void reDrawCalorieView() 
    {
        setCurrentNutrient(null);
        caloriesPerPortionUnit.setText("");
        getPortion().setText("");
        //stat at base calories
        getTotalCalories().setText("");
        foodCategories.clear();
        categoryChoices.getItems().clear();
        categoryChoices.getItems().addAll("");

	// Get & populate from database
	foodCategories.add( new Category(1,"Vegetables & fruits",0));
        foodCategories.add( new Category(2,"Grains-Breads",0));
	foodCategories.add( new Category(3,"Dairy",0));
        foodCategories.add( new Category(4,"Meats",0));
	foodCategories.add( new Category(5,"Fats, spreads and oils",0));
	foodCategories.add( new Category(6,"Foods and drinks high in fat",0 ));
        
        categoriesComboBox.getItems().clear();
        categoriesComboBox.getItems().addAll(foodCategories);
	categoriesComboBox.setPromptText("Food Categories");
        
        categoriesComboBox.valueProperty().set(null);
        categoryChoices.valueProperty().set(null);
        
	getPortion().setText("");
	
        //start at base calories
        getTotalCalories().setText("");
       caloriesPerPortionUnit.setText("");
       plateChart.getData().clear();
       plateChart.setData(getChartData()); 
       plateChart.setTitle("Total Calories: 00");
       
    }   
    public void reDrawCalorieView1(ObservableList<PieChart.Data> pieData) 
    {
        getPortion().setText("");
        //stat at base calories
        getTotalCalories().setText("");
       //caloriesPerPortionUnit.setText("");
       plateChart.getData().clear();
       plateChart.setData(pieData);  
       double total = 0.0;
       for (PieChart.Data d : plateChart.getData())
       {
             total += d.getPieValue();
       }
       pieData.forEach(data -> data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), " ", data.pieValueProperty(), " Cals"
                )
        ) );
       plateChart.setTitle("Total Calories: "+ Double.toString(total));
    }
    
    public void reDrawCalorieView2(ObservableList<Nutrient> selectedCatChoices) 
    {
        getCategoryChoices().getItems().clear();
        caloriesPerPortionUnit.setText("");
        getPortion().setText("");
        //stat at base calories
        getTotalCalories().setText("");
        getCategoryChoices().getItems().addAll(selectedCatChoices);
    }
    
    public void reDrawCalorieView3(Nutrient selectedNutrient) 
    {
        // TextField caloriesPerPortionUnit  = new TextField();
        // TextField portion  = new TextField();
        
        setCurrentNutrient(selectedNutrient);
        String unit=selectedNutrient.getServinUnit();
        String basePortion  = Double.toString(selectedNutrient.getBasePortion());
        String baseCalories = Double.toString(selectedNutrient.getBaseCalories());
        portionSlider.setValue((int)selectedNutrient.getBasePortion());
        String caloriesPerPortionUnitString =baseCalories+" Cals per "+basePortion+" "+unit;

        caloriesPerPortionUnit.setText(caloriesPerPortionUnitString);
        caloriesPerPortionUnit.prefColumnCountProperty().bind(caloriesPerPortionUnit.textProperty().length());
        //Display the calories per unit of the base
        caloriesPerPortionUnit.setDisable(true);
        caloriesPerPortionUnit.setEditable(false);
        
	//start at the base unit
        getPortion().setText(basePortion);
        //stat at base calories
        getTotalCalories().setText(Double.toString(selectedNutrient.getBaseCalories()));
        // update currentNutrient as the userr changes portions
    }
    
    public void reDrawCalorieViewxxx(ObservableList<PieChart.Data> pieData) 
    {
	this.getChildren().clear();
	nutrientGrid.getChildren().clear();
	plateChart.setData(pieData);
	
	//set insets
        this.setPadding(new Insets(20, 10, 10, 10));
        this.setBorder(new Border(new BorderStroke(Color.NAVY, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(5))));
        
	// Categories Panel
	Font myFont = Font.font("Verdana", FontWeight.BOLD, 62);
        label1.setFont(myFont);
        label1.setTextFill(Color.WHITE);
        label1.setWrapText(true);
	VBox vblabel = new VBox();
        vblabel.setStyle("-fx-background-color: #cc7000;");
	vblabel.setAlignment(Pos.BASELINE_CENTER);
	vblabel.getChildren().addAll(label1);
	
	myFont = Font.font("Verdana", FontPosture.ITALIC, 30);
        label2.setFont(myFont);
        label2.setTextFill(Color.web("#0870a3"));
        label2.setWrapText(true);
	
	caloriesPerPortionUnitLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
	portionLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
	totalCaloriesabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
	
	// Need Drop Down List
//        categoriesComboBox.getItems().addAll(
//            "Protein",
//            "Meats",
//            "Grains",
//            "Dairy");
	categoriesComboBox.setPromptText("Food Categories");
	
	// Need Drop Down List
//        categoryChoices.getItems().addAll(
//            "Chicken",
//            "Fish",
//            "Lamb",
//            "Beef");
	
	getCategoryChoices().setPromptText("Category Choices");
	
	nutrientGrid.addRow(0, categoriesComboBox, getCategoryChoices());
	nutrientGrid.addRow(1, caloriesPerPortionUnitLabel, caloriesPerPortionUnit);
	nutrientGrid.addRow(2, portionLabel, getPortion());
	nutrientGrid.addRow(3, totalCaloriesabel, getTotalCalories());
	nutrientGrid.addRow(4,addtoPlateBtn);
	
	Separator separator1 = new Separator();
        separator1.setMinSize(20, 20);
        separator1.setOrientation(Orientation.HORIZONTAL);
	
	Separator separator2 = new Separator();
        separator2.setMinSize(20, 20);
        separator2.setOrientation(Orientation.HORIZONTAL);
        
	//plateChart.setData(getChartData());        
        boolean flag=true;
        plateChart.setClockwise(flag);
        plateChart.setStartAngle(90);
        plateChart.setLabelLineLength(10);
        plateChart.setLegendSide(Side.TOP);
	plateChart.setTitle("You Plate Portions");
	
	//this.setAlignment(Pos.BASELINE_LEFT);
	this.getChildren().addAll(vblabel, label2,nutrientGrid,separator2,plateChart);
    }
    
    /*
    "1","Vegetables & fruits",0));
        foodCategories.add( new Category("2","Grains-Breads",0));
	foodCategories.add( new Category("3","Dairy",0));
        foodCategories.add( new Category("4","Meats",0));
	foodCategories.add( new Category("5","Fats, spreads and oils",0));
	foodCategories.add( new Category("6","Foods and drinks high in fat"
    */
    
    //"Grains" "Vegetables & fruits" "Dairy" "Meats" "Fats, spreads and oils" "Foods and drinks high in fat"
   
    public ObservableList<PieChart.Data> getChartData() 
    {
        // Get from an SQL or File or whateer....
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Vegtables & fruits-01", 1),
                new PieChart.Data("Grains-02", 1),
	        new PieChart.Data("Dairy-03", 1),
                new PieChart.Data("Meats-04", 1),
                new PieChart.Data("Fats & oils-05", 1),
                new PieChart.Data("High in Fat-06", 1));
                return pieChartData;
    }
    
    public void updateUserView (ObservableList<PieChart.Data> pieData)
    {
        this.getChildren().clear();
	plateChart.setData(pieData);	
	this.getChildren().addAll(addtoPlateBtn, plateChart);
    }


	/**
	 * @return the addtoPlateBtn
	 */
	public Button getAddtoPlateBtn() {
		return addtoPlateBtn;
	}

	/**
	 * @param addtoPlateBtn the addtoPlateBtn to set
	 */
	public void setAddtoPlateBtn(Button addtoPlateBtn) {
		this.addtoPlateBtn = addtoPlateBtn;
	}

	/**
	 * @return the categoriesComboBox
	 */
	public ComboBox getCategoriesComboBox() {
		return categoriesComboBox;
	}

	/**
	 * @param categoriesComboBox the categoriesComboBox to set
	 */
	public void setCategoriesComboBox(ComboBox categoriesComboBox) {
		this.categoriesComboBox = categoriesComboBox;
	}

    /**
     * @return the categoryChoices
     */
    public ComboBox getCategoryChoices() {
        return categoryChoices;
    }

    /**
     * @param categoryChoices the categoryChoices to set
     */
    public void setCategoryChoices(ComboBox categoryChoices) {
        this.categoryChoices = categoryChoices;
    }

    /**
     * @return the currentNutrient
     */
    public Nutrient getCurrentNutrient() {
        return currentNutrient;
    }

    /**
     * @param currentNutrient the currentNutrient to set
     */
    public void setCurrentNutrient(Nutrient currentNutrient) {
        this.currentNutrient = currentNutrient;
    }

    /**
     * @return the clearPlateBtn
     */
    public Button getClearPlateBtn() {
        return clearPlateBtn;
    }

    /**
     * @param clearPlateBtn the clearPlateBtn to set
     */
    public void setClearPlateBtn(Button clearPlateBtn) {
        this.clearPlateBtn = clearPlateBtn;
    }

    /**
     * @return the portionSlider
     */
    public Slider getPortionSlider() {
        return portionSlider;
    }

    /**
     * @param portionSlider the portionSlider to set
     */
    public void setPortionSlider(Slider portionSlider) {
        this.portionSlider = portionSlider;
    }

    /**
     * @return the portion
     */
    public TextField getPortion() {
        return portion;
    }

    /**
     * @param portion the portion to set
     */
    public void setPortion(TextField portion) {
        this.portion = portion;
    }

    /**
     * @return the totalCalories
     */
    public TextField getTotalCalories() {
        return totalCalories;
    }

    /**
     * @param totalCalories the totalCalories to set
     */
    public void setTotalCalories(TextField totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     * @return the clearNutrientBtn
     */
    public Button getClearNutrientBtn() {
        return clearNutrientBtn;
    }

    /**
     * @param clearNutrientBtn the clearNutrientBtn to set
     */
    public void setClearNutrientBtn(Button clearNutrientBtn) {
        this.clearNutrientBtn = clearNutrientBtn;
    }

    /**
     * @return the plateDisplaygroup
     */
    public ToggleGroup getPlateDisplaygroup() {
        return plateDisplaygroup;
    }

    /**
     * @param plateDisplaygroup the plateDisplaygroup to set
     */
    public void setPlateDisplaygroup(ToggleGroup plateDisplaygroup) {
        this.plateDisplaygroup = plateDisplaygroup;
    }

    /**
     * @return the isFoodCategories
     */
    public boolean isIsFoodCategories() {
        return isFoodCategories;
    }

    /**
     * @param isFoodCategories the isFoodCategories to set
     */
    public void setIsFoodCategories(boolean isFoodCategories) {
        this.isFoodCategories = isFoodCategories;
    }
}
