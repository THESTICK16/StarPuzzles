package starb.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import starb.puzzle.Parser;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class PuzzleHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String p = uri.getPath();
        String fileName = p.substring(1);

        starb.puzzle.Parser parse = new Parser();

        String p1 = parse.puzzleFileToString(fileName);

        //send string version of puzzle
        String response = p1; 

        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/plain");

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
