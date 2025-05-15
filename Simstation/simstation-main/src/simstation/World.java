package simstation;
import mvc.*;

import java.awt.*;
import java.util.*;
import java.util.List;


public class World extends Model{
    public static int SIZE = 500;
    protected int clock = 0;
    int alive= 0;
    protected List<Agent> agents = new ArrayList<>();
    private ObserverAgent observer;
    private transient Thread clockThread;
    private boolean running = false;

    /*
    public World() {
        populate();
        observer = new ObserverAgent(this);
        addAgent(observer);

    }

 */
    public List<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent a){
        agents.add(a);
        a.setWorld(this);
    }
    public void startAgents(){
        populate();
        for (Agent a : agents){
            a.start();
        }
        startClock();
    }
    public void stopAgents(){
        for (Agent a : agents){
            a.stop();
        }
        stopClock();
    }
    public void pauseAgents(){
        for (Agent a : agents){
            a.pause();
        }
    }
    public void resumeAgents(){
        for (Agent a : agents){
            a.resume();
        }
    }
    public void populate(){
        //if (agents.isEmpty()) populate();
    }


    public String[] getStatus() {
        String[] msg = {"#agents = " + agents.size(), "\n#living: " + alive, "\nclock = " + clock};
        return msg;
    }
    public void updateStatistics(){
        clock++;
        alive = agents.size();
        changed();
    }

    public void update(){
        clock++;
        alive = agents.size();
        changed();
    }

    public Iterator<Agent> iterator() {
        return agents.iterator();
    }
    public void startClock() {
        running = true;
        clockThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000); // 1 second
                    clock++;
                    changed(); // Notify views
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        clockThread.start();
    }

    public void stopClock() {
        running = false;
        if (clockThread != null) {
            clockThread.interrupt();
        }
    }

    public Agent getNeighbor(Agent caller, int radius){
        if(agents.size() <=1 ){
            return null;
        }
        Random random = new Random();
        int start = random.nextInt(agents.size());

        for(int i = 0; i < agents.size(); i++){
            Agent potentialAgent = agents.get((start+i)% agents.size());
            if (potentialAgent != caller ){
                int dx = caller.xc - potentialAgent.xc;
                int dy = caller.yc - potentialAgent.yc;

                int sqrd = dx*dx + dy*dy;

                if (sqrd <= radius * radius) {
                    return potentialAgent;
                }

            }
        }
        return null;
    }

    public int getWidth() {
        return SIZE;
    }

    public int getHeight() {
        return SIZE;
    }

    public boolean isValidLocation(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }


}
