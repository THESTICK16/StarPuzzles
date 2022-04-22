package starb;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Parser {

    private File file;
    private int dimension;
    private TreeMap<Integer,ArrayList<Coordinate>> inv = new TreeMap<>();
    private ArrayList<Coordinate> solutions = new ArrayList<>();

    public Parser(){};

    public int getDimension(){
        return dimension;
    }

    public TreeMap<Integer,ArrayList<Coordinate>> getInv(){
        return inv;
    }

    public ArrayList<Coordinate> getSolutions(){
        return solutions;
    }

    private void readFile(String f){
        try{
            this.file = new File(f);
        }catch(Exception e){
            System.out.println("An error occurred reading the file");
            e.printStackTrace();
        }
    }

    private void parseFile(){
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
    }




}
