package pdTourney;


/**
 * Write a description of class RandomlyCheat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class RandomlyCheat implements Strategy
{

    static Random rng = new Random();
    public boolean choose() {
        return rng.nextBoolean();
    }
}
