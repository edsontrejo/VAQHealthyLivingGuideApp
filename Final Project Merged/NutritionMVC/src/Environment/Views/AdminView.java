package Environment.Views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AdminView extends BorderPane{
            private VBox Center;
    
    private Label Title = new Label("");
    private Label Info = new Label("");
    
    private Button Access;
    
    public AdminView(){
        this.setId("adminView");
        
        Center = new VBox();
        this.Center.setId("Center");
        
        Access = new Button();
        
        updateView();        
    }
    
    public void updateView() 
    {
        this.getChildren().clear();

        Title.setText("Admin Control Panel");
        Title.setId("pageTitle");
        Info.setText("Welcome Back {Admin Name}, let's manage some accounts, foods, exercises...");
        Info.setId("pageInfo");
        
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info); 
        
        this.setCenter(Center);
    }
}
