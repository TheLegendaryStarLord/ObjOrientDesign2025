package simstation;

import mvc.*;


        import javax.swing.*;
        import java.awt.*;
        import java.util.*;

public class WorldPanel extends AppPanel {


    //private Timer timer;
    public JPanel threadPanel = new JPanel();

    public WorldPanel(WorldFactory factory) {

        super(factory);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        controlPanel.setBackground(Color.pink);
        this.setPreferredSize(new Dimension(1000, 600));



        threadPanel.setLayout(new GridLayout(1, 5));
        threadPanel.setOpaque(false);



        JPanel p = new JPanel();
        p.setOpaque(false);
        JButton button = new JButton("Start");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Pause");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Resume");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stop");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stats");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        controlPanel.setLayout(new BorderLayout());

        p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);


        //controlPanel.add(threadPanel, BorderLayout.NORTH);
        controlPanel.add(p,  BorderLayout.NORTH);
        //makeControlPanel();
        //this.setPreferredSize(this.getPreferredSize());
        //frame.setSize(frame.getPreferredSize());
    }



    public void setModel(Model m) {
        super.setModel(m);
        World w = (World)m;
        Iterator<Agent> it = w.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
    }

    //protected View getView(Model model) { return new SimulationView(model); }

    public void update() {
        // repaint();
    }

    public void addControlPanel(JPanel customControls) {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(customControls, BorderLayout.CENTER);

        controlPanel.add(wrapper, BorderLayout.SOUTH);
        controlPanel.revalidate();
        controlPanel.repaint();
    }



}

