package facade;

import facade.response.LoginResponseData;
import facade.response.Response;
import service.ConnexionService;
import service.GameService;

/**
 * Created by vantorre on 04/11/17.
 */
public interface Facade {
    void setConnexionService(ConnexionService connexionService);
    void setGameService(GameService gameService);

    Response putConnexion(String login);

    Response<LoginResponseData> getConnectedLogin();

    Response createGame(String nom, int dureeTour, int nbMaxPlayers, int tailleCarte, int distMinVille, int qtResTour, int qtInitRes);
}
