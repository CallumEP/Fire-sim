import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame {
    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);


       Grid g = new Grid(300 ,300,30,30);

        frame.add(g);
        frame.setVisible(true);
            frame.add(g);




    }
}


