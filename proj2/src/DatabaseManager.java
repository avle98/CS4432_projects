package Main;
import java.util.ArrayList;
import java.util.Date;
import Block.BlockLoader;
import Block.Record;
import Index.ArrayIndex;
import Index.DefaultIndex;
import Index.HashIndex;
import Index.Index;
import Query.Query;
import Query.QueryCondition;
import Query.QueryManager;

public class DatabaseManager {

    private DefaultIndex defaultIndex;
    private HashIndex hashIndex;
    private ArrayIndex arrayIndex;
    private boolean indexGenerated;

    public DatabaseManager() {
        defaultIndex = new DefaultIndex();
        indexGenerated = false;
    }

    void createIndexes() {
        hashIndex = new HashIndex();
        arrayIndex = new ArrayIndex();
        indexGenerated = true;
        BlockLoader.flush();
    }

    public void executeQuery(String query_str) {
        BlockLoader.flush();
        Query query = QueryManager.makeQuery(query_str);
        Index choosen = null;

        if (!indexGenerated) {
            choosen = defaultIndex;
        } else if (query.getType() == Query.Type.EQUAL || query.getType() == Query.Type.INEQUAL) {
            choosen = arrayIndex;
        } else if (query.getType() == Query.Type.RANGE) {
            choosen = hashIndex;
        }

        System.out.println("Results:");
        ArrayList<Record> results = query.execute(choosen);

        if(results != null && results.size() > 0) {
            for(Record r : results) {
                System.out.println("\t" + r);
            }

            System.out.println("Index: " + choosen);
            System.out.println("Time: " + query.getQueryDuration());
            System.out.println("Disk Blocks Read: " + BlockLoader.getLoadedBlockCount());
        }
        else {
            System.out.println("\tNo results found.");
        }
    }
}