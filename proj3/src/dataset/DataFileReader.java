package dataset;
import data.Record;
import hash.Bucket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DataFileReader {

	private Dataset dataset;
	private int fileNumber;

	/**
	 * public constructor
	 * @param dataset
	 * @param fileNumber
	 */
	public DataFileReader(Dataset dataset, int fileNumber) {
		this.dataset = dataset;
		this.fileNumber = fileNumber;
	}

	/**
	 *
	 * @return directory path
	 */
	public String getLocalPath() {
		return this.dataset.getDirectory() + "/" + dataset.toString() + this.fileNumber + ".txt";
	}

	/**
	 * pubilc constructor
	 * @param recordNumber
	 * @return input of which record to make or null
	 */
	public Record getRecord(int recordNumber) {
		try {
			File file = new File(getLocalPath());
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			int recordStringLength = Record.RECORD_STRING_LENGTH;
			int recordStringOffset = (recordNumber - 1) * recordStringLength;
			char input[] = new char[recordStringLength];
			br.skip(recordStringOffset);
			br.read(input, 0, recordStringLength);
			return makeRecord(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * private function
	 * @param input
	 * @return record
	 */
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

	/**
	 * public function
	 * @return bucket
	 */
	public Bucket getAllRecords() {
		Bucket bucket = new Bucket();
		for(int x = 1; x <= dataset.getRecordsPerFile(); x++) {
			Record record = getRecord(x);
			bucket.add(record);
		}
		return bucket;
	}
}