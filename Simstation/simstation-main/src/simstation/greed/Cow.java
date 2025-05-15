package simstation.greed;

import simstation.*;
import mvc.*;
import java.util.*;
public class Cow extends MobileAgent {
    public int energy = 100;
    public static int greediness = 25;

    public Cow() {
        super("Cow");
    }

    public void update() {
        Meadow meadow = (Meadow) world;
        Patch patch = meadow.getPatch(getX(), getY());

        if (patch.energy >= greediness) {
            patch.eat(greediness);
            energy += greediness;
            if (energy > 100) energy = 100;
        } else if (energy >= Meadow.moveEnergy) {
            energy -= Meadow.moveEnergy;
            setHeading(Heading.random());
            move(Utilities.rng.nextInt(20));
        } else {
            energy -= Meadow.waitPenalty;
        }

        if (energy <= 0) {
            energy = 0;
            stop();
        }
    }


    public boolean isStopped() {
        return state == AgentState.STOPPED;
    }
}
