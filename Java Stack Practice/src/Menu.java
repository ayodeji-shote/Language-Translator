import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu start = new Menu();
		start.menu();
	}

	/**
	 * This is the main method that I run the Whole program from, the menu has the options between 1 and 0
	 */
	public void menu() {

		displayInstructions();// Calling the method to display the instructions.
		displayMenu();// Calling the method to display the menu. 
		try {
			Scanner userInput = new Scanner(System.in); // The scanner for the user input to choose the options for the menu
			int choice = userInput.nextInt();
			if (choice == 1 || choice == 0) {
				switch (choice) {
				case 0:
					exit(); // Exit the program
					break;
				case 1:
					RPNCalculator parser = new RPNCalculator(); // Making an instance of the class the rpn calculator to call the main calculator method.
					parser.runSplit();
					break;
				case 2:

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
/**
 * These is the method that displays the instructions for how to type in postfix notation.
 */
	private void displayInstructions() {
		System.out.println(" ");
		System.out.println(" Input the line of your Postfix  calculations ");
		System.out.println(
				" These characters must all be on the same line and each character should be seperated by a , ");
		System.out.println(" Valid opperators that you can choose are: + , - , * , /");
		System.out.println(
				" All the inputs that are entered to the program must be numbers, if numbers are not entered the program will request for your too input it again. ");

	}
// Method to exit our program
	public void exit() {
		System.exit(0);
	}

	/**
	 * This is the method that displays the menu options to the user
	 */
	public static void displayMenu() {
		System.out.println("==========================");
		System.out.println("Please select your options ");
		System.out.println("1: Start calculator");
		System.out.println("0: Exit ");
		System.out.println("==========================");
	}

}
