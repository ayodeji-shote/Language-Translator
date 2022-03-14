package week7Assigment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Menu {
	Scanner iteamchoice = new Scanner(System.in);
	int printchoice; // This is the int that lets you pick which Menu you want to print out 
	int storechoice; // This is the int that lets you pick what you want to do in the store.
	int iteamcounter = 1; // This is the int that counts which iteam that you are on.
	int id; // This is the int that represents the id of each iteam 
	double iteamprice; // This is the int that represents the iteam price of each iteam 
	binaryTree bintree = new binaryTree();
	public static void main(String[] args) {
		Menu m = new Menu();
		// TODO Auto-generated method stub
		m.menu();
	}
	// Display method for the main menu 
	public void MenuDisplay() {
		// This text was coppied from https://www.messletters.com/en/big-text/.
		System.out.println(
				"  __        __         _                                       _               _     _                ____    _                         \r\n"
						+ " \\ \\      / /   ___  | |   ___    ___    _ __ ___     ___    | |_    ___     | |_  | |__     ___    / ___|  | |_    ___    _ __    ___ \r\n"
						+ "  \\ \\ /\\ / /   / _ \\ | |  / __|  / _ \\  | '_ ` _ \\   / _ \\   | __|  / _ \\    | __| | '_ \\   / _ \\   \\___ \\  | __|  / _ \\  | '__|  / _ \\\r\n"
						+ "   \\ V  V /   |  __/ | | | (__  | (_) | | | | | | | |  __/   | |_  | (_) |   | |_  | | | | |  __/    ___) | | |_  | (_) | | |    |  __/\r\n"
						+ "    \\_/\\_/     \\___| |_|  \\___|  \\___/  |_| |_| |_|  \\___|    \\__|  \\___/     \\__| |_| |_|  \\___|   |____/   \\__|  \\___/  |_|     \\___|\r\n"
						+ "                                                                                                                                       ");
		System.out.println("Please select what you want to do");
		System.out.println("---------------------------------");
		System.out.println("1:Add an item to the binary tree ");
		System.out.println("2:Print your binary tree");
		System.out.println("3:remove an item from your binary tree ");
		System.out.println("4: Check the total price of the basket");
		System.out.println("5: Search for an item ");
		System.out.println("6: Save tree to a text file and load it from a text file. ");
		System.out.println("7: View tester results");
		System.out.println("0:exit");
	}	
	// Display method for printing the tree
	public void printList() {
		System.out.println("Please select what you want to do");
		System.out.println("---------------------------------");
		System.out.println("1:Print the pre order binary tree");
		System.out.println("---------------------------------");
		System.out.println("2:Print the post order binary tree");
		System.out.println("---------------------------------");
		System.out.println("3:Print the post order binary tree");
		
	}
	/**
	 * Method that lets you pick which tree you want to print.
	 */
	public void listPrinter() {
		printchoice = 0;
		String choice;
		printchoice = iteamchoice.nextInt();
		if (printchoice == 1 ||  printchoice == 2 || printchoice == 3 )
		{
			try {
			switch (printchoice) {	
		case 1:
			System.out.println("----------------------------------------------------------");
			System.out.println("		   Preorderlist					 " );
			System.out.println("----------------------------------------------------------");
			System.out.println("Name	" + "	ID	" + "	Price	"+" Amount	");
			bintree.preOrderPrint(bintree.getroot());
			menuReturn();
			break;
		case 2:
			System.out.println("----------------------------------------------------------");
			System.out.println("		   Postorderlist					 " );
			System.out.println("----------------------------------------------------------");
			System.out.println("Name	" + "	ID	" + "	Price	"+" Amount	");
			bintree.postOrderPrint(bintree.getroot());
			menuReturn();
			break;

		case 3:
			System.out.println("----------------------------------------------------------");
			System.out.println("		   	inorderlist					 " );
			System.out.println("----------------------------------------------------------");
			System.out.println("Name	" + "	ID	" + "	Price	"+" Amount	");
			bintree.inOrderPrint(bintree.getroot());
			menuReturn();
			break;
			
			
			}
			
			
		}
			catch (Exception e) {
				System.out.println(" There is nothing in that list please try again ");
			}
		}
		else {
			System.out.println("  That option is not avialable please try again");
			listPrinter();
		}
		
	
	}
	/**
	 * Method that asks if you want to return to the main menu after completing a task
	 */
	public void menuReturn() {
		System.out.println(" Would you like to return to the menu ? ");
		String choice1 = null;
		try {
		choice1 = iteamchoice.next();
		if (choice1.equals("yes"))
		{
			menu();
		}
		else if (choice1.equals("no"))
		{
			exit();
		}
		else 
		{
			System.out.println(" That is not a valid choice please try again ");
			menuReturn();
		}
		}
		catch (Exception e) {
			System.out.println(" That answer is not valid please try again ");
		}
		
	}
	
	/**
	 * This is the main menu method that lets you choose between which option you want.
	 */
	public void menu() {
		int op;
		MenuDisplay();
		Scanner option = new Scanner(System.in);
		
			op = option.nextInt();
			if (op == 1 || op == 0 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6 || op == 7) {
				switch (op) {
				case 0:
					exit();
					
					break;
				case 1:
					addtoTree();
					break;
				case 2:
					printList();
					listPrinter();
					break;

				case 3:
					removefromTree();
					break;

				case 4:
					bintree.printTotalPrice();
					menuReturn();
					break;
				case 5:
					searchiteam();
					menuReturn();
					break;
				case 6:
					System.out.println(" Your file has been saved ");
					System.out.println(" Your file has been loaded ");
					System.out.println("----------------------------------------------------------");
					System.out.println("		   Preorderlist					 " );
					System.out.println("----------------------------------------------------------");
					System.out.println("Name	" + "	ID	" + "	Price	" + "	Amount	");
					Savebinarytree(bintree.getroot());
					readtoaFile();
					menuReturn();
					break;
				case 7:
					tester();
					break;
				}
			} else {
				System.out.println(" Sorry that isn't a valid option");
				menu();
			}
		} 

	
	/**
	 * This is the method that takes in the user input and passes it into the add treenode method
	 */
	public void addtoTree()
	{
		System.out.println(" To add iteams to the store all you have to do is enter their name, price and id ");
		System.out.println(" If you want to stop adding an iteam enter stop when it asks for the name ");
		try {
		String name = " ";
		int addID=0;
		double addprice=0;
		while(!name.equals(" stop ")){
		System.out.println(" This is iteam "  + iteamcounter  );
		System.out.println(" What is the name of your iteam ");
		name = iteamchoice.next();
		if(name.equals("stop")) {
			menuReturn();
		}
		else {
		System.out.println(" What is the ID of your iteam. If you want to quit enter stop");
		addID = iteamchoice.nextInt();
		System.out.println(" What is the price of your iteam ");
		addprice = iteamchoice.nextDouble();
		 bintree.addTree(name, addID, addprice);
		iteamcounter++;
		}
		}
		}
		catch (Exception e) {
			System.out.println(" That is not a valid option please try again ");
			addtoTree();
		}
		
	}
	
	/**
	 * This is the method that removes a treenode from a tree by taking in a user input
	 */
	public void removefromTree()
	{
		try {
		int p = 0;
		System.out.println("What is the node that you want to delete, to do this enter the id of the node that you want do delete.");
		System.out.println("----------------------------------------------------------");
		System.out.println("		   Preorderlist					 " );
		System.out.println("----------------------------------------------------------");
		bintree.preOrderPrint(bintree.getroot());
		p = iteamchoice.nextInt();
		bintree.searchRoot(p,bintree.getroot());
		bintree.deleteroot1(p);
		bintree.preOrderPrint(bintree.getroot());
		menuReturn();
		}
		catch (Exception e) {
			System.out.println(" That is not a valid option please try again ");
			addtoTree();
		}
		
	}
	
	/**
	 * This is the method that takes in the user input to search for a specific Treenode
	 */
	public void searchiteam() {
		int search;
		
		try {
			System.out.println(" Please input the id of the iteam that you would like to find ");
			search = iteamchoice.nextInt();
			
			bintree.searchRoot(search ,bintree.getroot());
		}
		catch (Exception e) {
			System.out.println(" There is nothing to search ");
			addtoTree();
		}
	}
	
	
	// This is the method that lets the user exit the program
	public void exit() {
		System.out.println(" Program ended have a nice day ");
		System.exit(0);
	}
	
	/**
	 * This is the methodo that saves the binary tree into a text file 
	 * @param root The root of the binary tree
	 */
	public void Savebinarytree(Treenode root)
	{

	   FileOutputStream outputStream;
	   PrintWriter printWriter = null;
	   try
	   {
		outputStream = new FileOutputStream("Binarytree.txt");
		printWriter = new PrintWriter(outputStream); 
		recwrite(root,printWriter);
		

			
	   }
	   catch (IOException e)
	   {
	 	System.out.println("Sorry, an error occurred writer ");
	 	menu();
	   }
	   finally
	   {
		printWriter.close();
	   }

	}
	/**
	 * This is the method that takes in the current parameter and the print writer, and uses recursion to write every node to the text file
	 * @param root the current node 
	 * @param p an object for the print writer
	 */
	public void recwrite(Treenode root, PrintWriter p) {
		try {
			p.println((root.getName() + "	,	" + root.getID() + "	,	" + root.getPrice() ));
			if (root.getleft() != null) {
				recwrite(root.getleft(),p);
			}
			System.out.println(root.getName() + "	,	" + root.getID() + "	,	" + root.getPrice()+ "	,	" + root.getamount());
			if (root.getright() != null) {
				recwrite(root.getright(),p);
			}
		} catch (Exception e) {
			System.out.println(" please add something to the store then try again");
			
		}
	}

	/**
	 * This is the method that reads the file and loads up a binary tree to use 
	 */
	public void readtoaFile() {
		FileReader fileReader;
		BufferedReader bufferedReader = null;
		String nextLine;
		try
		   {
		fileReader = new FileReader("Binarytree.txt");
		bufferedReader = new BufferedReader(fileReader); 

		nextLine = bufferedReader.readLine();
		while (nextLine != null)
		{
			String [] values = nextLine.split("	,	");
			int n;
			double i;
			n = Integer.parseInt(values[1]); 
			i = Double.parseDouble(values[2]);
			bintree.addTree2(values[0],n,i);
		   nextLine = bufferedReader.readLine();
		   
		}
		 }
		 catch (IOException e)
		   {
		 	System.out.println("Sorry, an error occurred reader ");
		 	
		   }
		finally
		   {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
	}
	
public void tester() {
	Testing t = new Testing();
	t.Testermenu();
}
	
	
	
	
	

}
