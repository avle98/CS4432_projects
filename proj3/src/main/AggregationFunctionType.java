package main;
import data.Record;

public enum AggregationFunctionType {

	private AggregationFunction function;

	/**
	 * public constructor
	 * @param function
	 */
	private AggregationFunctionType(AggregationFunction function) {
		this.function = function;
	}

	// getter
	public AggregationFunction getFunction() {
		return this.function;
	};

	/**
	 * aggregation function
	 */
	//SUM(RandomV)
	SUM_RANDOMV(
		(bucket) -> {
			double sum = 0;
			for(Record record : bucket) {
				sum += record.getRandomValue();
			}
			return sum;
		}) ,
	//AVG(RandomV)
	AVG_RANDOMV(
		(bucket) -> {
			double sum = 0;
			for(Record record : bucket) {
				sum += record.getRandomValue();
			}
			return sum / bucket.size();
		});

}