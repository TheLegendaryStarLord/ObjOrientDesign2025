package stoplightSim;

import tools.Publisher;
import java.awt.Color;
import java.io.Serializable;

public class StopLight extends Publisher implements Serializable
{
    private Color color = Color.GREEN;

    public Color getColor() { return color; }

    public String toString() { return "Stoplight.color = " + color.toString(); }

    public void change()
    {
        if (color.equals(Color.GREEN)) color = Color.YELLOW;
        else if (color.equals(Color.YELLOW)) color = Color.RED;
        else if (color.equals(Color.RED)) color = Color.GREEN;
        notifySubscribers();
    }
}