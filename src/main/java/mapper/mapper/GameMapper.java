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
        PreparedStatement preparedStatement = conn.prepareStatement("insert into game values (?);");//TODO ecrire la requette
        preparedStatement.setString(1,newGame.getName());
        preparedStatement.execute();
        //TODO ajouter un champ initResources a la base car tous les joueurs ne sont pas encore créés
        //TODO faire en sorte que l id soit automatiquement incrementé
    }
}
