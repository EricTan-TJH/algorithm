package algorithmicpuzzles;

import java.util.ArrayList;

public class WolfSheetCabbage {

	private static String WOLF = "WOLF";
	private static String SHEET = "Sheet";
	private static String CABBAGE = "Cabbage";
	private static String MAN = "Man";

	private String lastTransfer = "";

	ArrayList<String> source = new ArrayList<String>(3);
	ArrayList<String> destiny = new ArrayList<String>(3);

	public void init() {
		source.add(MAN);
		source.add(WOLF);
		source.add(SHEET);
		source.add(CABBAGE);
	}

	public void transfer() {
		do {
			forward();
			printStatus();
			if (destiny.size() < 4) {
				backward();
				printStatus();
			}
		} while (destiny.size() < 4);
	}

	public void backward() {
		destiny.remove(MAN);
		source.add(MAN);

		if (!isSomethingWillBeEatten(destiny)) {
			return;
		}
		for (int i = 0; i < destiny.size(); i++) {
			if (destiny.get(i).equals(lastTransfer)) {
				continue;
			}

			ArrayList<String> sourceSimulator = new ArrayList<String>(source);
			ArrayList<String> destSimulator = new ArrayList<String>(destiny);
			String toBeTransfer = destiny.get(i);
			destSimulator.remove(toBeTransfer);
			sourceSimulator.add(toBeTransfer);

			if (isSomethingWillBeEatten(sourceSimulator)
					|| isSomethingWillBeEatten(destSimulator)) {
				continue;
			}

			destiny.remove(toBeTransfer);
			source.add(toBeTransfer);

			lastTransfer = toBeTransfer;
		}
	}

	public void forward() {
		source.remove(MAN);
		destiny.add(MAN);

		for (int i = 0; i < source.size(); i++) {
			if (source.get(i).equals(lastTransfer)) {
				continue;
			}

			ArrayList<String> sourceSimulator = new ArrayList<String>(source);
			ArrayList<String> destSimulator = new ArrayList<String>(destiny);
			String toBeTransfer = source.get(i);
			sourceSimulator.remove(toBeTransfer);
			destSimulator.add(toBeTransfer);

			if (isSomethingWillBeEatten(sourceSimulator)
					|| isSomethingWillBeEatten(destSimulator)) {
				continue;
			}

			source.remove(toBeTransfer);
			destiny.add(toBeTransfer);

			lastTransfer = toBeTransfer;
			break;
		}
	}

	public boolean isSomethingWillBeEatten(ArrayList<String> list) {
		boolean wolfAndSheetTogether = list.contains(WOLF)
				&& list.contains(SHEET);
		boolean sheetAndCabbageTogether = list.contains(CABBAGE)
				&& list.contains(SHEET);
		return list.size() == 2
				&& (wolfAndSheetTogether || sheetAndCabbageTogether);
	}

	public void printList(ArrayList<String> list) {
		for (String currentStr : list) {
			System.out.print(currentStr + ",");
		}
	}

	public void printStatus() {
		printList(source);
		System.out.print("------");
		printList(destiny);
		System.out.println("");
	}

}
