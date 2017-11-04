package api;


import exception.UninitialisedInjectionException;
import facade.Facade;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class ApiManager {
    private Window mainWindow;
    private Facade facade;

    public void run() throws UninitialisedInjectionException {
        if(mainWindow==null || facade== null) throw new UninitialisedInjectionException();
        mainWindow.setVisible(true);
    }
}
