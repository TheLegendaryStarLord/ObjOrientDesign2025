package simstation.prisonersDilemma;

import java.io.Serializable;

public abstract class Strategy implements Serializable {
    public Prisoner myPrisoner;

    public abstract boolean cooperate();
}
