import java.util.*;
import java.io.*;

public class MyMountainFactory extends MountainFactory {

	private ArrayList<String> namesForCaves;
	public ArrayList<String> messagesForCaves;
    private final int NUMBER_OF_NODES = 15; //change the number of nodes to create smaller/larger structures
	private int cavesCreated;
	private int scalesPosition;

    private Random random;

    public MyMountainFactory() {
        namesForCaves = new ArrayList<String>();
        messagesForCaves = new ArrayList<String>();
        fillFromFile(namesForCaves, "cave_names.txt");
        fillFromFile(messagesForCaves, "cave_descriptions.txt");
        random = new Random();
    }

	
    public  MountainCave getMountainTop() {
        cavesCreated = 0;
        scalesPosition = random.nextInt(NUMBER_OF_NODES + 1);

        MountainCave root = buildCave(NUMBER_OF_NODES);

        //root.printCave("  ");   //uncomment to print the tree structure

    	return root;
    }

    private MountainCave buildCave(int numberOfCaves) {
		
		MountainCave cave;

    	if (numberOfCaves == 1) {
    		cave = createRandomCave();

    	} else {
            cave = createRandomCave();

    		int numberOfCaves1 = random.nextInt(numberOfCaves);
    		int numberOfCaves2 = (numberOfCaves-1) - numberOfCaves1;

            if ((numberOfCaves1 == 0) || (numberOfCaves2 == 0)) {
                appendChild(cave, buildCave(numberOfCaves-1));
            } else {
                appendChild(cave, buildCave(numberOfCaves1));
                appendChild(cave, buildCave(numberOfCaves2));
                }
    	}

    	return cave;

    }

    private void appendChild(MountainCave parent, MountainCave child) {
        child.setParent(parent);
        if (child.hasScales()) {
            parent.setAdjacentToScales(true);
        }
    }

    private MountainCave createRandomCave () {
    	MountainCave cave = new MountainCave(getRandomName(), getRandomMessage());
		
		if (scalesPosition == 0) {
			cave.setHasScales(true);
		}
        scalesPosition--;
    	return cave;
    }
	
    public void fillFromFile (ArrayList<String> array, String dataFile) {

    	Scanner file = null;
		try {
			file = new Scanner(new FileInputStream(dataFile));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found or not opened.");
			System.exit(0);
		}
		while (file.hasNextLine()) {
    		array.add(file.nextLine());
    	}

    }

    public String getRandomName() {
    	String name;

        if (cavesCreated == 0) {
            name = "Mountain Top";
        } else {
    	
            int index;

        	if (namesForCaves.size() > 0) {
        		index = random.nextInt(namesForCaves.size());
        		name = namesForCaves.get(index);
        		namesForCaves.remove(index);
        	} else {
                name = "Cave " + cavesCreated;
            }
        }
        cavesCreated++;
    	return name;
    }

    public String getRandomMessage() {
		String message;
    	int index;

    	if (messagesForCaves.size() > 0) {
    		index = random.nextInt(messagesForCaves.size()); 
    		message = messagesForCaves.get(index);
    		messagesForCaves.remove(index);
    	} else {
            message = "Nothing special here";
        }

    	return message;
    }
}
