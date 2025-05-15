package simstation.greed;

import simstation.*;
import mvc.*;
import java.awt.*;

public class GreedView extends WorldView {
    private static final int PATCH_SIZE = Meadow.patchSize;

    public GreedView(Meadow meadow) {
        super(meadow);
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Meadow meadow = (Meadow) model;
        Patch[][] grid = meadow.getGrid();

        for (int i = 0; i < Meadow.getDim(); i++) {
            for (int j = 0; j < Meadow.getDim(); j++) {
                int x = i * PATCH_SIZE;
                int y = j * PATCH_SIZE;

                int green = (int)(255 * (grid[i][j].energy / 100.0));
                gc.setColor(new Color(0, green, 0));
                gc.fillRect(x, y, PATCH_SIZE, PATCH_SIZE);
                gc.setColor(Color.GRAY); // light border
                gc.drawRect(x, y, PATCH_SIZE, PATCH_SIZE);
            }
        }


        for (Agent agent : meadow.getAgents()) {
            if (agent instanceof Cow) {
                Cow cow = (Cow) agent;
                if (cow.isStopped()) {
                    gc.setColor(Color.WHITE);
                } else {
                    gc.setColor(Color.RED);
                }
                gc.fillOval(cow.getX() - 3, cow.getY() - 3, 6, 6);
            }
        }
    }
}
