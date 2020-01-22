import java.security.SecureRandom;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	
	private static String [] wordList = new String[200];
	private int currentCard = 0;
	private SecureRandom randomNumbers = new SecureRandom();
	
	public Dictionary(String fileName) throws FileNotFoundException {
		
		readFile(fileName);
		
	} // end Dictionary (CONSTRUCTOR)
	
	private static void readFile(String fileName) throws FileNotFoundException {
	
		Scanner inFile = new Scanner(new FileReader(fileName));
		while(inFile.hasNext()) {
			for (int i = 0; i < 200; i++)
				wordList[i] = inFile.nextLine();
		}		
		inFile.close();
		
	} // end readFile
	
	public String chooseWord() {
		
		currentCard = randomNumbers.nextInt(200);
		return wordList[currentCard];
		
	}	// end chooseWord
	
}
