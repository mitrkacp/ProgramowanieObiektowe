package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {
    LinkedList<Shape> shapes;

    MyPanel(LinkedList<Shape> shapes_){
        shapes = new LinkedList<>();
        for(Shape shape: shapes_){
            shapes.add(shape);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
        for(Shape s: shapes) {
            s.draw(g);
        }
    }
}
