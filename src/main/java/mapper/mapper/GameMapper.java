package mapper.mapper;

import mapper.objetMetier.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vantorre on 14/11/17.
 */
public class GameMapper {
    private static final GameMapper INSTANCE = new GameMapper();
    public static GameMapper getInstance(){
        return INSTANCE;
    }
    private GameMapper() {
        conn = DatabaseConnexionHandler.getConnexion();
        identityMap=new IdentityMapGenerique();
    }
    Connection conn ;
    IdentityMapGenerique<Integer,Game> identityMap;

    public void creerGame(Game newGame) throws SQLException {
        //TODO commiter ce qu il y a dans l UOW avans d inserer + rendre le UOW transactionnel
        PreparedStatement preparedStatement =
                conn.prepareStatement("insert into game (name,state,owner,roundNumber,roundDuration,maxPlayers,ressourcesAllowedByRound,ressourcesAllowedInit) " +
                        "values (?,?,?,?,?,?,?,?);");
        preparedStatement.setString(1,newGame.getName());
        preparedStatement.setString(2,newGame.getState().toString());
        preparedStatement.setString(3,newGame.getOwner().getLogin());
        preparedStatement.setInt(4,0);
        preparedStatement.setDouble(5,newGame.getRoundDuration());
        preparedStatement.setInt(6,newGame.getMaxPlayers());
        preparedStatement.setInt(7,newGame.getRessourcesAllowedByRound());
        preparedStatement.setInt(8,newGame.getRessourcesInitiales());
        preparedStatement.execute();
        //TODO inesrer les maps etc
        //TODO ajouter un champ initResources a la base car tous les joueurs ne sont pas encore créés
        //TODO faire en sorte que l id soit automatiquement incrementé
        conn.commit();
    }
}
