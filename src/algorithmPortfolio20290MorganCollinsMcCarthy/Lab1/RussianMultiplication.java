package algorithmPortfolio20290MorganCollinsMcCarthy.Lab1;

import java.io.*;

public class RussianMultiplication {
	public int multiplication(int num1, int num2) {
		int p = 0;
		if (num1 % 2 != 0)
			p += num2;
		while (num1 != 1) { //while isnt 1
			num1 /= 2; // half the first num and double the 2nd
			num2 *= 2;
			if (num1 % 2 != 0)
				p += num2;
		}
		return p;
	}
}
