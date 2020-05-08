package dataset;

public enum Dataset {
	A("Project3Dataset-A", 99, 100), B("Project3Dataset-B", 99, 100);
	
	private String directory;
	private int numFiles, recordsPerFile;

	private Dataset(String directory, int numFiles, int recordsPerFile) {
		this.directory = directory;
		this.numFiles = numFiles;
		this.recordsPerFile = recordsPerFile;
	}
	public String getDirectory() { return this.directory; }
	public int getNumFiles() { return this.numFiles; }
	public int getRecordsPerFile() { return this.recordsPerFile; }
}