import mapper.mapper.GameMapper;
import service.GameService;
import service.GameServiceImpl;
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
        PlayerMapper playerMapper = PlayerMapper.getInstance();//TODO externaliser le choix d'implementation
        GameMapper gameMapper = GameMapper.getInstance();

        //initialisation services et injection du mapper
        ConnexionService connexionService = new ConnexionServiceImpl();
        connexionService.setPlayerMapper(playerMapper);
        GameService gameService = new GameServiceImpl();
        gameService.setGameMapper(gameMapper);

        //initialisation facade et injection services
        Facade facade = new FacadeImpl();
        facade.setConnexionService(connexionService);
        facade.setGameService(gameService);

        //initialisation API et injection facade
        Window window = new Window();
        UiManager uiManager = new UiManager(facade);
        uiManager.setMainWindow(window);

        //relais ApiManager
        uiManager.run();

    }
}
