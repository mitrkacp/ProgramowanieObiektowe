import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String pathIn;
        String pathOut;
        int delay_ms;
        int fps;
        try {
            pathIn = args[0];
            pathOut = args[1];
            delay_ms = Integer.parseInt(args[2]);
            fps = Integer.parseInt(args[3]);
            /*test
            pathIn = "C:\\Users\\Admin\\Desktop\\gravity.txt";
            pathOut = "C:\\Users\\Admin\\Desktop\\wynik.txt";
            delay_ms = 2000;
            fps = 60;*/
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Wrong args");
            return;
        }
        if (fps < 0) {
            System.err.println("Framerate can't be negative");
        }
        PrintWriter outputFile = null;
        try {
            outputFile = new PrintWriter(pathOut);
        } catch (FileNotFoundException e) {
            System.err.println("Invalid Path: " + pathOut);
            return;
        }
        File in = new File(pathIn);

        try {
            Subtitles.delay(in, outputFile, delay_ms, fps);
        } catch (InvalidFormat e) {
            System.err.println(e.getMessage());
            return;
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

        outputFile.close();
    }
}
