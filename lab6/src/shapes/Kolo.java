package shapes;

import java.awt.*;

public class Kolo extends Shape{
    private int x = 10;
    private int y = 200;
    private int r = 100;
    Kolo(String name){
        super(name);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0,0,255));
        g.fillOval(offsetX+x,offsetY+y,r,r);
    }

    @Override
    public void setOffset(int x,int y){
        this.offsetX+=x;
        this.offsetY+=y;
    }

    @Override
    public boolean pressed(int x, int y){
        return (x <= this.x + this.offsetX + r && x >= this.x + this.offsetX && y <= this.y + this.offsetY + r &&
                y >= this.y + this.offsetY);
    }
}
