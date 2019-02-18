package Environment.Tabs;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class MenuTab {
    private int Id;
    private String title;
    private String imageName;
    private Button button;
    private String cssId;
    private ArrayList<SubMenuTab> submenus;
    private boolean active = false;
    
    public MenuTab(int Id, String title, String imageName, Button button, String cssId){
        this.Id = Id;
        this.title = title;
        this.imageName = imageName;
        this.button = button;
        this.cssId = cssId;
        
        generateId();
    }
    
    public MenuTab(String title){
        this.title = title;
        this.cssId = generateId();
        this.button = new Button();
        this.button.setId(cssId);
    }
    
    public String generateId(){
        
        boolean titleWhitespace = this.title.matches("^\\s*$");
        
        if(this.cssId != null){
            boolean idWhiteSpace = this.cssId.matches("^\\s*$");

            if(!idWhiteSpace)
                return this.cssId;
        }
        else 
            this.cssId = (!titleWhitespace) ? this.title : this.cssId.replaceAll("\\s+","");
    
        return this.cssId;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    
    /**
    * @return the title
    */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName the imageName to set
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
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
     * @return the id
     */
    public String getCSSId() {
        return cssId;
    }

    /**
     * @param id the id to set
     */
    public void setCSSId(String id) {
        this.cssId = id;
    }

    /**
     * @return the submenus
     */
    public ArrayList<SubMenuTab> getSubmenus() {
        return submenus;
    }

    /**
     * @param submenus the submenus to set
     */
    public void setSubmenus(ArrayList<SubMenuTab> submenus) {
        this.submenus = submenus;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
