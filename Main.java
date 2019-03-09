import javax.swing.*;



public class Main extends JFrame {
    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(1920 ,1080);

       Grid g = new Grid(1000 ,1000,5,5);
       g.createMap();

       g.getArea(9,9,3);
        frame.add(g);
        frame.setVisible(true);
            frame.add(g);




    }
}


