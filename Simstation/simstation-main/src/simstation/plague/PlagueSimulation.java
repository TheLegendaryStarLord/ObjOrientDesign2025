package simstation.plague;

import simstation.*;
import mvc.*;
import java.util.Random;

public class PlagueSimulation extends World {
    public int virulence = 50;
    public int resistance = 2;
    public int numAgents = 50;
    public int startInfected = 1;
    public int recoveryTime = 100;
    public boolean fatal = false;

    public void populate() {
        Random r = new Random();
        agents.clear();
        int actualInfected = (int)(numAgents * (startInfected / 100.0));
        if (actualInfected < 1) actualInfected = 1;
        for (int i = 0; i < actualInfected; i++) {
            int[] pos = {r.nextInt(getWidth()), r.nextInt(getHeight())};
            addAgent(new PlagueAgent(this, pos, true));
        }
        for (int i = 0; i < numAgents - actualInfected; i++) {
            int[] pos = {r.nextInt(getWidth()), r.nextInt(getHeight())};
            addAgent(new PlagueAgent(this, pos, false));
        }
    }

    public String[] getStatus() {
        int total = getAgents().size();
        int infected = 0;
        int alive = 0;

        for (Agent a : getAgents()) {
            if (!a.isStopped()) {
                alive++;
            }
            if (a instanceof PlagueAgent && ((PlagueAgent) a).isInfected()) {
                infected++;
            }
        }

        float percentInfected = 100f * infected / total;

        String[] msg = {
                "#agents = " + total,
                "#living = " + alive,
                "#infected = " + infected + " (" + String.format("%.1f", percentInfected) + "%)",
                "clock = " + clock,
                "Fatal: " + (fatal ? "Yes" : "No")
        };

        return msg;
    }


    public static void main(String[] args) {
        WorldPanel p = new PlaguePanel(new PlagueFactory());
        p.display();
    }
}