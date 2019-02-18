package Environment.Database;

import java.sql.*;

import Environment.Core.ConfigurationManager;
import Environment.MainApplication;

public class Database
{   
    private Connection myConnection = null;
    private Statement myStatement = null;
    ResultSet myRs = null;
    
    public Database(ConfigurationManager config)
    {        
        long millis = System.currentTimeMillis();

        boolean SQLException = false;

        try
        {
            myConnection = DriverManager.getConnection("jdbc:mysql://" + config.getValue("db.hostname", "localhost") + ":" + config.getValue("db.port", "3306") + "/" + config.getValue("db.database", "vaqnutri"), config.getValue("db.username"), config.getValue("db.password"));
            
            myStatement = myConnection.createStatement();
        }
        catch (SQLException e)
        {
            SQLException = true;
            System.err.println("Failed to connect to your database.");
            System.out.println(e.getMessage());
        }
        finally
        {
            if (SQLException)
                MainApplication.prepareShutdown();
        }

        System.out.println("Database -> Connected! (" + (System.currentTimeMillis() - millis) + " MS)");
    }
    
    /**
     * @return the myConnection
     */
    public Connection getMyConnection() {
        return myConnection;
    }

    /**
     * @param myConnection the myConnection to set
     */
    public void setMyConnection(Connection myConnection) {
        this.myConnection = myConnection;
    }

    /**
     * @return the myStatement
     */
    public Statement getMyStatement() {
        return myStatement;
    }

    /**
     * @param myStatement the myStatement to set
     */
    public void setMyStatement(Statement myStatement) {
        this.myStatement = myStatement;
    }
}