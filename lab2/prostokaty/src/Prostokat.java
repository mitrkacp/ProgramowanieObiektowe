public class Prostokat extends Kwadrat {

    double b;

    public Prostokat(double a, double b) {
        super(a);
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    double area(){
        return a*b;
    }

    boolean isBigger(Prostokat p){
        if(p.a * p.b > this.a * this.b)return true;
        return false;
    }
}
