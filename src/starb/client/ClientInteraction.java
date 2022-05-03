package starb.client;



public class ClientInteraction
{

    /*
    *
    */
    public int cellLength(int x, int y)
    {
        //write code here that does the math, and when you call it from the puzzle drawing panel it will
        //have the location automatically.
        //getWidth
        //getHeight / pixels

        //Dimensions of the board.
        int xDim = 550/10; //width of board divided by how many grids gives cell length by pix.
        int yDim = 550/10; //height of board divided by how many grids

        //xcord of mouse click / the length of the cell which will give u what grid youre in.

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
