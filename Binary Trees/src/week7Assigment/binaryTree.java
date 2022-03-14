package week7Assigment;

public class binaryTree {
	private Treenode root; // This is the first Treenode for the binary tree
	boolean deletedNode = false;
	Treenode previous; // This is the Treenode behind the current Treenode
	Treenode currentnum;// This is the current Treenode
	Treenode change; // This is the node that is changed when deleting parts of the trees
	double totalprice = 0; // This is the double amount that records the total flask
	int amount1 = 1; // This is the int for recording the amount of iteams in the binary tree
	int amount2 = 1;// This is the int for removing one from the amount of iteams in the binary tree

	/**
	 * This is the constructor method for the binary tree
	 */
	public binaryTree() {
		root = null;
	}

	/**
	 * This is the method that adds a Treenode to the binary Tree when a dublicate
	 * iteam is added it increases the amount
	 * 
	 * @param name  The name of the iteam
	 * @param id    The id of the iteam
	 * @param price This is the price of each iteam that is put in
	 */
	public void addTree(String name, int id, double price) {
		Treenode newNode;
		newNode = new Treenode(name, id, price);
		totalprice = price + totalprice;
		if (root == null) {
			root = newNode;
		} else {
			addNode(newNode, root);
		}

	}

	/**
	 * This is the add method that handles writing to a file this first half of the method handles adding the root to the tree.
	 * 
	 * @param name  The name of the iteam
	 * @param id    The id of the iteam
	 * @param price This is the price of each iteam that is put in
	 */
	public void addTree2(String name, int id, double price) {
		Treenode newNode;
		newNode = new Treenode(name, id, price);
		totalprice = price + totalprice;
		if (root == null) {
			root = newNode;
		} else {
			addNode2(newNode, root);
		}

	}
	/**
	 * This is the same method as the previous add method but the first add method
	 * adds the root to the tree, this one adds everynode that is not the root
	 * 
	 * @param name  The name of the iteam
	 * @param id    The id of the iteam
	 * @param price This is the price of each iteam that is put in
	 */
	public void addNode(Treenode added, Treenode current) {
		Menu h = new Menu();
		if (added.getID() < current.getID()) {
			if (current.getleft() == null) {
				current.setleft(added);
			} else {
				addNode(added, current.getleft());
			}

		} else if (added.getID() > current.getID()) {
			if (current.getright() == null) {
				current.setright(added);

			}

			else {
				addNode(added, current.getright());
			}

		} else if (added.getID() == current.getID()) {

			amount1 = amount1 + 1;
			current.setamountnode(amount1);
			System.out.println(
					" --------------------------------------------------------------------------------------------------------------");
			System.out.println(
					" Oh the id of this iteam is the same as another iteam the program will just add one to the stock of this iteam ");
			System.out.println(
					" --------------------------------------------------------------------------------------------------------------");
		}
	}
/**
 * This is the second add method that is part of the file writing method, the purpose of this method is too add Treenodes to the binary tree save it too a text file then load in the same text file.
 * @param added this is the Treenode that is added to the Treenode
 * @param current This is the Treenode that is used to check where the added treenode belongs on the tree.
 */
	public void addNode2(Treenode added, Treenode current) {
		Menu h = new Menu();
		if (added.getID() < current.getID()) {
			if (current.getleft() == null) {
				current.setleft(added);
			} else {
				addNode2(added, current.getleft());
			}

		} else if (added.getID() > current.getID()) {
			if (current.getright() == null) {
				current.setright(added);

			}

			else {
				addNode2(added, current.getright());
			}

		} else if (added.getID() == current.getID()) {

		}
	}
/**
 * This is the first method for deleting a Treenode, this method deals with deleting the root of the Treenode
 * @param id this is the id of the node you want to delete
 */
	public void deleteroot1(int id) {
		Treenode rootToDelete;
		Treenode nodetomove;
		Treenode nodesTosave1;
		Treenode nodesTosave2;
		if (id == root.getID()) {
			double p = root.getPrice();
			totalprice = totalprice - p;
			Treenode right = root.getleft();
			if (right.getright() != null) {
				rootdeltercheckleft(right.getright(), root.getleft());
			} else {
				if (root.getamount() >= 2) {
					root.setamountnodedelete(amount2);
				} else if (root.getamount() == 1) {
					nodetomove = root.getleft();
					nodesTosave1 = root.getleft();
					nodesTosave1 = nodesTosave1.getleft();
					nodesTosave2 = root.getright();
					rootToDelete = root;
					rootToDelete.setleft(null);
					setroot(nodetomove);
					nodetomove.setleft(nodesTosave1);
					nodetomove.setright(nodesTosave2);
				}
			}

		} else if (id < root.getID()) {
			deletenode(id);
		} else if (id > root.getID()) {
			deletenode(id);
		}
	}
	/**
	 * This is the delete method if you want to delete a node that is attached to two other nodes on the left side
	 * @param start
	 * @param prev
	 */
	public void rootdeltercheckleft(Treenode start, Treenode prev) {
		Treenode rootToDelete;
		Treenode nodetomove;
		Treenode nodesTosave1;
		Treenode nodesTosave2;
		change = start;
		if (change.getright() != null) {
			rootdeltercheckleft(change.getright(), prev.getright());
		} else if (change.getright() == null) {
//			root.setamountnode(amount2);
			if (root.getamount() >= 2) {
				root.setamountnodedelete(amount2);
			} else if (root.getamount() == 1) {
				rootToDelete = root;
				nodesTosave1 = root.getright();
				nodesTosave2 = root.getleft();
				setroot(null);
				setroot(change);
				prev.setright(null);
				root.setleft(nodesTosave2);
				root.setright(nodesTosave1);
			}

		}
	}
/**
 * This is the method that handles deleting Treenodes that are attacked to no nodes, or one node
 * @param id
 */
	public void deletenode(int id) {
		double a = currentnum.getPrice();
		System.out.println(" The iteam with the ID " + currentnum.getID() + " will be deleted");
		Treenode nodeToDelete;
		System.out.println(" The id is  " + id);
		Treenode left = currentnum.getleft();
		Treenode right = currentnum.getright();
		if (id == currentnum.getID() && left == null && right == null && previous.getleft() == currentnum) {
			totalprice = totalprice - a;
//			currentnum.setamountnode(amount2);
			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				nodeToDelete = currentnum;
				previous.setleft(null);
			}
		} else if (id == currentnum.getID() && left == null && right == null && previous.getright() == currentnum) {
			totalprice = totalprice - a;
//			currentnum.setamountnode(amount2);
			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				nodeToDelete = currentnum;
				previous.setright(null);
			}
		} else if (id == currentnum.getID() && left != null && right == null && previous.getleft() == currentnum) {
			totalprice = totalprice - a;

			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				nodeToDelete = currentnum;
				previous.setleft(null);
				previous.setleft(left);
			}
		} else if (id == currentnum.getID() && left == null && right != null && previous.getright() == currentnum) {
			totalprice = totalprice - a;
			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				nodeToDelete = currentnum;
				previous.setright(null);
				previous.setright(right);
			}
		} else if (id == currentnum.getID() && previous.getleft() == currentnum) {
			deleteW2left1(currentnum.getleft(), currentnum.getleft());
		} else if (id == currentnum.getID() && previous.getright() == currentnum) {
			deleteW2right1(currentnum.getleft(), currentnum.getleft());
		}

	}
/**
 * This is the method that deals with deleting nodes that are attacked to two other nodes for the left side
 * if there is no right node on the left side this method just takes the first left node and uses it .
 * @param current This is the current node you are on
 * @param before This is the node before the current node
 */
	public void deleteW2left1(Treenode current, Treenode before) {

		Treenode rootToDelete; // This is the Treenode that you delte
		Treenode nodetomove; // This is the Treenode that you move 
		Treenode nodesTosave1; // This is the left point of the node that you delete
		Treenode nodesTosave2; // This is the right pointer of the node that you delete
		if (current.getright() != null) {
			deleteW2left2(current.getright(), before);
		} else if (current.getleft() == null && current.getright() == null)

		{
			rootToDelete = previous.getleft();
			double b = rootToDelete.getPrice();
			totalprice = totalprice - b;
			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				currentnum.setamountnodedelete(amount2);
				nodesTosave2 = currentnum.getright();
				nodetomove = currentnum.getleft();
				previous.setleft(null);
				previous.setleft(nodetomove);
				nodetomove.setright(nodesTosave2);
			}

		}

	}
	/**
	 * This is the method that deals with deleting nodes that are attacked to two other nodes but for the right side .
	 * @param current This is the current node you are on
	 * @param before This is the node before the current node
	 */
	public void deleteW2right1(Treenode current, Treenode before) {
		Treenode rootToDelete;
		Treenode nodetomove;
		Treenode nodesTosave1;
		Treenode nodesTosave2;
		if (current.getright() != null) {
			
			deleteW2right2(current.getright(), before);
		} else if (current.getright() == null && current.getleft() == null)

		{
			rootToDelete = previous.getright();
			double c = rootToDelete.getPrice();
			totalprice = totalprice - c;
			if (currentnum.getamount() >= 2) {
				currentnum.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				currentnum.setamountnodedelete(amount2);
				rootToDelete.setamountnode(amount2);
				nodesTosave2 = currentnum.getleft();
				nodetomove = currentnum.getright();
				previous.setright(null);
				previous.setright(nodetomove);
				nodetomove.setleft(nodesTosave2);
			}
		}
	}
	/**
	 * This is the method that deals with deleting nodes that are attacked to two other nodes for the left side
	 * if there is a right node on the left side this method just keeps going right untill it hits a right node and uses it for replacement .
	 * @param current This is the current node you are on
	 * @param before This is the node before the current node
	 */
	public void deleteW2left2(Treenode right, Treenode beforeright) {
		Treenode rootToDelete;
		Treenode nodetomove;
		Treenode nodesTosave1;
		Treenode nodesTosave2;

		change = right;
		if (right.getright() != null) {
			deleteW2left2(right.getright(), beforeright.getright());
		} else if (right.getright() == null) {
			rootToDelete = previous.getleft();
			double c = rootToDelete.getPrice();
			totalprice = totalprice - c;
			if (rootToDelete.getamount() >= 2) {
				rootToDelete.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				currentnum.setamountnodedelete(amount2);
				nodetomove = right;
				nodesTosave1 = currentnum.getleft();
				nodesTosave2 = currentnum.getright();
				beforeright.setright(null);
				previous.setleft(null);
				nodetomove.setright(null);
				previous.setleft(nodetomove);
				nodetomove.setleft(nodesTosave1);
				nodetomove.setright(nodesTosave2);
			}

		}

	}
	/**
	 * This is the method that deals with deleting nodes that are attacked to two other nodes for the right side
	 * if there is a left node on the right side this method just keeps going right until it hits a left node and uses it for replacement .
	 * @param current This is the current node you are on
	 * @param before This is the node before the current node
	 */
	public void deleteW2right2(Treenode right, Treenode beforeright) {
		Treenode rootToDelete;
		Treenode nodetomove;
		Treenode nodesTosave1;
		Treenode nodesTosave2;
		change = right;
		if (right.getright() != null) {
			deleteW2right2(right.getright(), beforeright.getright());
		} else if (right.getright() == null) {
			rootToDelete = previous.getright();
			double d = rootToDelete.getPrice();
			totalprice = totalprice - d;
			if (rootToDelete.getamount() >= 2) {
				rootToDelete.setamountnodedelete(amount2);
			} else if (currentnum.getamount() == 1) {
				currentnum.setamountnodedelete(amount2);
				nodetomove = right;
				nodesTosave1 = currentnum.getleft();
				nodesTosave2 = currentnum.getright();
				beforeright.setright(null);
				previous.setright(null);
				nodetomove.setleft(null);
				previous.setright(nodetomove);
				nodetomove.setleft(nodesTosave1);
				nodetomove.setright(nodesTosave2);
			}

		}

	}
/**
 * This is the method for search the first thing that it searches for is the root of the binary tree if it cant find it then it calls another method.
 * @param id This is the id of the current node you are trying to find 
 * @param root This is the root of the tree.
 */
	public void searchRoot(int id, Treenode root) {

		if (id == root.getID()) {
			System.out.println("  The iteam is found it is iteam " + root.getName());
		} else {
			searchnode(id, root);
		}
	}
	/**
	 * This is the method for searching in the binary tree if it can't find it then it calls another method.
	 * @param id This is the id of the current node you are trying to find 
	 * @param root This is the root of the tree.
	 */
	public Treenode searchnode(int id, Treenode current) {

		try {
			if (id < current.getID()) {
				previous = current;
				searchnode(id, current.getleft());
			} else if (id > current.getID()) {
				previous = current;
				searchnode(id, current.getright());
			} else if (id == current.getID()) {
				currentnum = current;
				System.out.println(" The iteam is found it is  " + current.getName());
				return currentnum;

			}

		} catch (Exception e) {
			System.out.println(" That value is not in our inventory please try again ");

		}
		return previous;

	}
/**
 * This is the method that handles post order print
 * @param temp This is the root of the binary tree or where to start printing from.
 */
	public void postOrderPrint(Treenode temp) {
		Menu a = new Menu();
		try {
			if (temp.getleft() != null) {
				postOrderPrint(temp.getleft());
			}
			if (temp.getright() != null) {
				postOrderPrint(temp.getright());
			}
			System.out.println(temp.getName() + "	||	" + temp.getID() + "	||	" + temp.getPrice() + "	||	"
					+ temp.getamount());
		} catch (Exception e) {
			System.out.println(" please add something to the store then try again");
			a.menu();
		}
	}
	/**
	 * This is the method that handles pre order print
	 * @param temp This is the root of the binary tree or where to start printing from.
	 */
	public void preOrderPrint(Treenode temp) {
		Menu b = new Menu();
		try {
			System.out.println(temp.getName() + "	||	" + temp.getID() + "	||	" + temp.getPrice() + "	||	"
					+ temp.getamount());
			if (temp.getleft() != null) {
				preOrderPrint(temp.getleft());
			}
			if (temp.getright() != null) {
				preOrderPrint(temp.getright());
			}
		} catch (Exception e) {
			System.out.println(" please add something to the store then try again");
			b.menu();
		}

	}
	/**
	 * This is the method that handles in order print
	 * @param temp This is the root of the binary tree or where to start printing from.
	 */
	public void inOrderPrint(Treenode temp) {
		Menu c = new Menu();
		try {
			if (temp.getleft() != null) {
				inOrderPrint(temp.getleft());
			}
			System.out.println(temp.getName() + "	||	" + temp.getID() + "	||	" + temp.getPrice() + "	||	"
					+ temp.getamount());
			if (temp.getright() != null) {
				inOrderPrint(temp.getright());
			}
		} catch (Exception e) {
			System.out.println(" please add something to the store then try again");
			c.menu();
		}
	}
/**
 * This is the method that displays the total price of the basket
 */
	public void printTotalPrice() {
		System.out.println("----------------------------------------------------------");
		System.out.println("		Your total price is 	" + totalprice);
		System.out.println("----------------------------------------------------------");
	}
/**
 * This is the method to get the root of the binary tree
 * @return
 */
	public Treenode getroot() {
		Menu men = new Menu();
		if (root == null) {
			System.out.println(" Sorry you need to add iteams to the store first ");
			men.MenuDisplay();
		}
		return root;

	}
/**
 * This is the method to set the root of the binary tree 
 * @param current This is the treenode that you want to set the root too when replacing it
 */
	public void setroot(Treenode current) {
		root = current;
	}

	/**
	 * This is the method that gets the treenode behind the one that the program is currently on
	 * @return this method returns the previous value
	 */
	public Treenode previous() {

		return previous;
	}
	/**
	 * This is the method that get the treenode that the program is currently on
	 * @return This method returns the current value
	 */
	public Treenode current() {
		System.out.println(" The current is " + currentnum.getID());
		return currentnum;
	}

}
