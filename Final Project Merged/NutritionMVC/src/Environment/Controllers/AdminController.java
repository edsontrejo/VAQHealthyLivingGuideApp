package Environment.Controllers;

import Environment.Views.AdminView;

public class AdminController {
    private AdminView View = new AdminView();

    public AdminController() {
        this.View = new AdminView();
    }

    /**
     * @return the View
     */
    public AdminView getView() {
        return View;
    }

    /**
     * @param View the View to set
     */
    public void setView(AdminView View) {
        this.View = View;
    }
}
