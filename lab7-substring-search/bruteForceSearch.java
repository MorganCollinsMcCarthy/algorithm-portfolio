import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Java program for Naive Pattern Searching 

public class bruteForceSearch {

	public static void search(String txt, String pat) {
		for (int i = 0; i < txt.length(); i++) {
			int match=0;
			for (int j = 0; j < pat.length(); j++) {
				if(txt.charAt(i+j)==pat.charAt(j))
					match++;
			}
			if(match==pat.length()) {
				System.out.println("Match found");break;
			}
		}

	}

	public static void main(String[] args) {
		String txt = "";
	    try {
	      txt = new String(Files.readAllBytes(Paths.get("lab7-substring-search/test.txt")));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		String pat = "ABABCABAB";
		search(txt, pat);
	}
}
