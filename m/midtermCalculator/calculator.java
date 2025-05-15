package midtermCalculator;


/**
 * Write a description of class calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;
import javax.swing.*;
import java.util.*;

class calculator extends Model {
    private double accumulator;
    
    public void addCom(double arg) throws Exception {
        accumulator = accumulator + arg;
        System.out.println(accumulator);
        changed();
    }

    public void mulCom(double arg) throws Exception {
        accumulator = accumulator * arg;
        System.out.println(accumulator);
        changed();
    }
    
    //public Iterator<Double> iterator() { return stack.iterator(); }

    public void clearCom() throws Exception{
        accumulator = 0;
        System.out.println(accumulator);
    }
    //HOW THE HELL DO I GET IT TO UPDATE IN VIEW
    public double getaccumulator() {
        return accumulator;
    }
}

