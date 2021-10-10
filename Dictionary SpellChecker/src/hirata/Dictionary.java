package hirata;

public class Dictionary {
	private WordNode root;

	public Dictionary () {
		root = null;
	}

	public void insertWordNode (String word) {
		WordNode temp = new WordNode(word);
		if (root == null) {
			root = temp;
		} else {
			insertAtLocation(root, temp);
		}
	}

	public void insertAtLocation(WordNode ptr, WordNode wordToAdd) {
		// Negative integer = wordToAdd is less than ptr
		// Zero = wordToAdd is equal to the ptr
		// Positive = wordToAdd is greater than pointer
		while (true) {
			// Word already exists
			if (wordToAdd.word.compareToIgnoreCase(ptr.word) == 0) {
				break;
			} else if (wordToAdd.word.compareToIgnoreCase(ptr.word) < 0) { // Move left if less than
				if (ptr.left != null) {
					ptr = ptr.left;
				} else { // Add node to the left
					ptr.left = wordToAdd;
					break;
				}
			} else { // Move right if greater than
				if (ptr.right != null) {
					ptr = ptr.right;
				} else {
					ptr.right = wordToAdd;
					break;
				}
			}
		}
	}

	// Traversing the dictionary
	public void displayDictionary () {
		inOrderRecursivePrint(root);

	}

	public void inOrderRecursivePrint(WordNode ptr) {
		if (ptr != null) {
			inOrderRecursivePrint(ptr.left);
			System.out.println(ptr.word);
			inOrderRecursivePrint(ptr.right);
		}
	}

	// Spell checker

	public boolean spellCheck (String str) { 
		  boolean b = recursiveCheck(root, str);
		  return b;
	}
	
	public boolean recursiveCheck(WordNode ptr, String str) {
		if (ptr == null)
	        return false;
	 
	    if (ptr.word == str)
	        return true;
	 
	   // Recurring on left
	    boolean b1 = recursiveCheck(ptr.left, str);
	   
	    // If node is found
	    if(b1) return true;
	 
	    // Recurring on right
	    boolean b2 = recursiveCheck(ptr.right, str);
	 
	    return b2;
		
	}


}
