package starb.client;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleWindow extends JFrame{
    private PuzzleDrawingPanel graphicsPanel;

    public PuzzleWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Star Battle");

        JPanel titlePanel = new JPanel();
        titlePanel.add( new JLabel("Star Battle Puzzle") );
        JPanel startButton = new JPanel();
        JButton start = new JButton("Start New Puzzle");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start Button Clicked!!!!");
                //graphicsPanel.loadPuzzle();
            }
        });

        startButton.add(start);

        graphicsPanel = new PuzzleDrawingPanel();
        
        

        
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(startButton, BorderLayout.SOUTH);
        this.add(graphicsPanel, BorderLayout.CENTER);
        this.pack();
        setResizable(false);
    }

    public void puzzleRepaint(){
        graphicsPanel.repaint();
        //test comment
    }

}
