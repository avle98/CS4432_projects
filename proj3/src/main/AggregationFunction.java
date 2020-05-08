package main;

import hash.Bucket;

@FunctionalInterface
public interface AggregationFunction {
	double aggregate(Bucket group);
}