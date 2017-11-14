package mapper.mapper;

import configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vantorre on 12/11/17.
 */
public class DatabaseConnexionHandler {
    private Configuration databaseConfiguration;
    private static final DatabaseConnexionHandler INSTANCE = new DatabaseConnexionHandler();
    private DatabaseConnexionHandler(){
        databaseConfiguration= Configuration.getDatabaseConf();
        try {
            initConnexion();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConnexionHandler getInstance(){
        return INSTANCE;
    }
    public static Connection getConnexion(){
        return conn;
    }
    private static Connection conn ;

    public void initConnexion() throws ClassNotFoundException, SQLException {
        Class.forName(databaseConfiguration.getProperty("db.driver"));
        String sDbUrl = databaseConfiguration.getProperty("db.url");
        conn = DriverManager.getConnection(sDbUrl);
        conn.setAutoCommit(false);
    }
}
