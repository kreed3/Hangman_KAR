import java.io.*;
import java.util.*;

import java.util.Arrays;

/**
* the Hangman class includes the methods that "play the game" and make each part work.
*
* @author Kaitlyn Reed
* @version 4.12
* Programming Project 1 * SPRING/2020
*/

public class Hangman {
 private Formatter x;  // an attempt at figuring out the loadWL and writeWL methods
 private int wins;     // keeps track of the wins accumulated in one round of playing
 private int losses;   // keeps track of the losses accumulated in one round of playing
 private String currentWord;   // currentWord represents the word that the player is trying to guess
 private Dictionary dictionary = new Dictionary("dictionary.txt");   // initializes a Dictionary object
 private int[] WL = new int[2];   // another attempt at figuring out loadWL and writeWL
 
 /**
  * The default  constructor is empty and is used in the main method 
  to create a Hangman object hang.
  *
  * @throws FileNotFoundException
  */
public Hangman() throws FileNotFoundException {

} // end default constructor
 
/**
 * The loadWL method is meant to load the wins and losses but my efforts
 were not fruitful
 * @throws FileNotFoundException
 */
private void loadWL() throws FileNotFoundException {
	/*File file = new File("wins-losses.txt"); // File object called file
	FileWriter fw = new FileWriter(file, true);    // FileWriter fw that accepts file
	PrintWriter pw = new PrintWriter(fw);    // PrintWriter pw that accepts fw
	
	getWins();
	getLosses();
	
	pw.println(wins);
	pw.println(losses);
	
	pw.close();
	*/
	
	Scanner inFile = new Scanner(new FileReader("wins-losses.txt"));
	while (inFile.hasNextInt()) {
		for (int i = 0; i < 2; i++)
			WL[i]=inFile.nextInt();
	}
	inFile.close();
} //  end loadWL

/**
 * The writeWL method is meant to load the wins and losses but my efforts
 were not fruitful, again
 * @throws FileNotFoundException
 */
private void writeWL() throws IOException {
	File file = new File("wins-losses.txt");       // File object called file
	FileWriter fw = new FileWriter(file, true);    // FileWriter fw that accepts file
	PrintWriter pw = new PrintWriter(fw);          // PrintWriter pw that accepts fw
	
	getWins();
	getLosses();
	
	pw.println(WL[0]);
	pw.println(WL[1]);
	
	pw.close();

}  // end writeWL
 
/**
 * The playGame method run the game part of the program:
 -asks the player for guesses
 -keeps track of correct answers
 -asks the player if he/she wishes to play again
 -keeps track of wins/losses per round
 *
 * @throws IOException
 */
public void playGame() throws IOException {
	Scanner scan = new Scanner(System.in);
	
	String play = "y";  // allows player to decide whether or not they want to play after one round

	String guess = "";  // allows the guess from the player to be read as a String with a Scanner;

	// begins the game and chooses the word to be guessed
	while (play.equalsIgnoreCase("y")) {
		currentWord = dictionary.chooseWord();   // chooses the random word from dictionary.txt
		char[] blank = new char[currentWord.length()];  // creates an array for blank characters
		
		int guesses = 5;  // sets users incorrect guesses available to 5
		
		for (int i = 0 ; i < currentWord.length(); i++) 
			blank[i] = '-';
		
		// user begins guessing
		while (guesses > 0 && !(Arrays.equals(blank,currentWord.toCharArray()))) {
				System.out.println("You have " + guesses + " incorrect guesses left.");
				
				// prints the blank characters
				for (int h = 0; h < blank.length; h ++)
					System.out.print(blank[h]);
				
				// takes user guess and transforms it into a character
				System.out.println("\nWhat is your guess?");
				guess = scan.next();
				char x = guess.charAt(0);
				
				// checks if the letter guessed is in the word and replaces dashes if needed
				// otherwise subtracts one incorrect guess available
				if (currentWord.contains(x+"")) {
					for(int g = 0; g < currentWord.length(); g++)
						if (currentWord.charAt(g) == x)
							blank[g] = x;
					
				} else 
					guesses -= 1;
				
		} // end inside-while
		
		// tells the player whether he/she won or lost and adds to wins or losses respectively
		if (guesses == 0) {
		System.out.println("You are out of guesses!\nThe word was " + currentWord.toUpperCase());
		losses += 1;
		WL[1] += 1;
		} else {
		System.out.println("You won!");
		wins += 1;
		WL[0] +=1;
		}
		
		// asks whether the player wishes to play again or not using the Scanner
		System.out.println("Would you like to play again? y/n");
		play = scan.next();
		
	} //  end outside-while
	
	//  thanks the user for playing and displays wins/losses
	System.out.println("Thanks for playing!\nYou had " + wins + " wins and " + losses + " losses this round.");
	System.out.println("You have a total of " + WL[0] + " wins and " + WL[1] + " losses.");
	scan.close();
	
} // end playGame
 
// Getters and Setters
/**
 * @return integer that represents the current number of wins
 */
public int getWins() {
	return wins;
} // end getWins

/**
 * @param wins takes wins and sets it
 */
public void setWins(int wins) {
	this.wins = wins;
} // end setWins

/**
 * @return integer that represents the current number of losses
 */
public int getLosses() {
	return losses;
} // end getLosses

/**
 * @param losses takes losses and sets it
 */
public void setLosses(int losses) {
	this.losses = losses;
} // end setLosses

/**
 * @param currentWord takes in the current word and sets currentWord to that
 */
public void setCurrentWord(String currentWord) {
	this.currentWord = currentWord;
} // end setCurrentWord
 
} // end Hangman
