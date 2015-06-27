import java.util.*;

class MyWumpusHunter extends WumpusHunter {
	public String getName() {
		return "Elizaveta Kosiachenko";

	}

	public void startAt(MountainCave root) {

		

		MountainCave currentCave = root;
		Stack<MountainCave> cavesToCheck = new Stack<MountainCave>();

		boolean foundScales = false;
		while (!foundScales) {

			actionLog += "Entering the "+currentCave.getCaveName()+"\n";

			if (currentCave.isAdjacentToScales()) {
				actionLog += "We've neared the scales!"+"\n";
			}

			if (currentCave.hasScales()) {
				foundScales = true;
				actionLog += "We've found the scales!"+"\n";
				actionLog += "...The path is...\nStart at the Mountain Top\n";

				ArrayList<String> path = new ArrayList<String>();
				while (currentCave != root) {
					path.add(currentCave.getCaveName());
					currentCave = currentCave.getParent();
				}
				for (int i=path.size()-1; i>=0; i--) {
					actionLog += "and then visit the "+path.get(i)+"\n";
				}

			} else {
				ArrayList<MountainCave> childrenOfCurrentCave = currentCave.getChildren();

				for (MountainCave cave: childrenOfCurrentCave) {
					cavesToCheck.push(cave);
				}

				currentCave = cavesToCheck.pop();
			}
		}
	}
}