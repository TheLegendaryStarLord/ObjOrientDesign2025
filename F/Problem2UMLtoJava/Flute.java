package Problem2UMLtoJava;


/**
 * Write a description of class Flute here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flute implements Instrument
{
    @Override
    public void playNote(Note n){
        System.out.println("Flute noises");
    }
}
