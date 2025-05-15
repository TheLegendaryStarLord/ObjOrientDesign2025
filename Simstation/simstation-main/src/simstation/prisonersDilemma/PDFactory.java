package simstation.prisonersDilemma;

import mvc.*;
import simstation.*;

public class PDFactory extends WorldFactory {

    public Model makeModel() {
        return new PDSimulation();
    }

    public View makeView(Model simulation) {
        return new PDView((PDSimulation)simulation);
    }

    public String getTitle() {
        return "Prisoner's Dilemma Tournament";
    }

    public String about(){
        return "Simulates prisoners playing the prisoner's dilemma with varying strategies.";
    }
}