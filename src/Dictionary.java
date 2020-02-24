import java.security.SecureRandom;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* the Dictionary class uses a Scanner to read the  dictionary.txt
and creates an array of all the words
*
* @author Kaitlyn Reed
* @version 4.12
* Programming Project 1 * SPRING/2020
*/

public class Dictionary {
	
	private static String [] wordList = new String[200]; // represents the list of  words that can be used
	private int currentCard = 0; // holds the number of the word in the wordList array
	private SecureRandom randomNumbers = new SecureRandom(); // computes a random number 
	
/**
 * This Dictionary constructor takes in a file name and call the readFile method.
 * 
 * @param fileName (dictionary.txt)
 * @throws FileNotFoundException
 */
	
	public Dictionary(String fileName) throws FileNotFoundException {
		
		readFile(fileName);
		
	} // end Dictionary (CONSTRUCTOR)
	
/**
 * This readFile method reads the file provided and creates an array of what the file contains.
 * (in this case, words)
 * 
 * @param fileName (dictionary.txt)
 * @throws FileNotFoundException
 */
	
	private static void readFile(String fileName) throws FileNotFoundException {
	
		Scanner inFile = new Scanner(new FileReader(fileName));
		while(inFile.hasNext()) {
			for (int i = 0; i < 200; i++)
				wordList[i] = inFile.nextLine();
		}		
		inFile.close();
		
	} // end readFile
	
/**
 * The chooseWord method returns a String from dictionary.txt based on the index 
 of the wordList array computed by randomNumbers 
 *
 * @return String (word from dictionary.txt)
 */
	
	public String chooseWord() {
		
		currentCard = randomNumbers.nextInt(200);
		return wordList[currentCard];
		
	}	// end chooseWord
	
} // end Dictionary
