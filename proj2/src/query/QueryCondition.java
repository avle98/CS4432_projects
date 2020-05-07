package query;
import block.Record;
import index.Index;
import java.util.ArrayList;

public interface QueryCondition {
    @FunctionalInterface
    public interface Condition {
        ArrayList<Record> perform(ArrayList<Integer> expected, Index index);
    }

    /**
     * specific query
     */
    public static Condition find = (expected, index) -> {
        ArrayList<Record> results = new ArrayList<Record>();
        for (Integer r : expected) {
            ArrayList<Record> pulled = index.get(r);
            if (pulled != null && pulled.size() > 0) {
                for (Record t : index.get(r)) {
                    results.add(t);
                }
            }
        }
        return results;
    };

}