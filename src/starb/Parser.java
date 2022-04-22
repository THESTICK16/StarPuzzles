package starb;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Parser {

    private File file;
    private int dimension;
    private int numStars;
    private TreeMap<Integer,ArrayList<Coordinate>> inv = new TreeMap<>();
    private ArrayList<Coordinate> solutions = new ArrayList<>();

    public Parser(){};

    public Parser(String fileString){
        readFile(fileString);
        parseFile();
    };

    public TreeMap<Integer,ArrayList<Coordinate>> getData(){
        return inv;
    }

    public int getStars() {
        return numStars;
    }

    public int getDimension(){
        return dimension;
    }

    public TreeMap<Integer,ArrayList<Coordinate>> getInv(){
        return inv;
    }

    public ArrayList<Coordinate> getSolutions(){
        return solutions;
    }

    public File getFile() {
        return file;
    }

    public void readFile(String f){
        try{
            this.file = new File(f);
        }catch(Exception e){
            System.out.println("An error occurred reading the file");
            e.printStackTrace();
        }
    }

    /**
     * Updates the puzzles dimension data from the string of the second line in the puzzle file
     * @param s String of the puzzle dimension data (ex: 10 2)
     */
    public void parsePuzzleData(String s){
        int spacePosition = -1;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                spacePosition = i;
                break;
            }
        }

        StringBuilder dimension = new StringBuilder();
        for(int i = 0; i < spacePosition; i++){
            dimension.append(s.charAt(i));
        }
        this.dimension = Integer.parseInt(dimension.toString());

        StringBuilder stars = new StringBuilder();
        for(int i = spacePosition+1; i < s.length(); i++){
            stars.append(s.charAt(i));
        }
        this.numStars = Integer.parseInt(stars.toString());
    }

    /**
     * @param s String of coordinate pairs (found in puzzle file)
     * @return Arraylist of coordinate pairs
     */
    public ArrayList<Coordinate> parseCoordinates(String s){
        ArrayList<Coordinate> list = new ArrayList<>();

        StringBuilder coordinate = new StringBuilder();

        CharacterIterator it = new StringCharacterIterator(s);

        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j) != ' '){
                coordinate.append(s.charAt(j));
            }else{
                String coord = coordinate.toString();
                coordinate.setLength(0);
                int comma = -1;

                for(int i = 0; i < coord.length(); i++){
                    if(coord.charAt(i) == ','){
                        comma = i;
                        break;
                    }
                }

                StringBuilder x = new StringBuilder();
                for(int i = 0; i < comma; i++){
                    x.append(coord.charAt(i));
                }

                StringBuilder y = new StringBuilder();
                for(int i = comma+1; i < coord.length(); i++){
                    y.append(coord.charAt(i));
                }

                Coordinate c = new Coordinate(Integer.parseInt(x.toString()),Integer.parseInt(y.toString()));
                list.add(c);
            }
        }

        String coord = coordinate.toString();
        coordinate.setLength(0);
        int comma = -1;

        for(int i = 0; i < coord.length(); i++){
            if(coord.charAt(i) == ','){
                comma = i;
                break;
            }
        }

        StringBuilder x = new StringBuilder();
        for(int i = 0; i < comma; i++){
            x.append(coord.charAt(i));
        }

        StringBuilder y = new StringBuilder();
        for(int i = comma+1; i < coord.length(); i++){
            y.append(coord.charAt(i));
        }

        Coordinate c = new Coordinate(Integer.parseInt(x.toString()),Integer.parseInt(y.toString()));
        list.add(c);

        return list;
    }


    /**
     * @param f file to check
     * @return int count, number of total lines in the file
     */
    public int numFileLines(File f){
        int count = 0;
        try{
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                count++;
                scan.nextLine();
            }
        }catch (Exception e){
            System.out.println("An error occurred counting the lines");
            e.printStackTrace();
        }
        return count;
    }


    /**
     * Function to combine all other functionality of the class to update the data
     * storage with data from string format
     */
    private void parseFile(){
        try{
            Scanner scan = new Scanner(getFile());
            int line = 0;
            int boardCount = 1;
            int numLines = numFileLines(getFile());
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                if(line == 1){
                    parsePuzzleData(data);
                }
                if (line > 1 && line < numLines-2) {
                    ArrayList<Coordinate> l = new ArrayList<>();
                    l = parseCoordinates(data);

                    inv.put(boardCount,l);
                    boardCount++;
                }
                if(line == numLines-1){
                    ArrayList<Coordinate> l = new ArrayList<>();
                    this.solutions = parseCoordinates(data);
                }
                line++;
            }
        }catch(Exception e){
            System.out.println("An error occurred parsing the file.");
            e.printStackTrace();
        }
    }



}
