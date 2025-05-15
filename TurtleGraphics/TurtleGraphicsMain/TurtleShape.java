package TurtleGraphicsMain;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TurtleShape
{
    private Turtle turtle;
    private int height, width, xc, yc;
    private Ellipse2D.Double TurtleCircle;

    public TurtleShape(Turtle turtle) {
        this.turtle = turtle;
        this.height = 20; // Size of the turtle
        this.width = 20; // Size of the turtle
        this.xc = turtle.getLocation().getX() - width / 2;
        this.yc = turtle.getLocation().getY() - height / 2;
        this.TurtleCircle = new Ellipse2D.Double(xc, yc, width, height);
    }

    //public TurtleShape(Turtle turtle) { this(turtle, 50, 50, 100); }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public int getXc() { return xc; }

    public int getYc() { return yc; }

    public void draw(Graphics2D gc) {
        Point currentPosition = turtle.getLocation();
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        int size = 20; // Size of the turtle

        if (turtle.isPenDown()) {
            gc.setColor(turtle.getColor());
            gc.fillOval(x - size / 2, y - size / 2, size, size);
        } else {
            gc.setColor(turtle.getColor());
            gc.drawOval(x - size / 2, y - size / 2, size, size);
        }
    }
}