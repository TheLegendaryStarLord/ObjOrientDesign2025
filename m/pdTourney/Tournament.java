package pdTourney;
import java.util.*;

public class Tournament {
    Set<Prisoner> prisoners = new HashSet<Prisoner>();

    // test driver (not required):
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        Prisoner cheater1 = new Prisoner();
        cheater1.myStrategy = new AlwaysCheat();
        tournament.prisoners.add(cheater1);
        Prisoner cheater2 = new Prisoner();
        cheater2.myStrategy = new AlwaysCheat();
        tournament.prisoners.add(cheater2);

        Prisoner cooperator1 = new Prisoner();
        cooperator1.myStrategy = new AlwaysCooperate();
        tournament.prisoners.add(cooperator1);
        Prisoner cooperator2 = new Prisoner();
        cooperator2.myStrategy = new AlwaysCooperate();
        tournament.prisoners.add(cooperator2);

        Prisoner rando1 = new Prisoner();
        rando1.myStrategy = new RandomlyCheat();
        tournament.prisoners.add(rando1);
        Prisoner rando2 = new Prisoner();
        rando2.myStrategy = new RandomlyCheat();
        tournament.prisoners.add(rando2);

        ArrayList<Prisoner> prisoners = new ArrayList<Prisoner>(tournament.prisoners);
        for (int i = 0; i < 100; i++) {
            Prisoner prisoner1 = prisoners.get(RandomlyCheat.rng.nextInt(prisoners.size()));
            Prisoner prisoner2 = prisoners.get(RandomlyCheat.rng.nextInt(prisoners.size()));
            if (prisoner1 != prisoner2) {
                prisoner1.opponent = prisoner2;
                prisoner2.opponent = prisoner1;
                prisoner1.playOnce();
                prisoner2.playOnce();
            }
        }

        System.out.println("cheater1.score = " + cheater1.score);
        System.out.println("cheater2.score = " + cheater2.score);
        System.out.println("cooperator1.score = " + cooperator1.score);
        System.out.println("cooperator2.score = " + cooperator2.score);
        System.out.println("rando1.score = " + rando1.score);
        System.out.println("rando2.score = " + rando2.score);

    }
}