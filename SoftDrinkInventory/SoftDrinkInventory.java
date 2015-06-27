import java.util.*;

public class SoftDrinkInventory {

	String [] names;
	String [] iDs;
	int [] initialInventories;
	int [] finalInventories;
	int [] numberOfTransactions;
	int drinksCount = 0;

	public SoftDrinkInventory() {
		int n = 100;
		names = initializeString(n);
		iDs = initializeString(n);
		initialInventories = initializeInt(n);
		finalInventories = initializeInt(n);
		numberOfTransactions = initializeInt(n);
	}

	public void buildInventory (Scanner inventoryFile) {
		
		while (inventoryFile.hasNextLine()) {
			String line = inventoryFile.nextLine();
			String [] tokens = line.split(" ");
			names[drinksCount] = tokens[0];
			iDs[drinksCount] = tokens[1];
			initialInventories[drinksCount] = Integer.parseInt(tokens[2]);
			finalInventories[drinksCount] = Integer.parseInt(tokens[2]);
			drinksCount +=1;
		}
	}

	public void processTransactions(Scanner transFile) {
		while (transFile.hasNextLine()) {
			String line = transFile.nextLine();
			String [] tokens = line.split(" ");

			int n = findID(tokens[0]);

			if (n > -1) {
				finalInventories[n] += Integer.parseInt(tokens[1]);
				numberOfTransactions[n] += 1;
			}		

		}
	}

	public void displayReport () {
		
		String title1 = "Soft Drink";
		String title2 = "ID";
		String title3 = "Starting inventory";
		String title4 = "Final inventory";
		String title5 = "# transactions";
		
		int len1 = longest(title1, names);
		int len2 = longest(title2, iDs);
		int len3 = longest(title3, initialInventories);
		int len4 = longest(title4, finalInventories);
		int len5 = longest(title5, numberOfTransactions);

		printWithBlanks(title1, len1);
		printWithBlanks(title2, len2);
		printWithBlanks(title3, len3);
		printWithBlanks(title4, len4);
		printWithBlanks(title5, len5);
		System.out.print("\n");

		int i = 0;
		while (i<drinksCount) {
			printWithBlanks(names[i], len1);
			printWithBlanks(iDs[i], len2);
			printWithBlanks(Integer.toString(initialInventories[i]), len3);
			printWithBlanks(Integer.toString(finalInventories[i]), len4);
			printWithBlanks(Integer.toString(numberOfTransactions[i]), len5);
			System.out.print("\n");

			i+=1;
		}

	}

	public int longest(String title, String[] values) {
		int len = title.length();
		for (String value: values) {
			if (value.length() > len) {
				len = value.length();
			}
		}	
		return len;	
	}

	public int longest(String title, int[] values) {
		int len = title.length();
		for (int value: values) {
			String valueStr = Integer.toString(value);
			if (valueStr.length() > len) {
				len = valueStr.length();
			}
		}	
		return len;	
	}
	public void printWithBlanks(String value, int len) {
		System.out.print(value);
		for (int i=0; i<(len - value.length()+2); i++) {
			System.out.print(" ");
		}

	}

	private int findID(String iD) {
		int index = -1;
		for (int i=0; i<drinksCount; i++) {
			if (iDs[i].equals(iD)) {
				index = i;
			}
		}
		return index;
	}
	
	private int[] initializeInt(int numberOfElements) {
		int[] array = new int[numberOfElements];
		return array;
	}

	private String[] initializeString(int numberOfElements) {
		String[] array = new String[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			array[i] = "";
		}
		return array;
	}
}