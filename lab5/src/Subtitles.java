import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.io.File;

public class Subtitles {
    public static void delay(File in,PrintWriter out, int delay, int fps) throws InvalidFormat,
            FileNotFoundException {
        String pattern = "\\{(\\d+)\\}\\{(\\d+)\\}(.+)";
        Pattern correct = Pattern.compile(pattern);
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher m = correct.matcher(line);
            StringBuilder result = new StringBuilder();
            if (m.find()) {
                int newStart = Integer.parseInt(m.group(1)) + (delay * fps) / 1000;
                int newEnd = Integer.parseInt(m.group(2)) + (delay * fps) / 1000;
                if (newEnd < newStart) {
                    throw new InvalidFormat(line);
                }
                result.append("{" + newStart + "}{" + newEnd + "}" + m.group(3));
                out.println(result.toString());
            } else throw new InvalidFormat(line);

        }
    }
}
