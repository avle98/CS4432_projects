package Index;

import java.util.ArrayList;

import block.BlockLoader;
import block.Record;

public class DefaultIndex implements Index {


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

    public void put(Integer value, IndexPointer indexPointer) {
        // TODO Auto-generated method stub

    }

    public String toString() { return "Full Table Scan used";}

}