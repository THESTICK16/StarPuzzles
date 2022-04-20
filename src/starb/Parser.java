package starb;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.util.Scanner;

public class Parser {

    private File file;
    private int height;
    private int width;
    private int[][] board;

    public Parser(){};

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

    private void readFile(String f){
        try{
            this.file = new File(f);
        }catch(Exception e){
            System.out.println("An error occurred reading the file");
            e.printStackTrace();
        }
    }

    private int[][] parseFile(){
        try{
            StringBuilder sb = new StringBuilder();
            Scanner scan = new Scanner(this.file);
            while(scan.hasNextLine()){
                String data = scan.nextLine();
            }
        }catch(Exception e){
            System.out.println("An error occurred parsing the file.");
            e.printStackTrace();
        }
        return null;
    }




}
