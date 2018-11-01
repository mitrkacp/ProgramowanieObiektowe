public class ROT11 implements Algorithm {
    int ascii;

    @Override
    public String crypt(String in) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            ascii = in.charAt(i);
            if(ascii < 123 && ascii > 96){
                ascii = 97 + ((ascii + 11 - 97) % 26);
            }
            else if(ascii < 91 && ascii > 64){
                ascii = 65 + ((ascii + 11 - 65) % 26);
            }
            out.append((char) ascii);
        }
        return out.toString();
    }

    @Override
    public String decrypt(String in) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            ascii = in.charAt(i);
            if(ascii < 123 && ascii > 96){
                ascii = 122 - ((122 - ascii + 11) % 26);
            }
            else if(ascii < 91 && ascii > 64){
                ascii = 90 - ((90 - ascii + 11) % 26);
            }
            out.append((char) ascii);
        }
        return out.toString();
    }
}
