package main;
import blocklevel.NestedJoin;
import data.Record;
import dataset.Dataset;
import dataset.DataFileReader;
import hash.HashTable;
import hash.Bucket;
import java.util.Set;

public class Query {

	/**
	 * hash join function
	 */
	public static void performHashJoin() {
		long start = System.currentTimeMillis();
		HashTable table = new HashTable(Dataset.A, (record) -> {
			int randomValue = record.getRandomValue();
			String key = Integer.toBinaryString(randomValue);
			return key;
		});
		DataFileReader reader = null;
		System.out.println("Results:");
		Bucket resultBucket = new Bucket();

		for (int x = 1; x <= Dataset.B.getNumFiles(); x++) {
			reader = new DataFileReader(Dataset.B, x);
			for (int y = 1; y < Dataset.B.getRecordsPerFile(); y++) {
				Record record = reader.getRecord(y);

				Bucket bucket = table.getBucket(record);
				resultBucket.addAll(bucket);
				for (Record r : bucket) {
					System.out.println("\t" + r.getIdentifierString() + ", " + r.getNameString() + ", "
							+ record.getIdentifierString() + ", " + record.getNameString());
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start) + " ms");
	}

	/**
	 * hash-based aggregation function
	 * @param dataset
	 * @param af
	 */
	public static void performHashBasedAggregationFunction(Dataset dataset, AggregationFunctionType af) {
		long start = System.currentTimeMillis();
		HashTable table = new HashTable(dataset, (record) -> {
			return record.getNameString();
		});
		Set<String> keys = table.keySet();
		System.out.println("Results:");
		for (String key : keys) {
			Bucket group = table.getBucket(key); //get the group
			double result = af.getFunction().aggregate(group);
			System.out.println("\t" + key + ", " + result);
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (end - start) + " ms");
	}

	/**
	 * block-level nested-loop join function
	 */
	public static void performBlockLevelNestedLoopJoin() {
		long start = System.currentTimeMillis();
		NestedJoin join = new NestedJoin(Dataset.A, Dataset.B, (r1, r2) -> {
			return r1.getRandomValue() > r2.getRandomValue();
		});
		long end = System.currentTimeMillis();
		Bucket results = join.getResults();
		System.out.println("Result count: " + results.size());
		System.out.println("Execution time: " + (end - start) + " ms");
	}

}

