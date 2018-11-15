package shapes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Movement implements MouseMotionListener, MouseListener {
    private int X,Y; //mouse coordinates
    private MyPanel panel;
    private Shape captured;

    public Movement(MyPanel panel) {
        this.panel=panel;
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
        captured=null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        System.out.println("mousePressed");
        for(Shape shape: panel.shapes){
            if(shape.pressed(X,Y)){
                captured=shape;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        captured=null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged");
        if(captured!=null){
            captured.setOffset(e.getX()-X,e.getY()-Y);
            X=e.getX();
            Y=e.getY();
            panel.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");
    }
}
