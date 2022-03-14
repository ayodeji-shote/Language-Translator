
/**
 * These are the classes that you import into the java.
 */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Files {
private static final String crypt1 = "cipherabdfgjk";
private static final String crypt2 = "lmnoqstuvwxyz";

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		/**
//		 * This is the object that is is used to call the run file test methods.
//		 */
//Files runFile = new Files(); 
//
//runFile.runFileTests();
//
//
//	}

	
	
	
/**
 * The run method that calls the other methods 
 */
public void	runFileTests(){
	//runFile.fileReader();
//	writeToAFile();
//	Copyfile();
	//fileDecipher();
	averageData();
	}

/**
 * This is the file reader method
 */
public static void fileReader()
{
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    /**
     * This is the scanner that is used to take in the user input of what file they want the program to read
     */
    
    System.out.println("Please input your file name ");
    Scanner input = new Scanner(System.in);
    String fileName; 
    
    /**
     * This is the file reader, it takes the string filename.txt as the name of the file, then uses the buffer reader to 
     * read the file, the catch line is used to find the exception 
     */
    try
    {
        fileReader = new FileReader(fileName = input.nextLine());
        bufferedReader = new BufferedReader(fileReader); 

        String nextLine = bufferedReader.readLine();
        
        while (nextLine != null)
        {
            System.out.println(nextLine);
            nextLine = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
    catch (FileNotFoundException e)
    {
        System.out.println("File not found: " + e);
    }
    catch (IOException e)
    {
        System.out.println("IO Error reading from file: " + e);
    }
}

/**
 * This is the method that creates a file and writes the information you want in it.
 */

public static void writeToAFile()
{
    FileOutputStream outputStream = null;
    PrintWriter printWriter = null;
    Scanner write = new Scanner(System.in);
    String word;
    String userinput;
    
    /**
     * This output stream takes in the string word and types it on the next line 
     */
    try
    {
    	System.out.println("What is your file name");
        outputStream = new FileOutputStream(word= write.nextLine());
        printWriter = new PrintWriter(outputStream); 
        do
        {
        /**
         * Every time you press enter this allows you input your user input into the next line 
         * but everytime you input a line it would go to the next line 
         */
        System.out.println("Please enter the next line: ");
        userinput = write.nextLine();
    
        
        printWriter.println(userinput);
        }
        while(!userinput.isEmpty());
        
    }
    
     catch (IOException e)
    {
        System.out.println("Error in file write: " + e);
    }
    finally
    {
    	printWriter.close(); 
    }
}
/**
 * This is the method that copy's a file and puts it in another file
 */

public static void Copyfile()
{
	 FileReader fileReader = null;
	 BufferedReader bufferedReader = null;    
	 FileOutputStream outputStream = null;
	 PrintWriter printWriter = null;
	 
	/**
	 * This is the string and scanner that is involved in the input of name of the file you are trying to copy
	 * and the file that you are copying too.
	 */
	 String Firstfile;
	 String Copyfile;
	 Scanner f1 = new Scanner(System.in);
	 Scanner f2 = new Scanner(System.in);
	 
	 try
	    { 
		 /**
		  * This is the input that selects the file that you want to copy 
		  */
		 System.out.println("What is your file name that you want to copy from ");
		 fileReader = new FileReader(Firstfile= f1.nextLine());
		 bufferedReader = new BufferedReader(fileReader); 
		 
		 /**
		  * This is the input that sets the name of your copy file inputs the copied information
		  */
		 System.out.println("Enter the name of your copy file ");
		 outputStream = new FileOutputStream(Copyfile= f2.nextLine());
		 printWriter = new PrintWriter(outputStream); 
		
		 /**
		  * prints the message your file has been copied 
		  */
		 
		 System.out.println("Your file has been copied");
		 
		 
		 String nextLine = bufferedReader.readLine();
	        
		 /**
		  * 
		  */
	        while (nextLine != null)
	        {
	            System.out.println(nextLine);
	            printWriter.println(nextLine);
	            nextLine = bufferedReader.readLine();
	        }
	        bufferedReader.close();
	    }
	 
	 catch (FileNotFoundException u)
	    {
	        System.out.println("FileNotFoundException: " + u);
	    }
	 
	 catch (IOException a)
	    {
	        System.out.println("Error in file write: " + a);
	    }
	 catch (Exception a)
	 {
		 System.out.println("Error in file write: " + a);
	 }
	 
	   finally
	    {
	    	printWriter.close(); 
	    }	 
}

public static void fileDecipher()
{
	 FileReader fileReader = null;
	 BufferedReader bufferedReader = null;    
	 FileOutputStream outputStream = null;
	 PrintWriter printWriter = null;
	 
	 
	 try
	    { 
		 /**
		  * This is the input that selects the file that you want to copy 
		  */
		 fileReader = new FileReader("mystery.txt");
		 bufferedReader = new BufferedReader(fileReader); 
		 
		 /**
		  * This is the input that sets the name of your copy file inputs the copied information
		  */
		 System.out.println("Enter the name of your copy file ");
		 outputStream = new FileOutputStream("Decripted_file.txt");
		 printWriter = new PrintWriter(outputStream); 
		 
		 
		 System.out.println("Your file has been decripted");
		 
		 
		 String nextLine = bufferedReader.readLine();
	        
	        while (nextLine != null)
	        {
	            System.out.println(nextLine);
	            printWriter.println(cipherDecipherString(nextLine));
	            nextLine = bufferedReader.readLine();
	        }
	        bufferedReader.close();
	    }
	 
	 catch (FileNotFoundException u)
	    {
	        System.out.println("FileNotFoundException: " + u);
	    }
	 
	 catch (IOException a)
	    {
	        System.out.println("Error in file write: " + a);
	    }
	 catch (Exception a)
	 {
		 System.out.println("Error in file write: " + a);
	 }
	 
	   finally
	    {
	    	printWriter.close(); 
	    }	
}

private static String cipherDecipherString(String text)
{
    // declare variables we need
    int i, j;
    boolean found = false;
    String temp="" ; // empty String to hold converted text

    for (i = 0; i < text.length(); i++) // look at every character in text
    {
        found = false;
        if ((j = crypt1.indexOf(text.charAt(i))) > -1) // is char in crypt1?
        {           
            found = true; // yes!
            temp = temp + crypt2.charAt(j); // add the cipher character to temp
        } 
        else if ((j = crypt2.indexOf(text.charAt(i))) > -1) // and so on
        {
            found = true;
            temp = temp + crypt1.charAt(j);
        }

        if (! found) // to deal with cases where char is NOT in crypt2 or 2
        {
            temp = temp + text.charAt(i); // just copy across the character
        }
    }
    return temp;
}


public static void averageData()
{
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    FileOutputStream outputStream = null;
	 PrintWriter printWriter = null;

    
    /**
     * This is the array called list that only takes in String data types, and this is the local variables string first name and last name.
     */
    try
    {
    	String [] list; 
    	String FName, LName;
        fileReader = new FileReader("details.txt");
        bufferedReader = new BufferedReader(fileReader); 
        outputStream = new FileOutputStream("Average score.txt");
		printWriter = new PrintWriter(outputStream); 

		/**
		 * This is the method that reads each line of string and moves to the next line as long as it is not empty.
		 */
		
        String nextLine = bufferedReader.readLine();
        while (nextLine != null)
        {	
        	list = nextLine.split(" ");
        	FName = list[0];
        	LName = list[1];
        /**
         * these are the base values for the fields in the array they are set to 0 because when ever a new average is calculated it isnt affected by the new average.
         */
        	int length = 0, total = 0, score = 0;
        	float average = 0;
        	for (int i = 2; i<list.length; i++) 
        	{
        		/**
        		 * This is the code that turns string values into an int
        		 */
        		length++;
        		score = Integer.parseInt(list[i]);
        		total += score;
        	}
        	average = total / length;
        	System.out.println(FName +" " + LName + ": Final score is ");
        	System.out.printf("%.2f", average);
        	System.out.println("");
//        	printWriter.print(FName + " " + LName + ": Final score is ");
//        	System.out.printf("%.2f", average);
//        	System.out.println("");
        	nextLine = bufferedReader.readLine(); 
  
        }
        bufferedReader.close();
    }
    catch (FileNotFoundException e)
    {
        System.out.println("FileNotFoundException: " + e);
    }
    catch (IOException e)
    {
        System.out.println("IO Error reading from file: " + e);
    }
}

public static void arrayfile ()
{
	/**
	 * This is the print writer and file, file output stream that prints what the user wants into the file 
	 */
	 FileOutputStream outputStream = null;
	    PrintWriter printWriter = null;
	    Scanner arraywrite = new Scanner(System.in);
	    String arrayName;
	    
	    /**
	     * This is the int field that lets the user input what they want into the field
	     */
	    int arrayinput;
	    int [][] arrayFile = { { 1, 2, 3, },
	    					   { 4, 5, 6, },
	    					   { 7, 8, 9, }, };
	    
	    /**
	     * This output stream takes in the int number and types it on the next line 
	     */
	    try
	    {
	    	System.out.println("What is your file name");
	        outputStream = new FileOutputStream(arrayName= arraywrite.nextLine());
	        printWriter = new PrintWriter(outputStream); 
	    
	    /**
	     * Fetching the data from the array that was created earlier
	     */
	    for (int[] array: arrayFile)
	    	
	    {
	    	printWriter.println(Arrays.toString(array));
	    }
	    }
	        
	        /**
	         * Every time you press enter this allows you input your user input into the next line 
	         * but everytime you input a line it would go to the next line 
	         */
	        
	    
	    /**
	     * This is the catch statment that catches any exception in your code.
	     */
	        	
	     catch (IOException e)
	    {
	        System.out.println("Error in file write: " + e);
	    }
	    finally
	    {
	    	printWriter.close(); 
	    }
	
}

public void arrayDVD () {
	/**
	 * These are the DVD objects and the  parentheses are the fields for each dvd object 
	 */
	 DVD dvd1= new DVD("Hell boy ","Guilamo del toro", 234);
	 DVD dvd2= new DVD("Hell boy 2 ","Guilamo del toro", 264);
	 DVD dvd3= new DVD("Hell boy 3 ","Guilamo del toro", 254);
	 
	/**
	 * This is the array called dvd with the objects dvd1 dvd2 and dvd3
	 */
	 DVD [] DVDCollection = { dvd1,dvd2,dvd3};
	 
	 FileOutputStream outputStream;
	 PrintWriter printWriter = null;
	 
	 /**
	  * this is the try and catch method for the information of the dvd object written in a file.
	  */
	 try
	    {
	    	
	        outputStream = new FileOutputStream("u.txt");
	        printWriter = new PrintWriter(outputStream); 
	        
	        String title,director,runTime;
	        for (DVD dvd: DVDCollection)
	        {
	        	title = "title: " + dvd.getTitle();
	        	director = "director: " + dvd.getDirector();
	        	runTime = "Running time: " + dvd.getRunningTime();
	        }
	    }
	          	
	   	     catch (IOException e)
	   	    {
	   	        System.out.println("Error in file write: " + e);
	   	    }
	   	    finally
	   	    {
	   	    	printWriter.close(); 
	   	    }
	   	
	 
}

}
