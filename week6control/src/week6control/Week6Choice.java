package week6control;

import java.util.Scanner;

/**
 * These are the fields for the methods.
 * @author User
 *
 */
public class Week6Choice {
	static int userinput;
	static String grade;
	static int mathlowinput;
	static int mathhighinput;
	static int statnum1;
	static int statnum2;
	static int statnum3;
	static int statnum4;
	static float average; 
	static float total;
	static float max;
	static float min; 
	static int fail; 

	
/**
 * Scanner that is used in the grade calculator method
 * @return
 */
	public static int p() {
		Scanner s = new Scanner(System.in);
		int userinput = s.nextInt();
		return userinput;
	}
	
	public static int c() {
		Scanner c = new Scanner(System.in);
		int userinput = c.nextInt();
		return userinput;

	}
	
	

	/**
	 * These are the methods that are used to display that the methods are initiated
	 */
	
	public static String gradecalculator() {
		System.out.print("Grade calculator opened");
		boolean gradcalc = true;
		while (gradcalc == true) {
		System.out.println(" please input your percentage grade. ");
		userinput = p();
		
		if (userinput > 69 && userinput<100) {
			grade = "A";
			System.out.println("Your grade is " + grade);
			return grade; 
		}

		else if (userinput > 59 && userinput<69) {
			grade = "B";
			System.out.println("Your grade is " + grade);
			return grade; 
		}

		else if (userinput > 49  && userinput<59) {
			grade = "C";
			System.out.println("Your grade is " + grade);
			return grade; 
		}

		else if (userinput > 40 && userinput<49 ) {
			grade = "D";
			System.out.println("Your grade is " + grade);
			return grade; 
		}

		else if (userinput < 39 && userinput>0) {
			grade = "E";
			System.out.println("Your grade is " + grade);
			return grade;
		}
		else 
		{
			System.out.println("invalid option was selected.");
			System.out.println("Your grade is not valid" );
		}

		}
		return grade; 
		}

			
	
	


	/**
	 * This is the method that displays the table values.
	 */
	public static void PrintValues() {
		System.out.println("method choice 2 executed");
		System.out.println("Please input lower band value. ");
		mathlowinput = p();
		System.out.println("Please input higher band value. ");
		mathhighinput = p();
		double l = (double) mathlowinput;
/**
 * Scanner for the table 
 */
		System.out.println("Value" + "\t" + "Square" + "\t" + "Cube" + "\t" + "Square root");
		/**
		 * condition for lower bound and higher bound, and calculates the 
		 */
		for (double i = (double) l; i<=mathhighinput;i++) {
			double squared = Math.pow(i,2);
			double cubic  = Math.pow(i,3);
			double squareRoot = Math.sqrt(i);
				System.out.printf("%.2f \t",i);
				System.out.printf("%.2f \t",squared);
				System.out.printf("%.2f \t",cubic);
				System.out.printf("%.2f \t",squareRoot);
				System.out.println("");
		}
	
		} 

/**
 * Method that calculates the average, total, maximum and minumum numbers. 
 */

	public static void statistics() {
		
		System.out.println("Statistics is  executed");
		while (statnum1 <= 0 || statnum2 <= 0 || statnum3 <= 0 || statnum4  <= 0) 
		{
		System.out.println("Please input first  number ");
		statnum1 = p();
		System.out.println("Please input second  number ");
		statnum2 = p();
		System.out.println("Please input third  number ");
		statnum3 = p();
		System.out.println("Please input fourth number ");
		statnum4 = p();
		if (statnum1 <= 0 || statnum2 <= 0 || statnum3 <= 0 || statnum4  <= 0)  { 
			System.out.println("Incorrect number please try again");
			
		}
		}
		
		
		average =(statnum1 + statnum2 + statnum3 + statnum4)/4; 
		total =(statnum1 + statnum2 + statnum3 + statnum4);
		System.out.println("The total is " + total);
		System.out.println("The average is " + average);
		Maxnum();
		Minnum();
		}

		
	

	
	/**
	 * This is the method that calculates the maximum number
	 */

	public static void Maxnum() { 
		max = statnum1; 
	if ( max < statnum2 ) {	
		max = statnum2; 
	}
	 if (max < statnum3) {
		 max = statnum3;
	}
	if (max < statnum4) {
		max = statnum4;
	}
	System.out.println("The max number is. "+ max);
	} 
	
	/**
	 * This is the method that calculates the minimum number
	 */
	public static void Minnum() { 
		min = statnum1; 
	if ( min > statnum2 ) {	
		min = statnum2; 
	}
	 if (min > statnum3) {
		 min = statnum3;
	}
	if (min > statnum4) {
		min = statnum4;
	}
	System.out.println("The min number is. "+ min);
	} 	
	
	/**
	 * Method to check if the numbers inputed is less than -1.
	 */
	
	public static void checkminusone() {
		if (statnum1 <= -1 || statnum2 <= -1 || statnum3 <= -1 || statnum4  <= -1) {
			System.out.println (" cannot put negatives please enter another number because you put in a negative.");
			System.exit(0);
			
		}
	}
/**
 * Method that exits when the wrong input is entered 3 times.
 */
public static void checkPercentage() {
		System.out.println("please input your percentage grade ");
		userinput = c();
if (userinput<100 && userinput>0) {
	gradecalculator();
}
else if (userinput>100 && userinput<0) {
}
System.out.println("Incorrect value please try agian ");
userinput = c();
System.out.println("please input your percentage grade ");
if (userinput<100 && userinput>0) {
	gradecalculator();
}
else if (userinput>100 && userinput<0) {
	System.out.println("Incorrect value  please try agian ");
}
userinput = c();
System.out.println("Incorrect value  please try agian");
if (userinput<100 && userinput>0) {
	gradecalculator();
}
else if (userinput>100 && userinput<0) {
	System.out.println("Incorrect value please input your percentage grade  ");
}
else 
	System.out.println("Incorrect value ");
{
	System.out.println("The incorrect grade has been put in too many times please try agian");
}	
	}
/**
 * Method that exits when 5 is selected.
 */
	public static void exits() {
		System.out.println("goodbye");
	}
}
