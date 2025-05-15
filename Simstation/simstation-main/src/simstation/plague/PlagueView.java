package simstation.plague;

import simstation.*;
import java.awt.*;
import mvc.*;

public class PlagueView extends WorldView {
    private static final int RADIUS = 5;

    public PlagueView(PlagueSimulation simulation) {
        super(simulation);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        PlagueSimulation sim = (PlagueSimulation)model;
        for (Agent agent : sim.getAgents()) {
            if (agent instanceof PlagueAgent) {
                PlagueAgent plagueAgent = (PlagueAgent)agent;
                if (plagueAgent.isInfected()) {
                    gc.setColor(Color.RED);
                } else {
                    gc.setColor(Color.GREEN);
                }
                gc.fillOval(agent.getX() - RADIUS, agent.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
            }
        }
        gc.setColor(oldColor);
    }
}
