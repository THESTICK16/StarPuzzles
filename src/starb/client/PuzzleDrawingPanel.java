package starb.client;

import starb.puzzle.Coordinate;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(c.checkInit()) {
            if (c.checkWin()) {
                g.setColor(Color.green);
                g.fillRect(0,0,WIDTH,WIDTH);
                g.setColor(Color.black);
            }
        }
        if(c.checkInit()){
            paintBoard(g);
            paintState(g);
        }
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
        //TODO implement in a way that doesn't involve Coordinate class to reduce coupling
        ArrayList<Coordinate> stars = c.getPlacedStars();
        ArrayList<Coordinate> points = c.getPlacedPoints();

        int loopSize = Math.max(stars.size(), points.size());
        int starSizeScale = 4;
        int pointSizeScale = 3;

        for (int i = 0; i < loopSize; i++) {
            if (i < stars.size()) {
                Coordinate currentStar = stars.get(i);
                int paintX = (currentStar.getX() * cellSide) + (cellSide / starSizeScale);
                int paintY = (currentStar.getY() * cellSide) + (cellSide / starSizeScale);
                paintStar(g, paintX, paintY, cellSide / 2);
            }

            if (i < points.size()) {
                Coordinate currentPoint = points.get(i);
                int paintX = (currentPoint.getX() * cellSide) + (cellSide / pointSizeScale);
                int paintY = (currentPoint.getY() * cellSide) + (cellSide / pointSizeScale);
                paintPoint(g, paintX, paintY, cellSide / pointSizeScale);
            }

        }
    }

    private void paintStar(Graphics g, int x, int y, int w){
        //TODO Make cooler shape
        g.fillRect(x,y,w,w);
    }

    private void paintPoint(Graphics g, int x, int y, int w){
        g.fillOval(x,y,w,w);
    }

    public void loadPuzzle(){
        c.loadPuzzle();
    }


    public void updateBoard(int x, int y){
        c.boardClick(x,y);
    }

    public boolean checkInit(){
        if(c.checkInit()){
            return true;
        }
        return false;
    }
}
