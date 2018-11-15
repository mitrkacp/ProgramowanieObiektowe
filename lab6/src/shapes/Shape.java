package shapes;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    public String name;
    public int offsetX,offsetY;

    public abstract void draw(Graphics g);
    Shape(String name){
        this.name = name;
        this.offsetY=0;
        this.offsetX=0;
    }
    public abstract void setOffset(int x,int y);
    public abstract boolean pressed(int x, int y);
}
