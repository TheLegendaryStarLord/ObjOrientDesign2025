package simstation.greed;

import simstation.*;
import mvc.*;

public class GreedFactory extends WorldFactory {
    public Model makeModel() {
        return new Meadow();
    }

    public View makeView(Model model) {
        return new GreedView((Meadow) model);
    }

    public AppPanel makePanel(Model model) {
        return new GreedPanel(this);
    }

    public String getTitle() {
        return "Greed Simulation";
    }

    public String about() {
        return "A simulation of cows grazing in a meadow. They live, eat, move, or die based on greed.";
    }
}
