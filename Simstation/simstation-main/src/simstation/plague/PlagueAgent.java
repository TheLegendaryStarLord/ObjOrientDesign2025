package simstation.plague;

import mvc.*;
import simstation.*;
import java.awt.*;
import java.util.Random;

public class PlagueAgent extends Agent {

    public enum State {
        SUSCEPTIBLE, INFECTED, RECOVERED, DEAD
    }

    public State state;
    private int timeInfected = 0;
    private Random rng;
    private int moveSpeed;

    public PlagueAgent(PlagueSimulation sim, int[] pos, boolean startInfected) {
        super("", sim, pos);
        this.state = startInfected ? State.INFECTED : State.SUSCEPTIBLE;
        rng = new Random();
        heading = Heading.random();
        moveSpeed = rng.nextInt(5) + 1;
    }

    public void update() {
        PlagueSimulation sim = (PlagueSimulation) world;

        if (state == State.INFECTED) {
            timeInfected++;

            // Attempt to infect neighbors
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor instanceof PlagueAgent) {
                PlagueAgent other = (PlagueAgent) neighbor;
                if (other.state == State.SUSCEPTIBLE) {
                    if (rng.nextInt(100) > sim.resistance && rng.nextInt(100) < sim.virulence) {
                        other.state = State.INFECTED;
                    }
                }
            }

            // Recovery or death
            if (timeInfected >= sim.recoveryTime) {
                if (sim.fatal) {
                    state = State.DEAD;
                    stop(); // Agent will stop updating and moving
                } else {
                    state = State.RECOVERED;
                }
            }
        }

        // Move only if not dead
        if (state == State.SUSCEPTIBLE || state == State.INFECTED || state == State.RECOVERED) {
            move(moveSpeed);
        }
    }

    public boolean isInfected() {
        return state == State.INFECTED;
    }

    public synchronized void infect() {
        if (state == State.SUSCEPTIBLE && rng.nextInt(100) > ((PlagueSimulation) world).resistance) {
            state = State.INFECTED;
        }
    }

    public Color getColor() {
        switch (state) {
            case SUSCEPTIBLE: return Color.BLUE;
            case INFECTED:    return Color.RED;
            case RECOVERED:   return Color.GREEN;
            case DEAD:        return Color.WHITE;
            default:          return Color.BLACK;
        }
    }
}
