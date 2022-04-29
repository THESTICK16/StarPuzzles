package starb.client;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StarbClient {

    public static PuzzleWindow screen= new PuzzleWindow();

    public static void main( String[] args ) throws IOException, InterruptedException {
        
        // Start the GUI
        EventQueue.invokeLater( () -> {
            screen.setVisible(true);
        } );

        //create the client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000"))
                .header("Content-Type", "text/plain")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //response is puzzle in string format


        //create board with sections
        //repaint 
        screen.puzzleRepaint();

   
    }
    

}
