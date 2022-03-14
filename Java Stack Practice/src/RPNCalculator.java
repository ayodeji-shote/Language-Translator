import java.util.Scanner;

public class RPNCalculator {

	Scanner userInput = new Scanner(System.in);
	Stacks cStack = new Stacks(); // This is the object from the class stacks 

	public RPNCalculator() {

	}
/**
 * This is the method that parses the string input and turns it into a double value.
 */
	public void runSplit() {
		cStack.initialiseStack();// This initialises the stack
		List alist = new List();// New list object 
		Menu menu = new Menu();// New menu object 
		System.out.println(" Please input your Calculation ");
		String input = userInput.next();
		String testData = input;
		String[] splitString;
		String delimiter = ","; // This is used to seperate the string values of the input
		// These are the string variables that the method looks for in order to do the calculation 
		String plus = "+";
		String Minus = "-";
		String Mult = "*";
		String Div = "/";
		boolean validInput = false; // This is a boolean too check of the input entered is valid 
		boolean onlyres = false;// This is the boolean to check if there is a correct ratio of operands to operators.
		// These are the counters for standard Strings and the operands
		int Validopperators = 0;
		int NumOpparands = 0;
		String operands = null;
//		System.out.println("Test data = " + testData);
		splitString = input.split(delimiter);
// The double array is made to be the same size as the length of the string array 

		double[] numarray = new double[splitString.length]; // This makes sure that the array of doubles is the same size as the string array input length 
		// This counts through the array and looks for the plus,minus and mult variables to count. 
		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i].equals(plus) || splitString[i].equals(Minus) || splitString[i].equals(Mult)
					|| splitString[i].equals(Div)) {
				Validopperators++;
			} else {
				NumOpparands++;
			}
		}
		// This is a validator for the equation, if the input isnt valid then the program is going to run again.
		if (NumOpparands == (Validopperators + 1)) {
			validInput = true;
		} else {
			System.out.println(" Sorry this input is not valid please try again ");
			runSplit();

		}
		if (NumOpparands == 1 && Validopperators == 0) {
			onlyres = true;
		}
		// These methods are for attempting to display the correct inflix notation for the postfix input that is entered
		if (validInput == true) {
			for (int i = 0; i < splitString.length; i++) {
				if (splitString[i].equals("+")) {
					System.out.println(
							" The inflix notations is  " + "(" + splitString[i - 1] + " + " + splitString[i - 2] + ")");
				}
				if (splitString[i].equals("-")) {
					System.out.println(
							" The inflix notations is  " + "(" + splitString[i - 1] + " - " + splitString[i - 2] + ")");
				}
				if (splitString[i].equals("*")) {
					System.out.println(
							" The inflix notations is  " + "(" + splitString[i - 1] + " * " + splitString[i - 2] + ")");
				}
				if (splitString[i].equals("/")) {
					System.out.println(
							" The inflix notations is  " + "(" + splitString[i - 1] + " / " + splitString[i - 2] + ")");
				}
			}

		}

		try {
			if (validInput == true) {
				double result = 0;
				for (int i = 0; i < splitString.length; i++) {
					String opperators = splitString[i];
					{
// This is the part of the code that checks if an operator is next
						if (splitString[i].equals(plus)) {
							// These pop the numbers out of the stack 
							double num1 = cStack.pop();
							double num2 = cStack.pop();
							
							// This pushes the results of those numbers back into the stack as the head of the stack 
							cStack.push(num2 + num1);
							result = num2 + num1;
//							cStack.isStackEmpty(num2 + num1); // Checks if the stack is empty with the result that you put into the stack
						} else if (splitString[i].equals(Minus)) {
							double num1 = cStack.pop();
							double num2 = cStack.pop();
							cStack.push(num2 - num1);
							result = num2 - num1;
//							cStack.isStackEmpty(num2 - num1);
						} else if (splitString[i].equals(Mult)) {
							double num1 = cStack.pop();
							double num2 = cStack.pop();
							cStack.push(num2 * num1);
							result = num2 * num1;
//							cStack.isStackEmpty(num2 * num1);

						} else if (splitString[i].equals(Div)) {
							double num1 = cStack.pop();
							double num2 = cStack.pop();
							cStack.push(num2 / num1);
							result = num2 / num1;
//							cStack.isStackEmpty(num2 / num1);
						} else {
// This turns the Split individual parts of the string array into an int.
							numarray[i] = Double.parseDouble(opperators);

							cStack.push(numarray[i]);

							if (onlyres == true) {
								cStack.isStackEmpty(numarray[i]);
							}
						}

					}
				}
				cStack.pop(); 
				cStack.isStackEmpty(result);
			}

		} catch (Exception e) {
			System.out.println(" That is not a valid integer");
			runSplit();
		}
	}

}
