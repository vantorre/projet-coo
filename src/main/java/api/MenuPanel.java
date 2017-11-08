package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vantorre on 08/11/17.
 */
public class MenuPanel extends JPanel implements ActionListener {

    private ApiManager apiManager;
    JTextArea outputLogin = new JTextArea();

    public MenuPanel(ApiManager apiManager){
        this.apiManager=apiManager;
        this.setBackground(Color.green);

        outputLogin.setEditable(false);
        outputLogin.setVisible(true);
        this.add(outputLogin);

    }

    public void actualise(){
        outputLogin.setText(apiManager.getConnectedPlayer().getLogin());
    }

    public void actionPerformed(ActionEvent e) {

    }
}
