package Index;
import java.util.ArrayList;
import Block.BlockLoader;
import Block.Record;

public class ArrayIndex implements Index<Integer> {

    private ArrayList<IndexPointer> index[];

    public ArrayIndex() {
        this.index = new ArrayList[5000];
        load();
    }

    @Override
    public Record[] get(Integer value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void put(Integer value, IndexPointer indexPointer) {
        if (index[value] == null) {
            index[value] = new ArrayList<IndexPointer>();
        }

        index[value].add(indexPointer);
    }

    public void load() {
        Record records[] = BlockLoader.getAllRecords();

        for (Record record : records) {
            IndexPointer ptr = new IndexPointer(record.getFileNumber(), record.getRecordNumber());

            put(record.getRandomValue(), ptr);
        }
    }

    public String toString() {
        return "Array-Based Index used";
    }


}