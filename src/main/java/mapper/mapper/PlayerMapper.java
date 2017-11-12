package mapper.mapper;

import mapper.objetMetier.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vantorre on 04/11/17.
 */
public class PlayerMapper {
    private static final PlayerMapper INSTANCE = new PlayerMapper();
    public static PlayerMapper getInstance(){
        return INSTANCE;
    }
    private PlayerMapper() {
        conn = DatabaseConnexionHandler.getConnexion();
        identityMap=new IdentityMapGenerique();
    }

    Connection conn ;
    IdentityMapGenerique<String,Player> identityMap;



    public Player findById(String login) throws SQLException {
        Player stored = identityMap.get(login);
        if(stored!=null) {
            return stored;
        }else{
                PreparedStatement preparedStatement = conn.prepareStatement("select login from players where login like ?");
                preparedStatement.setString(1, login);
                ResultSet rs = preparedStatement.executeQuery();//TODO externaliser les requettes
                if (!rs.next()) {
                    return null;
                }
            Player player = Player.builder().login(rs.getString(1)).build();
            identityMap.put(login,player);
            return player;
            }
    }

    public boolean isRegistred(String login) throws SQLException {
        if(identityMap.get(login)!=null) {
        }
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
