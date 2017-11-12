import ui.UiManager;
import ui.Window;
import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.FacadeImpl;
import mapper.mapper.PlayerMapper;
import service.ConnexionService;
import service.ConnexionServiceImpl;

import java.sql.SQLException;

/**
 * Created by vantorre on 04/11/17.
 */
public class Main {
    public static void main(String[] args) throws UninitialisedInjectionException, SQLException, ClassNotFoundException {
        //initialisation mapper
        PlayerMapper playerMapper = new PlayerMapper();//TODO externaliser le choix d'implementation

        //initialisation services et injection du mapper
        ConnexionService connexionService = new ConnexionServiceImpl();
        connexionService.setPlayerMapper(playerMapper);

        //initialisation facade et injection services
        Facade facade = new FacadeImpl();
        facade.setConnexionService(connexionService);

        //initialisation API et injection facade
        Window window = new Window();
        UiManager uiManager = new UiManager(facade);
        uiManager.setMainWindow(window);

        //relais ApiManager
        uiManager.run();

    }
}
