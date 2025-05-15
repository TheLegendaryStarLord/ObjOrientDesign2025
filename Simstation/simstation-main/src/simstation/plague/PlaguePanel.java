package simstation.plague;

import simstation.*;
import mvc.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaguePanel extends WorldPanel implements ChangeListener {
    JPanel sliderPanel = new JPanel();
    JSlider infectedSlider, virulenceSlider, popSlider, recoverySlider;
    JButton fatalToggle;

    public PlaguePanel(WorldFactory factory) {
        super(factory);
        sliderPanel.setLayout(new GridLayout(5, 1));
        sliderPanel.setOpaque(false);

        PlagueSimulation sim = (PlagueSimulation)getModel();

        infectedSlider = new JSlider(0, 100, sim.startInfected);
        infectedSlider.setMajorTickSpacing(10);
        infectedSlider.setPaintTicks(true);
        infectedSlider.setPaintLabels(true);
        infectedSlider.setLabelTable(infectedSlider.createStandardLabels(10));
        infectedSlider.addChangeListener(this);

        virulenceSlider = new JSlider(0, 100, sim.virulence);
        virulenceSlider.setMajorTickSpacing(10);
        virulenceSlider.setPaintTicks(true);
        virulenceSlider.setPaintLabels(true);
        virulenceSlider.setLabelTable(virulenceSlider.createStandardLabels(10));
        virulenceSlider.addChangeListener(this);

        popSlider = new JSlider(0, 200, sim.numAgents);
        popSlider.setMajorTickSpacing(20);
        popSlider.setPaintTicks(true);
        popSlider.setPaintLabels(true);
        popSlider.setLabelTable(popSlider.createStandardLabels(20));
        popSlider.addChangeListener(this);

        recoverySlider = new JSlider(0, 500, sim.recoveryTime);
        recoverySlider.setMajorTickSpacing(50);
        recoverySlider.setPaintTicks(true);
        recoverySlider.setPaintLabels(true);
        recoverySlider.setLabelTable(recoverySlider.createStandardLabels(50));
        recoverySlider.addChangeListener(this);

        fatalToggle = new JButton(sim.fatal ? "Fatal" : "Not Fatal");
        fatalToggle.addActionListener(e -> {
            sim.fatal = !sim.fatal;
            fatalToggle.setText(sim.fatal ? "Fatal" : "Not Fatal");
            sim.changed();
        });

        addLabeledSlider("Initial % Infected", infectedSlider);
        addLabeledSlider("Infection Probability", virulenceSlider);
        addLabeledSlider("Initial Population Size", popSlider);
        addLabeledSlider("Fatality/Recovery Time", recoverySlider);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(fatalToggle);
        sliderPanel.add(buttonPanel);

        controlPanel.add(sliderPanel, BorderLayout.SOUTH);
    }

    private void addLabeledSlider(String label, JSlider slider) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        JLabel sliderLabel = new JLabel(label, SwingConstants.CENTER);
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setOpaque(false);
        labelPanel.add(sliderLabel);
        panel.add(labelPanel, BorderLayout.NORTH);

        panel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(panel);
    }

    public void stateChanged(ChangeEvent e) {
        PlagueSimulation sim = (PlagueSimulation) getModel();
        if (e.getSource() == infectedSlider) {
            sim.startInfected = infectedSlider.getValue();
        } else if (e.getSource() == virulenceSlider) {
            sim.virulence = virulenceSlider.getValue();
        } else if (e.getSource() == popSlider) {
            sim.numAgents = popSlider.getValue();
        } else if (e.getSource() == recoverySlider) {
            sim.recoveryTime = recoverySlider.getValue();
        }
        System.out.println("Initial % Infected: " + sim.startInfected);
        System.out.println("Infection Probability: " + sim.virulence);
        System.out.println("Initial Population Size: " + sim.numAgents);
        System.out.println("Recovery Time: " + sim.recoveryTime);
        sim.changed();
        update();
    }

    public void update() {
        PlagueSimulation sim = (PlagueSimulation) getModel();
        infectedSlider.setValue(sim.startInfected);
        virulenceSlider.setValue(sim.virulence);
        popSlider.setValue(sim.numAgents);
        recoverySlider.setValue(sim.recoveryTime);
        fatalToggle.setText(sim.fatal ? "Fatal" : "Not Fatal");
        repaint();
    }
}