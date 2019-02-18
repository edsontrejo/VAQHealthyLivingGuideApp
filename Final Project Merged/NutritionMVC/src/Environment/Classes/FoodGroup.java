package Environment.Classes;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class FoodGroup {
    private int groupId;
    private String name;
    private String cssid;
    private Button button;
    private ArrayList<Food> foods;
    
    
    public FoodGroup(int groupId, String name, String cssid){
        this.groupId = groupId;
        this.name = name;
        this.cssid = cssid;
        this.button = new Button();
        this.foods = new ArrayList<>();
    }
    
    public FoodGroup(int groupId, String name, String cssid, Button button){
        this.groupId = groupId;
        this.name = name;
        this.cssid = cssid;
        this.button = button;
        this.foods = new ArrayList<>();
    }
    
    public FoodGroup(){
        this.groupId = 0;
        this.name = "undefined";
        this.cssid = "undefined";
        this.button = new Button();
        this.foods = new ArrayList<>();
    }

    /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cssid
     */
    public String getCssid() {
        return cssid;
    }

    /**
     * @param cssid the cssid to set
     */
    public void setCssid(String cssid) {
        this.cssid = cssid;
    }

    /**
     * @return the button
     */
    public Button getButton() {
        return button;
    }

    /**
     * @param button the button to set
     */
    public void setButton(Button button) {
        this.button = button;
    }

    /**
     * @return the foods
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * @param foods the foods to set
     */
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
