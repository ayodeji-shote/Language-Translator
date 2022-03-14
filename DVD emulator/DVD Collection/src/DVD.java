import java.util.Scanner;
public class DVD {
/** 
 * These are the fields for the object 
 */
	private String title;
	private String director;
	private int runningTime;
	private float  purchaseCost;
	public void example() {
		System.out.println("booting up");
		}
	
	/**
	 * Constructor method for the object fields.
	 */
	public DVD() { 
		title = "";
		director = "";
		runningTime = 0;
		purchaseCost = 0;
	
	}
	/**
	 * This is the accessor method for the  movie title 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * This is the mutator method for the  movie title 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * This is the accessor method for the  movie director 
	 * @return
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * This is the mutator method for the  movie director
	 * @return
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * This is the accessor method for the  movie running time
	 * @return
	 */
	public int getRunningTime() {
		return runningTime;
	}
	/**
	 * This is the mutator method for the  movie running time
	 * @return
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	/**
	 * This is the accessor method for the  movie cost
	 * @return
	 */
	public float getPurchaseCost() {
		return purchaseCost;
	}
	/**
	 * This is the mutator method for the movie cost
	 * @return
	 */
	public void setPurchaseCost(float purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	/** These are the getters and setters for the fields that get attributes of the class
	 * 
	 */
	public void setAllDVDDetails() {
		Scanner s2 = new Scanner(System.in); 
		System.out.print("Insert movie title");
		this.title = s2.nextLine();
		System.out.print("Insert movie director. ");
		this.director = s2.nextLine();
		System.out.print("insert running time. ");
		this.runningTime = s2.nextInt(); 
		System.out.print("insert price. ");
		this.purchaseCost = s2.nextFloat(); 
		s2.close(); 
	}


	/**
	 * This is the method that displays all the dvd details 
	 */
	public void displayAllDVDDetails() {
		System.out.println("Title? "+ title );
		System.out.println("Director? " + director);
		System.out.println("Running Time? " + runningTime);
		System.out.println("Purchase Cost? " + purchaseCost);
	}
	
	}




 


