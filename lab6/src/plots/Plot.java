package plots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Plot extends JPanel implements ActionListener {
    private static final int size = 600;
    private int a_=1,b_=0,c_=0,from_ = -10,to_ = 10,scale_=100;
    private JTextField a = new JTextField("1",3);
    private JTextField b = new JTextField("0",3);
    private JTextField c = new JTextField("0",3);
    private JTextField scale = new JTextField("50",3);
    private JTextField from = new JTextField("-10",3);
    private JTextField to = new JTextField("10",3);
    private JButton ok = new JButton("rysuj");

    public Plot() {
        setPreferredSize(new Dimension(size, size));

    }

    @Override
    protected void paintComponent(Graphics g) {
        a.setLocation(20, size-50);
        b.setLocation(60, size-50);
        c.setLocation(100, size-50);
        scale.setLocation(380, size-50);
        from.setLocation(420, size-50);
        to.setLocation(460, size-50);
        ok.setLocation(size - 100, size - 50);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        scale.addActionListener(this);
        from.addActionListener(this);
        to.addActionListener(this);
        ok.addActionListener(this);
        add(a);
        add(b);
        add(c);
        add(scale);
        add(from);
        add(to);
        add(ok);
        super.paintComponent(g);
        int valuePrev, argPrev, arg = 0, value = 0;
        double x;
        double y;
        double step = 1/(double)scale_;
        for (x = (double)from_; x <= (double)to_; x += step) {
            valuePrev = value;
            argPrev = arg;

            y = a_ * x * x + b_ * x + c_;



            arg = (int)(x * scale_) + size / 2;
            value = (int)(-y * scale_) + size / 2;


            g.setColor(new Color(0,0,255));
            if (argPrev != 0) {
                g.drawLine(arg, value, argPrev, valuePrev);
            }
            g.setColor(new  Color(0, 0, 0) );
            g.drawLine(0, size / 2, size, size / 2);
            g.drawLine(size / 2, 0, size / 2, size);

        }
        g.drawString("x", size - 10, size / 2);
        g.drawString("y", size / 2 + 10, 10);
        g.drawString("a", 25, size-55);
        g.drawString("b", 65, size-55);
        g.drawString("c", 105, size-55);
        g.drawString("scale", 380,size-55);
        g.drawString("from", 420,size-55);
        g.drawString("to",460 ,size-55);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
            a_=Integer.parseInt(a.getText());
            b_=Integer.parseInt(b.getText());
            c_=Integer.parseInt(c.getText());
            from_=Integer.parseInt(from.getText());
            to_=Integer.parseInt(to.getText());
            scale_=Integer.parseInt(scale.getText());
            repaint();
        }

    }

}
