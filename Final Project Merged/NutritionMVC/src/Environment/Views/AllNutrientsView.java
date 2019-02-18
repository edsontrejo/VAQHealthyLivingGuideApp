package Environment.Views;

import Environment.Classes.Food;
import Environment.Classes.FoodGroup;
import Environment.MainApplication;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;

public class AllNutrientsView extends BorderPane{
    private VBox Center;
    private HBox NutrientStats;
    private HBox CategoryBox;
    private ScrollPane ItemDisplayer;
    private VBox ItemDisplayerContentV1;
    private VBox ItemDisplayerContentV2;
    private HBox ItemDisplayerContentH;
    private VBox DetailDisplayer;
    private VBox DetailView;
    
    private Label Title = new Label("");
    private Label Info = new Label("");
    
    private ArrayList<FoodGroup> foodGroups;
    private int totalGroups = 0;
    private int totalFoods = 0;
    
    private Button Access;
    
    private FoodGroup currentFoodGroup;
    
    private Button buttonBack = new Button("Go Back");
    private Button buttonBack2 = new Button("Go Back");
    
    private Food foodPicked = new Food();
    
    private Button addFood = new Button("Add to my List");
    
    public AllNutrientsView() {
        
        this.setId("allNutrientsView");
        
        Center = new VBox();
        this.Center.setId("Center");
        
        NutrientStats = new HBox();
        this.NutrientStats.setId("Stats");
        
        CategoryBox = new HBox();
        this.CategoryBox.setId("Categories");
        
        ItemDisplayer = new ScrollPane();
        this.ItemDisplayer.setId("ItemDisplay");
        
        ItemDisplayerContentH = new HBox();
        this.ItemDisplayerContentH.setId("ItemDisplayContentH");

        ItemDisplayerContentV1 = new VBox();
        this.ItemDisplayerContentV1.setId("ItemDisplayContentV");

        ItemDisplayerContentV2 = new VBox();
        this.ItemDisplayerContentV2.setId("ItemDisplayContentV");
        
        DetailDisplayer = new VBox();
        this.DetailDisplayer.setId("detailDisplay");
        
        DetailView = new VBox();
        DetailView.setId("detailView");
        
        this.ItemDisplayerContentH.getChildren().add(ItemDisplayerContentV1);
        this.ItemDisplayerContentH.getChildren().add(ItemDisplayerContentV2);
        this.ItemDisplayer.setContent(ItemDisplayerContentH);
        
        
        this.DetailDisplayer.getChildren().add(DetailView);
        
        buttonBack.setOnAction(new Back());
        buttonBack2.setOnAction(new Back2ViewItems());
        Access = new Button();       
    }
    
    public void updateView() 
    {
        clearMain();
        
        Title.setText("All Nutrients");
        Title.setId("pageTitle");
        Info.setText("Select a category to view all of our recommended foods to get a nice diet.");
        Info.setId("pageInfo");
        
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info);
        
        drawStats();
        
        drawCategories();
        
        this.Center.getChildren().add(NutrientStats);
        this.Center.getChildren().add(CategoryBox);
        
        this.setCenter(Center);
    }
    
    public void updateFoods(FoodGroup f){
        clearItemViewer();
        
        Title.setText(f.getName());
        
        this.Center.getChildren().add(buttonBack);
        this.Center.getChildren().add(Title);
        
        drawFoods(f);
        ItemDisplayer.setVvalue(0);
        this.Center.getChildren().add(ItemDisplayer);
    }
    
    public void updateFoodDetails(Food f, FoodGroup fg){
        clearDetailViewer();
        
        this.Center.getChildren().add(buttonBack2);
        
        drawFoodDetails(f, fg);
        
        this.Center.getChildren().add(DetailDisplayer);
    }
    
    private void clearMain(){
        this.getChildren().clear();
        this.Center.getChildren().clear();
        this.NutrientStats.getChildren().clear();
        this.CategoryBox.getChildren().clear();
    }
    
    private void clearItemViewer(){
        this.Center.getChildren().clear();
        this.ItemDisplayerContentV1.getChildren().clear();
        this.ItemDisplayerContentV2.getChildren().clear();
    }
    
    private void clearDetailViewer(){
        this.Center.getChildren().clear();
        this.DetailView.getChildren().clear();
    }
    
    public void drawStats(){
        StackPane totalGroupsV = new StackPane();
        totalGroupsV.setId("statsBox");
        Label totalGroupsL = new Label(this.totalGroups + " Groups");
        
        totalGroupsV.getChildren().add(totalGroupsL);
        
        StackPane totalNutrientsV = new StackPane();
        totalNutrientsV.setId("statsBox");
        Label totalNutrientsL = new Label(this.totalFoods + " Foods");
        
        totalNutrientsV.getChildren().add(totalNutrientsL);
        
        StackPane totalSavedItemsV = new StackPane();
        totalSavedItemsV.setId("statsBox");
        Label totalSavedItemsL = new Label("0 Saved Items");
        
        totalSavedItemsV.getChildren().add(totalSavedItemsL);
        
        this.NutrientStats.getChildren().add(totalGroupsV);
        this.NutrientStats.getChildren().add(totalNutrientsV);
        this.NutrientStats.getChildren().add(totalSavedItemsV);
    }
    
    public void drawCategories(){
        for(FoodGroup f : foodGroups){
            StackPane Image = new StackPane();
            Image.setId(f.getCssid());
            Image.getChildren().add(new Label(" "));
            f.setButton(new Button(f.getName(), Image));
            f.getButton().setContentDisplay(ContentDisplay.TOP);
            f.getButton().setOnAction((ActionEvent event) -> {
                currentFoodGroup = f;
                updateFoods(f);
            });
            this.CategoryBox.getChildren().add(f.getButton());
        }
    }
    
    public void drawFoods(FoodGroup f){
        for(Food food : f.getFoods()){
            HBox itemView = new HBox();
            itemView.setId("itemViewBox");

            VBox itemImageView = new VBox();

            StackPane itemImagePane = new StackPane();
            itemImagePane.setId("itemImageLayout");

            itemImageView.setId("itemImageView");
            ImageView itemImage = new ImageView(); 

            try{
                itemImage = MainApplication.getTools().getImagebyName("foods/" + food.getImage());
            } catch(Exception e){
                System.err.println("Image foods/" + food.getImage() + " cannot be generated");
            }

            itemImage.setId("itemImage");
            itemImage.setFitWidth(50);
            itemImage.setFitHeight(50);

            itemImagePane.getChildren().add(itemImage);
            itemImageView.getChildren().add(itemImagePane);

            VBox itemInfo = new VBox();
            itemInfo.setId("itemInfoSection");

            Label itemName = new Label(food.getName());
            itemName.setId("itemTitle");

            HBox itemData = new HBox();
            itemData.setId("itemData");

            VBox data_1 = new VBox();
            data_1.getChildren().add(new Label("Group Id"));
            data_1.getChildren().add(new Label(Integer.toString(food.getGroupId())));

            VBox data_2 = new VBox();
            data_2.getChildren().add(new Label("Calories"));
            data_2.getChildren().add(new Label(Double.toString(food.getCalories())));

            VBox data_3 = new VBox();
            data_3.getChildren().add(new Label("Fats"));
            data_3.getChildren().add(new Label(Double.toString(food.getFats())));

            itemData.getChildren().add(data_1);
            itemData.getChildren().add(data_2);
            itemData.getChildren().add(data_3);

            HBox itemOptions = new HBox();
            itemOptions.setId("itemOptions");

            Button details = new Button("See More");
            details.setId("itemDetailsButton");
            
            details.setOnAction((ActionEvent event) -> {
                updateFoodDetails(food, f);
            });

            itemOptions.getChildren().add(details);

            itemInfo.getChildren().add(itemName);
            itemInfo.getChildren().add(itemData);
            itemInfo.getChildren().add(itemOptions);

            itemView.getChildren().add(itemImageView);
            itemView.getChildren().add(itemInfo);
            
            if(food.getId() % 2 != 0)
                this.ItemDisplayerContentV1.getChildren().add(itemView);
            else
                this.ItemDisplayerContentV2.getChildren().add(itemView);
        }
    }
    
    public void drawFoodDetails(Food f, FoodGroup fg){
        foodPicked = f;
        HBox GlobalDetails = new HBox();
        GlobalDetails.setId("globalDetails");
        
        HBox FoodInfo = new HBox();
        FoodInfo.setId("detailFoodInfo");
        
        VBox itemImageView = new VBox();
        itemImageView.setId("detailFoodImageView");
        
        StackPane itemImagePane = new StackPane();
        itemImagePane.setId("detailFoodImageLayout");

        ImageView itemImage = new ImageView(); 

        try{
            itemImage = MainApplication.getTools().getImagebyName("foods/" + f.getImage());
        } catch(Exception e){
            System.err.println("Image foods/" + f.getImage() + " cannot be generated");
        }

        itemImage.setId("detailFoodImage");
        itemImage.setFitWidth(100);
        itemImage.setFitHeight(100);
        
        itemImagePane.getChildren().add(itemImage);
        itemImageView.getChildren().add(itemImagePane);
        
        VBox detailData = new VBox();
        detailData.setId("detailData");
        
        Label data_1 = new Label(f.getName());
        data_1.setId("detailDataTitle");
        
        String groupName = (f.getGroupId() == fg.getGroupId()) ? fg.getName() : "{Undefined}" ;
        
        Label data_2 = new Label(groupName);
        data_2.setId("detailDataGroup");
        
        detailData.getChildren().add(data_1);
        detailData.getChildren().add(data_2);
        
        FoodInfo.getChildren().add(itemImageView);
        FoodInfo.getChildren().add(detailData);
        
        VBox FoodFacts = new VBox();
        FoodFacts.setId("foodFacts");
        
        Label FactsTitle = new Label("Nutritional Facts");
        FactsTitle.setId("factsTitle");
        
        TextFlow FactFlow = new TextFlow();
        FactFlow.setId("factsFlow");
        
        Label a0 = new Label("Amount per ");
        a0.setId("factT");
        Label a1 = new Label(" {Needs to be added in the Database}");
        a1.setId("factD");
        
        FactFlow.getChildren().add(a0);
        FactFlow.getChildren().add(a1);
        
        HBox Facts = new HBox();
        Facts.setId("FactsH");
        
        GridPane Facts0 = new GridPane();
        Facts0.setId("factsPane");
        
        GridPane Facts1 = new GridPane();
        Facts1.setId("factsPane");
        
        Label c0 = new Label("Calories");
        c0.setId("factT");
        Label c1 = new Label(Double.toString(f.getCalories()));
        c1.setId("factD");

        Label f0 = new Label("Total Fats");
        f0.setId("factT");
        Label f1 = new Label(f.getFats() + " g");
        f1.setId("factD");

        Label ch0 = new Label("Cholesterol");
        ch0.setId("factT");
        Label ch1 = new Label(f.getCholesterol() + " mg");
        ch1.setId("factD");

        Label s0 = new Label("Sodium");
        s0.setId("factT");
        Label s1 = new Label(f.getSodium() + " mg");
        s1.setId("factD");

        Label p0 = new Label("Potassium");
        p0.setId("factT");
        Label p1 = new Label(f.getPotassium() + " mg");
        p1.setId("factD");

        Label cb0 = new Label("Total Carbohydrate");
        cb0.setId("factT");
        Label cb1 = new Label(f.getCarbohydrates() + " g");
        cb1.setId("factD");
        
        Label pr0 = new Label("Protein");
        pr0.setId("factT");
        Label pr1 = new Label(f.getProteins() + " g");
        pr1.setId("factD");

        Facts0.add(c0, 0, 0);
        Facts0.add(c1, 1, 0);
        Facts0.add(f0, 0, 1);
        Facts0.add(f1, 1, 1);
        Facts0.add(s0, 0, 2);
        Facts0.add(s1, 1, 2);
        Facts0.add(cb0, 0, 3);
        Facts0.add(cb1, 1, 3);
        
        Facts1.add(ch0, 0, 0);
        Facts1.add(ch1, 1, 0);
        Facts1.add(p0, 0, 1);
        Facts1.add(p1, 1, 1);
        Facts1.add(pr0, 0, 2);
        Facts1.add(pr1, 1, 2);
        
        Facts0.setVgap(10);
        Facts0.setHgap(10);
        Facts1.setVgap(10);
        Facts1.setHgap(10);
        
        Facts.getChildren().add(Facts0);
        Facts.getChildren().add(Facts1);
        
        FoodFacts.getChildren().add(FactsTitle);
        FoodFacts.getChildren().add(FactFlow);
        FoodFacts.getChildren().add(Facts);
        
        GlobalDetails.getChildren().add(FoodInfo);
        GlobalDetails.getChildren().add(FoodFacts);
        
        HBox GlobalOptions = new HBox();
        GlobalOptions.setId("globalPlate");
        
        VBox FoodPlate = new VBox();
        FoodPlate.setId("optionFoodPlate");
        
        Label FoodPlateTitle = new Label("Add to my plate");
        FoodPlateTitle.setId("foodplateTitle");
        
        GridPane FoodPlateGrid = new GridPane();
        FoodPlateGrid.setId("foodplateGrid");
        
        Label  CaloriesPortionL = new Label("Calories/Portion-unit: ");
        CaloriesPortionL.setId("foodplateL");
        
        Label  CaloriesPortionAL = new Label("{Number of calories per portion unit}");
        CaloriesPortionAL.setId("foodplateL");
        
        Label portionL = new Label("Portion: ");
        portionL.setId("foodplateL");
        Slider portionSlider = new Slider();
        
        portionSlider.setMin(0);
        portionSlider.setMax(1000);
        portionSlider.setValue(0);
        portionSlider.prefWidth(100000);
        portionSlider.minWidth(100000);
        portionSlider.setShowTickLabels(true);
        portionSlider.setShowTickMarks(true);
        portionSlider.setMajorTickUnit(100);
        portionSlider.setMinorTickCount(50);
        portionSlider.setBlockIncrement(10);
        
        Label portionCalL = new Label("Portion Calories: ");
        portionL.setId("portionCalL");
        
        TextField caloriesPerPortionUnit  = new TextField();
        
        getAddFood().setId("addFoodButton");
        
        FoodPlateGrid.addRow(0, CaloriesPortionL, CaloriesPortionAL);
        FoodPlateGrid.addRow(1, portionL, portionSlider);
        FoodPlateGrid.addRow(2, portionCalL, caloriesPerPortionUnit);
        FoodPlateGrid.addRow(3, getAddFood());
        
        FoodPlate.getChildren().add(FoodPlateTitle);
        FoodPlate.getChildren().add(FoodPlateGrid);
        
        GlobalOptions.getChildren().add(FoodPlate);
        
        DetailView.getChildren().add(GlobalDetails);
        DetailView.getChildren().add(GlobalOptions);
    }
    
    public class ViewItems implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            for(FoodGroup f : foodGroups){
                if(event.getSource().equals(f.getButton())){
                    currentFoodGroup = f;
                    updateFoods(f);
                }
            }
        }
    }
    
    public class Back implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            updateView();
        }
    }
    
    public class Back2ViewItems implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            updateFoods(currentFoodGroup);
        }
    }

    /**
     * @return the foodGroups
     */
    public ArrayList<FoodGroup> getFoodGroups() {
        return foodGroups;
    }

    /**
     * @param foodGroups the foodGroups to set
     */
    public void setFoodGroups(ArrayList<FoodGroup> foodGroups) {
        this.foodGroups = foodGroups;
    }

    /**
     * @return the totalGroups
     */
    public int getTotalGroups() {
        return totalGroups;
    }

    /**
     * @param totalGroups the totalGroups to set
     */
    public void setTotalGroups(int totalGroups) {
        this.totalGroups = totalGroups;
    }

    /**
     * @return the totalFoods
     */
    public int getTotalFoods() {
        return totalFoods;
    }

    /**
     * @param totalFoods the totalFoods to set
     */
    public void setTotalFoods(int totalFoods) {
        this.totalFoods = totalFoods;
    }

    /**
     * @return the foodsPicked
     */
    public Food getFoodsPicked() {
        return foodPicked;
    }

    /**
     * @param foodsPicked the foodsPicked to set
     */
    public void setFoodsPicked(Food foodsPicked) {
        this.foodPicked = foodsPicked;
    }

    /**
     * @return the addFood
     */
    public Button getAddFood() {
        return addFood;
    }
}
