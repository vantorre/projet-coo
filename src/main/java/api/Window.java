package api;

import facade.Facade;
import facade.response.Response;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class Window extends JFrame{
    private String connectedPlayer;
    private Facade facade;
    ApiManager apiManager;

    public Window() {
        this.setTitle("Age of Farmer");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }
    private void printFailedResponseMessage(Response response){
        JOptionPane.showMessageDialog(this, response.getStatutMessage());
    }



}
