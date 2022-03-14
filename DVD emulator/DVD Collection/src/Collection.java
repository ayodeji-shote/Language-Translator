import java.util.Scanner;

public class Collection {
// These are the fields for the DVD 
	private DVD dvd1= new DVD();
	private DVD dvd2= new DVD();
	private DVD dvd3= new DVD();
/** 
 * The method creates an instance of the collection called my collection
 * @param args main method 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("booting up");
//		DVD dvd1=new DVD(); 
//		dvd1.setAllDVDDetails("Constantine", "Alban", 90, 300);
//		String title=dvd1.getTitle();
//		System.out.println("What is the title?");
//		System.out.println(title);
		
		Collection myCollection= new Collection();
	/** 
	 * giving an instance of the collection class 
	 */
		myCollection.runProgram();
		myCollection.displayAllCollectionDVDDetails();
		myCollection.totalValueOfCollection();
		/**
		 * This a scanner that lets you input your dvd title 
		 * @return
		 */
		Scanner s1 = new Scanner(System.in);
		System.out.println("input movie title.");
		String input =s1.nextLine();
		myCollection.dvdSearcher(input);
		s1.close(); 
	}
			
		
	
	
	/**
	 * Constructor method for Collection class 
	 */
	public Collection() { 

	}
	/**
	 * this is the set all methods for the collection class, and in this method we are calling the setallDVDDetials from the 
	 * method from the DVD class. 
	 */
	public void runProgram() {
	dvd1.setAllDVDDetails();
	dvd2.setAllDVDDetails();
	dvd3.setAllDVDDetails();
	}
	/**
	 * This is a method to display all the dvdDetials in the collection and calculate the total running time.	
	 */
	public void displayAllCollectionDVDDetails() {
		dvd1.displayAllDVDDetails();
		dvd2.displayAllDVDDetails();
		dvd3.displayAllDVDDetails();
		int total = dvd1.getRunningTime()+dvd2.getRunningTime()+dvd3.getRunningTime();
		System.out.printf("The running time of your collection is " + total);
		System.out.println();
		
	}
	/**
	 * This is a method that searches for your dvd
	 * @param userinput user input is what every the user enters 
	 */

		public void dvdSearcher(String userinput) {
			if (userinput.equals(dvd1.getTitle())) {
				dvd1.displayAllDVDDetails();
			}
			else if (userinput.equals(dvd2.getTitle())) {
				dvd2.displayAllDVDDetails();
			}
			else if (userinput.equals(dvd3.getTitle())) {
				dvd3.displayAllDVDDetails();
			}
			else {
				System.out.println("DVD not found");
			}
			}
		/**
		 * This is a that calculates the total cost. 
		 */
		public void totalValueOfCollection() {
			float total = dvd1.getPurchaseCost()+dvd2.getPurchaseCost()+dvd3.getPurchaseCost();
			System.out.printf("The total value of your collection is " + total);
			System.out.println();
		}
		}
			
		
		
		
		
	
	


