package starb.client;

import javax.swing.*;


import java.awt.*;

public class PuzzleWindow extends JFrame{
    private PuzzleDrawingPanel graphicsPanel;

    public PuzzleWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Puzzle Window");

        JPanel titlePanel = new JPanel();
        titlePanel.add( new JLabel("Puzzle Drawing") );

        graphicsPanel = new PuzzleDrawingPanel();
       

        this.add(graphicsPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.pack();
    }

    public void puzzleRepaint(){
        graphicsPanel.repaint();
    }

}
