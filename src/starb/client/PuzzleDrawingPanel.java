package starb.client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PuzzleDrawingPanel extends JComponent{
    private static final int WIDTH = 650;
    private static final int HEIGHT = 650;

    static final int cols = 10;
    static final int rows = 10;
    static final int originX = 23;
    static final int originY = 37;
    static final int cellSide = 59;

    public PuzzleDrawingPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.addMouseListener( new DrawPanelMouseListener() );
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
        public void mouseClicked(MouseEvent e) {
            System.out.printf("Click: (%d, %d)\n", e.getX(), e.getY());
        }
    }
}
