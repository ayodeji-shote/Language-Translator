package week7Assigment;

public class Treenode {
	public int id; // This is the id of each Treenode that is created 
	public String name;// This is the name of each Treenode that is created 
	public double price;// This is the price of each Treenode that is created 
	public int amount;// This is the amount of each Treenode that is created 
	public Treenode right;// This is the right of the treenode that you are currently on 
	public Treenode left;// This is the left of the treenode that you are currently on 
	
	/**
	 * This is the method that initialises all the fields for the Treenode
	 */
	public Treenode() {
		// set id and mark to default / empty values
		id = 0;
		name = "";
		price = 0;
		amount = 1;
		right = null;
		left = null;
		// TODO: set next node to null - no valid next node yet

	}
	/**
	 * This is the method that sets all the values of the fields to a specific value at the start of the program  
	 * @param name This is the name of the iteam
	 * @param id This is the id of each iteam
	 * @param price This is the price of each iteam
	 */
	public Treenode(String name, int id, double price) {
		// set id and mark to values provided
		this.id = id;
		this.name = name;
		this.price = price;
		amount = 1;
		right = null;
		left = null;
		// TODO: set next node to null - no valid next node yet
	}
/**
 * This is the method that gets the id of the iteam
 * @return the id of the iteam
 */
	public int getID() {
		return id;
	}
	/**
	 * This is the method that gets the name of the name
	 * @return the name of the iteam
	 */
	public String getName() {
		return name;
	}
	/**
	 * This is the method that gets the price of the price
	 * @return the price of the iteam
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This is the method that gets the Treenode on the right of the current Treenode
	 * @return the price of the iteam
	 */
	public Treenode getright() {

		return right;

	}
	/**
	 * This is the method that sets the Treenode on the right of the current Treenode.
	 * @param node
	 */
	public void setright(Treenode node) {
		right = node;
	}
	/**
	 * This is the method that sets the Treenode on the left of the current Treenode.
	 * @param node
	 */
	public Treenode getleft() {

		return left;

	}
	/**
	 * This is the method that gets the amount of iteams that are in the binary tree
	 * @return
	 */
			
	public int getamount() {
		
		return amount;
	}
	/**
	 * This is the method that is used to set the amount of the Treenode it increases when a new iteam is added
	 * @param num
	 */
	public void setamountnode(int num )
	{
		amount = num;
	}
	/**
	 * This is the method that is used to set the amount of the Treenode it reduceses when a Treenode is removed
	 * @param num
	 */
	public void setamountnodedelete(int num )
	{
		amount = amount -num;
	}
	/**
	 * This is the method that is used to set the Treenode that is to the left of the current treenode 
	 * @param node
	 */
	public void setleft(Treenode node) {
		left = node;
	}

}
