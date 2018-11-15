package shapes;

import javax.swing.*;
import java.util.LinkedList;


public class MainFrame extends JFrame{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public MainFrame(JPanel panel){
        super("Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setContentPane(panel);
    }

    public static void main(String[] argv){
        LinkedList<Shape> shapes = new LinkedList<>();
        shapes.add(new Kwadrat("r1"));
        shapes.add(new Kolo("c1"));
        shapes.add(new Trojkat("t1"));
        MyPanel panel = new MyPanel(shapes);
        Movement movement = new Movement(panel);
        MainFrame frame = new MainFrame(panel);

    }
}
