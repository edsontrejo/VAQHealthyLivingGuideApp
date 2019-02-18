package Environment.Views;

import Environment.Classes.Food;
import Environment.Classes.Nutrient;
import Environment.MainApplication;
import java.util.ArrayList;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MyItemsView extends BorderPane {
    private VBox Center;
    
    private Label Title = new Label("");
    private Label Info = new Label("");
    
    private Button Access;
    
    private ArrayList<Food> myList = new ArrayList<>();
    
    PieChart plateChart   = new PieChart();
    VBox ListBox = new VBox();
    
    public MyItemsView(){
        this.setId("myItemsView");
        
        Center = new VBox();
        this.Center.setId("Center");
        
        Access = new Button();
        
        updateView();        
    }
    
    public void updateView() 
    {
        this.getChildren().clear();

        Title.setText("My Items");
        Title.setId("pageTitle");
        Info.setText("Here you can manage all of your foods. If you want to add more foods into your list, go to 'All Foods'. ");
        Info.setId("pageInfo");
        
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info); 
        
        HBox Content = new HBox();
        ScrollPane ListPane = new ScrollPane();
        drawList(this.myList);
        ListPane.setContent(ListBox);
        
        plateChart.setData(getChartData());        
        boolean flag=true;
        plateChart.setClockwise(flag);
        plateChart.setStartAngle(90);
        plateChart.setLabelLineLength(10);
        plateChart.setLegendSide(Side.TOP);
	plateChart.setTitle("You Plate Portions");
        
        Content.getChildren().add(ListPane);
        Content.getChildren().add(plateChart);
        
        this.Center.getChildren().add(Content);
        
        this.setCenter(Center);
    }
    
    public VBox drawList(ArrayList<Food> list){
        ListBox.getChildren().clear();
        for(Food f : list){
            HBox itemView = new HBox();
            itemView.setId("itemViewBox");

            VBox itemImageView = new VBox();

            StackPane itemImagePane = new StackPane();
            itemImagePane.setId("itemImageLayout");

            itemImageView.setId("itemImageView");
            ImageView itemImage = new ImageView(); 

            try{
                itemImage = MainApplication.getTools().getImagebyName("foods/" + f.getImage());
            } catch(Exception e){
                System.err.println("Image foods/" + f.getImage() + " cannot be generated");
            }

            itemImage.setId("itemImage");
            itemImage.setFitWidth(50);
            itemImage.setFitHeight(50);

            itemImagePane.getChildren().add(itemImage);
            itemImageView.getChildren().add(itemImagePane);

            VBox itemInfo = new VBox();
            itemInfo.setId("itemInfoSection");

            Label itemName = new Label(f.getName());
            itemName.setId("itemTitle");

            HBox itemData = new HBox();
            itemData.setId("itemData");

            VBox data_1 = new VBox();
            data_1.getChildren().add(new Label("Group Id"));
            data_1.getChildren().add(new Label(Integer.toString(f.getGroupId())));

            VBox data_2 = new VBox();
            data_2.getChildren().add(new Label("Calories"));
            data_2.getChildren().add(new Label(Double.toString(f.getCalories())));

            VBox data_3 = new VBox();
            data_3.getChildren().add(new Label("Fats"));
            data_3.getChildren().add(new Label(Double.toString(f.getFats())));

            itemData.getChildren().add(data_1);
            itemData.getChildren().add(data_2);
            itemData.getChildren().add(data_3);

            HBox itemOptions = new HBox();
            itemOptions.setId("itemOptions");

            Button removeIt = new Button("Remove");
            removeIt.setId("itemRemovalButton");

            itemOptions.getChildren().add(removeIt);


            itemInfo.getChildren().add(itemName);
            itemInfo.getChildren().add(itemData);
            itemInfo.getChildren().add(itemOptions);

            itemView.getChildren().add(itemImageView);
            itemView.getChildren().add(itemInfo);

            ListBox.getChildren().add(itemView);
        }
        
        return ListBox;
    }
    
    public void reDrawCalorieView1(ObservableList<PieChart.Data> pieData) 
    {
       //caloriesPerPortionUnit.setText("");
       plateChart.getData().clear();
       plateChart.setData(pieData);  
       int total=0;
       for (PieChart.Data d : plateChart.getData())
       {
             total += d.getPieValue();
       }
       pieData.forEach(data -> data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), " ", data.pieValueProperty(), " Cals"
                )
        ) );
       plateChart.setTitle("Total Calories: "+ Integer.toString(total));
    }
    
    public ObservableList<PieChart.Data> getChartData() 
    {
        // Get from an SQL or File or whateer....
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Category-01", 1),
                new PieChart.Data("Category-02", 1),
	        new PieChart.Data("Category-03", 1),
                new PieChart.Data("Category-04", 1));
                return pieChartData;
    }

    /**
     * @return the myList
     */
    public ArrayList<Food> getMyList() {
        return myList;
    }

    /**
     * @param myList the myList to set
     */
    public void setMyList(ArrayList<Food> myList) {
        this.myList = myList;
    }
}
