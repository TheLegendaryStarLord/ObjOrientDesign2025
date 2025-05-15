package Problem2UMLtoJava;


/**
 * Write a description of class Trumpet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trumpet implements Instrument
{
    @Override
    public void playNote(Note n){
        System.out.println("Trumpet noises");
    }
}
