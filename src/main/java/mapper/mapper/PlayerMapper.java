package mapper.mapper;

import mapper.objetMetier.Player;

import java.sql.*;

/**
 * Created by vantorre on 04/11/17.
 */
public class PlayerMapper {

    Connection conn ;

    public PlayerMapper() throws SQLException, ClassNotFoundException {
        conn = DatabaseConnexionHandler.getConnexion();
    }

    public Player findById(String login) throws SQLException {
            PreparedStatement preparedStatement = conn.prepareStatement("select login from players where login like ?");
            preparedStatement.setString(1,login);
            ResultSet rs = preparedStatement.executeQuery();//TODO externaliser les requettes
            if(!rs.next()){
                return Player.builder().build();
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
