package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vantorre on 08/11/17.
 */
public class MenuPanel extends JPanel implements ActionListener {

    private UiManager uiManager;
    JTextArea outputLogin = new JTextArea();

    public MenuPanel(UiManager uiManager){
        this.uiManager = uiManager;
        this.setBackground(Color.green);

        outputLogin.setEditable(false);
        outputLogin.setVisible(true);
        this.add(outputLogin);

    }

    public void actualise(){
        outputLogin.setText(uiManager.getConnectedPlayer().getLogin());
    }

    public void actionPerformed(ActionEvent e) {

    }
}
