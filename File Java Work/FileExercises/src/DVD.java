import java.util.Scanner;
public class DVD {
/** 
 * These are the fields for the object 
 */
	private String title;
	private String director;
	private int runningTime;
	
	/**
	 * Constructor method for the object fields.
	 * @param i 
	 * @param string2 
	 * @param string 
	 */
	public DVD(String title, String director, int runningTime) { 
		title = "";
		director = "";
		runningTime = 0;
		 
	
	}
	/**
	 * This is the accessor method for the  movie title 
	 * @return this accesor method returns the title 
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * This is the mutator method for the  movie title 
	 * @param the input that this mutator method recives is the string title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * This is the accessor method for the  movie director 
	 * @return this accesor method returns the director 
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * This is the mutator method for the  movie director
	 * @return this mutator method returns the director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * This is the accessor method for the  movie running time
	 * @return this method returns the running time 
	 */
	public int getRunningTime() {
		return runningTime;
	}
	/**
	 * This is the mutator method for the  movie running time
	 * @return this method sets the running time 
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
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
		s2.close(); 
	}


	/**
	 * This is the method that displays all the dvd details 
	 */
	public void displayAllDVDDetails() {
		System.out.println("Title? "+ title );
		System.out.println("Director? " + director);
		System.out.println("Running Time? " + runningTime);
	}
	
	}




 


