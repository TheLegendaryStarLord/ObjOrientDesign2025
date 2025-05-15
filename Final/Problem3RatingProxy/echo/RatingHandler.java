package Problem3RatingProxy.echo;
import java.net.Socket;


/**
 * Write a description of class RatingHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RatingHandler extends ProxyHandler
{
    private Boolean hasRated = false;
    private Rater rater = Rater.getInstance();
    
    @Override
    public String response(String req) throws Exception{
        if (req.startsWith("rate")) {
            if (hasRated) {
                return "you already rated this service";
            }

            try {
                String[] parts = req.split(" ");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid rate command");
                }

                double rating = Double.parseDouble(parts[1]);
                if (rating < 0 || rating > 5) {
                    throw new IllegalArgumentException("Rating out of range");
                }

                rater.addRating(rating);
                hasRated = true;
                return "Thank you";
            } catch (NumberFormatException e) {
                return "Rating out of range";
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        } else if (req.equals("rating")) {
            double avgRating = rater.getAverageRating();
            int numRatings = rater.getNumRatings();
            return String.format("rating = %.3f #ratings = %d", avgRating, numRatings);
        }

        // Delegate to next handler
        return super.response(req);
    }
}

