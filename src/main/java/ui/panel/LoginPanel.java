package ui.panel;

import lombok.Getter;
import lombok.Setter;
import ui.UiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vantorre on 07/11/17.
 */
@Getter
@Setter
public class LoginPanel extends JPanel implements ActionListener{
    private UiManager uiManager;
    JButton connection;
    public static JTextField inputLogin;
    public static JTextField outputLogin;

    public LoginPanel(UiManager uiManager){
        this.uiManager = uiManager;
        loginLayout();
    }

    private void loginLayout() {
        setLayout(new GridLayout(3,0));

        setBackground(Color.GRAY);

        outputLogin = new JTextField();
        outputLogin.setText("LOGIN :");
        outputLogin.setEditable(false);
        outputLogin.setVisible(true);
        outputLogin.setHorizontalAlignment(JTextField.CENTER);
        this.add(outputLogin);

        inputLogin = new JTextField();
        inputLogin.setBackground(Color.blue);
        inputLogin.setVisible(true);
        inputLogin.setFont(new Font(" ", Font.BOLD, 30));
        inputLogin.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        inputLogin.setHorizontalAlignment(JTextField.CENTER);
        this.add(inputLogin);

        connection=new JButton();
        connection.setSize(300,200);
        connection.setText("Connection !");//TODO externaliser les textes
        connection.addActionListener(this);
        this.add(connection);
        connection.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String content = inputLogin.getText();
        if(e.getSource()==connection && !content.equals("")){
            System.out.println("click sur le bouton de connection");
            uiManager.connectWith(content);
        }
    }

}
