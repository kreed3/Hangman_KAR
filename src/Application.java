import java.io.IOException;
/**
* the Application class includes the main method and is
where the program is run from.
*
* @author Kaitlyn Reed
* @version 4.12
* Programming Project 1 * SPRING/2020
*/
public class Application {

	public static void main(String[] args) throws IOException {
		
		Hangman hang = new Hangman(); // Hangman object hang created
		hang.playGame();              // playGame() runs the general game
		
	} // end main

} // end Application
