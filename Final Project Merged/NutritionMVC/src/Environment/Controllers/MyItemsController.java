package Environment.Controllers;

import Environment.MainApplication;
import Environment.Models.MyItemsModel;
import Environment.Views.MyItemsView;

public class MyItemsController {
    private MyItemsView View = new MyItemsView();
    private MyItemsModel Model = new MyItemsModel();

    public MyItemsController() {
        this.View = new MyItemsView();
        this.Model = new MyItemsModel();
        attachEvents();
    }
    
    public void attachEvents()
    {
        handleretrieveFoodGroups();
    }
    
    public void handleretrieveFoodGroups()
    {
        View.setMyList(Model.retrieveFoodList(MainApplication.profile.id));
        View.drawList(View.getMyList());
    }

    /**
     * @return the View
     */
    public MyItemsView getView() {
        return View;
    }

    /**
     * @param View the View to set
     */
    public void setView(MyItemsView View) {
        this.View = View;
    }

    /**
     * @return the Model
     */
    public MyItemsModel getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(MyItemsModel Model) {
        this.Model = Model;
    }
}
