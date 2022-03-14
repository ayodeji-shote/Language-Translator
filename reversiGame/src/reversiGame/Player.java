package reversiGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int player1moveY;

	public int player1moveX;

	public int player2moveY;

	public int player2moveX;

	public String user1;
	public String user2;
	public String userinput;
	public String userload;
	// This is the user input for the board game.
	Scanner player1inputY = new Scanner(System.in);
	Scanner player1inputX = new Scanner(System.in);
	Scanner player2inputY = new Scanner(System.in);
	Scanner player2inputX = new Scanner(System.in);
	Scanner Username1 = new Scanner(System.in);
	Scanner Username2 = new Scanner(System.in);
	Scanner savegame = new Scanner(System.in);
	Scanner loadgame = new Scanner(System.in); 


/**This is the method for the player 1 Y input
 * 
 * @return This returns the player 1 y position 
 */
	public int Player1Y() {
		System.out.println(user1 + " Please put in the Y coord for the X piece");

		while (!player1inputY.hasNextInt()) {
			System.out.println(user1 + " Error please enter the Y coord for the X piece");
			// Stores the user's new input
			player1inputY.next();
		}
		// Stores the user's input as an integer
		player1moveY = player1inputY.nextInt() - 1;
		return player1moveY;
	}

	/**This is the method for the player 1 X input
	 * 
	 * @return This returns the player 1 X position 
	 */
	public int Player1X() {
		System.out.println(user1 + " Please put in the X coord for the X piece ");

		while (!player1inputX.hasNextInt()) {
			System.out.println(user1 + " Error please enter the X coord for the X piece ");
			// Stores the user's new input
			player1inputX.next();
		}
		// Stores the user's input as an integer
		player1moveX = player1inputX.nextInt() - 1;
		return player1moveX;
	}

	/**This is the method for the player 2 X input
	 * 
	 * @return This returns the player 2 X position 
	 */
	public int Player2X() {
		System.out.println(user2 + " Please put in the X coord for the O piece ");

		while (!player2inputX.hasNextInt()) {
			System.out.println(user2 + " Error please enter the X coord O piece  ");
			// Stores the user's new input
			player2inputX.next();
		}
		// Stores the user's input as an integer
		player2moveX = player2inputX.nextInt() - 1;
		return player2moveX;
	}

	/**This is the method for the player 2 Y input
	 * 
	 * @return This returns the player 2 Y position 
	 */
	public int Player2Y() {
		gameBoard save = new gameBoard();
		System.out.println(user2 + " Please put in the Y coord for the O piece ");
		while (!player2inputY.hasNextInt()) {
			System.out.println(user2 + " Error please enter the Y coord for the O piece ");
			// Stores the user's new input
			player2inputY.next();
		}
		// Stores the user's input as an integer
		player2moveY = player2inputY.nextInt() - 1;
		return player2moveY;
	}

//This is the method to ask for the username of player 1 
	public String yourname1() {
		System.out.println("Player 1 please enter your name you will be the X piece ");

		user1 = Username1.nextLine();
		return user1;
	}

//This is the method to ask for the username of player 2 
	public String yourname2() {
		System.out.println("Player 2 please enter your name you will be the O piece");

		user2 = Username2.nextLine();
		return user2;
	}

	/**
	 * This method sets the users names as the strings name 1 and name 2 for the load method
	 * @param name1 The new name for the user 1 
	 * @param name2 The new name for the user 2 
	 */
	public void setNames(String name1, String name2) {
		user1 = name1; 
		user2 = name2;
		
	}



	
	
	
}
