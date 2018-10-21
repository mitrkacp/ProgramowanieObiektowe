public class Pesel {

    public static boolean check(String pesel) {

        char[] stringToCharArray = pesel.toCharArray();
        int sum = 9 * Character.getNumericValue(stringToCharArray[0]) + 7 * Character.getNumericValue(stringToCharArray[1])
                + 3 * Character.getNumericValue(stringToCharArray[2]) + 1 * Character.getNumericValue(stringToCharArray[3])
                + 9 * Character.getNumericValue(stringToCharArray[4]) + 7 * Character.getNumericValue(stringToCharArray[5])
                + 3 * Character.getNumericValue(stringToCharArray[6]) + 1 * Character.getNumericValue(stringToCharArray[7])
                + 9 * Character.getNumericValue(stringToCharArray[8]) + 7 * Character.getNumericValue(stringToCharArray[9]);

        if (Character.getNumericValue(stringToCharArray[10]) == sum % 10) return true;
        return false;
    }
}