package hirata;

public class Dictionary {
	private WordNode root;

	public Dictionary () {
		root = null;
	}

	public void insertWordNode (String word) {
		assert (word != ""): "An empty string is not valid";

		WordNode temp = new WordNode(word);
		if (root == null) {
			root = temp;
		} else {
			insertAtLocation(root, temp);
		}
	}

	private void insertAtLocation(WordNode ptr, WordNode wordToAdd) {
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

	private void inOrderRecursivePrint(WordNode ptr) {
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
	
	private boolean recursiveCheck(WordNode ptr, String str) {
		if (ptr == null)
	        return false;
	 
	    if (ptr.word.equalsIgnoreCase(str))
	        return true;
	 
	   // Recurring on left
	    boolean b1 = recursiveCheck(ptr.left, str);
	   
	    // If node is found
	    if(b1) return true;
	 
	    // Recurring on right
	    boolean b2 = recursiveCheck(ptr.right, str);
	 
	    return b2;
		
	}
	
	public void checkWord(String str) {
		deleteNode(root, str);
	}
	
	private void deleteNode(WordNode ptr, String str) {
		WordNode parent = null;
		WordNode current = ptr;
		
		while (current!= null && !current.word.equalsIgnoreCase(str)) {
			parent = current;
			 
            if (str.compareToIgnoreCase(current.word)>0) {
                current = current.right;
            }
            else {
                current = current.left;
            }
		}
		
		if (current == null) {
			System.out.println("No node to delete");
			return;
		}
		
		// Node to be deleted has no children
		if (current.left == null && current.right == null) {
   
            if (current != root)
            {
                if (parent.left == current) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            // If the tree has only a root node, set it to null
            else {
                root = null;
            }
        }
		
		// Node to be deleted has two children
		else if (current.left != null && current.right != null)
        {
            // Find its inorder successor node
            WordNode successor = getMinimumKey(current.right);
 
            // Store successor word
            String s = successor.word;
 
            // Recursively delete the successor
            deleteNode(root, successor.word);
 
            // Copy word of the successor to the current node
            current.word = s;
        }
		
		else {
            // Choose a child node
            WordNode child = (current.left != null)? current.left: current.right;
 
            // if the node to be deleted is not a root node, set its parent to its child
            if (current != root)
            {
                if (current == parent.left) {
                    parent.left = child;
                }
                else {
                    parent.right = child;
                }
            }
 
            // If node to be deleted is the root node
            else {
                root = child;
            }
        }
	}
	
	private WordNode getMinimumKey(WordNode curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }


}
