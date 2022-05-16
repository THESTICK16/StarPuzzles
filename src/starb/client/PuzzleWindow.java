package starb.client;

import javax.swing.*;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PuzzleWindow extends JFrame{
    private PuzzleDrawingPanel graphicsPanel;
    boolean startGame = false;

    public PuzzleWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Star Battle");

        JPanel titlePanel = new JPanel();
        titlePanel.add( new JLabel("Star Battle Puzzle") );
        JPanel startButton = new JPanel();
        JButton start = new JButton("Start New Puzzle");
        JButton check = new JButton("Check");
        

        start.addActionListener(e -> {
            startGame = true;
            graphicsPanel.loadPuzzle();
            puzzleRepaint();
        });

        check.addActionListener(e ->{
            //check solution

        });

        startButton.add(start);
        //if started new puzzle
        if(startGame){
            startButton.add(check);
        }
        

        graphicsPanel = new PuzzleDrawingPanel();

        graphicsPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(graphicsPanel.checkInit()) {
                    graphicsPanel.updateBoard(e.getX(), e.getY());
                    puzzleRepaint();
                }
            }
        });

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(startButton, BorderLayout.SOUTH);
        this.add(graphicsPanel, BorderLayout.CENTER);
        this.pack();
        setResizable(false);
    }


    /**
     * Repaints the PuzzleDrawingPanel which is the portion of the window containing the actual puzzle
     */
    public void puzzleRepaint(){
        graphicsPanel.repaint();
    }

}
