package midtermCalculator;


/**
 * Write a description of class clearCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;

public class clearCommand extends Command  {
    public clearCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        calculator calc = (calculator) model;
        calc.clearCom();
    }
}
