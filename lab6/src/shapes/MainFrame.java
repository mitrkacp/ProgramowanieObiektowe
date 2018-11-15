package shapes;

import javax.swing.*;


public class MainFrame extends JFrame{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public MainFrame(){
        super("Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
    }

    public static void main(String[] argv){
        MyPanel panel = new MyPanel();
        panel.shapes.add(new Kwadrat("r1"));
        panel.shapes.add(new Kolo("c1"));
        panel.shapes.add(new Trojkat("t1"));
        Movement movement = new Movement(panel);
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

    }
}
