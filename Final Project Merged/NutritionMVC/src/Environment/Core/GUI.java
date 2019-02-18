package Environment.Core;

import javafx.scene.layout.BorderPane;

import Environment.Tabs.TabManager;
import javafx.scene.Parent;

public class GUI extends BorderPane{
    TabManager _tabs;
    
    public GUI(){
        _tabs = new TabManager(this);
    }

    public Parent getrootNode(){ 
       return this;
    }

    /**
     * @return the root
     */
    public BorderPane getRoot(){
        return this;
    }

    /**
     *
     * @return
     */
    public TabManager getTabs(){
        return _tabs;
    }

    /**
     *
     * @param Tabs
     */
    public void setTabs(TabManager Tabs){
        this._tabs = Tabs;
    }
}
