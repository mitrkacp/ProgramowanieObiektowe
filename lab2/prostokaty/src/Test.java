import java.util.LinkedList;
import java.util.Scanner;

public class Test {

    LinkedList<Prostokat> figury = new LinkedList<Prostokat>();

    public static void main(String[] args){

        Test test = new Test();

        System.out.println("Wybierz polecenie:");
        System.out.println("1) Wczytaj prostakat");
        System.out.println("2) Wyswietl wszystkie prostakaty");
        System.out.println("3) Oblicz sume pol wszystkich prostokatow");
        System.out.println("4) Zakoncz");

        Scanner scanner = new Scanner(System.in);
        int number;
        number = scanner.nextInt();
        double a,b;
        while(number < 4 && number > 0){
            if(number == 1){
                System.out.println("Podaj dl boku a: ");
                a = scanner.nextDouble();
                System.out.println("Podaj dl boku b: ");
                b = scanner.nextDouble();
                Prostokat prostokat = new Prostokat(a,b);
                test.figury.addLast(prostokat);
            }
            else if(number == 2){
                for (Prostokat i: test.figury)
                {
                    System.out.println("Prostokąt "+i.getA()+" x "+i.getB());
                }
            }
            else if (number == 3){
                double sum = 0;
                for (Prostokat i: test.figury)
                {
                    sum = sum + i.area();
                }
                System.out.println("Suma pól: " + sum );
            }
            number = scanner.nextInt();
        }
    }
}
