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

    public boolean equals(Coordinate compareTo) {
        if (this.getX() == compareTo.getX() && this.getY() == compareTo.getY()) {
            return true;
        }
        return false;
    }
}


