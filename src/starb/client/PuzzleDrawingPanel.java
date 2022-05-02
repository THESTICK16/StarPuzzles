package starb.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PuzzleDrawingPanel extends JComponent{
    private static final int WIDTH = 550;
    private static final int HEIGHT = 550;

    static final int cols = 10;
    static final int rows = 10;
    static final int originX = 10;
    static final int originY = 10;
    static final int cellSide = 50;

    public PuzzleDrawingPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addMouseListener( new DrawPanelMouseListener() ); //this would be new ClientInteraction object and you would re override the bottom method
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < rows + 1; i++){
            g.drawLine(originX, originY + (i * cellSide), originX+(cols * cellSide), originY + (i * cellSide));
        }

        for(int i = 0; i < cols + 1; i++){
            g.drawLine(originX + (i * cellSide), originY, originX+(i * cellSide), originY + (rows * cellSide));
        }
       

        
    }

    private static class DrawPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            System.out.printf("Click: (%d, %d)\n", e.getX(), e.getY());
        }
    }
}
//call client interaction from this existing handler, or ^^