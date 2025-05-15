package simstation;
import mvc.*;

public class StatusCommand extends Command{
    public StatusCommand(Model model){
        super(model);
    }
    public void execute() throws Exception{
        String[]curr = ((World)model).getStatus();
        Utilities.inform(curr);
    }
}
