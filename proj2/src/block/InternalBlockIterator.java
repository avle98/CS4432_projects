package block;
import main.Helper;
import java.util.Iterator;
import java.lang.String;

public class InternalBlockIterator implements Iterator<String> {
    private String blockString;
    private int currentPosition;
    private String[] recordStrings;

    /**
     * default constructor
     * @param blockString
     */
    public InternalBlockIterator(String blockString) {
        this.blockString = blockString;
        this.currentPosition = 0;
        this.recordStrings = Helper.splitString(this.blockString, Record.RECORD_SIZE);
    }

    /**
     *
     * @return length of records
     */
    public int getRecordCount() {
        return this.recordStrings.length;
    }

    /**
     * override function
     * @return the current position
     */
    @Override
    public boolean hasNext() {
        return currentPosition < recordStrings.length;
    }

    /**
     * override function
     * @return string of record
     */
    @Override
    public String next() {
        String recordString = recordStrings[currentPosition];
        currentPosition++;
        return recordString;
    }




}