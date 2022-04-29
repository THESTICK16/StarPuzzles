package starb.client;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StarbClient {

    public static void main( String[] args ) throws IOException, InterruptedException {
        // Start the GUI
        EventQueue.invokeLater( () -> {
            new PuzzleWindow().setVisible(true);
        } );

        //create the client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000"))
                .header("Content-Type", "text/plain")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response status: " + response.statusCode());    
        System.out.println("Response body: " + response.body());
    }
    

}
