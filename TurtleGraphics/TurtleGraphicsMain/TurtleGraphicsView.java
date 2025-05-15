package TurtleGraphicsMain;

import tools.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class TurtleGraphicsView extends JPanel implements Subscriber {
    private Turtle turtle;

    public TurtleGraphicsView(Turtle turtle) {
        this.turtle = turtle;
        turtle.subscribe(this);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(250, 250));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Point> path = turtle.getPath();
        Graphics2D g2d = (Graphics2D) g;
    
        for (int i = 1; i < path.size(); i++) {
            Point p1 = path.get(i - 1);
            Point p2 = path.get(i);
            if (p2.getPenStatus()) {
                g2d.setColor(p2.getColor());
                g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            }
        }

        // Draw the turtle
        TurtleShape shape = new TurtleShape(turtle);
        shape.draw(g2d);
    }

    public void update() { repaint(); }
    
    public void setTurtle(Turtle newTurtle)
    {
        turtle.unSubscribe(this);
        turtle = newTurtle;
        turtle.subscribe(this);
        repaint();
    }
    
    public void updateView() {
        repaint();
    }
}

