package ui.panel;

import configuration.Configuration;
import ui.UiManager;
import ui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YoursGamesPanel extends JPanel implements ActionListener {
    private UiManager uiManager;
    JTextArea outputLogin = new JTextArea();
    public static Configuration libelles = Configuration.getLibelleConf();



    public YoursGamesPanel(UiManager uiManager){
        this.uiManager = uiManager;
        joinPanelLayout();
    }

    private void joinPanelLayout() {
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
