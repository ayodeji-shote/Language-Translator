
/**
 * These are the imports for the java set class. 
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class LotterySet {
	Menu er = new Menu();
	Mysetclass h = new Mysetclass();// This is the object from the My set class that is used to make a new set
	public Set<Integer> Lotset = new HashSet<>(); // The hashset for the lottery
	public Set<Integer> Copyset = new HashSet<>();// The first copy of hashset for the user created set
	public Set<Integer> copyset1 = new HashSet<Integer>();; // The second copy of hashset for the user created set so it
															// doesn't get

	Scanner answer1 = new Scanner(System.in);

	int Weeks; // The weeks that lottery input is run for
	int Weekcounter = 0; // counts each week that the lottery is run
	int TotalWinnings = 0; // Counts the total amount won
	public int TotalCost = 0; // Counts the total amount spent
	public int Totalprofit = 0; // counts the continous amount won after each week
	public int Spending = 0; // The total profit minus the total Cost
	public int maxlotnum;

	/**
	 * This is the constructor method that initialises the copyset hashset
	 */
	public LotterySet() {
		Mysetclass option = new Mysetclass();
		Lotset = new HashSet<Integer>();
		Copyset = new HashSet<Integer>();
		

	}

	public int getlotmax() {
		try {
		System.out.println("  Please enter your lottery max ");
		maxlotnum = answer1.nextInt();
		if (maxlotnum <=5) {
			System.out.println(" That is not a valid input please try again");
			er.menu();
		}
		h.setMaxlot(maxlotnum);
		}
		 catch (Exception e) {
				System.out.println(" That is not a valid input please try again");
				er.menu();
			}
		return maxlotnum;
	}

	/**
	 * This is the method that initialises the lottery set
	 * 
	 * @param data is the input parameter for the lottery set.
	 */
	public LotterySet(Set<Integer> data) {
		this.Lotset = new HashSet<Integer>(data);
	}

	/**
	 * This is the method that copy's the data from the user's input to the Copyset
	 * class.
	 */
	public void collectSet() {
		getlotmax();
		h.addToSet();
		Copyset = h.returnset();
	}

	/**
	 * This is the method that puts the data from the random number generator into
	 * the lottery set
	 */
	public void Lottery() {
		try {
			int Lotdata = 0;
			Lotset.clear();
			boolean winNums = false;
			Random randGenerator = new Random();
			while (Lotset.size() != 6) {
				int num = randGenerator.nextInt(maxlotnum + 1);
				if (num > 0) {
					winNums = Lotset.add(num);
				}

			}
			System.out.println(" Lottery " + Lotset);
		} catch (Exception e) {
			System.out.println(" That is not a valid input please try again");
			Lottery();
		}

	}

	/**
	 * This is the intersection method that initialises the second copy set and
	 * tranfers the data from the first copyset to the second is it isnt lost then
	 * it compares the data from the lottery set to the new copyset and finds the
	 * intersection then prints this interscetion
	 */
	public void Intersection() {
		System.out.println(Copyset);
		copyset1 = new HashSet<Integer>(Copyset);
		copyset1.retainAll(Lotset);
		System.out.println(" Your winning numbers are " + copyset1);
	}

	/**
	 * This is the method that calculates what you get from winning
	 */
	public void Winnings() {
		int ticketCost = 2;
		int winnings = 0;
		int profit = 0;
		if (copyset1.size() >= 3) {
			if (copyset1.size() == 3) {
				winnings = winnings + 25;
				TotalCost = TotalCost + 2;
				profit = winnings - ticketCost;
				Totalprofit = profit + Totalprofit;
				System.out.println(" Congratulations you won something for week " + Weekcounter
						+ " The value of your winnings are " + winnings + " Your  profit is " + profit);
			} else if (copyset1.size() == 4) {
				winnings = winnings + 100;
				TotalCost = TotalCost + 2;
				profit = winnings - ticketCost;
				Totalprofit = profit + Totalprofit;
				System.out.println(" Congratulations you won something for week " + Weekcounter
						+ " The value of your winnings are " + winnings + " Your  profit is " + profit);
			} else if (copyset1.size() == 5) {
				winnings = winnings + 1000;
				TotalCost = TotalCost + 2;
				profit = winnings - ticketCost;
				Totalprofit = profit + Totalprofit;
				System.out.println(" Congratulations you won something for week " + Weekcounter
						+ " The value of your winnings are " + winnings + " Your  profit is " + profit);
			} else if (copyset1.size() == 6) {
				winnings = winnings + 1000000;
				TotalCost = TotalCost + 2;
				profit = winnings - ticketCost;
				Totalprofit = profit + Totalprofit;
				System.out.println(" Congratulations you won something for week " + Weekcounter
						+ " The value of your winnings are " + winnings + " Your  profit is " + profit);
			}

		} else {
			TotalCost = TotalCost + 2;
			System.out.println("Sorry unfortunately you did not win anything this week try again next week ");
		}

	}

	/**
	 * This is the method that returns the value of the lottery set
	 * 
	 * @return
	 */
	public Set returnlotteryset() {
		return Lotset; // Returns the numbers in the lottery set
	}

	/**
	 * This is the method that runs the program based on the amount of weeks the
	 * user picked
	 */
	public void weekrun() {
		Menu m = new Menu();
		try {
			System.out.println(" How many weeks do you want to run your numbers for ");
			Weeks = answer1.nextInt();
			for (int i = 0; i < Weeks; i++) {
				Weekcounter++;
				Lottery();
				Intersection();
				Winnings();
			}
			Spending = Totalprofit - TotalCost;
			System.out.println(" Your total cost is " + TotalCost + " Pounds ");
			System.out.println(" =============================== ");
			System.out.println(" Your total profit is " + Totalprofit);
			System.out.println(" =============================== ");
			System.out.println(" Your Winnings is " + Spending + " Pounds ");
		} catch (Exception e) {
			System.out.println(" That is not a valid input please try again");
			m.menu();

		}

	}

}
