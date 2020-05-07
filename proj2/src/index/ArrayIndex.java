package index;
import block.BlockLoader;
import block.Record;
import java.util.ArrayList;

public class ArrayIndex implements Index<Integer> {
    private ArrayList<IndexPointer> index[];

    /**
     * default constructor
     */
    public ArrayIndex() {
        this.index = new ArrayList[5000];
        load();
    }

    /**
     * load function
     */
    public void load() {
        Record records[] = BlockLoader.getAllRecords();
        for (Record record : records) {
            IndexPointer pointer = new IndexPointer(record.getFileNumber(), record.getRecordNumber());
            put(record.getRandomValue(), pointer);
        }
    }

    /**
     * create string
     * @return
     */
    public String toString() {
        return "Array-Based Index used";
    }

    /**
     * override function
     * @param value
     * @return
     */
    @Override
    public Record[] get(Integer value) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * override function
     * @param value
     * @param indexPointer
     */
    @Override
    public void put(Integer value, IndexPointer indexPointer) {
        if (index[value] == null) {
            index[value] = new ArrayList<IndexPointer>();
        }
        index[value].add(indexPointer);
    }

}