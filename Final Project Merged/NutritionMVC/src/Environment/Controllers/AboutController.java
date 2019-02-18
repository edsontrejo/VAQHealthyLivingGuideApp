package Environment.Controllers;

import Environment.Classes.SourceInfo;
import Environment.Models.AboutModel;
import Environment.Views.AboutView;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class AboutController {
   ArrayList<SourceInfo> myList = new ArrayList(); 
    private AboutModel infoModel; 
    private AboutView infoView;

    public AboutController(AboutModel infoModel, AboutView infoView) 
    {
        this.infoModel = infoModel;
        this.infoView = infoView;
        setupHandlers();
    }
    
    public AboutController() 
    {
        this.infoModel = new AboutModel();
        this.infoView  = new AboutView();
        setupHandlers();
    }
    
    public void setupHandlers()
    {
        myList = infoModel.getSources();
        //Hyperlinks
        infoView.getHyperlink1().setText(myList.get(0).getWebsiteURL());
        infoView.getHyperlink2().setText(myList.get(1).getWebsiteURL());
        infoView.getHyperlink3().setText(myList.get(2).getWebsiteURL());
        infoView.getHyperlink4().setText(myList.get(3).getWebsiteURL());
        infoView.getHyperlink5().setText(myList.get(4).getWebsiteURL());
        infoView.getHyperlink6().setText(myList.get(5).getWebsiteURL());
        infoView.getHyperlink7().setText(myList.get(6).getWebsiteURL());
        infoView.getHyperlink8().setText(myList.get(7).getWebsiteURL());
        infoView.getHyperlink9().setText(myList.get(8).getWebsiteURL());
        //buttons
        infoView.getHyperlink1().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(0).getWebsiteURL());
        });
        infoView.getHyperlink2().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(1).getWebsiteURL());
        });
        infoView.getHyperlink3().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(2).getWebsiteURL());
        });
        infoView.getHyperlink4().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(3).getWebsiteURL());
        });
        infoView.getHyperlink5().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(4).getWebsiteURL());
        });
        infoView.getHyperlink6().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(5).getWebsiteURL());
        });
        infoView.getHyperlink7().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(6).getWebsiteURL());
        });
        infoView.getHyperlink8().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(7).getWebsiteURL());
        });
        infoView.getHyperlink9().setOnAction((ActionEvent event) -> {
            OPENwebsite(myList.get(8).getWebsiteURL());
        });
    }
    
    public void OPENwebsite(String u){
        try {
                Desktop.getDesktop().browse(new URI(u));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
    }
    
    /**
     * @return the infoModel
     */
    public AboutModel getModel() {
        return infoModel;
    }

    /**
     * @param infoModel the infoModel to set
     */
    public void setModel(AboutModel infoModel) {
        this.infoModel = infoModel;
    }

    /**
     * @return the infoView
     */
    public AboutView getView() {
        return infoView;
    }

    /**
     * @param infoView the infoView to set
     */
    public void setView(AboutView infoView) {
        this.infoView = infoView;
    }
}
