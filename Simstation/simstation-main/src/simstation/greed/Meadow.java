package simstation.greed;

import simstation.*;

public class Meadow extends World {
    public static final int SIZE = 500;
    public static final int patchSize = 5;
    public static final int dim = SIZE / patchSize;

    public static int waitPenalty = 5;
    public static int moveEnergy = 10;
    public static int numCows = 100;

    private Patch[][] grid;

    public Meadow() {
        grid = new Patch[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                grid[i][j] = new Patch();
            }
        }
    }

    public Patch getPatch(int x, int y) {
        int i = Math.min(dim - 1, Math.max(0, x / patchSize));
        int j = Math.min(dim - 1, Math.max(0, y / patchSize));
        return grid[i][j];
    }

    public void populate() {
        for (int i = 0; i < numCows; i++) {
            addAgent(new Cow());
        }
    }

    public void update() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                grid[i][j].update();
            }
        }
        super.update();
    }

    public static int getDim() {
        return dim;
    }

    public Patch[][] getGrid() {
        return grid;
    }

    public String[] getStatus() {
        int Total = getAgents().size();
        int alive = 0;
        int dead = 0;

        for (Agent a : getAgents()) {
            if (!a.isStopped()) {
                alive++;
            }
            if (a instanceof Cow && ((Cow) a).isStopped()) {
                dead++;
            }
        }
        String[] stats = {"Total: "+ Total,
                "Alive: "+ alive,
                "Dead: " + dead
        };
        return stats;
    }
}
