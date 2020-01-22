import java.io.*;
import java.util.*;
import java.lang.*;

import java.util.Arrays;

public class Hangman {
 private Formatter x;
 private int wins;
 private int losses;
 private String currentWord;
 private Dictionary dictionary = new Dictionary("dictionary.txt");
 private int[] WL = new int[2];
 
public Hangman() throws FileNotFoundException {

} // default constructor
 
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
}
 
private void writeWL() throws IOException {
	File file = new File("wins-losses.txt"); // File object called file
	FileWriter fw = new FileWriter(file, true);    // FileWriter fw that accepts file
	PrintWriter pw = new PrintWriter(fw);    // PrintWriter pw that accepts fw
	
	getWins();
	getLosses();
	
	pw.println(WL[0]);
	pw.println(WL[1]);
	
	pw.close();
	
	
}
 
public void playGame() throws IOException {
	Scanner scan = new Scanner(System.in);
	
	String play = "y";

	String guess = "";

	while (play.equalsIgnoreCase("y")) {
		String currentWord = dictionary.chooseWord();
		char[] blank = new char[currentWord.length()];
		
		int guesses = 5;
		
		for (int i = 0 ; i < currentWord.length(); i++) 
			blank[i] = '-';
		
		while (guesses > 0 && !(Arrays.equals(blank,currentWord.toCharArray()))) {
				System.out.println("You have " + guesses + " incorrect guesses left.");
				
				for (int h = 0; h < blank.length; h ++)
					System.out.print(blank[h]);
				
				System.out.println("\nWhat is your guess?");
				guess = scan.next();
				char x = guess.charAt(0);
				
				if (currentWord.contains(x+"")) {
					for(int g = 0; g < currentWord.length(); g++)
						if (currentWord.charAt(g) == x)
							blank[g] = x;
					
				} else 
					guesses -= 1;
				
		}
		if (guesses == 0) {
		System.out.println("You are out of guesses!\nThe word was " + currentWord.toUpperCase());
		losses += 1;
		WL[1] += 1;
		} else {
		System.out.println("You won!");
		wins += 1;
		WL[0] +=1;
		}
		
		System.out.println("Would you like to play again? y/n");
		play = scan.next();
	}
	System.out.println("Thanks for playing!\nYou had " + wins + " wins and " + losses + " losses this round.");
	System.out.println("You have a total of " + WL[0] + " wins and " + WL[1] + " losses.");
	scan.close();
} // end playGame
 

public int getWins() {
	return wins;
}
public void setWins(int wins) {
	this.wins = wins;
}
public int getLosses() {
	return losses;
}
public void setLosses(int losses) {
	this.losses = losses;
}
public String getCurrentWord() {
	return currentWord;
}
public void setCurrentWord(String currentWord) {
	this.currentWord = currentWord;
}
 
} // end Hangman.class
