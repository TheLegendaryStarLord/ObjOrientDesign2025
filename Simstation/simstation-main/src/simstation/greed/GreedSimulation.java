package simstation.greed;

import simstation.*;
import mvc.*;

public class GreedSimulation {
    public static void main(String[] args) {
        AppPanel panel = new GreedPanel(new GreedFactory());
        panel.display();
    }
}
