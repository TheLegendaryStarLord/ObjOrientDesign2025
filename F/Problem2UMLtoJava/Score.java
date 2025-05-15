package Problem2UMLtoJava;
import java.util.*;


/**
 * Write a description of class Score here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Score
{
    private List<Note> notes = new ArrayList<>();
    private Instrument instrument;

    public Score(Instrument instrument) {
        this.instrument = instrument;
    }

    public void addNote(Note n) {
        notes.add(n);
    }

    public void play() {
        for (Note n : notes) {
            instrument.playNote(n);
        }
    }
}
