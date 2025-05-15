package reactorSim;


/**
 * Write a description of class ReactorPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mvc.*;
import javax.swing.*;


public class ReactorPanel extends AppPanel {
    public ReactorPanel(AppFactory factory) {
        super(factory);
        JButton b = new JButton("incTemp");
        b.addActionListener(this);
        controlPanel.add(b);
        b = new JButton("decTemp");
        b.addActionListener(this);
        controlPanel.add(b);
    }
    public static void main(String[] args) {
        AppPanel p = new ReactorPanel(new ReactorFactory());
        p.display();
    }
}
