package Block;

import java.util.Iterator;
import java.lang.String;
import main.Helper;

public class InternalBlockIterator implements Iterator<String> {
    private String blockString;
    private int currentPosition;
    private String[] recordStrings;

    public InternalBlockIterator(String blockString) {
        this.blockString = blockString;
        this.currentPosition = 0;
        this.recordStrings = Helper.splitString(this.blockString, Record.RECORD_SIZE);
    }

    @Override
    public boolean hasNext() {
        return currentPosition < recordStrings.length;
    }

    @Override
    public String next() {
        String recordString = recordStrings[currentPosition];
        currentPosition++;
        return recordString;
    }

    public int getRecordCount() {
        return this.recordStrings.length;
    }


}