package simstation;
import mvc.*;

public class StartCommand extends Command{
    public StartCommand(Model model){
        super(model);
    }
    public void execute() throws Exception{
        ((World) model).startAgents();
    }
}
