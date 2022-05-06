package starb.client;



public class ClientInteraction {

    private ClientGameState g;

    public ClientInteraction(){

    }

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
    public void boardClick() {
        /* TODO get coordinate x and y of board click in relation to grid coordinate
        int x
        int y
        if(g.getSquare(x,y) == SPACE){
            g.setStar(x,y)
            draw g.getGameState()
        }else if(g.getSquare(x,y) == STAR){
            g.setPoint(x,y)
            draw g.getGameState()
        }else{
            g.setSpace(x,y)
            draw g.getGameState()
        */

    }

    /*
    * This will load a puzzle in. If the user mouse click on the button to load a puzzle in, this method
    * will send a request to the server to load a new puzzle in.
    */
    public void loadPuzzle() {
        // String puzzleString = TODO Get puzzle from server
        // g = new ClientGameState(puzzleString);
        // draw g.getBoard() TODO draw method
    }

}
