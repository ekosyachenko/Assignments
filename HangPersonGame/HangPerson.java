import java.util.*;
import java.io.*;


public class HangPerson {

	public Scanner file;

	public HangPerson(Scanner wordsFile) {
		file = wordsFile;

		gameStates[0] = "|-----|-\n|\n|\n|\n|\n|__________";
		gameStates[1] = "|-----|-\n|     O\n|\n|\n|\n|__________";
		gameStates[2] = "|-----|-\n|     O\n|     |\n|\n|\n|__________";
		gameStates[3] = "|-----|-\n|     O\n|     |\n|     |\n|\n|__________";
		gameStates[4] = "|-----|-\n|     O\n|    \\|\n|     |\n|\n|__________";
		gameStates[5] = "|-----|-\n|     O\n|    \\|/\n|     |\n|\n|__________";
		gameStates[6] = "|-----|-\n|     O\n|    \\|/\n|     |\n|    /\n|__________";
		gameStates[7] = "|-----|-\n|     O\n|    \\|/\n|     |\n|    / \\\n|__________";
	}
	
	public String wordToGuess = new String();

	public String [] gameStates = new String [8];

	public void displayGameIntro() {

		System.out.println("Welcome to the hangperson game ...");
		System.out.println("To play, guess a letter to try to guess the word.");
		System.out.println("Every time you choose an incorrect letter another");
		System.out.println("body part appears on the gallows. If you guess the");
		System.out.println("word before you're hung, you win. If you get hung you lose.");
		System.out.println("Time to guess ...");

	}

	public void play() {
		int mistakeCount = 0;

		boolean[] lettersTried = new boolean[26]; 

		wordToGuess=file.nextLine();

		char[] wordToGuessArray = toCharArray(wordToGuess);

		boolean[] guessStatus = new boolean[wordToGuess.length()];

		System.out.println(gameStates[mistakeCount]);
		printStatusMessage(lettersTried, guessStatus, wordToGuessArray, mistakeCount);


		while ((gameWon(guessStatus) == false)&&(mistakeCount < 7)) {

			char g = getUserInput();
			int i = g - 'a';

			if (lettersTried[i] == true) {
				System.out.println("You already tried this letter\n");
			} else {
				lettersTried[i] = true;

				boolean guessed = false;


				for (int j=0; j<wordToGuessArray.length; j++) {
					if (wordToGuessArray[j] == g) {
						guessed = true;
						guessStatus[j] = true;
					}
				}

				if (guessed == false) {
					mistakeCount++;
				}

				System.out.println(gameStates[mistakeCount]);
				printStatusMessage(lettersTried, guessStatus, wordToGuessArray, mistakeCount);
			}
		}

		if (gameWon(guessStatus) == true) {
			System.out.println ("Congratulations, you win!!!");

		} else {
			System.out.println ("Too bad, you lose!");
			System.out.println ("The word was ==> " + wordToGuess);
		}

	}

	public char getUserInput () {
		System.out.print("Choose a letter => ");
		String s;
		char sChar;

		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			s = bufferRead.readLine();
						
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}

		if (s.length() == 1) {
			sChar = s.charAt(0);
			if (((sChar - 'a')>= 0)&&((sChar - 'z')<= 0)) {
				return sChar;
			}
		} 

		System.out.println("Invalid input\n");
		return getUserInput();
	}

	public boolean gameWon(boolean[] guessStatus) {
		
		for (boolean n:guessStatus) {
			if (n == false) {
				return false;
			}
		}

		return true;
	}

	public void printStatusMessage (boolean[] lettersTried, boolean[] guessStatus,
									 char[] wordToGuessArray, int mistakeCount) {

		System.out.print ("Letters tried already => ");
			for (int i=0; i<26; i++) {
				if (lettersTried[i] == true) {
					int c = 'a' + i;
					System.out.print((char) c + " ");
				}
			}
			System.out.println();

			System.out.println ("Number of wrong guesses => "+ mistakeCount);

			System.out.print ("The word so far => ");
			
			for (int i=0; i<wordToGuessArray.length; i++) {
				if (guessStatus[i] == true) {
					System.out.print(wordToGuessArray[i]);
				} else {
					System.out.print("-");
				}
			}

			System.out.print("\n\n");
	}

	public char[] toCharArray (String word) {
		char[] array = new char[word.length()];
		for (int i=0; i<word.length(); i++) {
			array[i] = word.charAt(i);
		}
		return array;
	}
}