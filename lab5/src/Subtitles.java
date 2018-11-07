import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtitles {
    public static String delay(String in,int delay, int fps) throws InvalidFormat{
        String pattern = "\\{(\\d+)\\}\\{(\\d+)\\}(.+)";
        Pattern correct = Pattern.compile(pattern);
        Matcher m = correct.matcher(in);
        StringBuilder result = new StringBuilder();

        if(m.find()) {
            int newStart = Integer.parseInt(m.group(1)) + (delay * fps) / 1000;
            int newEnd = Integer.parseInt(m.group(2)) + (delay * fps) / 1000;
            result.append("{"+newStart+"}{"+newEnd+"}"+m.group(3));
            return result.toString();
        } else throw new InvalidFormat(in);
    }
}
