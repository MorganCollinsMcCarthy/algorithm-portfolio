package algorithmPortfolio20290MorganCollinsMcCarthy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import algorithmPortfolio20290MorganCollinsMcCarthy.Lab4and5and6.Sorts;
import algorithmPortfolio20290MorganCollinsMcCarthy.Lab8.Trie;
import algorithmPortfolio20290MorganCollinsMcCarthy.Lab8.Trie.TrieNode;
import algorithmPortfolio20290MorganCollinsMcCarthy.lab7.search;
import algorithmPortfolio20290MorganCollinsMcCarthy.Lab1.RussianMultiplication;
import algorithmPortfolio20290MorganCollinsMcCarthy.Lab3.fibonacci;

public class Main {

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		Sorts test = new Sorts();
		fibonacci test1 = new fibonacci();
		search test3 = new search();
		Trie test4 = new Trie();
		RussianMultiplication test2 = new RussianMultiplication();
		// ********Testing*******

		// Here we can test Russian Multiplication is working correctly
		int a = r.nextInt(5 * 100);
		int b = r.nextInt(5 * 100);
		if (test2.multiplication(a, b) == a * b)
			System.out.println("Russian Multiplication Working");

		if (test1.fibonacciIterative(20) == 6765)
			System.out.println("Fibonacci is working");

		// Here we can test each alg is sorting correctly
		int[] arr = newArray();
		test.selectionSort(arr);
		if (Sorts.isSorted(arr))
			System.out.println("Selection Sort Working");

		arr = newArray();
		test.insertionSort(arr);
		if (Sorts.isSorted(arr))
			System.out.println("Insertion Sort Working");

		arr = newArray();
		test.mergeSort(arr);
		if (Sorts.isSorted(arr))
			System.out.println("Merge Sort Working");

		arr = newArray();
		test.quickSort(arr, 0, arr.length - 1);
		if (Sorts.isSorted(arr))
			System.out.println("Quick Sort Working");

		// reading from file
		String txt = "";
		try {
			txt = new String(
					Files.readAllBytes(Paths.get("src/algorithmPortfolio20290MorganCollinsMcCarthy/lab7/test.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// here we test if brute force search is working for found and not found
		String pat = "ABABCABAB";
		if (test3.search(txt, pat))
			System.out.println("Found brute force search working");
		pat = "Z";
		if (!test3.search(txt, pat))
			System.out.println("Not Found brute force search working");

		// here we test if KMP search is working for found and not found
		pat = "ABABCABAB";
		if (test3.KMPSearch(pat, txt))
			System.out.println("Found KMP search working");
		pat = "Z";
		if (!test3.KMPSearch(pat, txt))
			System.out.println("Not Found KMP search working");

		// here we test the trie class
		String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };
		String output[] = { "Not present in trie, working", "Present in trie, working" };
		test4.root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			test4.insert(keys[i]);
		}
		// Search for different keys
		if (test4.search("bank") == true)
			System.out.println(output[1]);
		else
			System.out.println(output[0]);
		
		if (test4.search("hello") == true)
			System.out.println(output[1]);
		else
			System.out.println(output[0]);

		// ********Performance*******
		// Here we can test the runtime of each algorithm.
//		testRussianAlgorithm();
//		testFib();
//		sortTest(0, "Selection Sort");
//		sortTest(1, "Insertion Sort");
//		sortTest(2, "Merge Sort");
//		sortTest(3, "Quick Sort");
//		sortTest(4, "Advanced Quick Sort");
//		testSearch();
//		testKMPSearch();
	}

	public static int[] newArray() {
		Random r = new Random(System.currentTimeMillis());
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(5 * 100);
		}
		return arr;
	}

	public static void testSearch() {
		// here we test the bruteforce serach, we double the length of the string every
		// run
		search test = new search();
		String txt = "ABACACACACACABABABABAD";
		String add = "ABACACACACACABABABABAD";
		String pat = "AD";
		int totalRuns = 10;
		System.out.print("Testing Brute Force search ");
		System.out.println("(" + totalRuns + " runs per test)");
		System.out.println("Leght	Time");
		for (int i = 0; i < 10; i++) {
			long totalruntime = 0;
			long time = System.nanoTime();
			for (int run = 0; run < totalRuns; run++) {
				test.search(txt, pat);
			}
			totalruntime += System.nanoTime() - time;
			// printout runtime.
			System.out.println(txt.length() + "	" + totalruntime);
			txt = add + txt;
			add += add;
		}
		System.out.println();
	}

	public static void testKMPSearch() {
		// here we test the KMP search, we double the length of the string every run
		search test = new search();
		String txt = "ABACACACACACABABABABAD";
		String add = "ABACACACACACABABABABAD";
		String pat = "AD";
		int totalRuns = 10;
		System.out.print("Testing KMPsearch ");
		System.out.println("(" + totalRuns + " runs per test)");
		System.out.println("Leght	Time");
		for (int i = 0; i < 10; i++) {
			long totalruntime = 0;
			long time = System.nanoTime();
			for (int run = 0; run < totalRuns; run++) {
				test.KMPSearch(pat, txt);
			}
			totalruntime += System.nanoTime() - time;
			// printout runtime.
			System.out.println(txt.length() + "	" + totalruntime);
			txt = add + txt;
			add += add;
		}
		System.out.println();
	}

	public static void testFib() {
		// here we test the fib runtimes with random numbers selected from different
		// ranges
		// we can also select the total runs for each range
		fibonacci test = new fibonacci();
		Random r = new Random(System.currentTimeMillis());
		int totalRuns = 100;
		System.out.print("Testing fibonacciIterative");
		System.out.println("(" + totalRuns + " runs per test)");
		System.out.println("Range		Time");
		int high = 10;
		int low = 1;
		while (high != 10000000) {
			long totalruntime = 0;
			long time = System.nanoTime();
			for (int run = 0; run < totalRuns; run++) {
				test.fibonacciIterative(r.nextInt(high - low));
			}
			totalruntime += System.nanoTime() - time;
			// printout runtime.
			if (high < 1000)
				System.out.println(low + "-" + high + "		" + totalruntime);
			else
				System.out.println(low + "-" + high + "	" + totalruntime);
			low *= 10;
			high *= 10;
		}
		System.out.println();

	}

	public static void testRussianAlgorithm() {
		// here we test the russain alg runtimes with random numbers selected from
		// different ranges
		// we can also select the total runs for each range
		Random r = new Random();
		RussianMultiplication test = new RussianMultiplication();
		int totalRuns = 1;
		System.out.print("Testing RussianAlgorithm");
		System.out.println("(" + totalRuns + " runs per test)");
		System.out.println("Range   Time");
		int high = 10;
		int low = 1;
		while (high != 10000000) {
			long totalruntime = 0;
			long time = System.nanoTime();
			for (int run = 0; run < totalRuns; run++) {
				test.multiplication(r.nextInt(high - low), r.nextInt(high - low));
			}
			totalruntime += System.nanoTime() - time;
			// printout runtime.
			if (high < 1000)
				System.out.println(low + "-" + high + "		" + totalruntime);
			else
				System.out.println(low + "-" + high + "	" + totalruntime);
			low *= 10;
			high *= 10;
		}
		System.out.println();
	}

	public static void sortTest(int type, String name) {
		// here we test the sorting alg runtimes with different size inputs
		// we can also select the total runs for each range
		Sorts test = new Sorts();
		int[] isSorted = new int[100];
		for (int i = 0; i < isSorted.length; i++) {
			isSorted[i] = test.r.nextInt(5 * 100);
		}

		int totalRuns = 100;
		System.out.print("Testing " + name);
		System.out.println("(" + totalRuns + " runs per test)");
		System.out.println("Input	Time");
		// adjust input size to vary size of arrays
		for (int inputSize = 0; inputSize <= 1000; inputSize += 50) {
			// vary total Runs to give you many empirical tests
			long totalruntime = 0;
			for (int run = 0; run < totalRuns; run++) {
				int[] nums = new int[inputSize];
				for (int i = 0; i < nums.length; i++) {
					nums[i] = test.r.nextInt(5 * inputSize);
				}
				long time = System.nanoTime();
				switch (type) {
				case 0:
					test.selectionSort(nums);
					break;
				case 1:
					test.insertionSort(nums);
					break;
				case 2:
					test.mergeSort(nums);
					break;
				case 3:
					test.quickSort(nums, 0, inputSize - 1);
					break;
				case 4:
					test.advancedQuickSort(nums, 0, inputSize - 1);
					break;

				default:
					System.err.printf("\nBad sort ID '%d'", type);
					System.exit(-2);
				}
				totalruntime += System.nanoTime() - time;
			}
			// printout runtime.
			System.out.println(inputSize + "	" + totalruntime);
		}
		System.out.println();

	}

}
