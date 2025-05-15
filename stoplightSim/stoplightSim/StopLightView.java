package stoplightSim;

import tools.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StopLightView extends JPanel implements Subscriber
{
    private StopLight light;

    public StopLightView(StopLight light)
    {
        this.light = light;
        light.subscribe(this);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.LIGHT_GRAY);
    }

    public void update() { repaint(); }

    public void setLight(StopLight newLight)
    {
        light.unSubscribe(this);
        light = newLight;
        light.subscribe(this);
        repaint();
    }

    public void paintComponent(Graphics gc)
    {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        StopLightShape shape = new StopLightShape(light);
        shape.draw((Graphics2D) gc);
        gc.setColor(oldColor);
    }
}
