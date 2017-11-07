package service;

import mapper.GenericMapper;
import mapper.objetMetier.Player;

import java.sql.SQLException;

/**
 * Created by vantorre on 05/11/17.
 */
public interface ConnexionService {
    void setGenericMapper(GenericMapper genericMapper);

    Player switchActualPlayer(String login) throws SQLException;

    Player getConnectedPlayer() throws SQLException;
}
