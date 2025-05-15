package Problem2UMLtoJava;


/**
 * Write a description of class Bach here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bach
{
    public static void main(String[] args) {
        Score pianoScore = new Score(new Piano());
        pianoScore.addNote(new Note(440.0, 1.0));
        pianoScore.addNote(new Note(494.0, 0.5));
        pianoScore.play();

        System.out.println();

        Score organScore = new Score(new OrganAdapter(new Organ()));
        organScore.addNote(new Note(330.0, 2.0));
        organScore.play();
    }
}
