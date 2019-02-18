package Environment.Views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import Environment.MainApplication;

public class HomeView extends BorderPane{
            private VBox Center;
    
    private Label Title = new Label("");
    private Label Info = new Label("");
    
    private Button Access;
    
    public HomeView(){
        this.setId("homeView");
        
        Center = new VBox();
        this.Center.setId("Center");
        
        Access = new Button();
        
        updateView();        
    }
    
    public void updateView() 
    {
        this.getChildren().clear();

        Title.setText("Welcome {USERNAME}");
        Title.setId("pageTitle");
        Info.setText("UTRGV Vaquero Nutrition Application Version " + MainApplication.version);
        Info.setId("pageInfo");
        
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info); 
        
        this.setCenter(Center);
    }   
}
