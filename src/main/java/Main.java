import api.ApiManager;
import api.Window;
import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.FacadeImpl;
import mapper.GenericMapper;
import service.ConnexionService;
import service.ConnexionServiceImpl;

import java.sql.SQLException;

/**
 * Created by vantorre on 04/11/17.
 */
public class Main {
    public static void main(String[] args) throws UninitialisedInjectionException, SQLException, ClassNotFoundException {
        //initialisation mapper
        GenericMapper genericMapper = new GenericMapper();//TODO externaliser le choix d'implementation

        //initialisation services et injection du mapper
        ConnexionService connexionService = new ConnexionServiceImpl();
        connexionService.setGenericMapper(genericMapper);

        //initialisation facade et injection services
        Facade facade = new FacadeImpl();
        facade.setConnexionService(connexionService);

        //initialisation API et injection facade
        Window window = new Window();
        ApiManager apiManager = new ApiManager();
        apiManager.setMainWindow(window);
        apiManager.setFacade(facade);

        //relais ApiManager
        apiManager.run();

    }
}
