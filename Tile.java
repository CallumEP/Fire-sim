import java.awt.*;

public  abstract class Tile {
    private int x,y ;
    private Color colour ;

    public  Tile(int x,int y ){
        this.x = x ;
        this.y = y;
        this.colour = Color.red;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColour() {
        return colour;
    }
}
