
public class ListNode {
	// These are the fields that store the data being held in this list node (The
	// opperators in the form doubles, and the ListNode)
	private double opp;
	private ListNode next;

	/**
	 * Default constructor. Initialise fields to default values
	 */
	public ListNode() {
		// set opp to default which is null because it is an empty value empty values
		opp = 0;
		next = null;
	}

	/**
	 * This is the alternative constructor. Which sets fields to given values.
	 *
	 * @param opp The opperator value that enters the listnode.
	 */
	public ListNode(double opp) {
		// set opp to the values provided
		this.opp = opp;
		next = null;
	}

	/**
	 * Get the opp value contained in this list node
	 * 
	 * @return The opperator
	 */
	public double getOpp() {
		return opp;
	}

	/**
	 * Get the next node present in the list after this one
	 * 
	 * @return the next node
	 */
	public ListNode getNext() {
		// TODO: return your list node reference
		return next;
	}

	/**
	 * Set the next node present in the list after this one
	 * 
	 * @param next is a reference to a ListNode object which is the next node in the
	 *             list after this one.
	 */
	public void setNext(ListNode node) {
		next = node;

	}

}
