package simstation;

public abstract class MobileAgent extends Agent {
    protected Heading heading;

    public MobileAgent(String agentName) {
        super(agentName);
        heading = Heading.random();
    }

    public MobileAgent() {
        super();
    }


    public void move(int steps){


        switch(heading){
            case NORTH: yc -= steps; break;
            case EAST: xc += steps; break;
            case SOUTH: yc += steps; break;
            case WEST: xc -= steps; break;
        }


        xc = (World.SIZE + xc) % World.SIZE;
        yc = (World.SIZE + yc) % World.SIZE;

        world.changed();

    }
    public void turn(Heading newHead){
        heading = newHead;
    }
    public void setHeading(Heading h) {
        this.heading = h;
    }

}
