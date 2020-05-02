package Assignment1;
import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 *  Compilation:  javac Huffman.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 * Add instructions and documentation related to your Huffman algorithm here...
 *
 ******************************************************************************/

/**
 *
 * @author Morgan Collins McCarthy
 */
public class HuffmanAlgorithm {

	// alphabet size of extended ASCII
	private static final int R = 256;

	// Do not instantiate.
	private HuffmanAlgorithm() {
	}

	// Huffman trie node
	private static class Node implements Comparable<Node> {
		private final char ch;
		private final int freq;
		private final Node left, right;

		Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		// is the node a leaf node?
		private boolean isLeaf() {
			assert ((left == null) && (right == null)) || ((left != null) && (right != null));
			return (left == null) && (right == null);
		}

		// compare, based on frequency
		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
	}

	/**
	 * Reads a sequence of 8-bit bytes from standard input; compresses them using
	 * Huffman codes with an 8-bit alphabet; and writes the results to standard
	 * output.
	 */
	public static void compress() {
		String input = new BinaryStdIn().readString();
		char[] inputChar = input.toCharArray();

		// creating map of char and freq , kept getting an error when trying to create a tree from the map
		HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (int i = 0; i < inputChar.length; i++) {
			char c = inputChar[i];
			if (frequency.containsKey(c)) {
				frequency.put(c, frequency.get(c) + 1);
			} else {
				frequency.put(c, 1);
			}
		}

		// freq table in array of ascii legth
		int[] frequencyArr = new int[R];
		String[] st = new String[R];
		for (int i = 0; i < inputChar.length; i++)
			frequencyArr[inputChar[i]]++;

		// build Huffman trie
		Node root = buildTrie(frequencyArr);

		// build code table
		buildCode(st, root, "");

		// print trie for decoder
		writeTrie(root);

		// print number of bytes in original uncompressed message
		BinaryStdOut.write(inputChar.length);

		for (int i = 0; i < inputChar.length; i++) {
			String tmp = st[inputChar[i]];
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == '0') {
					BinaryStdOut.write(false);
				} else if (tmp.charAt(j) == '1') {
					BinaryStdOut.write(true);
				} else
					throw new IllegalStateException("Error");
			}
		}
		BinaryStdOut.close();
	}

	/**
	 * Reads a sequence of bits that represents a Huffman-compressed message from
	 * standard input; expands them; and writes the results to standard output.
	 */
	public static void decompress() {

		// read in Huffman trie from input stream
		Node root = readTrie();

		// number of bytes to write
		int length = BinaryStdIn.readInt();

		// decode using the Huffman trie
		for (int i = 0; i < length; i++) {
			Node tmp = root;
			while (!tmp.isLeaf()) {
				boolean bit = BinaryStdIn.readBoolean();
				if (bit)
					tmp = tmp.right;
				else
					tmp = tmp.left;
			}
			BinaryStdOut.write(tmp.ch, 8);
		}
		BinaryStdOut.close();
	}

	// build the Huffman trie given frequencies
	private static Node buildTrie(int[] freq) {

		// initialze priority queue with singleton trees
		MinPQ<Node> pq = new MinPQ<Node>();
		for (char i = 0; i < R; i++)
			if (freq[i] > 0)
				pq.insert(new Node(i, freq[i], null, null));

		// special case in case there is only one character with a nonzero frequency
		if (pq.size() == 1) {
			if (freq['\0'] == 0)
				pq.insert(new Node('\0', 0, null, null));
			else
				pq.insert(new Node('\1', 0, null, null));
		}

		// merge two smallest trees
		while (pq.size() > 1) {
			Node left = pq.delMin();
			Node right = pq.delMin();
			Node parent = new Node('\0', left.freq + right.freq, left, right);
			pq.insert(parent);
		}
		return pq.delMin();
	}

	// write bitstring-encoded trie to standard output
	private static void writeTrie(Node x) {
		if (x.isLeaf()) {
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch, 8);
			return;
		}
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}

	// make a lookup table from symbols and their encodings
	private static void buildCode(String[] st, Node x, String s) {
		if (!x.isLeaf()) {
			buildCode(st, x.left, s + '0');
			buildCode(st, x.right, s + '1');
		} else {
			st[x.ch] = s;
		}
	}

	private static Node readTrie() {
		boolean isLeaf = BinaryStdIn.readBoolean();
		if (isLeaf) {
			return new Node(BinaryStdIn.readChar(), -1, null, null);
		} else {
			return new Node('\0', -1, readTrie(), readTrie());
		}
	}

	/**
	 * Sample client that calls {@code compress()} if the command-line argument is
	 * "compress" an {@code decompress()} if it is "decompress".
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		if (args[0].equals("c")) {
			//final long startTime = System.nanoTime();
			compress();
			//final long elapsedTime = System.nanoTime() - startTime;
			//System.err.println("Compress time:" + elapsedTime);
		}

		else if (args[0].equals("d")) {
			//final long startTime = System.nanoTime();
			decompress();
			//final long elapsedTime = System.nanoTime() - startTime;
			//System.err.println("Decompress time:" + elapsedTime);
		}
		else
			throw new IllegalStateException("Error");
	}

}
