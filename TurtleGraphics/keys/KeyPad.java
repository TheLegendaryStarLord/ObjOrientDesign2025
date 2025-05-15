package keys;
/**
 * keypad gained from the hints and demos page
 *
 * @author Adam Sanchez
 * @version (a version number or a date)
 */
 
 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPad extends JPanel implements ActionListener {
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton west = new JButton("West");
    JButton east = new JButton("East");
    JButton clear = new JButton("Clear");
    JButton colour = new JButton("Color");
    /*JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b0 = new JButton("0");
    JButton bSharp = new JButton("#");
    JButton bStar = new JButton("*");
    */
    private void layout1() {
        add(north);
        add(south);
        add(west);
        add(east);
        add(clear);
        add(colour);
    }
    private void layout2() {

        setLayout(new BorderLayout());
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        keys.add(north);
        keys.add(south);
        keys.add(west);
        keys.add(east);
        keys.add(clear);
        keys.add(colour);

        //add(keys, "South");
        add(keys, "Center");
    }

    public void layout3() {

        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        add(p, "North");
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        p = new JPanel();
        p.add(north);
        keys.add(p);

        p = new JPanel();
        p.add(south);
        keys.add(p);

        p = new JPanel();
        p.add(west);
        keys.add(p);

        p = new JPanel();
        p.add(east);
        keys.add(p);

        p = new JPanel();
        p.add(clear);
        keys.add(p);

        p = new JPanel();
        p.add(colour);
        keys.add(p);
        
        add(keys);
    }

    public void setListeners() {
        north.addActionListener(this);
        south.addActionListener(this);
        west.addActionListener(this);
        east.addActionListener(this);
        clear.addActionListener(this);
        colour.addActionListener(this);
    }

    public KeyPad() {
        //layout1();
        //layout2();
        layout3();
        setListeners();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        
        frame.setTitle("TurtleGraphics");
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    //public static void main(String[] args) {
    //    KeyPad kp = new KeyPad();
    //}


    @Override
    public void actionPerformed(ActionEvent e) {
        String info = "You pushed " + e.getActionCommand();
        JOptionPane.showMessageDialog(this, info);
        ///display.setText(display.getText() + e.getActionCommand());
    }


}