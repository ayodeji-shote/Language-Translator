
public class Testerclass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testerclass test = new Testerclass();
		test.calculatorStart();
	}

	/**
	 * This was the Test to check the Start menu and the exit option of the menu and
	 * test the execptions for it;
	 */

	public void calculatorStart() {
		Menu m = new Menu();
		m.menu();

	}

	/**
	 * These were the methods and inputs i put it to check what would happen if i
	 * inputed the same lottery number twice
	 */

	public void numcheck() {
		LotterySet hi = new LotterySet();
		hi.collectSet(1, 1, 3, 4, 5, 6);
		hi.weekrun();
	}

	/**
	 * This was the test method to check if you added a string in the middle of it
	 */

	public void numcheck1() {
		LotterySet hi = new LotterySet();
		hi.collectSet(4, 6, 2, W, 1, 5);
		hi.weekrun();
	}

	/**
	 * Test to calculate the input for one week
	 */
	public void numcheck2() {
		LotterySet hi = new LotterySet();
		hi.collectSet(1, 2, 3, 4, 5, 6);
		hi.weekrun();
	}
	
	/**
	 * Test to calculate the input for a duplicate number
	 */
	public void numcheck3() {
		LotterySet hi = new LotterySet();
		hi.collectSet("W");
		hi.weekrun();
	}
	
	/**
	 * This is the test method to calulate putting in a string for the weeek 
	 */
	public void numcheck4() {
		LotterySet hi = new LotterySet();
		hi.collectSet();
		hi.weekrun("W");
	}
	/**
	 * This is the test method to calulate putting for multiple weeks
	 */
	public void numcheck5() {
		LotterySet hi = new LotterySet();
		hi.collectSet();
		hi.weekrun(3,10,100,1000,1000000);
	}
}
