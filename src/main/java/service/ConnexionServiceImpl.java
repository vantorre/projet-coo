package service;

import lombok.Setter;
import mapper.GenericMapper;
import mapper.objetMetier.Player;

import java.sql.SQLException;

/**
 * Created by vantorre on 05/11/17.
 */
@Setter
public class ConnexionServiceImpl implements  ConnexionService{
    private GenericMapper genericMapper;
    ActualPlayer actualPlayer = ActualPlayer.getInstance();

    public Player switchActualPlayer(String login) throws SQLException {
        if(!genericMapper.isRegistred(login)){
            genericMapper.inscribe(login);
        }
        actualPlayer.setLogin(login);
        return genericMapper.getPlayer(actualPlayer.getLogin());
    }

    public Player getConnectedPlayer() throws SQLException {
        return genericMapper.getPlayer(actualPlayer.getLogin());
    }
}
