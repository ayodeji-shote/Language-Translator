
import java.util.Scanner;

public class List {
	private ListNode head; // The variable used to hold a reference of the instance of a ListNode object
	// This is the first item in the list.

	/**
	 * This is the default constructor. It is used to initialize the  fields to the default values.
	 */
	public List() {
		// set the list to be empty, this means that your values will not be skewed by any previous thing in the list.
		head = null;
	}

	/**
	 * Get the list node which is at the top of the list also know as the head. 
	 * 
	 * @return A refrence of the head at the top of the list.
	 */
	public ListNode getHead() {
		return head;
	}

	/**
	 * This method sets  the 'head' of the list to the specific node
	 * 
	 * @param newHead Is a reference to a ListNode object which will be at the top of the
	 *                list.
	 * 
	 * 
	 */
	public void setHead(ListNode newHead) {
		head = newHead;
	}

	/**
	 * This method adds a new node to the start of the list which will contain the data inputed
	 * (opp).
	 * 
	 * @param opp The operator for the of the list class
	 */
	public void addToList(double opp) {
		ListNode newNode;
		newNode = new ListNode(opp);
		newNode.setNext(head);
		head = newNode;
		printList();
	}

	/**
	 * This is the method that deletes the listNode from the list.
	 * @return returns the data of the listnode which is the operator 
	 */
	public ListNode deleteFromList() {
		ListNode nodeToDelete;
		nodeToDelete = head;
		 if (head == null) {
			 return null;
		} else {
			head = head.getNext();
		}
		 printList();
		 return nodeToDelete;
		

	}


/**
 * This is the method that checks if the list is empty and then gets the result as an answer
 * @param opp this is the operator number for the listnode 
 */
	public void isListEmpty(double opp) {
		 if (head== null) {
			System.out.println( " Your result is "+opp);
		}

	}
	

	/**
	 * This is the method that prints what is in the list. 
	 */
	public void printList() {
		// TODO Auto-generated method stub
		ListNode marker = null;
		marker = head;
		ListNode Nextnode = null;

		while (marker != null) {
			marker.getOpp();
			System.out.print(marker.getOpp()+ ",");
			marker = marker.getNext();
		}
		System.out.println();
	}

}
