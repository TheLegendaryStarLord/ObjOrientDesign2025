import TurtleGraphicsMain.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TurtleGraphicsMain.AppPanel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        AppPanel.main(args);
    }
}


/*
public class Main {
    public static void main(String[] args) {
        // Create the turtle instance
        Turtle turtle = new Turtle();

        // Create the view (canvas)
        TurtleGraphicsView view = new TurtleGraphicsView(turtle);

        // Create the controller
        TurtleGraphicsController controller = new TurtleGraphicsController(turtle, view);

        // Create the main frame
        JFrame frame = new JFrame("Turtle Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        // Add the turtle graphics view to the frame
        frame.add(view, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons for movement
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton penButton = new JButton("Toggle Pen");
        JButton clearButton = new JButton("Clear");

        // Add action listeners to buttons
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String steps = JOptionPane.showInputDialog("Enter number of steps:");
                if (steps != null) {
                    turtle.move(Integer.parseInt(steps), Direction.NORTH);
                    view.updateView();
                }
            }
        });

        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String steps = JOptionPane.showInputDialog("Enter number of steps:");
                if (steps != null) {
                    turtle.move(Integer.parseInt(steps), Direction.SOUTH);
                    view.updateView();
                }
            }
        });

        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String steps = JOptionPane.showInputDialog("Enter number of steps:");
                if (steps != null) {
                    turtle.move(Integer.parseInt(steps), Direction.EAST);
                    view.updateView();
                }
            }
        });

        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String steps = JOptionPane.showInputDialog("Enter number of steps:");
                if (steps != null) {
                    turtle.move(Integer.parseInt(steps), Direction.WEST);
                    view.updateView();
                }
            }
        });

        penButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turtle.togglePen();
                view.updateView();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turtle.clear();
                view.updateView();
            }
        });

        // Add buttons to the panel
        buttonPanel.add(northButton);
        buttonPanel.add(southButton);
        buttonPanel.add(eastButton);
        buttonPanel.add(westButton);
        buttonPanel.add(penButton);
        buttonPanel.add(clearButton);

        // Add the button panel to the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
*/