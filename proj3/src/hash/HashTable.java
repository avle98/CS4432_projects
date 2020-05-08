package hash;

import java.util.HashMap;
import data.Record;
import dataset.DataFileReader;
import dataset.Dataset;

public class HashTable extends HashMap<String, Bucket> {

	private static final int NUM_BUCKETS = 500;
	
	private Dataset dataset;
	private KeyGenerator generator;
	
	public HashTable(Dataset dataset, KeyGenerator generator) {
		this.dataset = dataset;
		this.generator = generator;
		
		this.loadInDataset();
	}
	
	private void loadInDataset() {
		for(int x = 1; x <= this.dataset.getNumFiles(); x++) {
			DataFileReader reader = new DataFileReader(this.dataset, x);
			
			for(int y = 1; y <= this.dataset.getRecordsPerFile(); y++) {
				Record record = reader.getRecord(y);
				this.put(record);
			}
			
		}
		
	}
	
	public void put(Record record) {
		if(record == null) return;
		
		String key = getKey(record);
		
		Bucket bucket = super.get(key);
		
		if(bucket == null) bucket = new Bucket();
		
		bucket.add(record);
		
		super.put(key, bucket); 
	}
	
	public String getKey(Record record) {
		return generator.make(record);
	}
	
	
	public Bucket getBucket(Record record) {
		return get(getKey(record));
	}
	public Bucket getBucket(String key) {
		return super.get(key);
	}
	 
	
	
}