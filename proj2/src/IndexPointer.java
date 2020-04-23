package index;
import block.Record;

public class IndexPointer {
    private int fileNumber;
    private int recordNumber;

    /**
     * default constructor
     * @param fileNumber
     * @param recordNumber
     */
    public IndexPointer(int fileNumber, int recordNumber) {
        this.fileNumber = fileNumber;
        this.recordNumber = recordNumber;
    }

    /**
     *
     * @return recordNumber
     */
    public int getRecordNumber() {
        return recordNumber;
    }

    /**
     *
     * @return fileNumber
     */
    public int getFileNumber() {
        return fileNumber;
    }

}