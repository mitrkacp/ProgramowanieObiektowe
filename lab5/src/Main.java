import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathIn;
        String pathOut;
        int delay_ms;
        int framerate;
        try {
            pathIn = args[0];
            pathOut = args[1];
            delay_ms = Integer.parseInt(args[2]);
            framerate = Integer.parseInt(args[3]);
            /*test 
            pathIn = "C:\\Users\\Admin\\Desktop\\gravity.txt";
            pathOut = "C:\\Users\\Admin\\Desktop\\wynik.txt";
            delay_ms = 2000;
            framerate = 60;*/
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Wrong args");
            return;
        }
        if (framerate < 0) {
            System.err.println("Framerate can't be negative");
        }
        File in = new File(pathIn);
        PrintWriter OutputFile = null;
        try {
            OutputFile = new PrintWriter(pathOut);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid Path: " + pathOut);
            return;
        }
        Scanner sc = null;
        try {
            sc = new Scanner(in);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid Path: " + pathIn);
            return;
        }
        while (sc.hasNextLine()) {
            try {
                OutputFile.println(Subtitles.delay(sc.nextLine(), delay_ms, framerate));
            } catch (InvalidFormat e) {
                System.err.println(e.getMessage());
                return;
            }
        }
        OutputFile.close();
    }
}
