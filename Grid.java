import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Grid extends JPanel {
    private Tile map[][];
    private int width, height,spacing,padding,counter;

    /** Create a Grid of size X and Y with padding and the size of each tile*/
    public Grid(int width, int height,int spacing,int padding){
        map = new Tile[width/spacing][height/spacing];
        this.width =width;
        this.height =height;
        this.spacing = spacing;
        this.padding = padding;
        this.counter = 0 ;
        createClick();
    }

    /**When a mouseClick 1 is used add a fire object at rounded mouse position */
    private void createClick(){
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            int tempX = e.getX();
            int tempY = e.getY();

           tempX= (nearestTile(tempX)-1)/spacing;
           tempY = (nearestTile(tempY)-1)/spacing;

           if(inGrid(tempX,tempY)){
            addTile(new Fire(tempX,tempY));
           }
           else{System.out.println("out of bounds");}
        }
    });}

    private int nearestTile(int pos){

        if(pos%spacing != 0){
            pos = (int)roundDown(pos,spacing);
            return pos;
        }
        else return pos;
    }


    /**draw the grid and squares*/
    public void paint( Graphics g )
    {
        colourGrid(g);
        drawGrid(g);
        repaint();
    }

    /** round n down to nearest multiple of m */
    long roundDown(long n, long m) {
        return n >= 0 ? (n / m) * m : ((n - m + 1) / m) * m;
    }

    public void updateSize(int height,int width){
        this.width=width;
        this.height=height;
    }

private void drawGrid(Graphics g){
g.setColor(Color.black);
for ( int x = padding; x <= width; x += spacing )
for ( int y = padding; y <= height; y += spacing )
g.drawRect( x, y, spacing, spacing );
}
    /**loop though the tile array and draw all */
    private void colourGrid(Graphics g) {
        if (counter != 0) {
            for (int i = 0; i < map.length; i++) {
                for(int q = 0; q< map.length; q++){
                    if(map[i][q] != null){
                        Tile current = map[i][q];
                        g.setColor(current.getColour());
                        g.fillRect((current.getX()*spacing)+padding,(current.getY()*spacing)+padding,spacing,spacing);
                    }
                   }

                }
            }


        }

/**add a tile to the array in the corresponding location and increment the counter */
    public void addTile(Tile t){

       int y = (t.getY());
        System.out.print("Add tile y: "+y);
        int x =(t.getX());
        System.out.println(" X: "+x);
        map[x][y] = t;
        counter++;
    }

    /** Check if x,y is in the grid*/
    private boolean inGrid(int x, int y){

        if(x > map.length || y> map.length||y<0||x<0){
            return false ;
        }else{
            return true;
        }
    }

    /** Return a list of positions in a selected area*/
    public int[][] getArea(int x,int y,int area){

        /** if the area has a one cell centre*/
        if (area %2 <=0 ){
            return null ;
        }
        else{
            /** How much needs to be subtracted to get the corner of the area*/
           int sub = area/2;

            int [][] list = new int[area*area][2];
            int startX = x -sub;
            int startY = y- sub;
             x =startX;
             y =startY;

            /** for the selected area get the postions and see if there in the range of the grid*/
            for(int i = 0; i<area*area;i++) {

                /** If x is out of the area range then rest x and increment y*/
                if (x >= startX + area) {
                    y++;
                    x = startX;
                }
                /** If not in range of the grid add -1 else if in range add positions*/
                if (inGrid(x,y)==false) {
                    list[i][0] = -1;
                    list[i][1] = -1;
                } else {
                    list[i][0] = x;
                    list[i][1] = y;

                    x++;
                }
            }
            return list ;}
    }

    public void createMap(){
        int mapArea = map.length*map.length;
        System.out.println(mapArea);
        int amountSeeds = mapArea/10;
        System.out.print(amountSeeds);
        Terrian seed [] = new Terrian[amountSeeds];

        for(int i = 0;i<amountSeeds;i++){
            Random r = new Random();
            int randX = r.nextInt(map.length); //random X
            int randY = r.nextInt(map.length); // random Y
            int randSize = r.nextInt((mapArea/amountSeeds)-1)+1; // how much of the grid the terrain takes up


            for(int z=0;z<i;z++){
                if(randX == seed[z].getX() &&randY == seed[z].getY()){

                    randX = r.nextInt(map.length);
                    randY = r.nextInt(map.length);
                    z=0;
                }
            }
            seed[i] = new Terrian(randX,randY,randSize);
            addTile(seed[i]);
        }
    }
        }

