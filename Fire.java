import java.awt.*;
import java.util.Random;

public class Fire extends Tile {
    private int enrgy ;
    public Fire(int x ,int y){
        super(x,y);
        Random r = new Random();
        this.enrgy =  r.nextInt(99)+1;
        setColour(createColour());
    }
    Color createColour() {
        int percentage = enrgy/10;
        int red =255*percentage/10;
        if(255*percentage/10<50){
            red = 50;}
        return new Color(red,1,000);
    }
}
