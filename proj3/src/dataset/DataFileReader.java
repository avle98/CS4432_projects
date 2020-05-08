package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import data.Record;
import hash.Bucket;

public class DataFileReader {

	private Dataset dataset;
	private int fileNumber;

	public DataFileReader(Dataset dataset, int fileNumber) {
		this.dataset = dataset;
		this.fileNumber = fileNumber;
	}

	public String getLocalPath() {
		return this.dataset.getDirectory() + "/" + dataset.toString() + this.fileNumber + ".txt";
	}

	public Record getRecord(int recordNumber) {

		try {
			File file = new File(getLocalPath());
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);

			int recordStringLength = Record.RECORD_STRING_LENGTH;
			int recordStringOffset = (recordNumber - 1) * recordStringLength;

			char input[] = new char[recordStringLength];

			br.skip(recordStringOffset); // skip over this man characters
			br.read(input, 0, recordStringLength);

			return makeRecord(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Record makeRecord(char input[]) {

		Dataset dataset = Dataset.valueOf(input[0] + "");

		int fileNumber = Integer.parseInt(new String(input, 1, 2));
		int recordNumber = Integer.parseInt(new String(input, 7, 3));

		String name = new String(input, 12, 4);
		String address = new String(input, 21, 7);

		int randomV = Integer.parseInt(new String(input, 33, 4));
		Record record = new Record(dataset, fileNumber, recordNumber, name, address, randomV);

		return record;
	}
	
	
	public Bucket getAllRecords() {
		Bucket bucket = new Bucket();
		
		for(int x = 1; x <= dataset.getRecordsPerFile(); x++) {
			Record record = getRecord(x);
			bucket.add(record);
		}
		
		return bucket;
	}

	/*
	 * 0: A 1: 3 2: 2 3: - 4: R 5: e 6: c 7: 0 8: 9 9: 9 10: , 11: 12: N 13: a 14: m
	 * 15: e 16: 0 17: 9 18: 9 19: , 20: 21: a 22: d 23: d 24: r 25: e 26: s 27: s
	 * 28: 0 29: 9 30: 9 31: , 32: 33: 0 34: 4 35: 3 36: 1 37: . 38: . 39: .
	 * 
	 */

}