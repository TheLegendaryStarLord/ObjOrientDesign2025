package reactorSim;


/**
 * Write a description of class ReactorFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;
import javax.swing.*;

public class ReactorFactory implements AppFactory
{
    @Override
    public Model makeModel() {
        return new Reactor();
    }

    @Override
    public View makeView(Model model) {
        return new ReactorView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"incTemp", "decTemp"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equalsIgnoreCase("incTemp")) return new IncCommand(model);
        if (type.equalsIgnoreCase("decTemp")) return new DecCommand(model);
        return null;
    }

    @Override
    public String getTitle() {
        return "Reactor Control";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"incTemp increments reactor's temperature by a random amount < 100 degrees", "decTemp decrements reactor's temperature by a random amount < 100 degrees" };
    }

    @Override
    public String about() {
        return "Version 1.0, copyright 2025";
    }
}
