package Environment;

import Environment.Classes.Profile;
import javafx.application.Application;
import javafx.stage.Stage;

import Environment.Core.ConfigurationManager;
import Environment.Core.GUI;
import Environment.Core.Tools;
import Environment.Database.Database;
import javafx.scene.Scene;

public class MainApplication extends Application {

    Scene Mainscene;
    
    /**
     * Major version of the application.
     */
    public final static int MAJOR = 1;

    /**
     * Minor version of the application.
     */
    public final static int MINOR = 2;

    /**
     * Stable build version of the application.
     */
    public final static int BUILD = 3;

    /**
     * Version as string.
     */
    public static final String version = MAJOR + "." + MINOR + "." + BUILD;
    
    private String CSSLink = "resources/css/OB" + version + ".css";
    
    private static ConfigurationManager     config;
    private static Database                 database;
    private static GUI                      gui;
    private static Tools                    tools;
    public static Profile                  profile;
    
    @Override
    public void start(Stage primaryStage) {
        Mainscene = new Scene(gui.getrootNode()); 
        primaryStage.setScene(Mainscene);
        Mainscene.getStylesheets().add(CSSLink);
        primaryStage.setMaximized(true);      
        primaryStage.setTitle("Vaqnutri " + version);
        // Set Windows properties
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {            
            config = new ConfigurationManager("config.ini");
            database = new Database(getConfig());
            tools = new Tools();
            profile = new Profile();
            gui = new GUI();
            System.out.println("Main Application -> START");
            launch(args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
    * @return The ConfigurationManager
    */
    public static ConfigurationManager getConfig()
    {
        return config;
    }
    
    /**
    * @return The Database
    */
    public static Database getDatabase()
    {
        return database;
    }
    
    public static void prepareShutdown()
    {
        System.exit(0);
    }    

    /**
     * @return the tools
     */
    public static Tools getTools() {
        return tools;
    }

    /**
     * @param aTools the tools to set
     */
    public static void setTools(Tools aTools) {
        tools = aTools;
    }
}
