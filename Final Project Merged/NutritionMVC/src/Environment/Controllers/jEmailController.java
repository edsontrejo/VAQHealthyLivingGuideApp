/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Models.jEmailModel;
import Environment.Views.jEmailView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author JacobS
 */
public class jEmailController {
    
    private jEmailView view = new jEmailView();
    private jEmailModel model = new jEmailModel();

    
    public jEmailController(jEmailView view, jEmailModel model)
    {
        this.view = view;
        this.model = model;
        handlerSetUp();
        view.getHostT().setText(model.getHost());
        view.getPortT().setText(model.getPort());
        view.getUserNameT().setText(model.getUserName());
        view.getPasswordT().setText(model.getPassword());
        view.getToAddressT().setText(model.getToAddress());
        view.getSubjectT().setText(model.getSubject());
        view.getMessageT().setText(model.getMessage());
    }
    

    public void handlerSetUp()
    {
        view.getAttachBtn().setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select Attachment File");
                model.setFile(fileChooser.showOpenDialog(stage).getPath());
                view.getFileL().setText(model.getFile());
            }
        });
        view.getSendBtn().setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                try{
                    model.sendEmail();
                } catch(Exception ex)
                {
                    	System.out.println("Could not send email.");
			ex.printStackTrace();
                }
            }
        });
        view.getUpdateBtn().setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                model.setHost(view.getHostT().getText());
                model.setPort(view.getPortT().getText());
                model.setUserName(view.getUserNameT().getText());
                model.setPassword(view.getPasswordT().getText());
                model.setToAddress(view.getToAddressT().getText());
                model.setSubject(view.getSubjectT().getText());
                model.setMessage(view.getMessageT().getText());
            }
        });
    }
    
}
