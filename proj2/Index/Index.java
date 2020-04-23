package Index;

import java.util.ArrayList;

import block.Record;

public interface Index {
    ArrayList<Record> get(Integer value);

    void put(Integer value, IndexPointer indexPointer);

    String toString();


}