package simstation;

import mvc.*;
import java.awt.*;

public class WorldView extends View {
    protected final int RADIUS = 5;
    protected boolean drawAgents = true;
    public WorldView(World world) {
        super(world);
        setBackground(Color.WHITE);
    }

    public WorldView(Model model) {
        super(model);
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        World world = (World) model;
        for (Agent a : world.getAgents()) {
            drawAgent(a, gc);
        }
    }

    protected void drawAgent(Agent a, Graphics gc) {
        gc.setColor(Color.RED);
        gc.fillOval(a.getX() - RADIUS, a.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
    }
}
