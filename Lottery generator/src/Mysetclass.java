import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Mysetclass {
	public Set<Integer> setdata = new HashSet<>();
	Scanner answer12 = new Scanner(System.in);
	int dataInput = 0;
	int maxlotnum1;

	/**
	 * This is the method that initialises my set
	 */
	public Mysetclass() {
		setdata = new HashSet<Integer>();

	}

	/**
	 * This is the method that adds the user input to the set
	 */
	public void addToSet() {
		int data = 0;
		dataInput = 0;
		setdata.clear();
		Scanner input = new Scanner(System.in);
		boolean result = false;
		try {
			while (dataInput < 6) {
				System.out.println(" Please input your Lottery numbers  ");
				data = input.nextInt();
				if (data >= 1 && data <= maxlotnum1) {
					dataInput++;
					// Create an Integer object with our integer value
					Integer valueObject = new Integer(data);

					// Add the Integer object to our Set
					result = setdata.add(data);

				}
			}
			System.out.println(setdata);
			checksetSize();
		} catch (Exception e) {
			System.out.println(" That is not a valid input please try again");
			dataInput = 0;
			addToSet();

		}

		// Result will be false if the Integer already
		// exists in the Set

	}

	/**
	 * This is the method returns the set
	 * 
	 * @return returns the data in setdata
	 */
	public Set returnset() {
		return setdata;
	}

	/**
	 * This method prints the set
	 */
	public void printSet() {
		System.out.println(" Your lottery numbers are  " + setdata);
	}

	/**
	 * This is is the method that prints the set
	 * 
	 * @return
	 */
	public boolean isSetEmpty() {
		if (setdata.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This gets the size of the of the set method.
	 * 
	 * @return returns the size of the hashset called set data.
	 */

	public int getcardinality() {
		return setdata.size();

	}

	/*
	 * This is the setter method that gets the maximum lottery number 
	 */
	public void setMaxlot(int maxlotnum) {
		maxlotnum1 = maxlotnum;

	}

	/*
	 * This is the method that gets the set size.
	 */
	public void checksetSize() {
		if (setdata.size() != 6) {
			System.out.println(" Duplicate number detected please try again ");
			addToSet();
		} else {

		}
	}

}
