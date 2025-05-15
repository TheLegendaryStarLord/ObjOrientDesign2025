package simstation;
import mvc.*;

public class PauseCommand extends Command{
    public PauseCommand(Model model) {
        super(model);
    }
    public void execute() throws Exception{
        ((World)model).pauseAgents();
    }
}
