package starb.client;



public class ClientInteraction
{

    /*
    * Determines what cell the mouse click is in.
    * @Param: x cord, y cord,
    * I am thinking of I get the location of the mouse click, example(x coordinate 40, y coordinate 60),
    * then I divide it by 10, each of them, and if it falls between a certain index, that is the grid they
    * are in. so 40/10, and 60/10, they are in location 4 grid over, 6 grid down.
    */
    public int mouseClickLocation(int x, int y)
    {
        //write code here that does the math, and when you call it from the puzzle drawing panel it will
        //have the location automatically.
        //getWidth
        //getHeight / pixels



        return 0;
    }
    /*
    * Determines if the user adds a star to the grid or not based on mouse click.
    * @Param: grid location? call alterboard. gamestate.star or whatever
    */
    public int addStar()
    {


        return 0;
    }

    /*
    * This will load a puzzle in. If the user mouse click on the button to load a puzzle in, this method
    * will send a request to the server to load a new puzzle in.
    */
    public void loadPuzzle()
    {

    }

}
