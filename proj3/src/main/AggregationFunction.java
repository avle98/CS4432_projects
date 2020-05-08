package main;
import hash.Bucket;

/**
 * public interface to aggregate bucket
 */
@FunctionalInterface
public interface AggregationFunction {
	double aggregate(Bucket group);
}