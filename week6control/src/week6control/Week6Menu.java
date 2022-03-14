package week6control;
import java.util.Scanner;
/**
 * User input for the scanner
 * @author User
 *
 */
public class Week6Menu {
	String userinput;
	String seconduserinput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week6Menu menu1 = new Week6Menu();
		menu1.displayMenu();
		menu1.menuOption();

	}
	/**
	 * This is the method for the menu display.
	 */
	public void displayMenu() {

		System.out.println("please select one of the options below");
		System.out.println("1. Grade calculator ");
		System.out.println("2. Table");
		System.out.println("3. Statistics");
		System.out.println("4. Check percentage");
		System.out.println("0. Exit");
	}

	/**
	 * This is the method that calls the choice methods from the choice class.
	 */
	public void processUserChoices() {
		Week6Choice.gradecalculator();
		Week6Choice.PrintValues();
		Week6Choice.statistics();
		Week6Choice.checkPercentage();
		Week6Choice.exits();

	}

	/**
	 * This is the method for the menu option picker that loops unless option 1,2 or 4 is picked. 
	 * 
	 * 
	 */
	public void menuOption() {
		boolean runMenu = true;
		while (runMenu == true) {
			System.out.println("Please input the option you want. ");
			Scanner sc = new Scanner(System.in);
			String userinput = sc.nextLine();

			if (userinput.equals("1")) {
				Week6Choice.gradecalculator();
				break;
			} else if (userinput.equals("2")) {
				Week6Choice.PrintValues();
				break; 
			} else if (userinput.equals("3")) {
				Week6Choice.statistics();
				break;
			}  else if (userinput.equals("4")) {
				Week6Choice.checkPercentage();
				break;
			} 
			else if (userinput.equals("5")) {
				Week6Choice.exits();
			} else {
				System.out.println("invalid option was selected.");
			}
		}

	}

}


