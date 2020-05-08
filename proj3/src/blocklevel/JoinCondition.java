package blocklevel;

import data.Record;

@FunctionalInterface
public interface JoinCondition {
	boolean meets(Record r1, Record r2);
}