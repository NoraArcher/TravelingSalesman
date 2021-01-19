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
		// System.out.println(traveling(stack));
	}
	catch(FileNotFoundException e) {
		System.out.println("File not found");
		System.exit(1);
	}
}

//implement this to create array
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

// Think outside of the box.
// You don't have to find all of the paths in the correct order,
// and if you tested a path an extra few times it wouldnt matter.
// Homework hint:
// It is frustrating to do this without recursion as many must have figured out.
// I will allow you to do it with a VERY high probability of finding the correct result.
// This is possible since we are only testing 8 cities.

// 0, 1, 3, 2, 4
// 0, 1, 2, 3, 4
// 0, 1, 4, 3, 2
// Nested arrays?
// ArrayList?
// 2 -> 3 == 3 -> 2
// Just take the smallest distance and run with 8 at start?

// testing
public static int traveling (int[][] input) {
	double bestCost = Double.POSITIVE_INFINITY;
	int counter = 1;
	int [] distances = new int[input.length - 1];
	int [] visitedCities = new int[input.length];

	while (counter < input.length) {
		distances[counter - 1] = input[counter - 1][counter];
		visitedCities[counter] = counter;
		counter++;
	}
	System.out.println(Arrays.toString(distances));
	System.out.println(Arrays.toString(visitedCities));
	return Arrays.stream(distances).sum();
}
}
