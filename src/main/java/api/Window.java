package api;

import javax.swing.*;

/**
 * Created by vantorre on 04/11/17.
 */
public class Window extends JFrame{
    public Window() {
        this.setTitle("Age of Farmer");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }
}
