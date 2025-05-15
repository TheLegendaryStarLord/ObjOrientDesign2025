package keys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPad extends JPanel implements ActionListener
{
    JTextField display = new JTextField("555-1234", 10);
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b0 = new JButton("0");
    JButton bSharp = new JButton("#");
    JButton bStar = new JButton("*");

    private void layout1()
    {
        add(display);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(bSharp);
        add(b0);
        add(bStar);
    }

    private void layout2()
    {

        setLayout(new BorderLayout());
        add(display, "North");
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        keys.add(b1);
        keys.add(b2);
        keys.add(b3);
        keys.add(b4);
        keys.add(b5);
        keys.add(b6);
        keys.add(b7);
        keys.add(b8);
        keys.add(b9);
        keys.add(bSharp);
        keys.add(b0);
        keys.add(bStar);

        // add(keys, "South");
        add(keys);
    }


    private void layout3()
    {
        setLayout(new BorderLayout());
        // parent of a control should use flow layout
        JPanel p = new JPanel();
        p.add(display);
        add(p, "North");
        JPanel keys = new JPanel();
        keys.setLayout(new GridLayout(4, 3));

        p = new JPanel();
        p.add(b1);
        keys.add(p);

        p = new JPanel();
        p.add(b2);
        keys.add(p);

        p = new JPanel();
        p.add(b3);
        keys.add(p);

        p = new JPanel();
        p.add(b4);
        keys.add(p);

        p = new JPanel();
        p.add(b5);
        keys.add(p);

        p = new JPanel();
        p.add(b6);
        keys.add(p);

        p = new JPanel();
        p.add(b7);
        keys.add(p);

        p = new JPanel();
        p.add(b8);
        keys.add(p);

        p = new JPanel();
        p.add(b9);
        keys.add(p);

        p = new JPanel();
        p.add(bSharp);
        keys.add(p);

        p = new JPanel();
        p.add(b0);
        keys.add(p);

        p = new JPanel();
        p.add(bStar);
        keys.add(p);

        add(keys);
    }

    public void setListeners()
    {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bStar.addActionListener(this);
        bSharp.addActionListener(this);
    }

    public KeyPad()
    {
        //layout1();
        //layout2();
        layout3();
        setListeners();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setTitle("Key Pad");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) { KeyPad kp = new KeyPad(); }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String info = "You pushed " + e.getActionCommand();
        JOptionPane.showMessageDialog(null, info);
    }
}
