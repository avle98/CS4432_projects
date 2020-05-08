package blocklevel;
import data.Record;

/**
 * public interface to see whether record from dataset-A meets record from dataset-B
 */
@FunctionalInterface
public interface JoinCondition {
	boolean meets(Record r1, Record r2);
}