import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nrPesel;
        Scanner odczyt = new Scanner(System.in);
        nrPesel = odczyt.nextLine();
        if (Pesel.check(nrPesel)) {

            System.out.println("pesel poprawny");
        } else {

            System.out.println("pesel bledny");
        }
    }
}
