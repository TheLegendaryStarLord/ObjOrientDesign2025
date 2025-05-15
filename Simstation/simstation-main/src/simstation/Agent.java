package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    protected int xc;
    protected int yc;
    protected String agentName;
    transient protected Thread myThread;
    protected Heading heading = Heading.NORTH;
    protected AgentState state = AgentState.READY;
    protected World world;

    public Agent() {
        xc = 0;
        yc = 0;
        myThread = null;
    }

    public Agent(String agentName) {
        this();
        this.agentName = agentName;
    }

    public Agent(String name, World sim, int[] pos) {
        this(name);
        this.world = sim;
        this.xc = pos[0];
        this.yc = pos[1];
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public synchronized void start() {
        if (state == AgentState.READY) {
            state = AgentState.RUNNING;
            myThread = new Thread(this, "Agent-" + agentName);
            myThread.start();
        }
    }

    public synchronized void stop() {
        state = AgentState.STOPPED;
        notifyAll(); // Wake up any paused threads
    }

    public synchronized void pause() {
        if (state == AgentState.RUNNING) {
            state = AgentState.SUSPENDED;
        }
    }

    public synchronized void resume() {
        if (state == AgentState.SUSPENDED) {
            state = AgentState.RUNNING;
            notifyAll(); // Wake up the paused thread
        }
    }

    public void setThread(Thread thread) {
        myThread = thread;
    }

    @Override
    public void run() {
        try {
            onStart();

            while (state != AgentState.STOPPED) {
                synchronized (this) {
                    while (state == AgentState.SUSPENDED) {
                        wait();
                    }
                    if (state == AgentState.STOPPED) {
                        break;
                    }
                }

                update();

                try {
                    Thread.sleep(20);
                } catch (InterruptedException ie) {
                    System.err.println(ie.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Agent interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            onExit();
        }
    }

    protected void onStart() {}
    protected void onInterrupted() {}
    protected void onExit() {}

    public abstract void update();

    public void move(int steps) {
        switch (heading) {
            case NORTH:
                yc -= steps;
                break;
            case SOUTH:
                yc += steps;
                break;
            case WEST:
                xc -= steps;
                break;
            case EAST:
                xc += steps;
                break;
        }

        // Handle world wrapping
        if (xc >= world.getWidth()) {
            xc -= world.getWidth();
        } else if (xc < 0) {
            xc += world.getWidth();
        }

        if (yc >= world.getHeight()) {
            yc -= world.getHeight();
        } else if (yc < 0) {
            yc += world.getHeight();
        }

        world.changed();
    }

    public void turn(Heading newHeading) {
        this.heading = newHeading;
    }

    public int getX() {
        return xc;
    }

    public int getY() {
        return yc;
    }

    public String getName() {
        return agentName;
    }

    public Heading getHeading() {
        return heading;
    }

    public AgentState getState() {
        return state;
    }
    public boolean isStopped() {
        return state == AgentState.STOPPED;
    }


}