package reactorSim;


/**
 * Write a description of class IncCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;

public class IncCommand extends Command
{
    public IncCommand (Model model) {
        super(model);
    }
    
    @Override
    public void execute() throws Exception{
        ((Reactor)model).incTemp();
    }
}
