package midtermCalculator;


/**
 * Write a description of class addCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mvc.*;

public class addCommand extends Command  {
    public addCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        calculator calc = (calculator) model;
        Double x = Double.parseDouble(Utilities.ask("Enter a number"));
        calc.addCom(x);
    }
}