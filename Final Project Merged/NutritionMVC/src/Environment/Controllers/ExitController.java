package Environment.Controllers;

import Environment.Views.ExitView;

public class ExitController {
    private ExitView View = new ExitView();

    public ExitController() {
        this.View = new ExitView();
    }

    /**
     * @return the View
     */
    public ExitView getView() {
        return View;
    }

    /**
     * @param View the View to set
     */
    public void setView(ExitView View) {
        this.View = View;
    }
}
