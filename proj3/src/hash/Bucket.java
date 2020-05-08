package hash;
import blocklevel.JoinCondition;
import data.Record;
import java.util.ArrayList;

public class Bucket extends ArrayList<Record> {

	private static final long serialVersionUID = -7586311792950210120L;

	public Bucket() {
		super();
	}

	/**
	 * hashing of each record to determine the corresponding bucket based on join column
	 * for each record in Dataset-B, apply the same hash function on the join column
	 * to know which bucket you should check from Dataset-A
	 * @param condition
	 * @param r2
	 * @return subBucket
	 */
	public Bucket meetsJoinCondition(JoinCondition condition, Record r2) {
		Bucket subBucket = new Bucket();
		for(Record r1 : this) {
			if(condition.meets(r1, r2)) {
				subBucket.add(r1);
			}
		}
		return subBucket;
	}
	
}