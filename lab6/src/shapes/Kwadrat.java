package shapes;

import java.awt.*;

public class Kwadrat extends Shape{
    private int x = 10;
    private int y = 300;
    private int size = 100;
    Kwadrat(String name){
        super(name);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(new Color(255,0,0));
        g.fillRect(offsetX+x,offsetY+y,size, size);

    }

    @Override
    public void setOffset(int x,int y){
        this.offsetX+=x;
        this.offsetY+=y;
    }

    @Override
    public boolean pressed(int x, int y){
        return (x <= this.x + this.offsetX + size && x >= this.x + this.offsetX && y <= this.y + this.offsetY+ size &&
                y >= this.y + this.offsetY);
    }


}
