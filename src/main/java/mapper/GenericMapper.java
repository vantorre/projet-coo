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
        String sDbUrl = "jdbc:sqlite:ageOfFarmer.db";
        conn = DriverManager.getConnection(sDbUrl);
    }

    public GenericMapper() throws SQLException, ClassNotFoundException {
        initConnexion();
    }

    public Player getPlayer(String login) throws SQLException {
            PreparedStatement preparedStatement = conn.prepareStatement("select login from players where login like ?");
            preparedStatement.setString(1,login);
            ResultSet rs = preparedStatement.executeQuery();//TODO externaliser les requettes
            if(!rs.next()){
                return null;
            }
            return Player.builder().login(rs.getString(1)).build();
    }

    public boolean isRegistred(String login) throws SQLException {
            System.out.println("verif registred player");
            PreparedStatement preparedStatement = conn.prepareStatement("select login from players where login like ?");
            preparedStatement.setString(1,login);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
    }

    public void inscribe(String login) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into players(login) values (?);");
        preparedStatement.setString(1,login);
        preparedStatement.execute();
    }
}
