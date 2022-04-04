package starb.client;

import java.awt.*;

public class StarbClient {

    public static void main( String[] args ) {
        // Start the GUI
        EventQueue.invokeLater( () -> {
            new ExampleWindow().setVisible(true);
        } );
    }

}
