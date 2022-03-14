
public class Stacks {
// This is the list object that calls the list method in the list. 
	private List aList;

// This is the constructor method of the stack class that creates a new list object 
	public void initialiseStack() {
		aList = new List();
	}

// This is the method that pushes things in the stack using the list and the input parameter for this method is the double that is being pushed into the stack
	public void push(double opp) {
		aList.addToList(opp);

	}
//This is the method that popped things in the stack using the list and the input parameter for this method is the double that is being popped into the stack

	public double pop() {

		ListNode delete = aList.deleteFromList(); // This delete is a new listnode that is made to save the double's
													// that are being popped from the stack

		return delete.getOpp(); // This method calls the method that gets the doubles stored in a listnode
	}

// This method checks if the stack is empty by calling the list method thtat checks if the list is empty
	public void isStackEmpty(double opp) {

		aList.isListEmpty(opp);
	}
}
