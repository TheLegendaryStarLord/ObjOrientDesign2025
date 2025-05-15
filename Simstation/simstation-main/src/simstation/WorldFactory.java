package simstation;

import mvc.*;

public abstract class WorldFactory implements AppFactory {
    public Model makeModel(){
        return new World();
    }
    public View makeView(Model model){
        return new WorldView(model);
    }
    public String[] getEditCommands(){
        return new String[]{"Start", "Pause","Resume", "Stop","Stats"};

    }
    public Command makeEditCommand(Model model, String type, Object source){
        switch(type){
            case "Start": return new StartCommand(model);
            case "Pause": return new PauseCommand(model);
            case "Resume": return new ResumeCommand(model);
            case "Stop": return new StopCommand(model);
            case "Stats": return new StatusCommand(model);
            default: return null;

        }
    }
    public String getTitle(){
        return "SimStation";

    }
    public String[] getHelp(){
        return new String[]{"Agent based simulation framework"};
    }
    public String about(){
        return "SimStation 1.0";
    }

}
