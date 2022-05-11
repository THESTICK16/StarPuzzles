package starb.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class PuzzleDrawingPanel extends JComponent{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 540;

    static final int cols = 10;
    static final int rows = 10;
    static final int originX = 0;
    static final int originY = 0;
    static final int cellSide = 50;

    ClientInteraction c = new ClientInteraction();

    public PuzzleDrawingPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addMouseListener( new DrawPanelMouseListener() );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBoard(g);
    }

    private void paintBoard(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        HashMap<Integer, boolean[]> rowsBold = c.getSectionRow();
        HashMap<Integer, boolean[]> colsBold = c.getSectionCol();

        int x = originX;
        int y = originY;

        //borders
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(originX, originY , originX+ (cols*cellSide), originY );
        g2d.drawLine(originX, originY + (10*cellSide), originX+ (cols*cellSide), originY + (10*cellSide));
        g2d.drawLine(originX , originY, originX, originY + (rows*cellSide));
        g2d.drawLine(originX + (10*cellSide), originY, originX+(10*cellSide), originY + (rows*cellSide));

        //sections ROWS
        for(int i =0; i < rowsBold.size(); i++){

            for(int j = 0; j < rowsBold.size(); j++){
                if(c.getBoldRows(i, j, rowsBold)){
                    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(x, y + cellSide, x+ cellSide, y + cellSide );
                    x += cellSide;
                }
                else{
                    g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(x, y + (cellSide), x+ (cellSide), y + (cellSide));
                    x += cellSide;
                }
            }
            //change row
            y+=cellSide;
            x = originX;
        }
        //reset origin
        x = originX;
        y = originY;

        //sections COLUMNS
        for(int i =0; i < colsBold.size(); i++){

            for(int j = 0; j < colsBold.size(); j++){
                if(c.getBoldCols(i, j, colsBold)){
                    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(x + cellSide, y, x+ cellSide, y + cellSide );
                    y += cellSide;
                }
                else{
                    g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(x+ (cellSide), y , x+ (cellSide), y + (cellSide));
                    y += cellSide;
                }
            }
            //change row
            x+=cellSide;
            y = originY;
        }
    }

    private void paintState(Graphics g){

    }

    private void paintStar(Graphics g, int x, int y, int w){
        g.drawRect(x,y,w,w);
    }

    private void paintPoint(Graphics g, int x, int y, int w){
        g.fillOval(x,y,w,w);
    }

    public void loadPuzzle(){
        c.loadPuzzle();
    }


    private static class DrawPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.printf("Click: (%d, %d)\n", e.getX(), e.getY());
        }
    }
}
