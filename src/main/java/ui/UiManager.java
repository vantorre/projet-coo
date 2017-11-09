package ui;


import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.response.LoginResponseData;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class UiManager {
    private Window mainWindow;
    private Facade facade;

    private LoginPanel loginPanel;
    private MenuPanel menuPanel;

    public UiManager(){
        loginPanel=new LoginPanel(this);
        menuPanel=new MenuPanel(this);
    }


    public void run() throws UninitialisedInjectionException {
        if(mainWindow==null || facade== null) throw new UninitialisedInjectionException();
        mainWindow.setFacade(facade);
        mainWindow.setUiManager(this);
        mainWindow.setVisible(true);
        this.showLoginPage();
    }

    public void showLoginPage(){
        mainWindow.setContentPane(loginPanel);
        loginPanel.setVisible(true);
    }

    public void connectWith(String login) {
        facade.putConnexion(login);
        mainWindow.setContentPane(menuPanel);
        menuPanel.actualise();
        menuPanel.setVisible(true);
    }

    public LoginResponseData getConnectedPlayer() {
        return facade.getConnectedLogin().getDataResponse();
    }
}
