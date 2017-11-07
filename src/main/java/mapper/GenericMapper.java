package mapper;

import mapper.objetMetier.Player;
import sun.rmi.runtime.Log;

import java.sql.*;
import java.lang.Class;

/**
 * Created by vantorre on 04/11/17.
 */
public class GenericMapper {

    Connection conn ;

    public void initConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");//TODO conf a externaliser
        String sDbUrl = "jdbc:sqlite:/age-of-farmer.db";
        conn = DriverManager.getConnection(sDbUrl);
    }

    public GenericMapper() throws SQLException, ClassNotFoundException {
        initConnexion();
    }

    public Player getPlayer(String login) throws SQLException {
            CallableStatement preparedStatement = conn.prepareCall("select login from player where login like :LOGIN");
            preparedStatement.setString(login,"LOGIN");
            ResultSet rs = preparedStatement.executeQuery();//TODO externaliser les requettes
            if(!rs.next()){
                return null;
            }
            return Player.builder().login(rs.getString(0)).build();
    }

    public boolean isRegistred(String login) throws SQLException {
            CallableStatement preparedStatement = conn.prepareCall("select login from player where login like :LOGIN");
            preparedStatement.setString(login,"LOGIN");
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
    }

    public void inscribe(String login) throws SQLException {
        CallableStatement preparedStatement = conn.prepareCall("insert into player(login) values (:LOGIN)");
        preparedStatement.setString(login,"LOGIN");
        preparedStatement.execute();
    }
}
