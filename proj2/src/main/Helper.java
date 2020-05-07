package main;
import java.util.ArrayList;
import java.lang.String;
import java.util.List;

public class Helper {

    public static String padNumber(int number, int length) {
        return String.format("%0" + length + "d", number);
    }

    /**
     *
     * @param blockString
     * @param size
     * @return an arrayList sec
     */
    public static String[] splitString(String blockString, int size) {
        List<String> sec = new ArrayList<String>();
        int length = blockString.length();
        for(int x = 0; x < length; x += size) {
            sec.add(blockString.substring(x, Math.min(length, x + size)));
        }
        return sec.toArray(new String[0]);
    }
