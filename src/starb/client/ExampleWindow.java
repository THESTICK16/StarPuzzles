package starb.client;

import javax.swing.*;
import java.awt.*;

public class ExampleWindow extends JFrame {

    private ExampleDrawingPanel graphicsPanel;

    public ExampleWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Example Window");

        JPanel titlePanel = new JPanel();
        titlePanel.add( new JLabel("Example Drawing") );

        graphicsPanel = new ExampleDrawingPanel();

        this.add(graphicsPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.pack();
    }

}
