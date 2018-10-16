public class Kwadrat {

    protected double a;

    public Kwadrat(double a) {
        if(a < 0)
            System.out.println("bok nie moze miec wartosci ujemnej");
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
