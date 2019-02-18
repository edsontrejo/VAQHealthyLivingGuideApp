package Environment.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AboutView extends VBox{
    private Label header = new Label("Sources With Additional Information");
    HBox HeaderBox = new HBox();
    GridPane list = new GridPane();
    private Label i1Label = new Label("For dietary information and tips");
    private Label i2Label = new Label("For programs and events promoting healthy living");
    private Label i3Label = new Label("For nutrition education");
    private Label i4Label = new Label("For easy access to resources on nutrition");
    private Label i5Label = new Label("For adivce and suggestions for healthy living from others in the community");
    private Label i6Label = new Label("For information on a government program that targets women and children health");
    private Label i7Label = new Label("For programs sponsored by UT that promote healthy living");
    private Label i8Label = new Label("For general health information");
    private Label i9Label = new Label("For dietary guideline");
    private Hyperlink hyperlink1 = new Hyperlink("");
    private Hyperlink hyperlink2 = new Hyperlink("");
    private Hyperlink hyperlink3 = new Hyperlink("");
    private Hyperlink hyperlink4 = new Hyperlink("");
    private Hyperlink hyperlink5 = new Hyperlink("");
    private Hyperlink hyperlink6 = new Hyperlink("");
    private Hyperlink hyperlink7 = new Hyperlink("");
    private Hyperlink hyperlink8 = new Hyperlink("");
    private Hyperlink hyperlink9 = new Hyperlink("");
    
    public AboutView(){
        Image image = new Image("/resources/images/iconCOM.png");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(35);
        iv.setFitWidth(35);
        ImageView iv2 = new ImageView(image);
        iv2.setFitHeight(35);
        iv2.setFitWidth(35);
        ImageView iv3 = new ImageView(image);
        iv3.setFitHeight(35);
        iv3.setFitWidth(35);
        ImageView iv4 = new ImageView(image);
        iv4.setFitHeight(35);
        iv4.setFitWidth(35);
        ImageView iv5 = new ImageView(image);
        iv5.setFitHeight(35);
        iv5.setFitWidth(35);
        ImageView iv6 = new ImageView(image);
        iv6.setFitHeight(35);
        iv6.setFitWidth(35);
        ImageView iv7 = new ImageView(image);
        iv7.setFitHeight(35);
        iv7.setFitWidth(35);
        ImageView iv8 = new ImageView(image);
        iv8.setFitHeight(35);
        iv8.setFitWidth(35);
        ImageView iv9 = new ImageView(image);
        iv9.setFitHeight(35);
        iv9.setFitWidth(35);
        
        //Font
        Font myFont = Font.font("Verdana", FontWeight.BOLD,  30);
        header.setFont(myFont);
        header.setTextFill(Color.WHITE);
        HeaderBox.setAlignment(Pos.CENTER);
        HeaderBox.getChildren().add(header);
        HeaderBox.setStyle("-fx-background-color: #cc7000;");
        Font myF = Font.font("Verdana", FontWeight.BOLD, 12);
        i1Label.setFont(myF);
        i1Label.setTextFill(Color.MIDNIGHTBLUE);
        i2Label.setFont(myF);
        i2Label.setTextFill(Color.MIDNIGHTBLUE);
        i3Label.setFont(myF);
        i3Label.setTextFill(Color.MIDNIGHTBLUE);
        i4Label.setFont(myF);
        i4Label.setTextFill(Color.MIDNIGHTBLUE);
        i5Label.setFont(myF);
        i5Label.setTextFill(Color.MIDNIGHTBLUE);
        i6Label.setFont(myF);
        i6Label.setTextFill(Color.MIDNIGHTBLUE);
        i7Label.setFont(myF);
        i7Label.setTextFill(Color.MIDNIGHTBLUE);
        i8Label.setFont(myF);
        i8Label.setTextFill(Color.MIDNIGHTBLUE);
        i9Label.setFont(myF);
        i9Label.setTextFill(Color.MIDNIGHTBLUE);
        
        //Grid
        list.add(iv,0,0);
        list.add(i1Label, 1, 0);
        list.add(hyperlink1, 1, 1);
        list.add(iv2,0,2);
        list.add(i2Label, 1, 2);
        list.add(hyperlink2, 1, 3);
        list.add(iv3,0,4);
        list.add(i3Label, 1, 4);
        list.add(hyperlink3, 1, 5);
        list.add(iv4,0,6);
        list.add(i4Label, 1, 6);
        list.add(hyperlink4, 1, 7);
        list.add(iv5,0,8);
        list.add(i5Label, 1, 8);
        list.add(hyperlink5, 1, 9);
        list.add(iv6,0,10);
        list.add(i6Label, 1, 10);
        list.add(hyperlink6, 1, 11);
        list.add(iv7,0,12);
        list.add(i7Label, 1, 12);
        list.add(hyperlink7, 1, 13);
        list.add(iv8,0,14);
        list.add(i8Label, 1, 14);
        list.add(hyperlink8, 1, 15);
        list.add(iv9,0,16);
        list.add(i9Label, 1, 16);
        list.add(hyperlink9, 1, 17);
        
        this.getChildren().addAll(HeaderBox,list);
        list.setPadding(new Insets(20, 10, 10, 40));
        list.setMargin(hyperlink1, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink2, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink3, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink4, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink5, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink6, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink7, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink8, new Insets(0, 0, 10, 0));
        list.setMargin(hyperlink9, new Insets(0, 0, 10, 0));
    }
    
    /**
     * @return the hyperlink1
     */
    public Hyperlink getHyperlink1() {
        return hyperlink1;
    }

    /**
     * @param hyperlink1 the hyperlink1 to set
     */
    public void setHyperlink1(Hyperlink hyperlink1) {
        this.hyperlink1 = hyperlink1;
    }
    
    /**
     * @return the hyperlink2
     */
    public Hyperlink getHyperlink2() {
        return hyperlink2;
    }

    /**
     * @param hyperlink2 the hyperlink2 to set
     */
    public void setHyperlink2(Hyperlink hyperlink2) {
        this.hyperlink2 = hyperlink2;
    }

    /**
     * @return the hyperlink3
     */
    public Hyperlink getHyperlink3() {
        return hyperlink3;
    }

    /**
     * @param hyperlink3 the hyperlink3 to set
     */
    public void setHyperlink3(Hyperlink hyperlink3) {
        this.hyperlink3 = hyperlink3;
    }

    /**
     * @return the hyperlink4
     */
    public Hyperlink getHyperlink4() {
        return hyperlink4;
    }

    /**
     * @param hyperlink4 the hyperlink4 to set
     */
    public void setHyperlink4(Hyperlink hyperlink4) {
        this.hyperlink4 = hyperlink4;
    }

    /**
     * @return the hyperlink5
     */
    public Hyperlink getHyperlink5() {
        return hyperlink5;
    }

    /**
     * @param hyperlink5 the hyperlink5 to set
     */
    public void setHyperlink5(Hyperlink hyperlink5) {
        this.hyperlink5 = hyperlink5;
    }

    /**
     * @return the hyperlink6
     */
    public Hyperlink getHyperlink6() {
        return hyperlink6;
    }

    /**
     * @param hyperlink6 the hyperlink6 to set
     */
    public void setHyperlink6(Hyperlink hyperlink6) {
        this.hyperlink6 = hyperlink6;
    }

    /**
     * @return the hyperlink7
     */
    public Hyperlink getHyperlink7() {
        return hyperlink7;
    }

    /**
     * @param hyperlink7 the hyperlink7 to set
     */
    public void setHyperlink7(Hyperlink hyperlink7) {
        this.hyperlink7 = hyperlink7;
    }

    /**
     * @return the hyperlink8
     */
    public Hyperlink getHyperlink8() {
        return hyperlink8;
    }

    /**
     * @param hyperlink8 the hyperlink8 to set
     */
    public void setHyperlink8(Hyperlink hyperlink8) {
        this.hyperlink8 = hyperlink8;
    }

    /**
     * @return the hyperlink9
     */
    public Hyperlink getHyperlink9() {
        return hyperlink9;
    }

    /**
     * @param hyperlink9 the hyperlink9 to set
     */
    public void setHyperlink9(Hyperlink hyperlink9) {
        this.hyperlink9 = hyperlink9;
    }
}
