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
    JButton connection;

    public LoginPanel(){
        this.setBackground(Color.GRAY);
        //TODO ajout du champ text pour login
        connection=new JButton();
        connection.setSize(300,200);
        connection.setText("Connection !");//TODO externaliser les textes
        connection.addActionListener(this);
        this.add(connection);
        connection.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connection){
            System.out.println("click sur le bouton de connection");
            //TODO appel à l'API manager en passant en parametre le contenu du champ login
        }
    }

}
