import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Translation{
	
    private boolean mode = false; // Will interupt the program if no word is interupted 
    private double startTime; // this is the start time for calculating the words per second 
    private double endTime; // this is the end time for calculating the words per second 
    private double timeElapsed; // this is the startTime - the end time 
    public Translation(){

    }
    
    //TODO ADD TRANSLATE FILE _ call to read write file;
    /**
     * this is the method that translates the text file 
     * @param fileName this is the name of the file that you are translating the document 
     * @param input_lang this is the input language that the user is inputing 
     * @param trees - this is the array of binary trees.
     * @throws IOException - A call to IOException to prevent failing when the program runs into errors with file managing.
     */
    public void translateFile(String fileName, String input_lang,BinaryTree[] trees) throws IOException {
    	ReadWrite fileReader = new ReadWrite();
    	
    	timeStart();
    	
    	String text = fileReader.readText2(fileName);
    	System.out.println(text);
    	System.out.println("#-----------------------------------------------------------------");
    	
    	translateLine(text,input_lang,trees);
    	timeEnd();
    	timeElapsed = (double) (5200.0 / timeElapsed);
    	System.out.println("The time taken to translate a file of 5200 words is: " + timeElapsed);
    }

    /**
     * This is the method that turns on the mode 
     */
    public void onMode() {
    	mode = true;
    }
    
    /**
     * This is the method that turns off the mode
     */
    public void offMode() {
    	mode = false;
    }
    
    /**
     * This is the method that translates a specific line of code 
     * @param line this is the string that the userinputs 
     * @param input_lang this is the string that the user inputs 
     * @param trees this is the array of trees 
     * @throws IOException - A call to IOException so the program manages errors with fileReading/Writing
     * @return String value - the translated message.
     */
    public String translateLine(String line, String input_lang, BinaryTree[] trees) throws IOException{
        BinaryTree active = null;
        BinaryTree secondary = null;
        if (input_lang.equals("eng-fr")){
            active = trees[0];
            secondary = trees[1];
        } else if (input_lang.equals("fr-eng")){
            active = trees[1];
            secondary = trees[0];
        } else if (input_lang.equals("eng-italian")) {
            active = trees[2];
            secondary = trees[3];
        } else if (input_lang.equals("italian-eng")) {
        	active = trees[3];
        	secondary = trees[2];
        }
        
        String translated = "";
        String[] words = line.split(" ");
        for (int x = 0; x < words.length; x++){
            translated = translated + translateWord(words[x],input_lang,active,secondary) + " ";
        }
        
        System.out.println(translated);
        

        return translated;     
    }

    /**
     * This is the method that translates a specific line of code 
     * @param line this is the string that the userinputs 
     * @param input_lang this is the string that the user inputs 
     * @param active this is the active binary trees for the main langauge 
     * @param secondary this is the binary tree that the user is printing the other langauge too. 
     * 
     */
    private String translateWord(String word, String input_lang, BinaryTree active, BinaryTree secondary) throws IOException{
        //TODO add 's/
    	@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
        String trans = "";
        String translated = "";
        char[] letters = word.toCharArray();
        int capital = 0;
        boolean punctuated = false;
        String punctuationSigns = "!\"#$%&()*+,-./:;<=>?@[\\]^_`{|}~";
        String apostrophy = "'";
        boolean contraction = false;
        int apos_loc = 0;
        String contraction_word = "";
        boolean is_not = false;

        if (Character.isUpperCase(letters[0])){
		    capital = 1;
		}

        for (int z = 0; z < letters.length; z++){
            if (apostrophy.contains(String.valueOf(letters[z]))) {
                //System.out.println("It contains a contraction.");
                contraction = true;
                apos_loc = z;
            }
        }

        if (punctuationSigns.contains(String.valueOf(letters[letters.length-1]))) {
            word = "";
            punctuated = true;

            for (int y = 0; y < letters.length-1; y++){
                word = word + letters[y];
            }
        }

        if (input_lang.equals("eng-fr") || input_lang.equals("eng-italian")){
            if (contraction == true){
                word = "";
                if (punctuated == true){
                    if (letters.length == apos_loc + 4){
                        //System.out.println("\n" + (apos_loc + 1));
                        //System.out.println("\n" + letters[apos_loc + 1]);
                        if (String.valueOf(letters[(apos_loc + 1)]).equals("r") && String.valueOf(letters[(apos_loc + 2)]).equals("e")){
                            contraction_word = active.containsNode("are".hashCode()).word_translated;
                        }
                        else if (String.valueOf(letters[(apos_loc + 1)]).equals("l") && String.valueOf(letters[(apos_loc + 2)]).equals("l")){
                            contraction_word = active.containsNode("will".hashCode()).word_translated;
                        }
                        else if (String.valueOf(letters[apos_loc + 1]).equals("v") && String.valueOf(letters[apos_loc + 2]).equals("e")){
                            contraction_word = active.containsNode("have".hashCode()).word_translated;
                        } else {
                            for (int x = apos_loc; x < letters.length - 1; x++) {
                                contraction_word = contraction_word + letters[x];
                            }
                        }
                        for (int f = 0; f < letters.length - 4; f++){
                            word = word + letters[f];
                        }
                            
                    } else if (letters.length == apos_loc + 3){
                        if (String.valueOf(letters[apos_loc + 1]).equals("t") && String.valueOf(letters[apos_loc - 1]).equals("n")){
                            contraction_word = active.containsNode("not".hashCode()).word_translated;
                            is_not = true;
                        }
                        else if (String.valueOf(letters[apos_loc + 1]).equals("m")){
                            contraction_word = active.containsNode("am".hashCode()).word_translated;
                        } else {
                            for (int x = apos_loc; x < letters.length - 1; x++) {
                                contraction_word = contraction_word + letters[x];
                            }
                        }
                        for (int f = 0; f < letters.length - 3; f++){
                            word = word + letters[f];
                        }
                        
                        if (is_not == true) {
                            word = "";
                            for (int f = 0; f < apos_loc - 1; f++) {
                                word = word + letters[f];
                            }
                        }
                    }
                } else {

                    if (letters.length == apos_loc + 3){
                        if (String.valueOf(letters[apos_loc + 1]).equals("r") && String.valueOf(letters[apos_loc + 2]).equals("e")){
                            contraction_word = active.containsNode("are".hashCode()).word_translated;
                        }
                        else if (String.valueOf(letters[apos_loc + 1]).equals("l") && String.valueOf(letters[apos_loc + 2]).equals("l")){
                            contraction_word = active.containsNode("will".hashCode()).word_translated;
                        }
                        else if (String.valueOf(letters[apos_loc + 1]).equals("v") && String.valueOf(letters[apos_loc + 2]).equals("e")){
                            contraction_word = active.containsNode("have".hashCode()).word_translated;
                        } else {
                            for (int x = apos_loc; x < letters.length; x++) {
                                contraction_word = contraction_word + letters[x];
                            }
                            
                        }
                        for (int f = 0; f < letters.length - 3; f++){
                            word = word + letters[f];
                        }

                    } else if (letters.length == apos_loc + 2){
                        if (String.valueOf(letters[apos_loc + 1]).equals("t") && String.valueOf(letters[apos_loc - 1]).equals("n")){
                            contraction_word = active.containsNode("not".hashCode()).word_translated;
                            is_not = true;
                        }
                        else if (String.valueOf(letters[apos_loc + 1]).equals("m")){
                            contraction_word = active.containsNode("am".hashCode()).word_translated;
                        } else {
                            for (int x = apos_loc; x < letters.length; x++) {
                                contraction_word = contraction_word + letters[x];
                            }
                            
                        }

                        for (int f = 0; f < apos_loc; f++){
                            word = word + letters[f];
                        }
                        
                        if (is_not == true) {
                            word = "";
                            for (int f = 0; f < apos_loc - 1; f++) {
                                word = word + letters[f];
                            }
                        }
                    }
                }
            }
        } else {
            if (punctuated == true){
                for (int x = apos_loc; x < letters.length - 1; x++) {
                    contraction_word = contraction_word + letters[x];
                }
            } else {
               for (int x = apos_loc; x < letters.length; x++) {
                    contraction_word = contraction_word + letters[x];
                } 
            }
            for (int f = 0; f < apos_loc; f++){
                word = word + letters[f];
            }

        }
        //TODO - make it universal for all translation sets
        int hashValue = word.trim().toLowerCase().hashCode();

        if (mode == false) {
            if ( active.containsNode(hashValue) == null) {
                translated = word;
            } else {
                translated = active.containsNode(hashValue).word_translated;
            }            
        } else {
        	if (active.containsNode(hashValue) == null) {
        		System.out.println("The word: " + word + " wasn't found. Do you want to add it to the dictionary?");
        		if (!s1.nextLine().equals("yes")){
        			translated = word;
        		} else {
                    System.out.println("Please enter the translation to the word: " + word);
        			String translation = s1.nextLine();
        			active.add(word.toLowerCase().hashCode(), word, translation);
                    secondary.add(translation.toLowerCase().hashCode(),translation,word);
        			translated = active.containsNode(hashValue).word_translated;
        		}
        	} else {
        		translated = active.containsNode(hashValue).word_translated;
        	}
        }

        //Capital Check
        String[] translated_letters = translated.split("");
        if (capital == 1){
            translated_letters[0] = translated_letters[0].toUpperCase();
        }

        for (int p = 0; p < translated_letters.length; p++){
            trans = trans + translated_letters[p];
        }

        if (punctuated == true && contraction == false){
            trans = trans + String.valueOf(letters[letters.length - 1]);
        }

        if (punctuated == false && contraction == true){
            trans = trans + " " + contraction_word;
        }
        
        if (punctuated == true && contraction == true) {
            trans = trans + " " +  contraction_word + String.valueOf(letters[letters.length-1]);
        }

        //System.out.println(trans);
        return trans;
    }
    
    /**
     * This is the method that collects the starting time. 
     */
    private void timeStart() {
    	startTime = System.nanoTime();
    }
    
    /**
     * This is the method that collects the ending time.
     */
    private void timeEnd() {
    	endTime = System.nanoTime();
    	timeElapsed = endTime - startTime;
    	timeElapsed = timeElapsed / 1000000000;
    }
    

}