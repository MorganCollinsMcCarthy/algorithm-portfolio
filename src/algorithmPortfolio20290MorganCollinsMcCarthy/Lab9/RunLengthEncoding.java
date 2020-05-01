package algorithmPortfolio20290MorganCollinsMcCarthy.Lab9;

public class RunLengthEncoding {

	public static void main(String[] args) {
		BinaryIn input = new BinaryIn("abra.txt");

		String encoded = "";
		String txt = input.readString();
		int num = 0;
		
		//for loop szoe of string
		int size = txt.length();
		for (int i = 0; i < size; i++) { //here we are adding a new letter to the string and count counting how many times it occurs in a row
			num = 1;
			while (i < size - 1 && txt.charAt(i) == txt.charAt(i + 1)) {
				num++;
				i++;
			}
			encoded += txt.charAt(i) + "" + num; //when we reach a new char we add the char and num to string
		}
		System.out.println(encoded);
	}
}
