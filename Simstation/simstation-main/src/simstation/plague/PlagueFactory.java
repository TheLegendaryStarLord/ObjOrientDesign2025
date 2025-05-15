package simstation.plague;

import simstation.*;
import mvc.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    public String getTitle() {
        return "Plague Simulation";
    }

    public View makeView(Model simulation) {
        return new PlagueView((PlagueSimulation) simulation);
    }

    public String about() {
        return "Simulates a viral illness spreading between people.";
    }

    public WorldPanel makePanel(Model model) {
        return new PlaguePanel(this);
    }
}