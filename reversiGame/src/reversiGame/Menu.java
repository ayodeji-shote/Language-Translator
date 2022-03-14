package reversiGame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	gameBoard gameboard;
	boolean load=false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")

		Menu choice = new Menu();
		choice.menu();
	}

	/**
	 * This is the method that displays the menu options to the user 
	 */
	public static void displayMenu() {
		fileReader();// This is the method that reads the file welcome to reversi
		System.out.println("==========================");
		System.out.println("Please select your options ");
		System.out.println("1: Start new game Player VS Player ");
		System.out.println("2: Load game ");
		System.out.println("0: Exit ");
		System.out.println("==========================");
	}
/**
 * This is the menu that is used for selecting the options that you want. 
 */
	public void menu() {
		displayMenu();// This is the method that displays the menu
		gameBoard gameboard; // The gameboard object to call the game method
		try {
		Scanner userInput = new Scanner(System.in);
		int choice = userInput.nextInt();
		gameBoard game = new gameBoard();
		switch (choice) {

		case 0:
			exit(); // Exit the program 
			break;

		case 1:
			gameboard = new gameBoard();
			gameboard.intArray(); // This is the method that initialises the array and sets it up 
			gameboard.Game(load); // This method runs the actual game with the parameter load, this parameter is put in so that the program can remeber the names of the users.
			break;

		case 2:
			loadGame(); // This calls the method that actually loads the game 
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		case 6:
			break;

		}
		}
		 catch (Exception e) {
			System.out.println(" That is  not an integer Try again: ");

		}
	}

	public void exit() {
		System.exit(0);
	}

	/**
	 * Loads the game by loading each player object from the user's file in the
	 * saveFiles folder
	 */
	public void loadGame() {
		boolean load=true;
		System.out.println("SaveGame");
		// it as fileToImport
		String fileToImport = "Savegame";

		// This  a try block that is  used for Java's error handling system in order to handle any exceptions the user would put in 
		try {
			// This creates the object for the  FileInputStream used in order to import the file
			FileInputStream fileInput = new FileInputStream(new File(fileToImport));
			
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);

			// This  stores the object from the chosen file
			gameboard = (gameBoard) objectInput.readObject();
			gameboard.Game(load);
			System.out.println("Game has been loaded");

			// This closes the file
			objectInput.close();
			fileInput.close();
		}

		// Exceptions that runs  if there's no file found 
		catch (FileNotFoundException e) {
			System.out.println("No saved game has been found");
			loadGame();
		}

		//Exceptions that runs  if there's no class found
		catch (ClassNotFoundException e) {
			System.out.println("No valid save file has been found");
			loadGame();
		}

		// Runs if there's a more general error
		catch (IOException e) {
			System.out.println("An error has occured");
			// Prints out Java's interpretation of the error
			e.printStackTrace();
		}
	}

	// This is the file reader that reads the welcome to reversi text
	public static void fileReader() {

		try {
			// This open the file that is to be read from
			// This is the command line parameter for the file 
			FileInputStream fstream = new FileInputStream("/reversiGame/src/reversiGame/Reversi.txt");

			// This is that DataInputStream for the file 
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line 
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
