package TurtleGraphicsMain;

import tools.Publisher;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turtle extends Publisher implements Serializable {
    public static final int WORLD_SIZE = 250;
    private List<Point> path;
    private Point location;
    private Color color;
    private boolean penStatus;

    public Turtle() {
        this.path = new ArrayList<>();
        this.location = new Point(0, 0, Color.GREEN, true);
        this.color = Color.GREEN;
        this.penStatus = true;
        this.path.add(location);
    }

    public void move(int steps, Direction direction) {
        int newX = location.getX();
        int newY = location.getY();
        
        switch (direction) {
            case NORTH:
                newY -= steps; // Move up (decrease y)
                break;
            case EAST:
                newX += steps; // Move right (increase x)
                break;
            case SOUTH:
                newY += steps; // Move down (increase y)
                break;
            case WEST:
                newX -= steps; // Move left (decrease x)
                break;
        }
        // Update path and location
        
        // Check if the new position is within bounds
        if (newX < 0 || newX >= WORLD_SIZE || newY < 0 || newY >= WORLD_SIZE) {
            throw new IllegalArgumentException("Turtle cannot move outside the canvas.");
        }

        // Update the turtle's location
        location = new Point(newX, newY, color, penStatus);
        path.add(location); // Add the new point to the path if pen is down
    }

    public void togglePen() {
        this.penStatus = !this.penStatus;
        // Update the last point's pen status
    }

    public boolean isPenDown() {
        return penStatus;
    }
    
    public void clear() {
        this.path.clear();
        this.path.add(location); // Keep current position
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public Point getLocation(){
        return this.location;
    }
    
    public List<Point> getPath() {
        return this.path;
    }
}
