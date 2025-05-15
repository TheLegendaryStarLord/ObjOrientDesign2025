package simstation.greed;

import simstation.*;
import mvc.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class GreedPanel extends WorldPanel implements ChangeListener {
    private JSlider greedSlider, growSlider, moveSlider;

    public GreedPanel(WorldFactory factory) {
        super(factory);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(7, 1));
        sliderPanel.setOpaque(false);

        greedSlider = makeSlider("Greed:", 0, 100, Cow.greediness);
        growSlider = makeSlider("Grow back rate:", 0, 10, Patch.growBackRate);
        moveSlider = makeSlider("Move Energy:", 0, 50, Meadow.moveEnergy);

        sliderPanel.add(makeLabeledPanel("Greed:", greedSlider));
        sliderPanel.add(makeLabeledPanel("Grow back rate:", growSlider));
        sliderPanel.add(makeLabeledPanel("Move Energy:", moveSlider));

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.add(sliderPanel, BorderLayout.CENTER);

        controlPanel.add(wrapper, BorderLayout.SOUTH);

        greedSlider.addChangeListener(this);
        growSlider.addChangeListener(this);
        moveSlider.addChangeListener(this);
    }

    private JPanel makeLabeledPanel(String label, JSlider slider) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(label, SwingConstants.CENTER);
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);
        panel.setOpaque(false);
        return panel;
    }

    private JSlider makeSlider(String name, int min, int max, int value) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, value);
        slider.setMajorTickSpacing((max - min) / 5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    public void stateChanged(ChangeEvent e) {
        Cow.greediness = greedSlider.getValue();
        Patch.growBackRate = growSlider.getValue();
        Meadow.moveEnergy = moveSlider.getValue();

        // Debug output
        System.out.println("Greediness: " + Cow.greediness);
        System.out.println("Grow Back Rate: " + Patch.growBackRate);
        System.out.println("Move Energy: " + Meadow.moveEnergy);
    }

    public void update() {
        greedSlider.setValue(Cow.greediness);
        growSlider.setValue(Patch.growBackRate);
        moveSlider.setValue(Meadow.moveEnergy);
        repaint();
    }
}
