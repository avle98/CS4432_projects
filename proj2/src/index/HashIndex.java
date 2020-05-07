package index;
import block.Record;
import block.BlockLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class HashIndex implements Index {
    private HashMap<Integer, ArrayList<IndexPointer>> index;
    private int lastGetBlocksRead;

    /**
     * constructor
     */
    public HashIndex() {
        index = new HashMap<Integer, ArrayList<IndexPointer>>();
        lastGetBlocksRead = 0;
        load();
    }

    /**
     * load records
     */
    private void load() {
        Record records[] = BlockLoader.getAllRecords();
        for(Record record : records) {
            IndexPointer pointer = new IndexPointer(record.getFileNumber(), record.getRecordNumber());
            put(record.getRandomValue(), pointer);
        }
    }

    /**
     *
     * @param randomValue
     * @param indexPointer
     */
    public void put(Integer randomValue, IndexPointer indexPointer) {
        ArrayList<IndexPointer> aList = null;
        if(index.containsKey(randomValue)) {
            aList = index.get(randomValue);
        } else {
            aList = new ArrayList<IndexPointer>();
        }
        aList.add(indexPointer);
        index.put(randomValue, aList);
    }

    /**
     *
     * @param randomValue
     * @return results
     */
    public ArrayList<Record> get(Integer randomValue) {
        ArrayList<IndexPointer> list = index.get(randomValue);
        if(list == null) return null;
        ArrayList<Record> results = new ArrayList<Record>();

        for(IndexPointer pointer : list) {
            results.add(BlockLoader.getRecord(pointer));
        }
        return results;
    }

    /**
     *
     * @return text
     */
    public String toString() { 
        return "HashIndex used";
    }

}