import api.ApiManager;
import api.Window;
import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.FacadeImpl;

/**
 * Created by vantorre on 04/11/17.
 */
public class Main {
    public static void main(String[] args) throws UninitialisedInjectionException {
        //initialisation mapper
        //initialisation services et injection du mapper
        //initialisation facade et injection services
        Facade facade = new FacadeImpl();

        //initialisation API et injection facade
        Window window = new Window();
        ApiManager apiManager = new ApiManager();
        apiManager.setMainWindow(window);
        apiManager.setFacade(facade);

        //relais ApiManager
        apiManager.run();

    }
}
