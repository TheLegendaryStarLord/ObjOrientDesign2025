package simstation.greed;

public class Patch {
    public int energy = 100;
    public static int growBackRate = 1;
    public static final int MAX_ENERGY = 100;

    public void eat(int amount) {
        energy -= amount;
        if (energy < 0) energy = 0;
    }

    public void update() {
        energy += growBackRate;
        if (energy > MAX_ENERGY) energy = MAX_ENERGY;
    }
}
