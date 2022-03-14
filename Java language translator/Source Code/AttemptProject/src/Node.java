/**
 * The Node class is used to create a node object within our Binary Tree which was the selected data structure by the team to manage the dictionary storage.
 * It contains several variables which hold specific values that are used for word identification.
 * 
 *  left - it is used to connect a following node with smaller comparison ID.
 *  right - it is used to connect a following node with higher comparison ID.
 *  id - an integer value that is unique for each node within the specific tree, used to compare values when balancing and searching in the tree
 *  word_active - the unique word in the list which is being translated, used to create the hash(id) value of the node
 *  word_translated - the translated version of the word in the following language, might not be unique.
 *  found - A boolean value used by the balancing algorithm to define if a node was checked in the file.
 * 
 * @author truth
 * @version 1.0
 */
public class Node{

    Node left;
    Node right;
    int id;
    String word_active;
    String word_translated;
    boolean found;

    /**
     * Default constructor used when building the Binary Tree and storing it in it.
     * Defines the value of the components with the passed in parameters.
     * 
     * @param id - integer value with unique hash.
     * @param word_active - unique String that contains the original word in the desired language
     * @param word_translated - the translated version of the word to english or desired language if from english.
     */
    public Node(int id, String word_active, String word_translated){
        this.left = null;
        this.right = null;
        this.id = id;
        this.word_active = word_active;
        this.word_translated = word_translated;
        this.found = false;
    }
    
    /**
     * Sets the found variable in the node to true so it counts it as a scanned Node.
     * @param node - the reference to a specific Node
     */
    public void setfound(Node node) {
		found = true;
	}
    
    /**
     * Returns the value of found back to the caller method
     * @return - a boolean value contained within a specific Node.
     */
	public boolean getfound() {
		return found;
	}
}