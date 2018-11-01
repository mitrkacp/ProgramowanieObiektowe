import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int szyfrowanie = 0;
        int algorytm = 0;
        File in = new File(args[0]);
        PrintWriter out = null;
        try {
            out = new PrintWriter(args[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner odczyt = new Scanner(System.in);
        System.out.println("1. Szyfrowanie.");
        System.out.println("2. Deszyfrowanie.");
        String choice = odczyt.nextLine();
        if(choice.equals("1")) szyfrowanie = 1;
        else if (choice.equals("2")) szyfrowanie = 2;

        System.out.println("1. ROT11");
        System.out.println("2. Polibiusz");
        choice = odczyt.nextLine();
        if(choice.equals("1")) algorytm = 1;
        else if (choice.equals("2")) algorytm = 2;

        if(algorytm == 1){
            if(szyfrowanie == 1){
                Cryptographer.cryptfile(in, out, new ROT11());
            }
            else if(szyfrowanie == 2){
                Cryptographer.decryptfile(in, out, new ROT11());
            }
        }
        if(algorytm == 2){
            if(szyfrowanie == 1){
                Cryptographer.cryptfile(in, out, new Polibiusz());
            }
            else if(szyfrowanie == 2){
                Cryptographer.decryptfile(in, out, new Polibiusz());
            }
        }
    }
}
