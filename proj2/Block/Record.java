package Block;

public class Record {

    public final static int RECORD_SIZE = 40;
    private int fileNumber;
    private int recordNumber;
    private int randomV;
    private String address;
    private String name;

    public Record(int fileNumber, int recordNumber, int randomV, String address, String name) {
        this.fileNumber = fileNumber;
        this.recordNumber = recordNumber;
        this.randomV = randomV;

        this.address = address;
        this.name = name;
    }

    public int getFileNumber() { return fileNumber; }
    public int getRecordNumber() { return recordNumber; }
    public int getRandomValue() { return randomV; }

    public String toString() {
        return null;
    }

    public static Record parseRecord(String query_string) {
        String[] parts = query_string.split(", ");
        int fileNumber = Integer.parseInt(parts[0].substring(1, 3));
        int recordNumber = Integer.parseInt(parts[0].substring(8));
        String name = parts[1].substring(0, parts[1].length() - 3);
        String address = parts[2].substring(0, parts[2].length() - 3);
        int randomValue = Integer.parseInt(parts[3].substring(0, parts[3].indexOf(".")));
        return new Record(fileNumber, recordNumber, randomValue, address, name);
    }

}