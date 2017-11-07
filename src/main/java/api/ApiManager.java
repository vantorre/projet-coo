package api;


import exception.UninitialisedInjectionException;
import facade.Facade;
import facade.response.Response;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class ApiManager {
    private Window mainWindow;
    private Facade facade;

    private LoginPanel loginPanel;

    public ApiManager(){
        loginPanel=new LoginPanel();
    }


    public void run() throws UninitialisedInjectionException {
        if(mainWindow==null || facade== null) throw new UninitialisedInjectionException();
        mainWindow.setFacade(facade);
        mainWindow.setApiManager(this);
        mainWindow.setVisible(true);
        this.showLoginPage();
    }

    public void showLoginPage(){
        mainWindow.setContentPane(loginPanel);
        loginPanel.setVisible(true);
    }

}
