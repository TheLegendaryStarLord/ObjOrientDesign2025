package Problem2UMLtoJava;


/**
 * Write a description of class OrganAdapter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrganAdapter implements Instrument
{
    private Organ adaptee;
    OrganAdapter(Organ adaptee){
        this.adaptee = adaptee;
    }
    
    @Override
    public void playNote(Note n){
        adaptee.playOrganNote(n);
    }
}
