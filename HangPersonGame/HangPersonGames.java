import java.util.*;
import java.io.*;


public class HangPersonGames {
	public static void main(String[] args) {

		Scanner wordsFile = null;
		try {
			wordsFile = new Scanner(new FileInputStream("data7.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found or not opened.");
			System.exit(0);
		}

		HangPerson hangGame = new HangPerson(wordsFile);
		Scanner keyboard = new Scanner(System.in);

		hangGame.displayGameIntro();


		String playAgain;

		do {
			hangGame.play();
			System.out.print("Do you want to play again? ");
			playAgain = keyboard.next();
			System.out.println();

		} while (playAgain.toUpperCase().startsWith("Y"));

		System.out.println();
		System.out.println("Thanks for playing!");
		System.out.println();
	}
}