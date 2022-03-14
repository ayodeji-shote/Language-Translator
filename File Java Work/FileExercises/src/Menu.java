import java.util.Scanner;
public class Menu {
int choice;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Menu choice = new Menu();
choice.menu();
	}
/**
 * This is the method that displays the menu options 	
 */
	public void displayMenu() {
		System.out.println("Please select your options ");
		System.out.println("1: File Reader ");
		System.out.println("2: File Writer ");
		System.out.println("3: File copier ");
		System.out.println("4: File Decipherer ");
		System.out.println("5: Average data ");
		System.out.println("6: Array file" );
		System.out.println("0: Exit ");
	}

	
	/**
	 * this is the break and switch that lets the user pick which option they want 
	 */
	public void menu() {
		displayMenu(); 
		Scanner userInput = new Scanner(System.in);
		int choice = userInput.nextInt(); 
		
		
		
		switch (choice) {
		
		case 0:
			exit();
			break;
			
		case 1: Files.fileReader();
				break;
		
		case 2: Files.writeToAFile();
		break;
		
		case 3: Files.Copyfile();
		break;
		
		case 4: Files.fileDecipher();
		break;
		
		case 5: Files.averageData();
		break;
		
		case 6: Files.arrayfile();
		break;
		
		}
		
	}
		
public void exit(){
		System.exit(0);	
		}


}
