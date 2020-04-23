package Index;
import Block.Record;
import java.util.ArrayList;

public interface Index {
    ArrayList<Record> get(Integer value);
    void put(Integer value, IndexPointer indexPointer);
    String toString();
}