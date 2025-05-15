package midtermCalculator;


/**
 * Write a description of class mulCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mvc.*;
public class mulCommand extends Command  {
    public mulCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        calculator calc = (calculator) model;
        Double x = Double.parseDouble(Utilities.ask("Enter a number"));
        calc.mulCom(x);
    }
}