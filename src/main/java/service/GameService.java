package service;

import mapper.mapper.GameMapper;
import mapper.objetMetier.Game;

import java.sql.SQLException;

/**
 * Created by vantorre on 14/11/17.
 */
public interface GameService {
    void setGameMapper(GameMapper gameMapper);
    void createGame(String nom, int dureeTour, int nbMaxPlayers, int tailleCarte, int distMinVille, int qtResTour, int qtInitRes) throws SQLException;
}
