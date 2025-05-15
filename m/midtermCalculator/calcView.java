package midtermCalculator;


/**
 * Write a description of class calcFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mvc.*;
import javax.swing.*;
import java.util.*;



class calcView extends View {
    private JTextField accumText;

    JList<Double> memory;
    DefaultListModel<Double> memModel;
    
    public calcView(Model model) {
        super(model);
        accumText = new JTextField("" + ((calculator)model).getaccumulator());
        accumText.setEditable(false);
        add(accumText);
        model.subscribe(this);
    }

    @Override
    public void update() {
        accumText.setText(("" + ((calculator)model).getaccumulator()));
    }
}
