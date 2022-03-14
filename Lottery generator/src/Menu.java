import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Menu m = new Menu();
m.menu();
	}
	
	
	/**
	 * This is the method that displays the instructions for how to use the lottery 
	 */
	private void displayInstructions() {
		System.out.println(" ");
		System.out.println(" Input the ammount of weeks that you want to play for" );
		System.out.println(" Input your loterry number then press enter ");
		System.out.println(" Your max must be greater than 5 ");
		System.out.println(" The number must be between 1 and the max ");
		System.out.println(" Input your loterry number then press enter ");

	}
	/**
	 * This is a method that displays the menu for the lottery 
	 */
	private void Displaymenu() {
		System.out.println(" ");
		System.out.println(" Welcome to the lottery what are your options ");
		System.out.println(" 1: Single player  " );
		System.out.println(" 0: Exit ");
	}
	// Method to exit our program
		public void exit() {
			System.exit(0);
		}
	
	/**
	 * This is the menu that is used to run the main program
	 */
	public void menu() {
		displayInstructions();
		Displaymenu();// Calling the method to display the menu. 
		try {
			Scanner userInput = new Scanner(System.in); // The scanner for the user input to choose the options for the menu
			LotterySet hi = new LotterySet();
			int choice = userInput.nextInt();
			if (choice == 1 || choice == 0 ) {
				switch (choice) {
				case 0:
					exit(); // Exit the program
					break;
				case 1:
					hi.collectSet();
					hi.weekrun();
					break;
				}
			}
			else {
				menu(); // This is for repeating the menu when the user enters a wrong answer.
			}
		}
		catch (Exception e) {
			System.out.println(" That is not a valid integer");
			menu();

		}
	}
}
