package hash;

import java.util.ArrayList;

import blocklevel.JoinCondition;
import data.Record;

public class Bucket extends ArrayList<Record> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7586311792950210120L;

	public Bucket() {
		super();
	}
	
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