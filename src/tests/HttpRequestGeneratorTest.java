package tests;

import org.junit.Before;
import org.junit.Test;
import starb.client.HttpRequestGenerator;
import starb.server.StarbServer;

import java.io.IOException;

import static org.junit.Assert.*;

public class HttpRequestGeneratorTest {
    HttpRequestGenerator hrg;

    @Before
    public void setUp() throws Exception {
        hrg = new HttpRequestGenerator();
    }

    @Test
    public void getNewPuzzle() throws IOException, InterruptedException {
        String[] a = new String[0];
        StarbServer.main(a);
        hrg.getNewPuzzle();
    }
}