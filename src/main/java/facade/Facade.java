package facade;

import facade.response.Response;
import service.ConnexionService;

/**
 * Created by vantorre on 04/11/17.
 */
public interface Facade {
    void setConnexionService(ConnexionService connexionService);

    Response putConnexion(String login);

    Response getConnectedLogin();

}
