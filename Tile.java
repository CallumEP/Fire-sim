import java.awt.*;

public  abstract class Tile {
    private int x,y ;
    private Color colour ;

    public  Tile(int x,int y){
        this.x = x ;
        this.y = y;
        this.colour = Color.white;
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
    public void setColour(Color c){
        this.colour = c;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    abstract Color createColour();
}
