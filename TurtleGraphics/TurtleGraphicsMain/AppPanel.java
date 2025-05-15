package TurtleGraphicsMain;

import tools.*;
import keys.KeyPad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener
{
    private Turtle turtle;
    private JPanel controls; // my control panel
    private TurtleGraphicsView view;
    
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton west = new JButton("West");
    JButton east = new JButton("East");
    JButton clear = new JButton("Clear");
    JButton pen = new JButton("Pen");
    JButton colour = new JButton("Color");

    public AppPanel()
    {
        turtle = new Turtle();
        view = new TurtleGraphicsView(turtle);
        controls = new JPanel();
        controls.setBackground(Color.WHITE);
        JPanel p = new JPanel();
        ButtonLayout(p, controls);
        setListeners();
        
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);
       
        
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Turtle Graphics Project");
        frame.setSize(500, 250);
        frame.setVisible(true);
        
    }

    private void ButtonLayout(JPanel p, JPanel controls){
       
        p.add(north);
        p.add(south);
        p.add(west);
        p.add(east);
        p.add(clear);
        p.add(pen);
        p.add(colour);
        controls.add(p);
        controls.setLayout((new GridLayout(2,3)));
    }
    
    public void setListeners() {
        north.addActionListener(this::actionPerformed);
        south.addActionListener(this::actionPerformed);
        west.addActionListener(this::actionPerformed);
        east.addActionListener(this::actionPerformed);
        clear.addActionListener(this::actionPerformed);
        pen.addActionListener(this::actionPerformed);
        colour.addActionListener(this::actionPerformed);
    }
    
    protected JMenuBar createMenuBar()
    {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Pen", "Clear", "Color"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmmd = e.getActionCommand();
        
        try
        {
            switch (cmmd)
            {
                case "North":
                    moveTurtle(Direction.NORTH);
                    break;
                case "South":
                    moveTurtle(Direction.SOUTH);
                    break;
                case "East":
                    moveTurtle(Direction.EAST);
                    break;
                case "West":
                    moveTurtle(Direction.WEST);
                    break;
                case "Pen":
                    turtle.togglePen();
                    break;
                case "Clear":
                    turtle.clear();
                    break;
                case "Color":
                    chooseColor();
                    break;
                case "Save":
                {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.turtle);
                    os.close();
                    break;
                }
                case "Open":
                {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                    {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        turtle = (Turtle) is.readObject();
                        view.setTurtle(turtle);
                        is.close();
                    }
                    break;
                }
                case "New":
                {
                    turtle = new Turtle();
                    view.setTurtle(turtle);
                    break;
                }
                case "Quit":
                {
                    System.exit(0);
                    break;
                }
                case "About":
                {
                    Utilities.inform("Turtle Graphics Project");
                    break;
                }
                case "Help":
                {
                    String[] cmmds = new String[] {"North - Goes Up",
                        "South - Goes Down",
                        "West - Goes Left",
                        "East - Goes Right",
                        "Clear - Empties the entire canvas",
                        "Pen - Toggles the pen making lines", 
                        "Color - Changes the color"};
                    Utilities.inform(cmmds);
                    break;
                }
                default:
                {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }
            view.updateView();
        }
        catch (Exception ex)
        {
            Utilities.error(ex);
        }
    }

    private void moveTurtle(Direction direction) {
        String input = JOptionPane.showInputDialog("Enter number of steps:");
        try {
            int steps = Integer.parseInt(input);
            turtle.move(steps, direction);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number of steps.");
        }
    }
    
    private void chooseColor() {
        Color newColor = JColorChooser.showDialog(null, "Choose a color", turtle.getColor());
        if (newColor != null) {
            turtle.setColor(newColor);
        }
    }
    
    public static void main(String[] args) { AppPanel app = new AppPanel(); }
}
 
