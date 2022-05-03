package starb.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import starb.puzzle.Parser;
<<<<<<< HEAD
import starb.puzzle.PuzzleAdt;
=======
>>>>>>> 906a4c6b97cdc14c2bc40278bb38f4ed9810f6da

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class PuzzleHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String p = uri.getPath();
        String fileName = p.substring(1);

<<<<<<< HEAD
        Parser parse = new Parser();
        String p1 = parse.toString();// getData().toString(); FIXME update to new parser methods
=======
        starb.puzzle.Parser parse = new Parser();
>>>>>>> 906a4c6b97cdc14c2bc40278bb38f4ed9810f6da

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
