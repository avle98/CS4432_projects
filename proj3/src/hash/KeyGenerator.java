package hash;
import data.Record;

/**
 * public interface to make record
 */
@FunctionalInterface
public interface KeyGenerator {
	String make(Record record);
}