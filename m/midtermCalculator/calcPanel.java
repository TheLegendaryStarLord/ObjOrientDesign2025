package midtermCalculator;


/**
 * Write a description of class calcPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mvc.*;
import javax.swing.*;


public class calcPanel extends AppPanel {
    public calcPanel(AppFactory factory) {
        super(factory);
        JButton b = new JButton("Add");
        b.addActionListener(this);
        controlPanel.add(b);
        b = new JButton("Mul");
        b.addActionListener(this);
        controlPanel.add(b);
        b = new JButton("Clear");
        b.addActionListener(this);
        controlPanel.add(b);
    }
    public static void main(String[] args) {
        AppPanel p = new calcPanel(new calcFactory());
        p.display();
    }
}
