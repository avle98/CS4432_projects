package Main;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class Helper {


    public static String padNumber(int number, int length) {
        return String.format("%0" + length + "d", number);
    }

    /*
     * Algorithm taken from: https://kodejava.org/how-to-split-a-string-by-a-number-of-characters/
     */
    public static String[] splitString(String blockString, int size) {
        List<String> sections = new ArrayList<String>();

        int length = blockString.length();

        for(int x = 0; x < length; x += size) {
            sections.add(blockString.substring(x, Math.min(length, x + size)));
        }

        return sections.toArray(new String[0]);
    }
