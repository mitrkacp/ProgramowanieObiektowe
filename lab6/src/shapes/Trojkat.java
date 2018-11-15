package shapes;

import java.awt.*;

public class Trojkat extends Shape{
    private int x[] = {10,110,60};
    private int y[] = {120,120,35};
    private Polygon triangle;
    Trojkat(String name){
        super(name);
        triangle = new Polygon(x,y,3);
    }

    @Override
    public void setOffset(int movex,int movey){
        for(int i=0; i<3; i++){
            x[i] += movex;
            y[i] += movey;
        }

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0,255,0));
        g.fillPolygon(new Polygon(x,y,3));
    }

    @Override
    public boolean pressed(int x_, int y_){
        return new Polygon(this.x,this.y,3).contains(x_,y_);
    }

}
