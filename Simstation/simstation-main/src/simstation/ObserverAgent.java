package simstation;

public class ObserverAgent extends Agent {
    public ObserverAgent(){
       super("Observer");
    }
    @Override
    public void update(){
        world.updateStatistics();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            //handle this
        }
    }
}
