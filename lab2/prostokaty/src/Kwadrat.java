public class Kwadrat {

    double a;

    public Kwadrat(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    double area(){
        return a*a;
    }

    boolean isBigger(Kwadrat k){
        if(k.a > this.a)return true;
        return false;
    }
}
