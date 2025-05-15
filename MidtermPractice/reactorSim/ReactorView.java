package reactorSim;


/**
 * Write a description of class ReactorView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;
import javax.swing.*;



class ReactorView extends View {
    private JTextField thermometer;

    public ReactorView(Model model) {
        super(model);
        thermometer = new JTextField("" + ((Reactor)model).getTemp());
        thermometer.setEditable(false);
        add(thermometer);
        model.subscribe(this);
    }

    @Override
    public void update() {
        thermometer.setText(("" + ((Reactor)model).getTemp()));
    }
}
