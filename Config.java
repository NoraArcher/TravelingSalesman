import java.util.*;
import java.io.*;
public class Config {

public static void main(String[] args) {
	try {
		int[][] stack = config(8);
		for (int i = 0; i < stack.length; i++) {
			System.out.println(Arrays.toString(stack[i])); //Test
		}
		System.out.println();
		System.out.println(pick2(stack));
	}
	catch(FileNotFoundException e) {
		System.out.println("File not found");
		System.exit(1);
	}
}

public static int[][] config (int quantity) throws FileNotFoundException {
	int[][] distances = new int[quantity][quantity];
	String fileName = "input.txt"; //Input File for TravelingSalesman
	Scanner inputScan = new Scanner(new File(fileName));
	int temp = quantity;

	int i = 1;
	int j = 0;
	while (inputScan.hasNext()) {
		if (inputScan.hasNextInt()) {
			int store = inputScan.nextInt();
			//System.out.println(store);
			distances[i][j] = store; // i -> j
			distances[j][i] = store; // j -> i
			if (i == quantity - 1) {
				j++;
				i = j;
			}
			if (j == quantity - 1) {
				return distances;
			}
			i++;
		}
		else {
			inputScan.next();
		}
	}
	return distances;
}


// testing
public static int pick2 (int[][] config) {
	double bestCost = Double.POSITIVE_INFINITY;
	int counter = 1;
	int [] distances = new int[config.length - 1];
	int [] visitedCities = new int[config.length];
	while (counter < config.length) {
		int next
		distances[counter - 1] = config[counter - 1][counter];
		visitedCities[counter] = counter;
		counter++;
	}
	System.out.println(Arrays.toString(distances));
	System.out.println(Arrays.toString(visitedCities));
	return Arrays.stream(distances).sum();
}
}
