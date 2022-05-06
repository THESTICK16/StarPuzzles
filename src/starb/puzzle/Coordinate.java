package starb.puzzle;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return x + "," + y;
    }

    /**
     * @param c coordinate to compare
     * @return true if the coordinates are the same
     */
    public boolean compareCoord(Coordinate c) {
        if (this.x == c.getX() && this.y == c.getY()) {
            return true;
        }
        return false;
    }

}


