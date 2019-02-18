package Environment.Tabs;

import Environment.Controllers.AboutController;
import Environment.Controllers.AdminController;
import Environment.Controllers.AllNutrientsController;
import Environment.CalorieCalculator.CalorieController;
import Environment.Controllers.ExerciseController;
import Environment.Controllers.ExerciseController2;
import Environment.Controllers.ExerciseProfileController;
import Environment.Controllers.ExitController;
import Environment.Controllers.ExportController;
import Environment.Controllers.HomeController;
import Environment.Controllers.LoginController;
import Environment.Controllers.MedicalController1;
import Environment.Controllers.MuscleMenuController;
import Environment.Controllers.MyItemsController;
import Environment.Controllers.PersonalController;
import Environment.Controllers.RoutineController;
import Environment.Controllers.RoutineHomeController;
import Environment.Controllers.RoutineManagerController;
import Environment.Controllers.SearchController;
import Environment.MainApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TabManager extends HBox{
    public static BorderPane root;
    public static VBox mainMenuTemplate;
    public static VBox subMenuTemplate;
    
    public static String[] mainMenu;
    
    public static ExitController Exit = new ExitController();
    public static AllNutrientsController AllNutrients = new AllNutrientsController();
    public static CalorieController CalorieCalculator = new CalorieController();
    public static MyItemsController myItems = new MyItemsController();
    public static AboutController aboutTab = new AboutController();
    public static AdminController controlPanel = new AdminController();
    public static HomeController homeTab = new HomeController();
    public static LoginController loginTab = new LoginController();
    public static ExerciseController2 exerciseTab = new ExerciseController2();
    public static RoutineHomeController routineTab = new RoutineHomeController();
    public static RoutineController routineCreatorTab = new RoutineController();
    public static RoutineManagerController routineManagerTab = new RoutineManagerController();
    public static MedicalController1 medicalTab = new MedicalController1();
    public static PersonalController personalTab = new PersonalController();
    public static ExerciseProfileController exerciseProfileTab = new ExerciseProfileController();
    public static ExportController exportTab = new ExportController();
    public static SearchController searchTab = new SearchController();
    
    public static Object[][][] subMenus;
    
    public static LinkedHashMap<MenuTab, List<SubMenuTab>> TabsMap = new LinkedHashMap<>();
    
    public static MenuTab currentMenu;
    
    String CSSLink = "resources/css/OB11142017.css";

    public TabManager(BorderPane root) {
        mainMenuTemplate = new VBox();
        subMenuTemplate = new VBox();
        drawMenu();
        
        this.getChildren().add(mainMenuTemplate);
        this.getChildren().add(subMenuTemplate);
        
        this.root = root;
        
        this.root.setLeft(this);
        try {
            this.root.setCenter(loginTab.getView());
        } catch (IOException ex) {
            Logger.getLogger(TabManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void drawMenu(){
        mainMenuTemplate.setId("mainMenu");
        subMenuTemplate.setId("subMenu");
        
        int i = 0;
        
        if(MainApplication.profile.logged)
            TabManager.mainMenu = new String[]{"Home", "Profile", "Diet", "Exercise", "Routine", "About"};
        else
            TabManager.mainMenu = new String[]{"Home", "About"};
        
        subMenuTemplate.getChildren().clear();
        mainMenuTemplate.getChildren().clear();
        
        
        if(MainApplication.profile.logged)
        try {
            //Sub Tabs (Title, CSS Id, Controller View)
            TabManager.subMenus = new Object[][][]{
                /*Home*/
                {
                    {"Home Page" ,"homePage", homeTab.getView()},
                    {"Close Application" ,"exitPage", Exit.getView()},
                },
                /*Profile*/
                {
                    {"Personal Info" ,"profilePage", personalTab.getView()},
                    {"Medical Profile" ,"profilePage", medicalTab.getView()},
                    {"My Diet" ,"myItemsPage", myItems.getView()},
                    {"My Exercises" ,"profilePage", exerciseProfileTab.getView()},
                    {"Export Data" ,"profilePage", exportTab.getView()},
                },
                /*Diet*/
                {
                    {"All Foods" ,"allfoodsPage", AllNutrients.getView()},
                    {"Search" ,"searchPage", searchTab.getView()},
                    {"Calorie Calculator" ,"caloriecalPage", CalorieCalculator.getView()},
                },
                /*Exercise*/
                {
                    {"Exercises" ,"exercisePage", exerciseTab.getView()},
                },
                /*Routine*/
                {
                    {"Home" ,"routinePage", routineTab.getView()},
                    {"Creator" ,"routineCreator", routineCreatorTab.getView()},
                    {"Manager" ,"routineManager", routineManagerTab.getView()}
                },
                /*About*/
                {
                    {"About" ,"aboutPage", aboutTab.getView()}
                },
            };
        } catch (IOException ex) {
            Logger.getLogger(TabManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
            try{
            //Sub Tabs (Title, CSS Id, Controller View)
            TabManager.subMenus = new Object[][][]{
                /*Home*/
                {
                    {"Log In/Sign In" ,"homePage", loginTab.getView()},
                    {"Close Application" ,"exitPage", Exit.getView()},
                },
                /*About*/
                {
                    {"About" ,"aboutPage", aboutTab.getView()}
                },
            };
        } catch (IOException ex) {
            Logger.getLogger(TabManager.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        for (String s : mainMenu)
        {
            MenuTab mTab = new MenuTab(s);
            List<SubMenuTab> temp = new ArrayList<>();
            loadSubTabs loadSubMenu = new loadSubTabs();
            loadCenter loadCenterContent = new loadCenter();
            
            
            try{
                System.out.println(s + " has " + subMenus[i].length + " submenu(s).");
                
                for(Object[] o : subMenus[i]){
                    SubMenuTab sTab = new SubMenuTab(i, o[0].toString(), o[1].toString(), (Parent) o[2]);
                    sTab.getButton().setOnAction(loadCenterContent);
                    temp.add(sTab);
                }
               
            }catch(ArrayIndexOutOfBoundsException e){
                System.err.println(s + " doesn't contain any subTab(s)");
            }
            
            TabsMap.put(mTab, temp);
            drawMainButton(mTab);
            mTab.getButton().setOnAction(loadSubMenu);
            i++;
        }
        
        loadSubMenu(TabsMap.entrySet().iterator().next().getKey());
    }
    
    public static void drawMainButton(MenuTab _menuItem){
        _menuItem.getButton().setText(_menuItem.getTitle());
        _menuItem.getButton().setId(_menuItem.getCSSId());
        _menuItem.getButton().setContentDisplay(ContentDisplay.TOP);
        mainMenuTemplate.getChildren().add(_menuItem.getButton());
        
    }
    
    public static void drawSubButton(SubMenuTab _submenuItem){
        _submenuItem.getButton().setText(_submenuItem.getTitle());
        _submenuItem.getButton().setId(_submenuItem.getCSSId());
        subMenuTemplate.getChildren().add(_submenuItem.getButton());
    }
    
    public static void loadSubMenu(MenuTab Menu){
        subMenuTemplate.getChildren().clear();
                    
        for(SubMenuTab s : TabsMap.get(Menu))
            drawSubButton(s);
        
        TabManager.currentMenu = Menu;
    }
    
    public static void loadContent(SubMenuTab SubMenu){
        TabManager.root.setCenter(SubMenu.getContent());
    }
    
    public static class loadSubTabs implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            for(MenuTab m : TabsMap.keySet())
                if(event.getSource().equals(m.getButton()))
                    loadSubMenu(m);
        }
    }
    
    public static class loadCenter implements EventHandler<ActionEvent> {
       @Override
       public void handle(ActionEvent event) {
           myItems.attachEvents();
           for(SubMenuTab s : TabsMap.get(currentMenu))
               if(event.getSource().equals(s.getButton()))
                   loadContent(s);
       }
    }
    
    public static void setPage(Parent u){
        TabManager.root.setCenter(u);
    }
}
