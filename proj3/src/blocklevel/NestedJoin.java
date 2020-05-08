package blocklevel;
import data.Record;
import dataset.Dataset;
import dataset.DataFileReader;
import hash.Bucket;

public class NestedJoin {
	
	private Dataset startingDataset, joiningDataset;
	private JoinCondition condition;
	private Bucket startingBucket;
	private Bucket results;

	/**
	 * public constructor
	 * @param startingDataset
	 * @param joiningDataset
	 * @param condition
	 */
	public NestedJoin(Dataset startingDataset, Dataset joiningDataset, JoinCondition condition) {
		this.startingDataset = startingDataset;
		this.joiningDataset = joiningDataset;
		this.condition = condition;
		this.startingBucket = new Bucket();
		this.results = new Bucket();
		this.join();
	}

	/**
	 * join function
	 */
	private void join() {
		 // Step 1: Load data from startingDataset
		DataFileReader reader = null;
		for(int fileNumber = 1; fileNumber <= this.startingDataset.getNumFiles(); fileNumber++) {
			reader = new DataFileReader(this.startingDataset, fileNumber);
			Bucket fileRecords = reader.getAllRecords();
			this.startingBucket.addAll(fileRecords);
		}
		// Step 2: Read joiningDataset file by file record by record and see if it matches the join condition
		for(int fileNumber = 1; fileNumber <= this.joiningDataset.getNumFiles(); fileNumber++) {
			reader = new DataFileReader(this.joiningDataset, fileNumber);
			for(int recordNumber = 1; recordNumber <= this.joiningDataset.getRecordsPerFile(); recordNumber++) {
				Record attempt = reader.getRecord(recordNumber);
				Bucket resultsSubBucket = this.startingBucket.meetsJoinCondition(condition, attempt);
				this.results.addAll(resultsSubBucket);
			}
		}	
	}

	//getter
	public Bucket getResults() {
		return this.results;
	}

}