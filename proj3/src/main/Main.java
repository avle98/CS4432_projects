package main;
import data.Record;
import dataset.Dataset;
import dataset.DataFileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
		while(true) {
			System.out.println("Enter query:");
			String input = scanner.nextLine();
			// SQL queries
			switch(input) {
			case "SELECT A.Col1, A.Col2, B.Col1, B.Col2 FROM A, B WHERE A.RandomV = B.RandomV":
				Query.performHashJoin();
				break;
			case "SELECT count(*) FROM A, B WHERE A.RandomV > B.RandomV":
				Query.performBlockLevelNestedLoopJoin();
				break;
			case "SELECT Col2, SUM(RandomV) FROM A GROUP BY Col2":
				Query.performHashBasedAggregationFunction(Dataset.A,AggregationFunctionType.SUM_RANDOMV);
				break;
			case "SELECT Col2, SUM(RandomV) FROM B GROUP BY Col2":
				Query.performHashBasedAggregationFunction(Dataset.B,AggregationFunctionType.SUM_RANDOMV);
				break;	
			case "SELECT Col2, AVG(RandomV) FROM A GROUP BY Col2":
				Query.performHashBasedAggregationFunction(Dataset.A,AggregationFunctionType.AVG_RANDOMV);
				break;
			case "SELECT Col2, AVG(RandomV) FROM B GROUP BY Col2":
				Query.performHashBasedAggregationFunction(Dataset.B,AggregationFunctionType.AVG_RANDOMV);
				break;	
			}
		}
	}

}