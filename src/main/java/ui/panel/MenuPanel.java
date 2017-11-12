package ui.panel;

import configuration.Configuration;
import ui.UiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vantorre on 08/11/17.
 */
public class MenuPanel extends JPanel implements ActionListener {

    private UiManager uiManager;
    private static JButton creationGame;
    private static JButton joinGame;
    private static JButton yoursGames;
    JTextArea outputLogin = new JTextArea();
    public static Configuration libelles = Configuration.getLibelleConf();

    public MenuPanel(UiManager uiManager){
        menuLayout();
        this.uiManager = uiManager;
    }

    private void menuLayout() {
        setLayout(new GridLayout(10,0));
        this.setBackground(Color.gray);

        outputLogin.setEditable(false);
        outputLogin.setBackground(Color.darkGray);
        outputLogin.setVisible(true);
        this.add(outputLogin);

        creationGame = new JButton(libelles.getProperty("menu.panel.create.game"));
        creationGame.setBackground(Color.RED);
        creationGame.addActionListener(this);
        this.add(creationGame);

        joinGame = new JButton(libelles.getProperty("menu.panel.join.game"));
        joinGame.setBackground(Color.ORANGE);
        joinGame.addActionListener(this);
        this.add(joinGame);

        yoursGames = new JButton(libelles.getProperty("menu.panel.yours.games"));
        yoursGames.setBackground(Color.YELLOW);
        yoursGames.addActionListener(this);
        this.add(yoursGames);


    }

    public void actualise(){
        outputLogin.setText(libelles.getProperty("current.user.prepend")+uiManager.getConnectedPlayer().getLogin());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==creationGame) {
            System.out.println("click sur le bouton de creation");
            uiManager.showCreationGamePage();
        }else if(e.getSource()==joinGame) {
            System.out.println("click sur le bouton joinGame");
            uiManager.showJoinGamePage();
        }else if(e.getSource()==yoursGames) {
            System.out.println("click sur le bouton yoursGames");
            uiManager.showYoursGamesPage();
        }

    }
}
