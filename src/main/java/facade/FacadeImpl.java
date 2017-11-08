package facade;

import facade.response.LoginResponseData;
import facade.response.Response;
import facade.response.StatutResponse;
import lombok.Getter;
import lombok.Setter;
import service.ConnexionService;

import java.sql.SQLException;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class FacadeImpl implements Facade {
    ConnexionService connexionService;


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
}
