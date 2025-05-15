package Problem2UMLtoJava;


/**
 * Write a description of class Piano here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piano implements Instrument
{
    @Override
    public void playNote(Note n){
        System.out.println("Piano noises");
    }
}
