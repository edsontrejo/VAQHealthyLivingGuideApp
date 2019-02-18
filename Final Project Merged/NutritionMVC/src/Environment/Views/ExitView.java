/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Views;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import Environment.MainApplication;

/**
 *
 * @author dark_
 */
public class ExitView extends BorderPane{
    private VBox Center;
    
    private Label Title = new Label("");
    private Label Info = new Label("");
    private Button Leave = new Button();
    
    private Button Access;
    
    public ExitView() {
        this.setId("exitView");
        
        Center = new VBox();
        this.Center.setId("Center");
        
        Access = new Button();
        
        updateView();        
    }
    
    public void updateView() 
    {
        this.getChildren().clear();

        Title.setText("Goodbye, {username}!");
        Title.setId("pageTitle");
        Info.setText("All your data has been succesfully saved into our database. Hope you come back soon!");
        Info.setId("pageInfo");
        
        Leave.setText("Close {AppName}");
        Leave.setId("exitBtn");
        Leave.setOnAction((ActionEvent event) -> {
            MainApplication.prepareShutdown();
        });
        
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info);       
        this.Center.getChildren().add(Leave);
        
        this.setCenter(Center);
    }
}
