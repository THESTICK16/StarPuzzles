package starb.client;

import java.awt.*;
import java.io.IOException;

public class StarbClient {

    public static PuzzleWindow screen = new PuzzleWindow();

    public static void main( String[] args ) throws IOException, InterruptedException {
        
        // Start the GUI
        EventQueue.invokeLater( () -> {
            screen.setVisible(true);
        } );

   
    }
    

}
