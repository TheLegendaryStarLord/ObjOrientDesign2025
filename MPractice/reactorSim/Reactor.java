package reactorSim;


/**
 * an attempt at MidtermPractice
 *
 * @author Adam Sanchez
 * @version 1.0
 */

import mvc.*;
import javax.swing.*;

class Reactor extends Model {
    private int temperature = 4500;
    public static int maxTemperature = 5000;

    public void incTemp() throws Exception {
        temperature += Utilities.rng.nextInt(100);
        //System.out.println(temperature);
        if (temperature > maxTemperature) throw new Exception("Reactor too hot!");
        
        changed();
    }

    public void decTemp() throws Exception {
        temperature -= Utilities.rng.nextInt(100);
        if (temperature > maxTemperature) throw new Exception("Reactor too hot!");
        //System.out.println(temperature);
        changed();
    }

    
    
    public int getTemp() {
        return temperature;
    }
}
