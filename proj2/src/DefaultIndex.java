package index;
import block.BlockLoader;
import block.Record;
import java.util.ArrayList;

public class DefaultIndex implements Index {

    /**
     *
     * @param value
     * @return list
     */
    public ArrayList<Record> get(Integer value) {
        ArrayList<Record> list = new ArrayList<Record>();
        Record all[] = BlockLoader.getAllRecords();
        for(Record r : all) {
            if(value == r.getRandomValue()) {
                list.add(r);
            }
        }
        return list;
    }

    /**
     *
     * @return
     */
    public String toString() { return "Full Table Scan used";}

    /**
     *
     * @param value
     * @param indexPointer
     */
    public void put(Integer value, IndexPointer indexPointer) {
    }

}