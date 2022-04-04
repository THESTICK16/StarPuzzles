package starb.client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExampleDrawingPanel extends JComponent {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static final String SPOT_IMAGE_FILE = "image/spot_the_cow.png";

    private BufferedImage spotImage;

    public ExampleDrawingPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        try {
            spotImage = ImageIO.read(new File(SPOT_IMAGE_FILE));
        } catch(IOException e) {
            String message = "Unable to load image: " + SPOT_IMAGE_FILE;
            System.err.println(message);
            System.err.println(e.getMessage());
            throw new RuntimeException(message);
        }

        this.addMouseListener( new DrawPanelMouseListener() );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor( new Color(50, 100, 25) );
        g2d.fillRect(10, 10, 100, 100);

        g2d.drawImage(spotImage, 55, 50, this);
    }

    private static class DrawPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.printf("Click: (%d, %d)\n", e.getX(), e.getY());
        }
    }
}
