
public class Trie {

// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26;

// class for Trie node 
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

// If not key present, inserts into trie 
// If the key is prefix of Trie node,  
//  marks leaf node
	static void insert(String key) {
		int i;
		TrieNode node = root;

		for (int j = 0; j < key.length(); j++) {
			i = key.charAt(j) - 'a';
			if (node.children[i] == null)
				node.children[i] = new TrieNode();
			node = node.children[i];
		}
		node.isEndOfWord = true;
	}

// Returns true if key presents in trie, else false 
	static boolean search(String key) {
		int i;
		TrieNode node = root;

		for (int j = 0; j < key.length(); j++) {
			i = key.charAt(j) - 'a';
			if (node.children[i] == null)
				return false;

			node = node.children[i];

		}

		return (node.isEndOfWord && node != null);

	}

// Driver 
	public static void main(String args[]) {

// Input keys (use only 'a' through 'z' and lower case) 
		String keys[] = { "bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

// Construct trie 
		int i;
		for (i = 0; i < keys.length; i++) {
			insert(keys[i]);
		}

// Search for different keys 
		if (search("bank") == true)
			System.out.println(output[1]);

		if (search("hello") == true)
			System.out.println(output[1]);

	}

//end of class
}