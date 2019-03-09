import java.awt.*;
import java.util.Random;

public class Terrian extends Tile{
    private int fuel;
    private int spread;
    Terrian(int x,int y,int spread){
        super(x,y);
        Random r = new Random();
        fuel = r.nextInt(99)+1;
        setColour(createColour());
        this.spread = spread;
    }

    @Override
    Color createColour() {
        int percentage = fuel/10;
        int green =255*percentage/10;
        if(255*percentage/10<50){
            green = 50;}
        return new Color(000,green,000);
    }

    public void setSpread(int spread) {
        this.spread = spread;
    }



    public int getFuel() {
        return fuel;
    }

    public int getSpread() {
        return spread;
    }
}
