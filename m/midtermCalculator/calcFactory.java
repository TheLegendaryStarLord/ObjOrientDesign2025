package midtermCalculator;


/**
 * Write a description of class calcView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;
import javax.swing.*;

public class calcFactory implements AppFactory
{
    @Override
    public Model makeModel() {
        return new calculator();
    }

    @Override
    public View makeView(Model model) {
        return new calcView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"incTemp", "decTemp"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equalsIgnoreCase("Add")) return new addCommand(model);
        if (type.equalsIgnoreCase("Mul")) return new mulCommand(model);
        if (type.equalsIgnoreCase("Clear")) return new clearCommand(model);
        return null;
    }

    @Override
    public String getTitle() {
        return "calc Control";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"incTemp increments calc's temperature by a random amount < 100 degrees", "decTemp decrements calc's temperature by a random amount < 100 degrees" };
    }

    @Override
    public String about() {
        return "Version 1.0, copyright 2025";
    }
}