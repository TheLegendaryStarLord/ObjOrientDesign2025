package pdTourney;


/**
 * Write a description of class Prisoner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Prisoner {
    Prisoner opponent = null;
    int score = 0;
    Strategy myStrategy;

    void playOnce() {
        boolean cooperate = myStrategy.choose();
        boolean opponentCooperate = opponent.myStrategy.choose();
        if (cooperate) {
            if (opponentCooperate) {
                score += 3;
                opponent.score += 3;
            } else {
                opponent.score += 5;
                // I get 0
            }
        } else {
            if (opponentCooperate) {
                score += 5;
                // opponent gets 0
            } else {
                score += 1;
                opponent.score += 1;
            }

        }
    }
}
