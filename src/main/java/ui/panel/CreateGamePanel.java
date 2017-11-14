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
    JTextArea inputNom = new JTextArea();
    JTextArea outputNom = new JTextArea(libelles.getProperty("create.game.nom"));
    JTextArea inputDureeTour = new JTextArea();
    JTextArea outputDureeTour = new JTextArea(libelles.getProperty("create.game.duree.tour"));
    JTextArea inputNbMaxPlayers = new JTextArea();
    JTextArea outputNbMaxPlayers = new JTextArea(libelles.getProperty("create.game.nb.max.players"));
    JTextArea inputTailleCarte = new JTextArea();
    JTextArea outputTailleCarte = new JTextArea(libelles.getProperty("current.user.taille.carte"));
    JTextArea inputDistanceMinVilles = new JTextArea();
    JTextArea outputDistanceMinVilles = new JTextArea(libelles.getProperty("current.user.distance.min.villes"));
    JTextArea inputQteRessourcesTour = new JTextArea();
    JTextArea outputQteRessourcesTour = new JTextArea(libelles.getProperty("current.user.qte.ressurces.tour"));
    JTextArea inputQteInitialeResources = new JTextArea();
    JTextArea outputQteInitialeResources = new JTextArea(libelles.getProperty("create.game.qte.ressources.init"));
    public static Configuration libelles = Configuration.getLibelleConf();
    private JButton boutonCreer = new JButton(libelles.getProperty("create.game.boutton.creer"));


    public CreateGamePanel(UiManager uiManager){
        this.uiManager = uiManager;
        createGamePanelLayout();
    }

    private void createGamePanelLayout() {
        setLayout(new GridBagLayout());
        this.setBackground(Color.green);

        outputLogin.setEditable(false);
        outputLogin.setBackground(Color.gray);
        outputLogin.setVisible(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.fill= gbc.HORIZONTAL;
        this.add(outputLogin,  gbc);

        outputNom.setEditable(false);
        outputNom.setVisible(true);
        inputNom.setEditable(true);
        inputNom.setVisible(true);
        inputNom.setBackground(Color.red);
        outputDureeTour.setEditable(false);
        outputDureeTour.setVisible(true);
        inputDureeTour.setEditable(true);
        inputDureeTour.setVisible(true);
        outputNbMaxPlayers.setEditable(false);
        outputNbMaxPlayers.setVisible(true);
        inputNbMaxPlayers.setEditable(true);
        inputNbMaxPlayers.setVisible(true);
        outputTailleCarte.setEditable(false);
        outputTailleCarte.setVisible(true);
        inputTailleCarte.setEditable(true);
        inputTailleCarte.setVisible(true);
        outputDistanceMinVilles.setEditable(false);
        outputDistanceMinVilles.setVisible(true);
        inputDistanceMinVilles.setEditable(true);
        inputDistanceMinVilles.setVisible(true);
        outputQteRessourcesTour.setEditable(false);
        outputQteRessourcesTour.setVisible(true);
        inputQteRessourcesTour.setEditable(true);
        inputQteRessourcesTour.setVisible(true);
        outputQteInitialeResources.setEditable(false);
        outputQteInitialeResources.setVisible(true);
        inputQteInitialeResources.setEditable(true);
        inputQteInitialeResources.setVisible(true);
        this.add(outputNom,getGBC(1,1));
        this.add(inputNom,getGBC(1,2));
        this.add(outputDureeTour,getGBC(2,1));
        this.add(inputDureeTour,getGBC(2,2));
        this.add(outputNbMaxPlayers,getGBC(3,1));
        this.add(inputNbMaxPlayers,getGBC(3,2));
        this.add(outputTailleCarte,getGBC(4,1));
        this.add(inputTailleCarte,getGBC(4,2));
        this.add(outputDistanceMinVilles,getGBC(5,1));
        this.add(inputDistanceMinVilles,getGBC(5,2));
        this.add(outputQteRessourcesTour,getGBC(6,1));
        this.add(inputQteRessourcesTour,getGBC(6,2));
        this.add(outputQteInitialeResources,getGBC(7,1));
        this.add(inputQteInitialeResources,getGBC(7,2));

        boutonCreer.addActionListener(this);
        boutonCreer.setVisible(true);
        this.add(boutonCreer,getGBC(8,2));


    }

    public GridBagConstraints getGBC(int line, int colone){
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.fill=gbc.HORIZONTAL;
        gbc.gridx=colone;
        gbc.gridy=line;
        gbc.weightx=1;
        return gbc;
    }

    public void actualise(){
        outputLogin.setText(libelles.getProperty("current.user.prepend")+uiManager.getConnectedPlayer().getLogin());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==boutonCreer && verifierChamps()){
            System.out.println("créer");
            uiManager.createGame(inputNom.getText(),Integer.parseInt(inputDureeTour.getText()),Integer.parseInt(inputNbMaxPlayers.getText()),
                    Integer.parseInt(inputTailleCarte.getText()),Integer.parseInt(inputDistanceMinVilles.getText()),
                    Integer.parseInt(inputQteRessourcesTour.getText()),Integer.parseInt(inputQteInitialeResources.getText()));
        }
    }

    private boolean verifierChamps() {
        //TODO verifier les champs 1 par 1 et mettre en rouge les mauvais
        return true;
    }
}
