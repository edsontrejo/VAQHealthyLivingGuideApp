/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author JacobS
 */
public class jEmailView extends BorderPane{
    private Button attachBtn = new Button("File to Send");
    private Button sendBtn = new Button("Send File");
    private Button updateBtn = new Button("Update Email Details");
    private GridPane gridPane = new GridPane();
    private Label hostL = new Label("Host");
    private Label portL = new Label("Port");
    private Label userNameL = new Label("UserName/Email");
    private Label passwordL = new Label("Password");
    private Label toAddressL = new Label("Recepient");
    private Label subjectL = new Label("Subject");
    private Label messageL = new Label("Message");
    private Label fileL = new Label();
    private TextField hostT = new TextField();
    private TextField portT = new TextField();
    private TextField userNameT = new TextField();
    private TextField passwordT = new TextField();
    private TextField toAddressT = new TextField();
    private TextField subjectT = new TextField();
    private TextField messageT = new TextField();

    public GridPane getGridPane() {
        return gridPane;
    }

    public TextField getHostT() {
        return hostT;
    }

    public TextField getPortT() {
        return portT;
    }

    public TextField getUserNameT() {
        return userNameT;
    }

    public TextField getPasswordT() {
        return passwordT;
    }

    public TextField getToAddressT() {
        return toAddressT;
    }

    public TextField getSubjectT() {
        return subjectT;
    }

    public TextField getMessageT() {
        return messageT;
    }
    public Label getFileL()
    {
        return fileL;
    }
    

    public void setAttachBtn(Button attachBtn) {
        this.attachBtn = attachBtn;
    }

    public void setSendBtn(Button sendBtn) {
        this.sendBtn = sendBtn;
    }
    
    public void setUpateBtn(Button updateBtn) {
        this.updateBtn = updateBtn;
    }

    public Button getAttachBtn() {
        return attachBtn;
    }

    public Button getSendBtn() {
        return sendBtn;
    }
    
    public Button getUpdateBtn() {
        return updateBtn;
    }
    
    public jEmailView()
    {
        gridPane.addColumn(0,hostL, portL, userNameL, passwordL, toAddressL, subjectL, messageL);
        gridPane.addColumn(1,hostT, portT, userNameT, passwordT, toAddressT, subjectT, messageT);
        gridPane.addRow(7,attachBtn, updateBtn, sendBtn);
        gridPane.add(fileL, 2, 8);
        this.setCenter(gridPane);
    }
    
    
    
}
