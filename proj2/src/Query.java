package query;
package block.BlockLoader;
package block.Record;
package index.Index;
import query.QueryCondition.Condition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query {
    public enum Type {EQUAL, INEQUAL, RANGE};
    private ArrayList<Integer> parameters;
    private long start_time;
    private long end_time;
    private Type type;

    /**
     * default constructor
     */
    public Query() {
        start_time = 0;
        end_time = 0;
        parameters = new ArrayList<Integer>();
    }

    public void setConditionEqual(Integer value) {
        parameters.add(value);
        type = Type.EQUAL;
    }

    /**
     *
     * @param val1
     * @param val2
     */
    public void setConditionRange(Integer val1, Integer val2) {
        int min = Math.min(val1, val2);
        int max = Math.max(val1, val2);
        for(int x = min + 1; x < max; x++) {
            parameters.add(x);
        }
        type = Type.RANGE;
    }

    /**
     *
     * @param value
     */
    public void setConditionInequal(Integer value) {
        for(int x = 1; x <= 5000; x++) {
            if(x == value) continue;
            parameters.add(x);
        }
        type = Type.INEQUAL;
    }

    public Type getType() {
        return type;
    }

    /**
     *
     * @param index
     * @return
     */
    public ArrayList<Record> execute(Index index) {
        BlockLoader.flush();
        start_time = new Date().getTime();
        ArrayList<Record> results = QueryCondition.find.perform(parameters, index);
        end_time = new Date().getTime();
        return results;
    }

    /**
     *
     * @return
     */
    public long getQueryDuration() {
        return end_time - start_time;
    }

}