package api;

import lombok.Getter;
import lombok.Setter;

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
    ApiManager apiManager;
    JButton connection;
    public static JTextArea inputLogin;
    public static JTextArea outputLogin;

    public LoginPanel(ApiManager apiManager){
        this.apiManager=apiManager;
        this.setBackground(Color.GRAY);
        outputLogin = new JTextArea();
        outputLogin.setText("LOGIN :");
        outputLogin.setEditable(false);
        outputLogin.setVisible(true);
        this.add(outputLogin);
        inputLogin = new JTextArea();
        inputLogin.setBackground(Color.blue);
        inputLogin.setSize(30,10);
        Dimension dimentionMinimum= new Dimension();
        dimentionMinimum.setSize(30,10);
        inputLogin.setMinimumSize(dimentionMinimum);
        inputLogin.setVisible(true);
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
            apiManager.connectWith(content);
        }
    }

}
