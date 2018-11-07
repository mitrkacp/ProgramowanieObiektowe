public class InvalidFormat extends Exception {
    public InvalidFormat(String line) {
        super("Invalid format in line ".concat(line));
    }
}
