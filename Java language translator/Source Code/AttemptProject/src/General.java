import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class contains the main method which starts the program in which the menu is present.
 * This class also contains 2 minor validation methods for integer input.
 * 
 * @author truth
 *
 */
public class General{

	/**
	 * Default Constructor
	 */
    public General(){

    }

    /**
     * Main method.
     * Initialises 4 binary trees and stores it in a array of binary trees.
     * @param args
     * @throws IOException - used as there is a inclusion of a throw exception instead of a try and catch.
     */
    public static void main(String[] args) throws IOException {
        General menu = new General();
    	ReadWrite file = new ReadWrite();
        BinaryTree english_french = new BinaryTree();
        BinaryTree french_english = new BinaryTree();
        BinaryTree english_italian = new BinaryTree();
        BinaryTree italian_english = new BinaryTree();
        
        Translation translate = new Translation();

        BinaryTree[] trees = new BinaryTree[4];

        file.readDictionary(english_french,"english","A-Z_English_French_with_Hashes.txt");
        file.readDictionary(french_english,"french","A-Z_French_English_with_Hashes.txt");
        file.readDictionary(english_italian, "english", "A-Z_English_Italian_with_Hashes.txt");
        file.readDictionary(italian_english, "italian", "A-Z_Italian_English_with_Hashes.txt");

        trees[0] = english_french;
        trees[1] = french_english;
        trees[2] = english_italian;
        trees[3] = italian_english;
        
        for (int x = 0; x < trees.length; x++) {
            trees[x].leafFinder(trees[x].root);
            trees[x].depth(trees[x].root);
            trees[x].balanceControll(trees[x]);
            //trees[x].leafFinder(trees[x].root);
            //trees[x].depth(trees[x].root);
            //System.out.println("#-------------------------------------#");
        }        
       menu.displayMenu();
       menu.processUserChoices(trees);
    }

    /**
     * A simple method that displays menu choices
     */
	public void displayMenu()
	{
	 System.out.println("Please select one of the options below (Enter a number 0-3)");
	 System.out.println("1. Translate from text input");
	 System.out.println("2. Translate from a .txt File");
	 System.out.println("3. Set Mode (Set how unfound words are dealt with)");
	 System.out.println("4. Add a word to the dictionary");
	 System.out.println("5. Delete a word from the dictionary");
	 System.out.println("6. Display Dictionaries");
	 System.out.println("7. Save dictionaries to file");
	 System.out.println("0. Exit");
	}
	
	
	/**
     * A large method to deal with the choice the user inputs. A while loop is used both to repeat the menu until the user selects 	exit, and to repeat the menu if an invalid input in given.
     * 
     * In majority of cases the program will request the user to select with which languages they are dealing with. This is because we have 4 binary tree data structures.
     * When the user has selected the desired languages he is allowed to progress with the function he has selected as he is finally allowed to process the correct tree.
     * Each case in the menu is easily understood for its base functions outside of the input method and check linked to it.
     * This method is not prioritised by the program as it contains no special functions or methods.
     * 
     * @param trees - An array containing 4 binary trees.
     * @throws IOException - an exception call added as the program uses it to reinforce the program of breaking. It is only added as a try and catch wasn't implimented in a specific method.
     */
	public void processUserChoices(BinaryTree[] trees) throws IOException
	{
		Translation mainFunc = new Translation();
		int repeat = 0;
		String userChoice = "Default";
		int inputLangChoice;
		int outLangChoice;
		int Valid = 1;
		ReadWrite saveDic = new ReadWrite();
		
		while (repeat == 0) 
		{
			Scanner s = new Scanner(System.in);
			userChoice = s.nextLine();
			
			switch (userChoice)
			{
				case "1":
					System.out.println("You have chosen to translate from text input");
					System.out.println("Please select the Language you would like to translate from by entering a number 1 - 3");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					outLangChoice = 0;
					if (inputLangChoice == 1) {
						System.out.println("Please select the Language you would like to translate TO by entering a number 1 - 2");
						System.out.println("1: French");
						System.out.println("2: Italian");
						outLangChoice = validIntInput12();
					} else if (inputLangChoice == 2 || inputLangChoice == 3) {
						outLangChoice = 3;
					}
					
					System.out.println("Please enter whatever sentence you would like to translate");
					String translateMe = s.nextLine();
					if (inputLangChoice == 1 && outLangChoice == 1) {
						mainFunc.translateLine(translateMe, "eng-fr", trees);
					} else if (inputLangChoice == 1 && outLangChoice == 2) {
						mainFunc.translateLine(translateMe, "eng-italian", trees);
					} else if (inputLangChoice == 2) {
						mainFunc.translateLine(translateMe, "fr-eng", trees);
					} else if (inputLangChoice == 3) {
						mainFunc.translateLine(translateMe, "italian-eng", trees);
					}
					
					repeat = 0;
					displayMenu();
					break;		

				case "2":
					System.out.println("You have chosen to translate from a file");
					System.out.println("Please select the Language the input file is in entering a number 1 - 3");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					outLangChoice = 0;
					if (inputLangChoice == 1) {
						System.out.println("Please select the Language you would like to translate TO by entering a number 1 - 2");
						System.out.println("1: French");
						System.out.println("2: Italian");
						outLangChoice = validIntInput12();
					} else if (inputLangChoice == 2 || inputLangChoice == 3) {
						outLangChoice = 3;
					}
					
					// This block gets the name of input txt file
				    FileReader fileReader = null;
				    BufferedReader bufferedReader = null;
				    System.out.println("Please enter the name of the file you would like to read from");
				    String readFile = s.next();
				    while (Valid == 1) {
				    	try
				    	{
				    	fileReader = new FileReader(readFile);
			  		    bufferedReader = new BufferedReader(fileReader);
			  		    Valid = 0;
				    	}
				    	catch (IOException e){
				    		System.out.println("IO Error reading from file: " + e);
				     		Valid = 1;
				     		System.out.println("Please enter a valid file name");
				     		readFile = s.next(); 
				    	}
				    }
				    
				    //USED FOR EARLY TESTING.
				    // This block of code lets the user name the file they want to write too, the file is not actually created yet.
				    //FileOutputStream outputStream = null;
			        //PrintWriter printWriter = null;
			        //System.out.println("Please enter the name of the file you'd like to create and write too");
			        //Scanner S3 = new Scanner(System.in);
			        //String writeFile = S3.nextLine();
					
					
					System.out.println("Please enter whatever sentence you would like to translate");
					if (inputLangChoice == 1 && outLangChoice == 1) {
						mainFunc.translateFile(readFile, "eng-fr", trees);
					} else if (inputLangChoice == 1 && outLangChoice == 2) {
						mainFunc.translateFile(readFile, "eng-italian", trees);
					} else if (inputLangChoice == 2) {
						mainFunc.translateFile(readFile, "fr-eng", trees);
					} else if (inputLangChoice == 3) {
						mainFunc.translateFile(readFile, "italian-eng", trees);
					}
					
					
					repeat = 0;
					displayMenu();
					break;
					
				case "3":
					System.out.println("Would you like to deal with unfound words? Please enter 1 for yes. 2 for no.");
					int modeChoice = validIntInput12();
					if (modeChoice == 1) {
						mainFunc.onMode();
					} else {
						mainFunc.offMode();
					}
					repeat = 0;
					displayMenu();
					break;

				case "4":
					System.out.println("You have chosen to add words to the dictionary");
					System.out.println("Please select the Language you would like to add a word from by entering a number 1 - 3");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					outLangChoice = 0;
					if (inputLangChoice == 1) {
						System.out.println("Please select the Language for the afformentioned words translation by entering a number 1 - 2");
						System.out.println("1: French");
						System.out.println("2: Italian");
						outLangChoice = validIntInput12();
					} else if (inputLangChoice == 2 || inputLangChoice == 3) {
						outLangChoice = 3;
					}
					
					System.out.println("Please enter the word you would like to add");
				    String word = s.next();
				    System.out.println("Please enter the translation for the word you would like to add");
				    String wordTrans = s.next();
					
					if (inputLangChoice == 1 && outLangChoice == 1) {
						trees[0].add(word.trim().toLowerCase().hashCode(), word, wordTrans);
					} else if (inputLangChoice == 1 && outLangChoice == 2) {
						trees[2].add(word.trim().toLowerCase().hashCode(), word, wordTrans);
					} else if (inputLangChoice == 2) {
						trees[1].add(word.trim().toLowerCase().hashCode(), word, wordTrans);
					} else if (inputLangChoice == 3) {
						trees[3].add(word.trim().toLowerCase().hashCode(), word, wordTrans);
					}
					
					
					repeat = 0;
					displayMenu();
					break;

				case "5":
					System.out.println("You have chosen to delete a word from the dictionary");
					System.out.println("Please select the Language Dictionary you would like to delete a word from by entering a number 1 - 3");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					if (inputLangChoice == 1) {
						
					} else if (inputLangChoice == 2) {
						
					} else if (inputLangChoice == 3) {
						
					}
					
					System.out.println("Please enter the word you would like to delete");
				    String wordDelete = s.next();

					if (inputLangChoice == 1) {
						trees[0].delete(wordDelete.trim().toLowerCase().hashCode());
						trees[2].delete(wordDelete.trim().toLowerCase().hashCode());
					} else if (inputLangChoice == 2) {
						trees[1].delete(wordDelete.trim().toLowerCase().hashCode());
					} else if (inputLangChoice == 3) {
						trees[3].delete(wordDelete.trim().toLowerCase().hashCode());
					}
					repeat = 0;
					displayMenu();
					break;


				case "6":
					System.out.println("You have chosen to print a dictionary (Disclaimer: The Dictionaries are huge, and the CMD Line interface will cut off before the whole dictionary is displayed)");
					System.out.println("Please select the 'From' language");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					outLangChoice = 0;
					if (inputLangChoice == 1) {
						System.out.println("Please select the 'To' language by entering a number 1 - 2");
						System.out.println("1: French");
						System.out.println("2: Italian");
						outLangChoice = validIntInput12();
					} else if (inputLangChoice == 2 || inputLangChoice == 3) {
						outLangChoice = 3;
					}
					
					
					if (inputLangChoice == 1 && outLangChoice == 1) {
						trees[0].preOrderPrint(trees[0].root);
					} else if (inputLangChoice == 1 && outLangChoice == 2) {
						trees[2].preOrderPrint(trees[0].root);
					} else if (inputLangChoice == 2) {
						trees[1].preOrderPrint(trees[0].root);
					} else if (inputLangChoice == 3) {
						trees[3].preOrderPrint(trees[0].root);
					}
					repeat = 0;
					displayMenu();
					break;

				case "7":
					FileOutputStream outputStream = null;
			        PrintWriter printWriter = null;
					System.out.println("You have chosen to save a dictionary to file");
					System.out.println("Please select the 'From' language (for the dictionary you want to save)");
					System.out.println("1: English");
					System.out.println("2: French");
					System.out.println("3: Italian");
					inputLangChoice = validIntInput13();
					outLangChoice = 0;
					if (inputLangChoice == 1) {
						System.out.println("Please select the 'To' language by entering a number 1 - 2");
						System.out.println("1: French");
						System.out.println("2: Italian");
						outLangChoice = validIntInput12();
					} else if (inputLangChoice == 2 || inputLangChoice == 3) {
						outLangChoice = 3;
					}
					
					
					if (inputLangChoice == 1 && outLangChoice == 1) {
						// This block of code lets the user name the file they want to write too, the file is not actually created yet.
				        System.out.println("Please enter the name of the file you'd like to save too");
				        String writeFile = s.nextLine();
				        saveDic.writeFile(trees[0].root, printWriter, "eng-",writeFile);		        
				        
					} else if (inputLangChoice == 1 && outLangChoice == 2) {
						// This block of code lets the user name the file they want to write too, the file is not actually created yet.
				        System.out.println("Please enter the name of the file you'd like to save too");
				        String writeFile = s.nextLine();
				        saveDic.writeFile(trees[2].root, printWriter, "eng-",writeFile);
				        
					} else if (inputLangChoice == 2) {
						// This block of code lets the user name the file they want to write too, the file is not actually created yet.
				        System.out.println("Please enter the name of the file you'd like to save too");
				        String writeFile = s.nextLine();
				        saveDic.writeFile(trees[1].root, printWriter, "eng-",writeFile);
				        
					} else if (inputLangChoice == 3) {
						// This block of code lets the user name the file they want to write too, the file is not actually created yet.
				        System.out.println("Please enter the name of the file you'd like to save too");
				        String writeFile = s.nextLine();
				        saveDic.writeFile(trees[3].root, printWriter, "eng-",writeFile);
					}
					
					repeat = 0;
					displayMenu();
					break;
				
				
				case "0":
					repeat = 1;
					break;

				default:
					System.out.println("That is not a valid selection, please enter a valid option from the displayed Menu");
					displayMenu();
					repeat = 0;
					break;
			}    
		
		}
	
	}
	

	/**
	 * This method uses a simple algorithm which validates an input within a specific range.
	 * @return a correctly validated value.
	 */
	public int validIntInput13() {
		
		int userChoice;
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please enter either 1, 2 or 3");
		do {
		    while (!s.hasNextInt()) {
		        System.out.println("That is not a valid input, please enter either 1, 2, or 3.");
		        s.next();
		    }
		    userChoice = s.nextInt();
		    while (userChoice < 1 || userChoice > 3) {
		    	System.out.println("That is not a valid input, please enter either 1, 2, or 3.");
		    	while (!s.hasNextInt()) {
			        System.out.println("That is not a valid input, please enter either 1, 2, or 3.");
			        s.next();
			    }
		    userChoice = s.nextInt();
		    }	    
		} while (userChoice < 1 || userChoice > 3);

		return userChoice;
	}

	/**
	 * This method uses a simple algorithm which validates an input within a specific range.
	 * @return a correctly validated value.
	 */
	public int validIntInput12() {
		
		int userChoice;
		Scanner s = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please enter either 1, 2");
		do {
		    while (!s.hasNextInt()) {
		        System.out.println("That is not a valid input, please enter either 1, or 2");
		        s.next();
		    }
		    userChoice = s.nextInt();
		    while (userChoice < 1 || userChoice > 2) {
		    	System.out.println("That is not a valid input, please enter either 1, or 2");
		    	while (!s.hasNextInt()) {
			        System.out.println("That is not a valid input, please enter either 1, or 2");
			        s.next();
			    }
		    userChoice = s.nextInt();
		    }	    
		} while (userChoice < 1 || userChoice > 2);

		return userChoice;
	}

}