package reversiGame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class gameBoard implements Serializable {
	/**
	 * This serialVersionUID is for loading an object in the loadgame
	 */
	private static final long serialVersionUID = 1L;
	int playerTurn; // This is the variable for counting the player turns
	int turnNumber; // This is the variable for counting the turn number
	boolean play = true; // Boolean for running the game
	boolean player1turn = false; // Boolean for running player 1 turn
	boolean player2turn = false;// Boolean for running player 2 turn
	/**
	 * These ints are the two board pieces the X piece is represents 1 on the board,
	 * the O piece represents
	 */
	public final int X = 1;
	public final int O = 2;
	/**
	 * These are the variables for running the game
	 */
	int pointCounterY; // Counts the amount of O pieces
	int pointCounterX;// Counts the amount of X pieces
	int p1validcounter;// Counts the amount of valid moves for the X piece
	int p2validcounter;// Counts the amount of valid moves for the O piece
	/**
	 * These are the methods that booleans for verifying the position of the user
	 * piece.
	 */
	boolean validMovesp1E;
	boolean validMovesp1W;
	boolean validMovesp1N;
	boolean validMovesp1S;
	boolean validMovesp1NE;
	boolean validMovesp1SE;
	boolean validMovesp1SW;
	boolean validMovesp1NW;
	boolean validMovesp2E;
	boolean validMovesp2W;
	boolean validMovesp2N;
	boolean validMovesp2S;
	boolean validMovesp2NE;
	boolean validMovesp2SE;
	boolean validMovesp2SW;
	boolean validMovesp2NW;
	boolean p1validN;
	boolean p1validS;
	boolean p1validNW;
	boolean p1validNE;
	boolean p1validSW;
	boolean p1validSE;
	/**
	 * This is the grid the game is played on it is an int
	 */
	private int[][] grid = new int[8][8];

	/**
	 * These are the int's that is use for my player moves the totalvalidmovesX is
	 * the X axis the totalvalidmovesY is the Y axis.
	 */
	int totalvalidmovesX;
	int totalvalidmovesY;
	int turncount;
	/**
	 * These are the user names that they have to input in and it is stored as a
	 * string
	 */
	String user1;
	String user2;

	// This is the constructor method the initializes the gameboard array
	public gameBoard() {
		playerTurn = 1;
		intArray();
	}

	/**
	 * This is the method that actually initializes the array, it fill's the empty
	 * spaces with of the array with 0 and presets the position of the pieces to the
	 * default position.
	 */
	public void intArray() {
		int row;
		int col;
		for (row = 0; row < grid.length; row++) {
			for (col = 0; col < grid.length; col++) {
				grid[row][col] = 0;

			}
			grid[3][3] = X;
			grid[3][4] = O;
			grid[4][3] = O;
			grid[4][4] = X;

		}

	}

	/**
	 * a method to display game board to the user
	 */

	public void displayArray() {
		int row, col;

		System.out.print("    ");

		for (row = 0; row < grid.length; row++) {
			System.out.print(row + 1 + "  ");
		}

		System.out.println("  ");

		for (col = 0; col < grid.length; col++) {
			System.out.print(col + 1 + "  ");

			for (row = 0; row < grid.length; row++) {
				if (grid[row][col] == X) {
					System.out.print(" X ");
				} else if (grid[row][col] == O) {
					System.out.print(" O ");
				} else {
					System.out.print(" . ");
				}

			}
			System.out.println("  ");
		}
		System.out.println("==========================");
	}

	/**
	 * These are the methods that validate the users move in a direction these
	 * methods check that the place the player is placing the move is valid, then
	 * checks if there is the same piece at the end of the valid move, then flips
	 * all the pieces.
	 */
	/**
	 * Direction for East
	 * 
	 * @param player1moveX Player 1 X axis
	 * @param player1moveY Player 2 X axis
	 */
	public void P1E(int player1moveX, int player1moveY) { // Parameter for the method is the user moves.
		validMovesp1E = false;
		if (player1moveX + 2 <= 7) {
			if (player1moveX + 2 <= 7 && grid[player1moveX][player1moveY] != O) {
				if (grid[player1moveX + 1][player1moveY] == O) {

					if (player1moveX + 1 <= 7) { // Checks that the move is valid
						while (grid[player1moveX + 1][player1moveY] == O && player1moveX + 2 <= 7) {
							player1moveX++; // counts to find the opposing piece at the end of the move.
							if (player1moveX + 1 <= 7) {
								if (grid[player1moveX + 1][player1moveY] == X) {

									validMovesp1E = true;
								}
							}

						}
						if (validMovesp1E == true && player1moveX + 1 <= 7) {
							while (grid[player1moveX][player1moveY] == O && player1moveX - 1 >= 0) {
								grid[player1moveX][player1moveY] = X;
								player1moveX--; // counts back to its original position and starts flipping all the
												// opposing pieces that it crosses.
							}
							if (validMovesp1E == true && grid[player1moveX][player1moveY] == 0
									&& player1moveX + 1 <= 7) { // At the end of the flipping it prints the last piece
								grid[player1moveX][player1moveY] = X;
								player1turn = false;
							}
							if (validMovesp1E == true && grid[player1moveX][player1moveY] == 0 && player1moveX == 0) {
								grid[player1moveX][player1moveY] = X;
								player1turn = false;
							}

							else {

							}

						}
						if (validMovesp1E != true && player1moveX + 1 <= 7) {
							validMovesp1E = false;
						}
					}
				}
			}
		}
	}

	/**
	 * west direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1W(int player1moveX, int player1moveY) {
		validMovesp1W = false;
		if (player1moveX - 2 >= 0 && grid[player1moveX][player1moveY] != O) {
			if (grid[player1moveX - 1][player1moveY] == O && player1moveX - 2 >= 0) {

				while (grid[player1moveX - 1][player1moveY] == O && player1moveX - 2 >= 0) {
					player1moveX--;
					if (player1moveX - 1 >= 0) {
						if (grid[player1moveX - 1][player1moveY] == X) {

							validMovesp1W = true;
						}
					}

				}
				if (validMovesp1W == true && player1moveX - 1 >= 0) {
					while (grid[player1moveX][player1moveY] == O) {
						grid[player1moveX][player1moveY] = X;
						player1moveX++;
					}
					if (validMovesp1W == true && grid[player1moveX][player1moveY] == 0 && player1moveX - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					}

				}
				if (validMovesp1W != true) {
					validMovesp1W = false;

				}
			}
		}
	}

	/**
	 * North direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1N(int player1moveX, int player1moveY) {
		validMovesp1N = false;
		if (player1moveY - 2 >= 0) {
			if (grid[player1moveX][player1moveY - 1] == O && player1moveY - 2 >= 0
					&& grid[player1moveX][player1moveY] != O) {

				while (grid[player1moveX][player1moveY - 1] == O && player1moveY - 2 >= 0) {
					player1moveY--;
					if (player1moveY - 1 >= 0) {
						if (grid[player1moveX][player1moveY - 1] == X) {

							validMovesp1N = true;
						}

					}
				}
				if (validMovesp1N == true && player1moveY - 1 >= 0) {
					while (grid[player1moveX][player1moveY] == O && player1moveY + 1 <= 7) {
						grid[player1moveX][player1moveY] = X;
						player1moveY++;
					}
					if (validMovesp1N == true && validMovesp1E == false && validMovesp1W == false
							&& player1moveY - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					} else {

					}
				}
				if (validMovesp1N != true) {
					validMovesp1N = false;

				}
			}
		}
	}

	/**
	 * South direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1S(int player1moveX, int player1moveY) {
		validMovesp1S = false;
		if (player1moveY + 2 <= 7) {
			if (grid[player1moveX][player1moveY + 1] == O && player1moveY + 2 <= 7
					&& grid[player1moveX][player1moveY] != O) {

				if (player1moveY + 1 <= 7) {
					while (grid[player1moveX][player1moveY + 1] == O && player1moveY + 2 <= 7) {
						player1moveY++;
						if (player1moveY + 1 <= 7) {
							if (grid[player1moveX][player1moveY + 1] == X) {

								validMovesp1S = true;
							}
						}
					}
				}
				if (validMovesp1S == true && player1moveY + 1 <= 7) {
					while (grid[player1moveX][player1moveY] == O && player1moveY - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1moveY--;
					}
					if (validMovesp1S == true && validMovesp1E == false && validMovesp1W == false
							&& validMovesp1N == false && player1moveY + 1 <= 7) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					}
					if (validMovesp1S == true && validMovesp1E == false && validMovesp1W == false
							&& validMovesp1N == false && player1moveY + 1 <= 7) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					} else {

					}
				}
				if (validMovesp1S != true) {
					validMovesp1S = false;

				}
			}
		}
	}

	/**
	 * North east direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1NE(int player1moveX, int player1moveY) {

		validMovesp1NE = false;
		if (player1moveY - 2 >= 0 && player1moveX + 2 <= 7) {
			if (grid[player1moveX + 1][player1moveY - 1] == O && grid[player1moveX][player1moveY] != O
					&& player1moveY - 2 >= 0 && player1moveX + 2 <= 7) {
				if (player1moveY - 2 >= 0 && player1moveX + 2 <= 7) {
					while (grid[player1moveX + 1][player1moveY - 1] == O && player1moveY - 2 >= 0
							&& player1moveX + 1 <= 7) {
						player1moveY--;
						player1moveX++;
						if (player1moveY - 1 >= 0 && player1moveX + 1 <= 7) {
							if (grid[player1moveX + 1][player1moveY - 1] == X) {

								validMovesp1NE = true;
							}
						}
					}
				}
				if (validMovesp1NE == true && player1moveY - 1 >= 0 && player1moveX + 1 <= 7) {
					while (grid[player1moveX][player1moveY] == O && player1moveY + 1 <= 7 && player1moveX - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1moveY++;
						player1moveX--;
					}
					if (validMovesp1NE == true && validMovesp1S == false && validMovesp1E == false
							&& validMovesp1W == false && validMovesp1N == false && player1moveY - 1 >= 0
							&& player1moveX + 1 <= 7) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					} else {

					}
				}
				if (validMovesp1NE != true) {
					validMovesp1NE = false;

				}
			}
		}
	}

	/**
	 * South east direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1SE(int player1moveX, int player1moveY) {
		validMovesp1SE = false;
		if (player1moveY + 2 <= 7 && player1moveX + 2 <= 7) {
			if (grid[player1moveX + 1][player1moveY + 1] == O && grid[player1moveX][player1moveY] != O
					&& player1moveY + 2 <= 7 && player1moveX + 2 <= 7) {

				if (player1moveY + 1 <= 7 && player1moveX + 1 <= 7) {
					while (grid[player1moveX + 1][player1moveY + 1] == O && player1moveY + 2 <= 7
							&& player1moveX + 2 <= 7) {
						player1moveY++;
						player1moveX++;
						if (player1moveY + 1 <= 7 && player1moveX + 1 <= 7) {
							if (grid[player1moveX + 1][player1moveY + 1] == X) {

								validMovesp1SE = true;
							}
						}
					}
				}
				if (validMovesp1SE == true && player1moveY + 1 <= 7 && player1moveX + 1 <= 7) {
					while (grid[player1moveX][player1moveY] == O && player1moveY - 1 >= 0 && player1moveX - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1moveY--;
						player1moveX--;
					}
					if (validMovesp1SE == true && validMovesp1NE == false && validMovesp1S == false
							&& validMovesp1E == false && validMovesp1W == false && validMovesp1N == false
							&& player1moveY + 1 <= 7 && player1moveX + 1 <= 7) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					}

					else {

					}
				}
				if (validMovesp1SE != true && player1moveY + 1 <= 7 && player1moveX + 1 <= 7) {
					validMovesp1SE = false;

				}
			}
		}
	}

	/**
	 * South west direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1SW(int player1moveX, int player1moveY) {

		validMovesp1SW = false;
		if (player1moveY + 2 <= 7 && player1moveX - 2 >= 0) {
			if (grid[player1moveX - 1][player1moveY + 1] == O && grid[player1moveX][player1moveY] != O) {
				if (player1moveY + 2 <= 7 && player1moveX - 2 >= 0) {
					while (grid[player1moveX - 1][player1moveY + 1] == O && player1moveY + 2 <= 7
							&& player1moveX - 2 >= 0) {
						player1moveY++;
						player1moveX--;
						if (player1moveY + 2 <= 7 && player1moveX - 2 >= 0) {
							if (grid[player1moveX - 1][player1moveY + 1] == X) {

								validMovesp1SW = true;
							}

						}
					}
				}
				if (validMovesp1SW == true && player1moveY + 1 <= 7 && player1moveX - 1 >= 0) {
					while (grid[player1moveX][player1moveY] == O && player1moveX + 1 <= 7 && player1moveY - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1moveY--;
						player1moveX++;
					}
					if (validMovesp1SW == true && validMovesp1SE == false && validMovesp1NE == false
							&& validMovesp1S == false && validMovesp1E == false && validMovesp1W == false
							&& validMovesp1N == false && player1moveY + 1 <= 7 && player1moveX - 1 >= 0) {
						grid[player1moveX][player1moveY] = X;
						player1turn = false;
					} else {
					}
				}
			}
			if (validMovesp1SW != true) {
				validMovesp1SW = false;

			}
		}
	}

	/**
	 * Norht west direction
	 * 
	 * @param player1moveX x axis position
	 * @param player1moveY y axis position
	 */
	public void P1NW(int player1moveX, int player1moveY) {
		validMovesp1NW = false;
		if (player1moveY - 2 >= 0 && player1moveX - 2 >= 0) {
			if (grid[player1moveX - 1][player1moveY - 1] == O && grid[player1moveX][player1moveY] != O) {
				if (player1moveY - 2 >= 0 && player1moveX - 2 >= 0) {
					while (grid[player1moveX - 1][player1moveY - 1] == O && player1moveY - 2 >= 0
							&& player1moveX - 2 >= 0) {
						player1moveY--;
						player1moveX--;
						if (player1moveY - 1 >= 0 && player1moveX - 1 >= 0) {
							if (grid[player1moveX - 1][player1moveY - 1] == X) {

								validMovesp1NW = true;
							}

						}
						if (validMovesp1NW == true && player1moveY - 1 >= 0 && player1moveX - 1 >= 0) {
							while (grid[player1moveX][player1moveY] == O && player1moveY + 1 <= 7
									&& player1moveY + 1 <= 7) {
								grid[player1moveX][player1moveY] = X;
								player1moveY++;
								player1moveX++;
							}
							if (validMovesp1NW == true && validMovesp1SW == false && validMovesp1SE == false
									&& validMovesp1NE == false && validMovesp1S == false && validMovesp1E == false
									&& validMovesp1W == false && validMovesp1N == false && player1moveY - 1 >= 0
									&& player1moveX - 1 >= 0) {
								grid[player1moveX][player1moveY] = X;
								player1turn = false;
							} else {
							}
						}
						if (validMovesp1NW != true) {
							validMovesp1NW = false;
						}
					}
				}
			}
		}
	}

	/**
	 * These methods are the direction move validaton but for the player 2.
	 * 
	 * @param player2moveX x axis position
	 * @param player2moveY y axis position
	 */
	public void P2E(int player2moveX, int player2moveY) {
		validMovesp2E = false;
		if (player2moveX + 2 <= 7) {
			if (player2moveX + 2 <= 7 && grid[player2moveX][player2moveY] != O) {
				if (grid[player2moveX + 1][player2moveY] == X) {

					if (player2moveX + 1 <= 7) {
						while (grid[player2moveX + 1][player2moveY] == X && player2moveX + 2 <= 7) {
							player2moveX++;
							if (player2moveX + 1 <= 7) {
								if (grid[player2moveX + 1][player2moveY] == O) {

									validMovesp2E = true;
								}
							}

						}
						if (validMovesp2E == true && player2moveX + 1 <= 7) {
							while (grid[player2moveX][player2moveY] == X && player2moveX - 1 >= 0) {
								grid[player2moveX][player2moveY] = O;
								player2moveX--;
							}
							if (validMovesp2E == true && grid[player2moveX][player2moveY] == 0
									&& player2moveX + 1 <= 7) {
								grid[player2moveX][player2moveY] = O;
								player2turn = false;
							}
							if (validMovesp2E == true && grid[player2moveX][player2moveY] == 0 && player2moveX == 0) {
								grid[player2moveX][player2moveY] = O;
								player2turn = false;
							}

							else {

							}

						}
						if (validMovesp2E != true && player2moveX + 1 <= 7) {
							validMovesp2E = false;
						}
					}
				}
			}
		}
	}

	public void P2W(int player2moveX, int player2moveY) {
		validMovesp2W = false;
		if (player2moveX - 2 >= 0 && grid[player2moveX][player2moveY] != X) {
			if (grid[player2moveX - 1][player2moveY] == X && player2moveX - 2 >= 0) {

				while (grid[player2moveX - 1][player2moveY] == X && player2moveX - 2 >= 0) {
					player2moveX--;
					if (player2moveX - 1 >= 0) {
						if (grid[player2moveX - 1][player2moveY] == O) {

							validMovesp2W = true;
						}
					}

				}
				if (validMovesp2W == true && player2moveX - 1 >= 0) {
					while (grid[player2moveX][player2moveY] == X) {
						grid[player2moveX][player2moveY] = O;
						player2moveX++;
					}
					if (validMovesp2W == true && grid[player2moveX][player2moveY] == 0 && player2moveX - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					}

				}
				if (validMovesp2W != true) {
					validMovesp2W = false;

				}
			}
		}
	}

	public void P2N(int player2moveX, int player2moveY) {
		validMovesp2N = false;
		if (player2moveY - 2 >= 0) {
			if (grid[player2moveX][player2moveY - 1] == X && player2moveY - 2 >= 0
					&& grid[player2moveX][player2moveY] != X) {

				while (grid[player2moveX][player2moveY - 1] == X && player2moveY - 2 >= 0) {
					player2moveY--;
					if (player2moveY - 1 >= 0) {
						if (grid[player2moveX][player2moveY - 1] == O) {

							validMovesp2N = true;
						}
					}

				}
				if (validMovesp2N == true && player2moveY - 1 >= 0) {
					while (grid[player2moveX][player2moveY] != 0 && player2moveY + 1 <= 7) {
						grid[player2moveX][player2moveY] = O;
						player2moveY++;
					}
					if (validMovesp2N == true && validMovesp2E == false && validMovesp2W == false
							&& player2moveY - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					} else {

					}
				}
				if (validMovesp2N != true && player2moveY - 1 >= 0) {
					validMovesp2N = false;
				}
			}
		}
	}

	public void P2S(int player2moveX, int player2moveY) {
		validMovesp2S = false;
		if (player2moveY + 2 <= 7) {
			if (grid[player2moveX][player2moveY + 1] == X && player2moveY + 2 <= 7
					&& grid[player2moveX][player2moveY] != X) {

				if (player2moveY + 1 <= 7) {
					while (grid[player2moveX][player2moveY + 1] == X && player2moveY + 2 <= 7) {
						player2moveY++;
						if (player2moveY + 1 <= 7) {
							if (grid[player2moveX][player2moveY + 1] == O) {

								validMovesp2S = true;
							}
						}
					}
				}
				if (validMovesp2S == true && player2moveY + 1 <= 7) {
					while (grid[player2moveX][player2moveY] == X && player2moveY - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2moveY--;
					}
					if (validMovesp2S == true && validMovesp2E == false && validMovesp2W == false
							&& validMovesp2N == false && player2moveY + 1 <= 7) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					}
					if (validMovesp1S == true && validMovesp1E == false && validMovesp1W == false
							&& validMovesp1N == false && player2moveY + 1 <= 7) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					} else {

					}
				}
				if (validMovesp2S != true) {
					validMovesp2S = false;

				}
			}
		}
	}

	public void P2NE(int player2moveX, int player2moveY) {
		validMovesp2NE = false;
		if (player2moveY - 2 >= 0 && player2moveX + 2 <= 7) {
			if (grid[player2moveX + 1][player2moveY - 1] == X && grid[player2moveX][player2moveY] != O
					&& player2moveY - 2 >= 0 && player2moveX + 2 <= 7) {
				if (player2moveY - 2 >= 0 && player2moveX + 2 <= 7) {
					while (grid[player2moveX + 1][player2moveY - 1] == X && player2moveY - 2 >= 0
							&& player2moveX + 1 <= 7) {
						System.out.println(" up piece found");
						player2moveY--;
						player2moveX++;
						if (player2moveY - 1 >= 0 && player2moveX + 1 <= 7) {
							if (grid[player2moveX + 1][player2moveY - 1] == O) {

								validMovesp2NE = true;
							}
						}
					}
				}
				if (validMovesp2NE == true && player2moveY - 1 >= 0 && player2moveX + 1 <= 7) {
					while (grid[player2moveX][player2moveY] == X && player2moveY + 1 <= 7 && player2moveX - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2moveY++;
						player2moveX--;
					}
					if (validMovesp2NE == true && validMovesp2S == false && validMovesp2E == false
							&& validMovesp2W == false && validMovesp2N == false && player2moveY - 1 >= 0
							&& player2moveX + 1 <= 7) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					} else {

					}
				}
				if (validMovesp2NE != true) {
					validMovesp2NE = false;

				}
			}
		}
	}

	public void P2SE(int player2moveX, int player2moveY) {
		validMovesp2SE = false;
		if (player2moveY + 2 <= 7 && player2moveX + 2 <= 7) {
			if (grid[player2moveX + 1][player2moveY + 1] == X && grid[player2moveX][player2moveY] != X
					&& player2moveY + 2 <= 7 && player2moveX + 2 <= 7) {

				if (player2moveY + 1 <= 7 && player2moveX + 1 <= 7) {
					while (grid[player2moveX + 1][player2moveY + 1] == X && player2moveY + 2 <= 7
							&& player2moveX + 2 <= 7) {
						player2moveY++;
						player2moveX++;
						if (player2moveY + 1 <= 7 && player2moveX + 1 <= 7) {
							if (grid[player2moveX + 1][player2moveY + 1] == O) {

								validMovesp2SE = true;
							}
						}
					}
				}
				if (validMovesp2SE == true && player2moveY + 1 <= 7 && player2moveX + 1 <= 7) {
					while (grid[player2moveX][player2moveY] == X && player2moveY - 1 >= 0 && player2moveX - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2moveY--;
						player2moveX--;
					}
					if (validMovesp2SE == true && validMovesp2NE == false && validMovesp2S == false
							&& validMovesp2E == false && validMovesp2W == false && validMovesp2N == false
							&& player2moveY + 1 <= 7 && player2moveX + 1 <= 7) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					}

					else {

					}
				}
				if (validMovesp2SE != true && player2moveY + 1 <= 7 && player2moveX + 1 <= 7) {
					validMovesp2SE = false;

				}
			}
		}
	}

	public void P2SW(int player2moveX, int player2moveY) {

		validMovesp2SW = false;
		if (player2moveY + 2 <= 7 && player2moveX - 2 >= 0) {
			if (grid[player2moveX - 1][player2moveY + 1] == X && grid[player2moveX][player2moveY] != X) {
				if (player2moveY + 1 <= 7 && player2moveX - 1 >= 0) {
					while (grid[player2moveX - 1][player2moveY + 1] == X && player2moveY + 2 <= 7
							&& player2moveX - 2 >= 0) {
						player2moveY++;
						player2moveX--;
						if (player2moveY + 1 <= 7 && player2moveX - 1 >= 0) {
							if (grid[player2moveX - 1][player2moveY + 1] == O) {

								validMovesp2SW = true;
							}

						}
					}
				}
				if (validMovesp2SW == true && player2moveY + 1 <= 7 && player2moveX - 1 >= 0) {
					while (grid[player2moveX][player2moveY] == X && player2moveX + 1 <= 7 && player2moveY - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2moveY--;
						player2moveX++;
					}
					if (validMovesp2SW == true && validMovesp2SE == false && validMovesp2NE == false
							&& validMovesp2S == false && validMovesp2E == false && validMovesp2W == false
							&& validMovesp2N == false && player2moveY + 1 <= 7 && player2moveX - 1 >= 0) {
						grid[player2moveX][player2moveY] = O;
						player2turn = false;
					} else {
					}
				}
			}
			if (validMovesp2SW != true) {
				validMovesp2SW = false;

			}
		}
	}

	public void P2NW(int player2moveX, int player2moveY) {
		validMovesp2NW = false;
		if (player2moveY - 2 >= 0 && player2moveX - 2 >= 0) {
			if (grid[player2moveX - 1][player2moveY - 1] == X && grid[player2moveX][player2moveY] != X) {
				if (player2moveY - 2 >= 0 && player2moveX - 2 >= 0) {
					while (grid[player2moveX - 1][player2moveY - 1] == X && player2moveY - 2 >= 0
							&& player2moveX - 2 >= 0) {
						player2moveY--;
						player2moveX--;
						if (player2moveY - 1 >= 0 && player2moveX - 1 >= 0) {
							if (grid[player2moveX - 1][player2moveY - 1] == O) {

								validMovesp2NW = true;
							}

						}
						if (validMovesp2NW == true && player2moveY - 1 >= 0 && player2moveX - 1 >= 0) {
							while (grid[player2moveX][player2moveY] == X && player2moveY + 1 <= 7
									&& player2moveY + 1 <= 7) {
								grid[player2moveX][player2moveY] = O;
								player2moveY++;
								player2moveX++;
							}
							if (validMovesp2NW == true && validMovesp2SW == false && validMovesp2SE == false
									&& validMovesp2NE == false && validMovesp2S == false && validMovesp2E == false
									&& validMovesp2W == false && validMovesp2N == false && player2moveY - 1 >= 0
									&& player2moveX - 1 >= 0) {
								grid[player2moveX][player2moveY] = O;
								player2turn = false;
							} else {
							}
						}
						if (validMovesp2NW != true) {
							validMovesp2NW = false;
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * This is the method for playing the whole gaming .
	 * 
	 * @return
	 */

	public void Game(boolean load) { // The boolean load is for loading the names of the user for the game, so when load is true it will load in the String variables user one and two
		Player player = new Player();
		if (load) {
			player.setNames(user1, user2);
		} else {
			user1 = player.yourname1();// This is the Scanner that takes in player one's name.
			user2 = player.yourname2();// This is the Scanner that takes in player two's name.
		}
		player1turn = true;// This is the turn for the first player if it is true it runs their turn if it is false it skips it. 
		player2turn = true;// This is the turn for the second player if it is true it runs their turn if it is false it skips it. 
		p1validcounter = 0; // The valid move counter for the first player
		p2validcounter = 0; // The valid move counter for the second player
		/**
		 * These are the methods that count the valid moves for the positions on the board
		 */
		validcounterP1E();
		validcounterP1W();
		validcounterP1N();
		validcounterP1S();
		validcounterP1NE();
		validcounterP1NW();
		validcounterP1SE();
		validcounterP1SW();
		validcounterP2E();
		validcounterP2W();
		validcounterP2N();
		validcounterP2S();
		validcounterP2NE();
		validcounterP2NW();
		validcounterP2SE();
		validcounterP2SW();
		int turncount = 1; // This is the turn count for the players game 
		while (play = true) {

			/**
			 * The whole game is run in a try and catch method to stop any unknown user exceptions and will run the player turn again if it comes across any user exceptions. 
			 */
			try { 
			saveGame(); // This is the method that automatically saves the players game, this method was made automatic so it doesn't disturb the player in the middle of their game to save
			displayArray();// This is the method that displays the array
			if (p1validcounter == 0) { // This is the statment that skips the user turn if they have zero valid moves
				player1turn = false;
			}
			while (player1turn == true) {// While the player turn is true this while loop will continously loop, but if
											// the user has 0 valid moves the loop will skip their turn
				p1validcounter = 0; // These sets the player valid moves to 0
				p2validcounter = 0;
				validcounterP1E();
				validcounterP1W();
				validcounterP1N();
				validcounterP1S();
				validcounterP1NE();
				validcounterP1NW();
				validcounterP1SE();
				validcounterP1SW();
				validcounterP2E();
				validcounterP2W();
				validcounterP2N();
				validcounterP2S();
				validcounterP2NE();
				validcounterP2NW();
				validcounterP2SE();
				validcounterP2SW();
				System.out.println("==========================");
				countPointsX();// Displays the amount of x pieces on the board
				System.out.println("==========================");
				countPointsY();// Displays the amount of Y pieces on the board 
				System.out.println("==========================");
				Endgame(p1validcounter, p2validcounter, pointCounterX, pointCounterY); // This is the endgame method that checks if the turn doesnt equal one and if the user has 0 valid moves left.
				System.out.println("==========================");
				int player1moveX = player.Player1X(); // The scanner for player one input in the player class
				int player1moveY = player.Player1Y();// The scanner for player two input in the player class
				P1E(player1moveX, player1moveY);
				P1W(player1moveX, player1moveY);
				P1N(player1moveX, player1moveY);
				P1S(player1moveX, player1moveY);
				P1NE(player1moveX, player1moveY);
				P1SE(player1moveX, player1moveY);
				P1SW(player1moveX, player1moveY);
				P1NW(player1moveX, player1moveY);
				System.out.println("==========================");
				countPointsX();// Displays the amount of x pieces on the board
				System.out.println("==========================");
				countPointsY();// Displays the amount of Y pieces on the board 
				System.out.println("==========================");
				System.out.println(" Your turn count is:  " + turncount);
				displayArray();// Displays the array on the console 
			}
			turncount++;// This counts the turns after eace player turn 
			if (p2validcounter == 0) {
				player2turn = false;
			}
			player1turn = false;
			player2turn = true;
			while (player2turn == true) {
				p2validcounter = 0;
				p1validcounter = 0;
				validcounterP2E();
				validcounterP2W();
				validcounterP2N();
				validcounterP2S();
				validcounterP2NE();
				validcounterP2NW();
				validcounterP2SE();
				validcounterP2SW();
				validcounterP1E();
				validcounterP1W();
				validcounterP1N();
				validcounterP1S();
				validcounterP1NE();
				validcounterP1NW();
				validcounterP1SE();
				validcounterP1SW();
				Endgame(p1validcounter, p2validcounter, pointCounterX, pointCounterY);
				int player2moveX = player.Player2X();
				int player2moveY = player.Player2Y();
				P2E(player2moveX, player2moveY);
				P2W(player2moveX, player2moveY);
				P2N(player2moveX, player2moveY);
				P2S(player2moveX, player2moveY);
				P2NE(player2moveX, player2moveY);
				P2SE(player2moveX, player2moveY);
				P2SW(player2moveX, player2moveY);
				P2NW(player2moveX, player2moveY);
				System.out.println("==========================");
				countPointsX();
				System.out.println("==========================");
				countPointsY();
				System.out.println("==========================");
				System.out.println(" Your turn count is:  " + turncount);
			}
			player2turn = false;
			player1turn = true;
			turncount++;

		}

				catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("This out of bounds");

			} catch (Exception e) {
				System.out.println(" That is  not an integer Try again: ");

			}
		}

	}
	/**
	 * These are the methods that count the amount of valid moves that each player has on the board currently 
	 */
//	}

	public void validcounterP1E() {
		int x, y;

		for (y = 0; y < grid.length; y++) {

			for (x = 0; x < grid.length; x++) {
				if (grid[x][y] == X) {
					if (x + 2 <= 7) {
						if (grid[x + 1][y] == O && x + 2 <= 7) {
							if (x + 2 <= 7) {
								while (grid[x + 1][y] == O && x + 2 <= 7) {
									x++;
									if (x + 1 <= 7) {
										if (grid[x + 1][y] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP1W() {
		int x, y;
		for (y = grid.length - 1; y >= 0; y--) {
			for (x = grid.length - 1; x >= 0; x--) {
				if (grid[x][y] == X) {
					if (x - 2 >= 0) {
						if (grid[x - 1][y] == O && x - 2 >= 0) {

							if (x - 2 >= 0) {
								while (grid[x - 1][y] == O && x - 2 >= 0) {
									x--;
									if (x - 1 >= 0) {
										if (grid[x - 1][y] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP1N() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == X) {
					if (y - 2 >= 0) {
						if (grid[x][y - 1] == O && y - 2 >= 0) {

							if (y - 2 >= 0) {
								while (grid[x][y - 1] == O && y - 2 >= 0) {
									y--;
									if (y - 1 >= 0) {
										if (grid[x][y - 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP1S() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == X) {
					if (y + 2 <= 7) {
						if (grid[x][y + 1] == O && y + 2 <= 7) {
							if (y + 2 <= 7) {
								while (grid[x][y + 1] == O && y + 2 <= 7) {
									y++;
									if (y + 1 <= 7) {
										if (grid[x][y + 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP1NE() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == X) {
					if (x + 2 <= 7 && y - 2 >= 0) {
						if (grid[x + 1][y - 1] == O && y - 2 >= 0 && x + 2 <= 7) {

							if (x + 2 <= 7 && y - 2 >= 0) {
								while (grid[x + 1][y - 1] == O && y - 2 >= 0 && x + 2 <= 7) {
									y--;
									x++;
									if (x + 1 <= 7 && y - 1 >= 0) {
										if (grid[x + 1][y - 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP1NW() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == X) {
					if (x - 2 >= 0 && y - 2 >= 0) {
						if (grid[x - 1][y - 1] == O && y - 2 >= 0 && x - 2 >= 0) {

							if (x - 2 >= 0 && y - 2 >= 0) {
								while (grid[x - 1][y - 1] == O && y - 2 >= 0 && x - 2 >= 0) {
									y--;
									x--;
									if (x - 1 >= 0 && y - 1 >= 0) {
										if (grid[x - 1][y - 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP1SE() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == X) {
					if (x + 2 <= 7 && y + 2 <= 7) {
						if (grid[x + 1][y + 1] == O && y + 2 <= 7 && x + 2 <= 7) {

							if (x + 2 <= 7 && y + 2 <= 7) {
								while (grid[x + 1][y + 1] == O && y + 2 <= 7 && x + 2 <= 7) {
									y++;
									x++;
									if (x + 1 <= 7 && y + 1 <= 7) {
										if (grid[x + 1][y + 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP1SW() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == X) {
					if (x - 2 >= 0 && y + 2 <= 7) {
						if (grid[x - 1][y + 1] == O && y + 2 <= 7 && x - 2 >= 0) {

							if (x - 2 >= 0 && y + 2 <= 7) {
								while (grid[x - 1][y + 1] == O && y + 2 <= 7 && x - 2 >= 0) {
									y++;
									x--;
									if (x - 1 >= 0 && y + 1 <= 7) {
										if (grid[x - 1][y + 1] == 0) {
											p1validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP2E() {
		int x, y;

		for (y = 0; y < grid.length; y++) {

			for (x = 0; x < grid.length; x++) {
				if (grid[x][y] == O) {
					if (x + 2 <= 7) {
						if (grid[x + 1][y] == X && x + 2 <= 7) {
							if (x + 2 <= 7) {
								while (grid[x + 1][y] == X && x + 2 <= 7) {
									x++;
									if (x + 1 <= 7) {
										if (grid[x + 1][y] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP2W() {
		int x, y;
		for (y = grid.length - 1; y >= 0; y--) {
			for (x = grid.length - 1; x >= 0; x--) {
				if (grid[x][y] == O) {
					if (x - 2 >= 0) {
						if (grid[x - 1][y] == X && x - 2 >= 0) {

							if (x - 2 >= 0) {
								while (grid[x - 1][y] == X && x - 2 >= 0) {
									x--;
									if (x - 1 >= 0) {
										if (grid[x - 1][y] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP2N() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == O) {
					if (y - 2 >= 0) {
						if (grid[x][y - 1] == X && y - 2 >= 0) {

							if (y - 2 >= 0) {
								while (grid[x][y - 1] == X && y - 2 >= 0) {
									y--;
									if (y - 1 >= 0) {
										if (grid[x][y - 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP2S() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == O) {
					if (y + 2 <= 7) {
						if (grid[x][y + 1] == X && y + 2 <= 7) {
							if (y + 2 <= 7) {
								while (grid[x][y + 1] == X && y + 2 <= 7) {
									y++;
									if (y + 1 <= 7) {
										if (grid[x][y + 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}

	}

	public void validcounterP2NE() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == O) {
					if (x + 2 <= 7 && y - 2 >= 0) {
						if (grid[x + 1][y - 1] == X && y - 2 >= 0 && x + 2 <= 7) {

							if (x + 2 <= 7 && y - 2 >= 0) {
								while (grid[x + 1][y - 1] == X && y - 2 >= 0 && x + 2 <= 7) {
									y--;
									x++;
									if (x + 1 <= 7 && y - 1 >= 0) {
										if (grid[x + 1][y - 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP2NW() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = grid.length - 1; y >= 0; y--) {
				if (grid[x][y] == O) {
					if (x - 2 >= 0 && y - 2 >= 0) {
						if (grid[x - 1][y - 1] == X && y - 2 >= 0 && x - 2 >= 0) {

							if (x - 2 >= 0 && y - 2 >= 0) {
								while (grid[x - 1][y - 1] == X && y - 2 >= 0 && x - 2 >= 0) {
									y--;
									x--;
									if (x - 1 >= 0 && y - 1 >= 0) {
										if (grid[x - 1][y - 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP2SE() {
		int x, y;
		for (x = 0; x < grid.length; x++) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == O) {
					if (x + 2 <= 7 && y + 2 <= 7) {
						if (grid[x + 1][y + 1] == X && y + 2 <= 7 && x + 2 <= 7) {

							if (x + 2 <= 7 && y + 2 <= 7) {
								while (grid[x + 1][y + 1] == X && y + 2 <= 7 && x + 2 <= 7) {
									y++;
									x++;
									if (x + 1 <= 7 && y + 1 <= 7) {
										if (grid[x + 1][y + 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void validcounterP2SW() {
		int x, y;
		for (x = grid.length - 1; x >= 0; x--) {
			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == O) {
					if (x - 2 >= 0 && y + 2 <= 7) {
						if (grid[x - 1][y + 1] == X && y + 2 <= 7 && x - 2 >= 0) {

							if (x - 2 >= 0 && y + 2 <= 7) {
								while (grid[x - 1][y + 1] == X && y + 2 <= 7 && x - 2 >= 0) {
									y++;
									x--;
									if (x - 1 >= 0 && y + 1 <= 7) {
										if (grid[x - 1][y + 1] == 0) {
											p2validcounter++;

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * This is the method that ends the game, it counts all the board pieces to get the final score and to make sure that the user has no valid moves 
	 * @param p1validcounter counts all the valid moves for player 1 
	 * @param p2validcounter counts all the valid moves for player 2 
	 * @param pointCounterX counts all the valid moves for player 3 
	 * @param pointCounterY counts all the valid moves for player 4 
	 */

	public void Endgame(int p1validcounter, int p2validcounter, int pointCounterX, int pointCounterY) {
		Scanner Endgame = new Scanner(System.in);// This is the scanner that ask's the user for the if they want to
													// start a new game after winning
		String Answer; // This is the field of the users answer.
		Menu newgame = new Menu();// This is the object that is used to call the method menu in the menu class.
		int a;
		int b;
		int pointCounterY1 = 0;
		try {
			for (a = 0; a < grid.length; a++) {

				for (b = 0; b < grid.length; b++) {
					if (grid[a][b] == O) {
						pointCounterY1++;
					}
				}

			}
			int x;
			int y;
			int pointCounterX1 = 0;
			for (x = 0; x < grid.length; x++) {

				for (y = 0; y < grid.length; y++) {
					if (grid[x][y] == X) {
						pointCounterX1++;
					}

				}

			}

			if (turncount != 1 && p1validcounter == 0 && p2validcounter == 0) {

				if (pointCounterX1 > pointCounterY1) {
					play = false;
					System.out.println(" ========================== ");
					displayArray();
					Winner();
					System.out.println(" Congratulations " + user1 + " Your score is  " + pointCounterX1);
					System.out.print(" Do you want to start a new game ");
					Answer = Endgame.nextLine();
					if (Answer.equals("yes")) {
						newgame.menu();
					}
					if (Answer.equals("no")) {
						System.exit(0);
					} else {
						System.out.println(" That is not an option please enter Yes or No ");
						Endgame(p1validcounter, p2validcounter, pointCounterX, pointCounterY);
					}
				}
				if (pointCounterY1 > pointCounterX1) {
					play = false;
					System.out.println("==========================");
					displayArray();
					Winner();
					System.out.println(" Congratulations " + user2 + " Your score is  " + pointCounterY1);
					System.out.println(" Do you want to start a new game ");
					System.out.println("	");
					Answer = Endgame.nextLine();
					if (Answer.equals("yes")) {
						newgame.menu();
					}
					if (Answer.equals("no")) {
						System.exit(0);
					} else {
						System.out.print(" That is not an option please enter either Yes or No ");
						Endgame(p1validcounter, p2validcounter, pointCounterX, pointCounterY);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(" That is  not an integer Try again: ");

		}

	}

	/**
	 * this is the method that counts all the O pieces on the board 
	 * @return The return for this method is the total amount of piece on the board
	 */
	public int countPointsY() {
		int a;
		int b;
		int pointCounterY = 0;
		for (a = 0; a < grid.length; a++) {

			for (b = 0; b < grid.length; b++) {
				if (grid[a][b] == O) {
					pointCounterY++;
				}
			}

		}
		System.out.println(" The O pieces score is: " + pointCounterY);
		return pointCounterY;
	}

	/** This saves  the game by saving a  player object into the folder currently called saveFiles */
	public void saveGame() {

		// This file to export is a file that it saves the saved game on.
		String fileToExport = "SaveGame";

		// This creates a creates a try block used for Java's error handling system in case it doesn't find the files that it is looking for 
		try {
			// Creates an object of FileOutputStream used to export the file content
			FileOutputStream fileOutput = new FileOutputStream(new File(fileToExport));
			// this creates the  object of ObjectOutputStream fuction that is  used to export the object that will be put into the file 
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

			// Writes the objects and their contents  to the file
			objectOutput.writeObject((gameBoard) this);

			System.out.println(" Starting autosave... ");
			System.out.println(" finalizing autosave... ");

			// Closes the fileoutput and hte object output
			objectOutput.close();
			fileOutput.close();
		}

		// Runs if there was no files found as it is an exception
		catch (FileNotFoundException e) {
			System.out.println("The File has not been found");
			saveGame();
		}

		// Runs if there's a more general error when trying to read the file.
		catch (IOException e) {
			System.out.println("An error has occured");
			// this prints out Java's interpretation of the error so it tells you where in the code you have a problem 
			e.printStackTrace();
		}
	}


	public int countPointsX() {
		int x;
		int y;
		int pointCounterX = 0;
		for (x = 0; x < grid.length; x++) {

			for (y = 0; y < grid.length; y++) {
				if (grid[x][y] == X) {
					pointCounterX++;
				}

			}

		}
		System.out.println(" The X pieces score is: " + pointCounterX);
		return pointCounterX;
	}

	

/**
 * This is the method that displays the ascii text when you win a game.
 */
	public static void Winner() {

		try {
			// Open the file that you want it to read from 
			// command line parameter for where to look for the object 
			FileInputStream fstream = new FileInputStream("/reversiGame/src/reversiGame/Endgame.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line 
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console line by line 
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception when finding the file. 
			System.err.println("Error: " + e.getMessage());
		}
	}
}
