package stoplightSim;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class StopLightComponent extends JComponent
{
    private StopLight light;
    private int height = 100, width = 100, xc = 0, yc = 0;
    private Ellipse2D.Double redLight, yellowLight, greenLight;

    public StopLightComponent(StopLight light, int xc, int yc, int height)
    {
        this.light = light;
        this.height = height;
        this.xc = xc;
        this.yc = yc;
        int delta = 5;
        double diam = (height - 4 * delta)/3;
        this.width = (int)(diam + 2 * delta);
        redLight = new Ellipse2D.Double(xc + delta, yc + delta, diam, diam);
        yellowLight = new Ellipse2D.Double(xc + delta, yc + diam + 2 * delta, diam, diam);
        greenLight = new Ellipse2D.Double(xc + delta, yc + 2 * diam + 3 * delta, diam, diam);
    }

    public StopLightComponent(StopLight light) { this(light, 50, 50, 100); }


    public void paintComponent(Graphics gc)
    {

        // gc2D uses double coordinates inbstead of ints
        Graphics2D gc2d = (Graphics2D)gc;

        Color oldColor = gc2d.getColor();
        gc2d.setColor(Color.WHITE);
        gc2d.fillRect(xc, yc, width, height);
        gc2d.setColor(Color.BLACK);
        gc2d.drawRect(xc, yc, width, height);


        gc2d.draw(greenLight);
        gc2d.draw(yellowLight);
        gc2d.draw(redLight);

        if (light.getColor().equals(Color.GREEN))
        {
            gc2d.setColor(Color.GREEN);
            gc2d.fill(greenLight);
        }
        else if (light.getColor().equals(Color.YELLOW))
        {
            gc2d.setColor(Color.YELLOW);
            gc2d.fill(yellowLight);
        }
        else if (light.getColor().equals(Color.RED))
        {
            gc2d.setColor(Color.RED);
            gc2d.fill(redLight);
        }
        else
        {
            //throw new Exception("Invalid color: " + light.getColor().toString());
        }
        gc2d.setColor(oldColor);
    }
}
