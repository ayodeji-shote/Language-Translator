import java.util.ArrayList;

/**
 * Binary Tree is a class that is our data structure of choice. It will store our dictionary's data in a simple format.
 * There are 4 reference to this class within the main program as we use different trees for each language to foreign language translation.
 * They will contain the following formats:
 * English to French - English hash, English word, French word
 * English to Italian - English hash, English word, Italian word
 * French to English - French has, French word, English word
 * Italian to English - Italian hash, Italian word, English word
 * 
 * This format is kept for the main purpose that we want our code to be universally usable with any new language as long as we keep the same format of input
 * FOR SUMMARY of the many variables within this class which are used.
 * They are used to to only balance the tree once its being stored as a dictionary to optimise running speed of the program.
 * @author truth
 *
 */
public class BinaryTree{

    Node root;
    @SuppressWarnings("unused")
	private  int cancelR = 0;
	ArrayList<Node> leafs = new ArrayList<Node>();// Creating arraylist
	ArrayList<Node> btree = new ArrayList<Node>();
	double dr = 0;
	double dl = 0;
	double depthleft = 0;
	double depthright = 0;
	double[] depthcountL = new double[1];
	double[] depthcountR = new double[1];
	boolean l = false;
	boolean r = false;
	double ld;
	double rd;

    public BinaryTree(){

    }
/**
 * This is the method to add a word to the binary tree it calls the recursive method that finds the best place in the binary tree to add a word
 * @param id is the hashcode for the specific word 
 * @param word_active is the input word that the user putting int othe binary tree 
 * @param word_translated this is the translated version of the word that the user added.
 */
	public void add(int id,String word_active, String word_translated) {
	    root = addRecursive(root, id, word_active, word_translated);
	}
	
	
	/**
	 * This is the recursive add method that finds the right place in the tree to add the word
	 * @param current This is the current active node 
	 * @param id This is the hashcode of the word
	 * @param word_active this is the current word that the user wants to add 
	 * @param word_translated this is the translated version of the word the user added.
	 */
    private Node addRecursive(Node current, int id, String word_active, String word_translated) {
		if (current == null) {
			return new Node(id, word_active, word_translated);
		}

		if (id < current.id) {
			current.left = addRecursive(current.left, id, word_active, word_translated);
		} else if (id > current.id) {
			current.right = addRecursive(current.right, id, word_active, word_translated);
		} else {
			// id already exists
			return current;
		}
		return current;
	}

    /**
     * This is the method that finds the leaf of the tree 
     * @param temp - This is the current active node.
     */
    public void leafFinder(Node temp) {

		try {

			if (temp.left != null) {
				leafFinder(temp.left);
			}
			btree.add(temp);
			if (temp.right != null) {
				leafFinder(temp.right );

			}
			if (temp.right  == null && temp.right  == null && temp.found == false) {
				leafs.add(temp);
			}
		}

		catch (Exception e) {
			System.out.println(" please add something to the store then try again");
		}
	}
    
    /**
     * This is the method that finds the depth of the tree 
     * @param temp - this is the current active node.
     */
    public void depth(Node temp) {
		dr = 0;
		dl = 0;
		for (int i = 0; i < leafs.size(); i++) {
			if (leafs.get(i).id < temp.id) {
				searchnodeleft(leafs.get(i), temp);
			}

		}
		System.out.println(" The depth of the left side of the tree is  " + depthcountL[0]);
		for (int i = 0; i < leafs.size(); i++) {
			if (leafs.get(i).id  > temp.id) {
				searchnoderight(leafs.get(i), temp);
			}

		}
		System.out.println(" The depth of the right side of the tree is   " + depthcountR[0]);

	}
    
    /**
     * This is the method that searches the left subtrees of the entire binary tree 
     * @param k is the current active node 
     * @param m is the previous node from k.
     */
    public void searchnodeleft(Node k, Node m) {

		try {
			if (dl < 1) {
				depthleft = 0;
				dl++;
				l = false;
			}
			if (k.id < m.id) {
				depthleft++;
				searchnodeleft(k, m.left);
			} else if (k.id > m.id) {
				depthleft++;
				searchnodeleft(k, m.right);
			}
			if (l == false) {
				if (k.id == m.id) {
					depthleft++;

					if (l == false) {
						depthcountL[0] = depthleft;
						ld = 0;
						ld = depthcountL[0];
						l = true;
					} else if (depthleft > ld) {
						depthcountL[0] = 0;
						depthcountL[0] = depthleft;
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" That value is not in our inventory please try again ");

		}

	}
    
    
    /**
     * This is the method that searches the left subtrees of the entire binary tree 
     * @param p is the current active node 
     * @param f is the previous node from k.
     */
    public void searchnoderight(Node p, Node f) {

		try {
			if (dr < 1) {
				depthright = 0;
				dr++;
				r = false;
			}
			if (p.id < f.id) {
				depthright++;
				searchnoderight(p, f.left);
			} else if (p.id > f.id) {
				depthright++;
				searchnoderight(p, f.right);
			}

			if (r == false) {
				if (p.id == f.id) {
					depthright++;

					if (r == false) {
						depthcountR[0] = depthright;
						rd = 0;
						rd = depthcountR[0];
						r = true;
					} else if (depthright > rd) {
						depthcountR[0] = 0;
						depthcountR[0] = depthright;
					}

				}
			}
		}
		catch (Exception e) {
			System.out.println(" That value is not in our inventory please try again ");

		}
	}
    /**
     * This is the method that deletes the entire tree 
     * @param bt This is the binary tree object that is passed in to call the add method
     * @param node this is the current node
     */
    public Node deleteentireTree(BinaryTree bt,Node node) {
		@SuppressWarnings("unused")
		Node n = null;
		if (node == null) {
			return null;
		}
		node.left = deleteentireTree(bt,node.left);
		node.right = deleteentireTree(bt,node.right);

		bt.setroot(null);
		node = null;
		return node;
	}
    
    /**
     * This is the method that adds the root to the new balanced tree then adds the rest of the nodes using a recursive method
     * @param bt this is a binary tree object that is used to add a node to the binary tree
     */
    public void balanceControll(BinaryTree bt) {
		if(depthcountR[0] - depthcountL[0]> 1 || depthcountR[0] - depthcountL[0]< -1 )
		{
		System.out.println(" Your tree is not balanced ");
		int start = 0;
		int end = btree.size();
		int middle = (start + end) / 2;
		deleteentireTree(bt, bt.getroot());
		Node m = btree.get(middle);
		if (m.found == false) {
			bt.add(btree.get(middle).id,btree.get(middle).word_active,btree.get(middle).word_translated);
			m.setfound(m);

			end = middle;
			middle = (start + end) / 2;
			balance(bt,start, middle, end);
			start = end;
			end = btree.size();
			middle = (start + end) / 2;
			balance(bt,start, middle, end);
		}
		}
		else
		{
			System.out.println(" Your tree is already balanced ");
		}

	}
    
    /**
     * This is the method that gets the root
     * @return the root node.
     */
    public Node getroot() {
		if (root == null) {
			System.out.println(" Sorry you need to add iteams to the store first ");
		}
		return root;

	}
    
    /**
     * This is the method that recursivly balances the binary tree and adds nodes to it
     * @param bt binary tree object that is used to add things to the tree 
     * @param start This is the start of the array 
     * @param end This is the end of the array 
     * @param middle this is the midpoint between the start and end of the array
     */
    public void balance(BinaryTree bt,int start, int middle, int end) {
		int end1 = end;
		Node p = btree.get(middle);
		if (p.getfound() == false) {
			bt.add(btree.get(middle).id,btree.get(middle).word_active,btree.get(middle).word_translated);
			p.setfound(p);

			if (end - start != 1) {
				end = middle;
				middle = (start + end) / 2;
				balance(bt, start, middle, end);
				start = end;
				middle = (start + end1) / 2;
				balance(bt, start, middle, end1);

			} else if (end - start == 1) {
				bt.add(btree.get(middle).id,btree.get(middle).word_active,btree.get(middle).word_translated);
			}

		}

	}
    
    /**
     * This is the method that sets the root of the binary tree
     * @param current - This is node that you want to set the root too

     */
	public void setroot(Node current) {
		root = current;
	}
	
	 /**
	  * This is the method that prints the list in the preorder method
     * @param temp This is the current active node
     */
	public void preOrderPrint(Node temp) {
		@SuppressWarnings("unused")
		General b = new General();
		try {
			System.out.println(temp.word_active + "		" + temp.id + "		" + temp.word_translated );
			if (temp.left != null) {
				preOrderPrint(temp.left);
			}
			if (temp.right != null) {
				preOrderPrint(temp.right);
			}
		} catch (Exception e) {
			System.out.println(" please add something to the store then try again");
//			b.menuen();
		}

	}
	 /**
	  * This is the method that recursively deletes a node 
     * @param current This is the current active node 
     * @param value This is the hashvalue of the word your deleting
     */
    private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.id) {
			// Leaf
			if (current.left == null && current.right == null) {
				return null;
			}
				// One child
			if (current.right == null && current.left != null) {
				return current.left;
			}
				if (current.left == null && current.right != null) {
				return current.right;
			}
				// Two childs
			if (current.left != null && current.right != null) {
				int smallestValue = findSmallestValue(current.right);
				current.id = smallestValue;
				current.right = deleteRecursive(current.right, smallestValue);
				return current;
			}
		}
			if (value < current.id) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

    /** This is the method that finds the smallest value in the tree
     * @param root this is the root of the tree 
     */
	private int findSmallestValue(Node root) {
		return root.left == null ? root.id : findSmallestValue(root.left);
	}
	
	/** 
	 * This is the method that deltes a node
     * @param id This is the id of the word that you want to delete.
     */
	public void delete(int id) {
		root = deleteRecursive(root, id);
	}
	/**
	 * This is the method that checks if your word is in the binary tree 
     * @param current This is the current active node 
     * @param value This is the hash value of the node.
     */
	private Node containsNodeRecursive(Node current, int value) {
    	if (current == null) {
        	return null;
    	} 
    	if (value == current.id) {
        	return current;
    	} 
    	return value < current.id ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
	}

	/**
	 * This is the method that checks if a node is in the binary tree by calling another recursive method 
     * @param value This is the hashvalue of the word you want to check for 
     * @return Node id - the found node's ID.
     */
	public Node containsNode(int value) {
    	return containsNodeRecursive(root, value);
	}
	
	 /**
	  * This is the method to get the root of the tree with a specific binary tree object
     * @param bt this is the specific binary tree object
     */
	public Node getrot(BinaryTree bt)
    {
    	return bt.getroot();
    	
    }
    
	/**
	 * This is the method to print a binary tree in the pre order method
     * @param bt this is the specific binary tree object  
     */
    public void print(BinaryTree bt)
    {
    	bt.preOrderPrint(getrot( bt));
    }
    /**
     * This is the method that calls the add method for the binary tree with a specific binary tree object 
     * @param bt this is the specific binary tree object 
     * @param code This is the specific hashcode for the word that you want to add 
     * @param englishword This is the english word that is passed in 
     * @param frenchword This is the french word that is passed in
     */
    
    public void add1(BinaryTree bt,int code, String englishword, String frenchword)
    {
    	bt.add(code,englishword, frenchword);
    }
    
    /**
     * This is the method that calls the delete method of the binary tree with a specific binary tree object 
     * @param bt this is the specific binary tree object 
     * @param remove this is the hashvalue of the word that you want to remove 
     */
    public void delete1(BinaryTree bt,int remove)
    {
    	bt.delete(remove);
    }
}

