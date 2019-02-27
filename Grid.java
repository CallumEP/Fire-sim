import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grid extends JPanel {
    private Tile map[][];
    private int width, height,spacing,padding,indexX,indexY;
    // Create a Grid of size X and Y
    public Grid(int width, int height,int spacing,int padding){
        map = new Tile[width][height];

        this.width =width;
        this.height =height;
        this.spacing = spacing;
        this.padding = padding;
        this.indexX = 0 ;
        this.indexY = 0;
        createClick();



    }
    private void createClick(){
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println(e.getX()+", "+e.getY());
            int tempX = e.getX(); int tempY = e.getY();

            if(tempY%spacing != 0){

                tempY = (int)roundDown(tempY,spacing);
            }

            if(tempX%spacing != 0){


            tempX = (int) roundDown(tempX,spacing);}

            System.out.println("after: "+tempX+", "+tempY);
            addTile(new Fire(tempX,tempY));
        }
    });}



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
g.drawRect( x, y, width, height );
}

    private void colourTile(Graphics g,int x ,int y,Color c){
        g.setColor(c);
        g.fillRect(x,y,spacing,spacing);
    }

    private void colourGrid(Graphics g) {
        if (map[0][0] != null) {

            int q = 0 ;
            for (int i = 0; i < map.length; i++) {
                while( map[i][q] != null){
                    Tile current = map[i][q];
                    q++;
                    colourTile(g, current.getX(), current.getY(), current.getColour());}

                }
            }


        }

    public void addTile(Tile t){
        map[indexX][indexY] = t;
        indexY++;
        indexX++;
    }




        }

