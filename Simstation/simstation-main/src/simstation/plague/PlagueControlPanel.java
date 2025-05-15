package simstation.plague;

import simstation.*;
import mvc.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class PlagueControlPanel extends JPanel {
    private PlagueSimulation simulation;
    private JSlider infectedSlider, virulenceSlider, populationSlider, recoverySlider;
    private JCheckBox fatalCheckbox;

    public PlagueControlPanel(PlagueSimulation sim) {
        this.simulation = sim;
        setPreferredSize(new Dimension(300, 200));
        setLayout(new GridLayout(5, 1));
        infectedSlider = new JSlider(0, 100, simulation.startInfected);
        addSlider("Initial % Infected", infectedSlider);
        virulenceSlider = new JSlider(0, 100, simulation.virulence);
        addSlider("Infection Probability", virulenceSlider);
        populationSlider = new JSlider(0, 200, simulation.numAgents);
        addSlider("Population Size", populationSlider);
        recoverySlider = new JSlider(0, 500, simulation.recoveryTime);
        addSlider("Recovery Time", recoverySlider);
        fatalCheckbox = new JCheckBox("Fatal", simulation.fatal);
        fatalCheckbox.addActionListener(e -> simulation.fatal = fatalCheckbox.isSelected());
        add(fatalCheckbox);
    }

    private void addSlider(String label, JSlider slider) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(slider, BorderLayout.CENTER);
        slider.addChangeListener(e -> {
            if (!slider.getValueIsAdjusting()) {
                updateSimulation();
            }
        });
        add(panel);
    }

    private void updateSimulation() {
        simulation.startInfected = infectedSlider.getValue();
        simulation.virulence = virulenceSlider.getValue();
        simulation.numAgents = populationSlider.getValue();
        simulation.recoveryTime = recoverySlider.getValue();
    }
}