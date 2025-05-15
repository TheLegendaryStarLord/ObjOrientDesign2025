package TurtleGraphicsMain;

import java.awt.Color;
import java.io.Serializable;

public class Point implements Serializable {
    private int x;
    private int y;
    private Color color;
    private boolean penStatus;

    public Point(int x, int y, Color color, boolean penStatus) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.penStatus = penStatus;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
    
    public void setPenStatus(boolean status) {
        this.penStatus = status;
    }

    public boolean getPenStatus(){
        return this.penStatus;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

