package algorithmPortfolio20290MorganCollinsMcCarthy.Lab4and5and6;
import java.util.Arrays;
import java.util.Random;

/**
 * Implementation of various sorting algorithms that includes a framework for
 * testing with various input array sizes and over multiple runs
 * 
 */

public class Sorts {
	public static Random r = new Random(System.currentTimeMillis());
	static final int CUTOFF = 10;

	// ********print helper class*****
	// Prints the input array
	
	public void print(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	

	// ***************************** Insertion Sorts *****************************
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int valueToSort = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > valueToSort) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = valueToSort;
		}
	}

	// ***************************** Merge Sort *****************************
	public void mergeSort(int[] a) {
		int low = 0;
		int i;
		int high = a.length;
		int mid = (high + low) / 2;
		if (a.length < 2) {
			return;
		} else {
			int[] left = new int[mid];
			int[] right = new int[high - mid];
			for (i = 0; i < mid; i++)
				left[i] = a[i];
			for (int j = 0; j < high - mid; j++, i++)
				right[j] = a[i];
			mergeSort(left);
			mergeSort(right);
			merge(left, right, a);
		}
	}

	public int[] merge(int[] a, int[] b, int[] s) {
		int i = 0, j = 0, k = 0;
		// repeat while both arrays have elements in them

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				s[k] = a[i];
				i++;
				k++;
			} else {
				s[k] = b[j];
				j++;
				k++;
			}
		}
		while (i < a.length) {
			s[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length) {
			s[k] = b[j];
			j++;
			k++;
		}
		return s;
	}

	// ***************************** Quick Sorts *****************************

	// advanced quick
	public void advancedQuickSort(int array[], int low, int high) {
		if (high <= low + CUTOFF) { //this is the same as the quick sort but mixed with the insertion sort when high is lower than the cut ff
			insertionSort(array);
			return;
		}
		if (low < high) {
			int pi = partition(array, low, high);
			advancedQuickSort(array, low, pi - 1);
			advancedQuickSort(array, pi + 1, high);
		}
	}

	// quick sort
	public void quickSort(int array[], int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);

			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	// partition helper function
	public int partition(int array[], int low, int high) {
		int pivot = array[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return (i + 1);

	}

	// ***************************** Selection Sort ****************************

	public void selectionSort(int[] nums) {
		int minindex;
		for (int i = 0; i < nums.length - 1; i++) {
			minindex = i;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] < nums[minindex]) {
					minindex = j;
				}
			}
			if (minindex != i) {
				int tmp = nums[i];
				nums[i] = nums[minindex];
				nums[minindex] = tmp;
			}
		}
	}

	// ***************************** Silly Sorts *****************************
	// *** the silliest sorts of them all
	public static void bogoSort(int[] nums) {
		while (!isSorted(nums)) {
			shuffle(nums);
		}
	}

	// ******shuffle helper for bogoSort
	// Knuth Shuffle
	private static void shuffle(int[] nums) {
		int n, tmp;
		for (int i = nums.length - 1; i > 0; i--) {
			n = r.nextInt(i + 1);
			tmp = nums[i];
			nums[i] = nums[n];
			nums[n] = tmp;
		}
	}

	// **helper function to check if your array is sorted or not
	public static boolean isSorted(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
