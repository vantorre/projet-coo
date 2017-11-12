package service;

import lombok.Setter;
import mapper.mapper.PlayerMapper;
import mapper.objetMetier.Player;

import java.sql.SQLException;

/**
 * Created by vantorre on 05/11/17.
 */
@Setter
public class ConnexionServiceImpl implements  ConnexionService{
    private PlayerMapper playerMapper;
    ActualPlayer actualPlayer = ActualPlayer.getInstance();

    public Player switchActualPlayer(String login) throws SQLException {
        if(!playerMapper.isRegistred(login)){
            System.out.println("unregistred player");
            playerMapper.inscribe(login);
        }
        System.out.println("connection with "+login);
        actualPlayer.setLogin(login);
        return playerMapper.findById(actualPlayer.getLogin());
    }

    public Player getConnectedPlayer() throws SQLException {
        return playerMapper.findById(actualPlayer.getLogin());
    }
}
