package echo;


/**
 * Write a description of class Rater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rater
{
    private static final Rater instance = new Rater();
    private double numRatings = 0;
    private double ratingTotal = 0;

    private Rater() {}

    public static Rater getInstance() {
        return instance;
    }

    public void addRating(double rating) {
        ratingTotal += rating;
        numRatings++;
    }

    public double getAverageRating() {
        return numRatings == 0 ? 0 : ratingTotal / numRatings;
    }

    public int getNumRatings() {
        return (int) numRatings;
    }
}
