package facade;

import facade.response.LoginResponseData;
import facade.response.Response;
import facade.response.StatutResponse;
import lombok.Getter;
import lombok.Setter;
import service.ConnexionService;
import service.GameService;

import java.sql.SQLException;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class FacadeImpl implements Facade {
    ConnexionService connexionService;
    GameService gameService;


    public Response putConnexion(String login) {
        try {
            return new Response<LoginResponseData>(new LoginResponseData(connexionService.switchActualPlayer(login)), StatutResponse.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response<LoginResponseData>(null,StatutResponse.Failed,"exception sql : "+e.getMessage());
        }
    }

    public Response<LoginResponseData> getConnectedLogin() {
        try{
            return new Response<LoginResponseData>(new LoginResponseData(connexionService.getConnectedPlayer()), StatutResponse.OK);
        } catch (SQLException e) {
            return new Response<LoginResponseData>(null,StatutResponse.Failed,"exception sql : "+e.getMessage());
        }
    }

    public Response createGame(String nom, int dureeTour, int nbMaxPlayers, int tailleCarte, int distMinVille, int qtResTour, int qtInitRes) {
        try {
            gameService.createGame( nom,  dureeTour,  nbMaxPlayers,  tailleCarte,  distMinVille,  qtResTour,  qtInitRes);
            return new Response( StatutResponse.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response(null,StatutResponse.Failed,"exception sql : "+e.getMessage());
        }
    }
}
