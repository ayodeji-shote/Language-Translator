
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * This is the class that we control's reading the file and putting the words into a binary tree
 */
public class ReadWrite{
	/**
	 * A temporary array of strings that are used to store a file input
	 */
	String [] temp = new String[4];
    public ReadWrite(){
        //Default Constructor
    }

    /** This is the method that reads the dictionary text file and adds it into the tree
     * @param bt - The binary tree object that the user passes 
     * @param passed - The language that the user wants to translate too
     * @param fileName - The file name that the user wants to save the file as.
     */
    public void readDictionary(BinaryTree bt,String passed,String fileName){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String nextLine;
        int lang = 0;
        if (passed == "english") {
            lang = 1;
        } else {
            lang = 3;
        }

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            nextLine = bufferedReader.readLine();
            
            while (nextLine != null){

                //Replace this with a return statement.
                String[] temp = nextLine.split(", ");
                
                if (passed.equals("english")) {
                	bt.add(Integer.parseInt(temp[lang]),temp[0],temp[2]);
                } else {
                	bt.add(Integer.parseInt(temp[lang]),temp[2],temp[0]);
                }
                
                nextLine = bufferedReader.readLine();
            }
            bufferedReader.close();        
        }
        catch (FileNotFoundException e){
            System.out.println("Sorry the file was not found.");
        }
        catch (IOException e){
            System.out.println("Sorry, there has been a problem opening or reading from the file.");
        }
    }
    /**
     * This is the method that takes in the file of 5k words and translates it to the designated language.
     * @param fileName - a String passed indicating what file the program should use to read in the dictionary.
     * @throws IOException - An exception in case the file is not found or runs in an error.
     * @return String value which contains the whole content of the text file.
     */
    public String readText2(String fileName) throws IOException {
    	File file = new File(fileName);
    	@SuppressWarnings("resource")
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
    	byte[] buffer = new byte[(int) file.length()];
    	bin.read(buffer);
    	String fileStr = new String(buffer);
    	return fileStr;
    }
    

    /**
     * This is the method that writes the binary tree that is created into a file.
     * @param mainNode The current active node 
     * @param w The printwriter object 
     * @param input_lang The input language that the user is current inputing  
     * @param fileName - passed the fileName.
     * @throws FileNotFoundException - A throw call in case the program doesn't find 
     */
    public void writeFile(Node mainNode, PrintWriter w, String input_lang,String fileName) throws FileNotFoundException{
        if (mainNode == null)
            return;
        boolean top_call = false;
        if (w == null) {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            w = new PrintWriter(outputStream); 
            top_call = true;
        }
        if (input_lang.equals("eng-")) {
        	writeFile(mainNode.left, w,input_lang,fileName);
            w.print(mainNode.word_active + ", " + mainNode.id + ", " + mainNode.word_translated + ", " +  String.valueOf(mainNode.word_translated.hashCode() + "\n"));
            writeFile(mainNode.right, w,input_lang,fileName);
        } else {
        	writeFile(mainNode.left, w,input_lang,fileName);
            w.print(mainNode.word_translated + ", " + mainNode.id + ", " + mainNode.word_active + ", " +  String.valueOf(mainNode.word_translated.hashCode() + "\n"));
            writeFile(mainNode.right, w,input_lang,fileName);
        }
        

        if (top_call)
            w.close();
    }
}