package ui;


import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.response.LoginResponseData;
import facade.response.Response;
import facade.response.StatutResponse;
import lombok.Getter;
import lombok.Setter;
import ui.panel.*;

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
    private JoinGamePanel joinGamePanel;
    private YoursGamesPanel yoursGamesPanel;
    private CreateGamePanel createGamePanel;

    public UiManager(Facade facade){
        this.mainWindow = new Window();
        this.loginPanel=new LoginPanel(this);
        this.menuPanel=new MenuPanel(this);
        this.joinGamePanel= new JoinGamePanel(this);
        this.yoursGamesPanel= new YoursGamesPanel(this);
        this.createGamePanel=new CreateGamePanel(this);
        this.facade = facade;
    }

    public void run(){
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
        Response response = facade.putConnexion(login);
        if(response.getStatutResponse().equals(StatutResponse.OK)) {
            mainWindow.setContentPane(menuPanel);
            menuPanel.actualise();
            menuPanel.setVisible(true);
        }else{
            mainWindow.printFailedResponseMessage(response);
        }
    }

    public void showCreationGamePage() {
        System.out.println("changement page creation");
        mainWindow.setContentPane(createGamePanel);
        createGamePanel.actualise();
        createGamePanel.setVisible(true);
    }


    public void showJoinGamePage() {
        System.out.println("changement page join");
        mainWindow.setContentPane(joinGamePanel);
        joinGamePanel.actualise();
        joinGamePanel.setVisible(true);

    }

    public void showYoursGamesPage() {
        System.out.println("changement page games");
        mainWindow.setContentPane(yoursGamesPanel);
        yoursGamesPanel.actualise();
        yoursGamesPanel.setVisible(true);

    }

    public LoginResponseData getConnectedPlayer() {
        return facade.getConnectedLogin().getDataResponse();
    }
}
