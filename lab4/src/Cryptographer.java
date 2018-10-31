import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File in, PrintWriter out, Algorithm algo){
        Scanner scanner = null;

        try {
            scanner = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
            while (scanner2.hasNext()) {
                String s = scanner2.next();
                out.print(algo.crypt(s));
                out.print(" ");
            }
            out.println();
        }
        out.close();
    }
    public static void decryptfile(File in, PrintWriter out, Algorithm algo){
        Scanner scanner = null;

        try {
            scanner = new Scanner(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
            while (scanner2.hasNext()) {
                String s = scanner2.next();
                out.print(algo.decrypt(s));
                out.print(" ");
            }
            out.println();
        }
        out.close();
    }
}