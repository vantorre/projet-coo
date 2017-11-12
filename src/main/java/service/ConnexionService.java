package service;

import mapper.mapper.PlayerMapper;
import mapper.objetMetier.Player;

import java.sql.SQLException;

/**
 * Created by vantorre on 05/11/17.
 */
public interface ConnexionService {
    void setPlayerMapper(PlayerMapper playerMapper);

    Player switchActualPlayer(String login) throws SQLException;

    Player getConnectedPlayer() throws SQLException;
}
