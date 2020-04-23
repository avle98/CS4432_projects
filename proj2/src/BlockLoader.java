package block;
import index.IndexPointer;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.nio.file.Files;

public class BlockLoader {
    private final static String directory_str = "Project2Dataset";
    private final static int NUM_BLOCKS = 99;
    private static Record[] allRecords = null;
    private final static File directory = new File(directory_str);
    private static HashMap<Integer, Record[]> loadedBlocks = new HashMap<Integer, Record[]>();

    /**
     * retrieve all the records
     * @return allRecords
     */
    public static Record[] getAllRecords() {
        if(allRecords != null) {
            return allRecords;
        }
        List<Record> records = new ArrayList<Record>();
        for(int x = 1; x <= NUM_BLOCKS; x++) {
            for(Record r : getRecords(x)) {
                records.add(r);
            }
        }
        allRecords = records.toArray(new Record[0]);
        return allRecords;
    }

    /**
     *
     * @param pointer
     * @return records
     */
    public static Record getRecord(IndexPointer pointer) {
        if(pointer.getRecordNumber() == 0) System.out.println("f: " + pointer.getFileNumber() + " r: " + pointer.getRecordNumber());
        return getRecords(pointer.getFileNumber())[pointer.getRecordNumber() - 1];
    }

    /**
     *
     * @return block size
     */
    public static int getLoadedBlockCount() {
        return loadedBlocks.size();
    }

    /**
     * retrieve records with block number
     * @param blockNumber
     * @return records with block number
     */
    public static Record[] getRecords(int blockNumber) {
        if(loadedBlocks.containsKey(blockNumber)) {
            return loadedBlocks.get(blockNumber);
        }
        try {
            String blockString = Files.readAllLines(Paths.get(directory_str + "/F" + blockNumber + ".txt")).get(0);
            InternalBlockIterator blockIterator = new InternalBlockIterator(blockString);
            List<Record> records = new ArrayList<Record>();
            while(blockIterator.hasNext()) {
                String recordString = blockIterator.next();
                Record record = Record.parseRecord(recordString);
                records.add(record);
            }
            loadedBlocks.put(blockNumber, records.toArray(new Record[0]));
            return getRecords(blockNumber);
        }
        catch (IOException e) {
            System.out.println("Could not read file #" + blockNumber);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * removes cached blocks during a query
     */
    public static void flush() {
        allRecords = null;
        loadedBlocks = new HashMap<Integer, Record[]>();
    }
}