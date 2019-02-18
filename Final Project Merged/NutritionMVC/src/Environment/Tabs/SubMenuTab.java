package Environment.Tabs;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class SubMenuTab {
    private int parentId;
    private String title;
    private Button button;
    private String cssId;
    private Node content;
    
    /**
     *
     * @param parentId
     * @param title
     * @param imageName
     * @param button
     * @param cssId
     * @param content
     */
    public SubMenuTab(int parentId, String title, String imageName, Button button, String cssId, Node content){
        this.parentId = parentId;
        this.title = title;
        this.button = button;
        this.cssId = cssId;
        this.cssId = generateId();
        this.content = content;
    }
    
    public SubMenuTab(int parentId, String title, Node content){
        this.parentId = parentId;
        this.title = title;
        this.cssId = generateId();
        this.button = new Button();
        this.content = content;
    }
    
    public SubMenuTab(int parentId, String title, String id, Node content){
        this.parentId = parentId;
        this.title = title;
        this.cssId = id;
        this.cssId = generateId();
        this.button = new Button();
        this.content = content;
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
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
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
     * @return the content
     */
    public Node getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Node content) {
        this.content = content;
    }
}

