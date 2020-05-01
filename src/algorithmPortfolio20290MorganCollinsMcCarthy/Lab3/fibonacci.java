package algorithmPortfolio20290MorganCollinsMcCarthy.Lab3;

public class fibonacci {
	public int fibonacciIterative(int n) {
		if (n <= 1) 
			return 1;
		int fib = 1;
		int pFib = 1;
		for (int i = 2; i < n; i++) { //a loop to sum the last number to the current
			int tmp = fib;
			fib+= pFib;
			pFib = tmp;
		}
		return fib; //return the final fib number
	}
}
