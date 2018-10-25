/**
 * DictBinTree --- Class to store and manipulate Node data in a dictionary, and maintain the structure as a Binary Tree.
 * @author      Torvald Johnson
 * SDU Login:   tjohn16
 */
 
public class DictBinTree implements Dict{
  private Node root;
  private int treeSize;
  private int counter;
  
    /**
   * Constructor. Returns a new, empty dictionary, with a size of 0 and a root of null.
   */
  public DictBinTree() {
    treeSize = 0;
    counter = 0;
    root = null;
  }
  
  /**
   * Inserts a new node with key k into the dictionary. while preserving the binary tree structure.
   * Children are assigned to affected nodes as necessary to preserve the tree structure.
   * @param k is the key to be given to the new node.
   */
  @Override public void insert(int k) {
    treeSize ++;
    Node z = new Node(k);
    Node y = null;
    Node x = root;
    while (x != null) {
      y = x;
      if (z.key < x.key){
        x = x.left;
      }
      else{
        x = x.right;
      }
    }
    if (y==null) {
      root = z;   //tree was empty
    }
    else if(z.key < y.key){
      y.left = z;
    }
    else y.right = z;
  }
  
/**
   * Returns all keys within the tree in an array, sorted from least to greatest.
   * Uses the treeSize variable to create an integer array the size of the dictionary,
   * Then calls the private method orderedTraversal2 from the root, which recursively 
   * traverses the tree adding all keys to the array in sorted order.
   */
  @Override public int[] orderedTraversal() {
    
    counter = 0;
    int[] treeKeys = new int[treeSize];
    return orderedTraversal2(root, treeKeys);
    
  }
  
/**
   * Recursively traverses the tree starting at a specified node, adding all keys to a given
   * integer array in sorted order.
   * @param x is the node to start the ordered traversal from.
   * @param keys is the integer array to be filled with keys, ordered from least to greatest.
   */
  private int[] orderedTraversal2(Node x, int[] keys) {
    if (x != null && counter <= treeSize){

      orderedTraversal2(x.left, keys);
      
      keys[counter] = x.key;
      counter ++;
      orderedTraversal2(x.right, keys);
    }
    return keys;
  }
  
/**
   * Starting at the root, checks if the current node's key is equal to a given key. If it is not
   * and the given key is a lower value than the current key, continues with the left child. Otherwise
   * continues with the right child. Returns true if a matching key is found, and false if a null node
   * is reached.
   * @param k is the integer searched for.
   */
  @Override public boolean search(int k) {
    Node x = root;
    while (x != null) {
      if (x.key == k) {
        return true;
      }
      if (k < x.key) {
        x = x.left;
      }
      else {
        x = x.right;
      }
    }
    return false;
  }
}


/**
 * Node --- Class to store key data, and references to its left and right child nodes. Left or right will be null if 
 * there is no child.
 * @author      Torvald Johnson
 * SDU Login:   tjohn16
 */
class Node {

	int key;

	Node left;
	Node right;

	Node(int key) {

		this.key = key;
		left = null;
		right = null;

	}
}