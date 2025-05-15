package reactorSim;


/**
 * Write a description of class DecCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;

public class DecCommand extends Command
{
    public DecCommand (Model model) {
        super(model);
    }
    
    @Override
    public void execute() throws Exception{
        ((Reactor)model).decTemp();
    }
}
