package Problem3RatingProxy.echo;
import java.io.Serializable;


/**
 * Write a description of class Message here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Message<T extends Serializable> implements Serializable {
       T content;
       public Message(T content) {
         this.content = content;
       }
       public String toString() {
         return "[" + content + "]";
       }
    }