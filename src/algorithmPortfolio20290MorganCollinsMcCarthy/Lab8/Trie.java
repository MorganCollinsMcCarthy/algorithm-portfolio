package algorithmPortfolio20290MorganCollinsMcCarthy.Lab8;

public class Trie {

// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26;

// class for Trie node 
	public static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;

		public TrieNode() {
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	public static TrieNode root;

// If not key present, inserts into trie 
// If the key is prefix of Trie node,  
//  marks leaf node
	public static void insert(String key) {
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
	public static boolean search(String key) {
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
}