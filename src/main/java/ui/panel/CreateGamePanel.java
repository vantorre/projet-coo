package ui.panel;

import configuration.Configuration;
import ui.UiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vantorre on 14/11/17.
 */
public class CreateGamePanel extends JPanel implements ActionListener {
    private UiManager uiManager;
    JTextArea outputLogin = new JTextArea();
    public static Configuration libelles = Configuration.getLibelleConf();



    public CreateGamePanel(UiManager uiManager){
        this.uiManager = uiManager;
        createGamePanelLayout();
    }

    private void createGamePanelLayout() {
        setLayout(new GridLayout(10,0));
        this.setBackground(Color.gray);

        outputLogin.setEditable(false);
        outputLogin.setBackground(Color.gray);
        outputLogin.setVisible(true);
        this.add(outputLogin);
    }

    public void actualise(){
        outputLogin.setText(libelles.getProperty("current.user.prepend")+uiManager.getConnectedPlayer().getLogin());
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }
}
