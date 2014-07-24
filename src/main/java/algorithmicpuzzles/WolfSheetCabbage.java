package algorithmicpuzzles;

import java.util.ArrayList;

/**
 * 本算法解决的问题为狼羊菜过河
 * 一个人在河边，带着一匹狼、一只羊和一颗卷心菜。他需要用船将这三样东西运至对岸，然而，这艘船的空间有限，只容得下他自己和另一样东西（或狼或
 * 羊或卷心菜）。若他不在场看管的话，狼就会去吃羊，羊就会去吃卷心菜。此人如何才能把这三个“乘客”都送至对岸？
 */
public class WolfSheetCabbage {

	private final static String WOLF = "wolf";
	private final static String SHEET = "sheet";
	private final static String CABBAGE = "cabbage";
	private final static String MAN = "man";

	private static String lastTransfer = "";
	private static ArrayList<String> source = new ArrayList<String>(4);
	private static ArrayList<String> destination = new ArrayList<String>(4);

    static{
        source.add(MAN);
        source.add(WOLF);
        source.add(SHEET);
        source.add(CABBAGE);
    }

	public static void transfer() {
		do {
			forward();
			printStatus();
			if (destination.size() < 4) {
				backward();
				printStatus();
			}
		} while (destination.size() < 4);
	}

	private static void backward() {
		destination.remove(MAN);
		source.add(MAN);

		if (!isSomethingWillBeEaten(destination)) {
			return;
		}
		for (int i = 0; i < destination.size(); i++) {
			if (destination.get(i).equals(lastTransfer)) {
				continue;
			}

			ArrayList<String> sourceSimulator = new ArrayList<String>(source);
			ArrayList<String> destinationSimulator = new ArrayList<String>(destination);
			String toBeTransfer = destination.get(i);
			destinationSimulator.remove(toBeTransfer);
			sourceSimulator.add(toBeTransfer);

			if (isSomethingWillBeEaten(sourceSimulator)
					|| isSomethingWillBeEaten(destinationSimulator)) {
				continue;
			}

			destination.remove(toBeTransfer);
			source.add(toBeTransfer);

			lastTransfer = toBeTransfer;
		}
	}

	private static void forward() {
		source.remove(MAN);
		destination.add(MAN);

		for (int i = 0; i < source.size(); i++) {
			if (source.get(i).equals(lastTransfer)) {
				continue;
			}

			ArrayList<String> sourceSimulator = new ArrayList<String>(source);
			ArrayList<String> destinationSimulator = new ArrayList<String>(destination);
			String toBeTransfer = source.get(i);
			sourceSimulator.remove(toBeTransfer);
			destinationSimulator.add(toBeTransfer);

			if (isSomethingWillBeEaten(sourceSimulator)
					|| isSomethingWillBeEaten(destinationSimulator)) {
				continue;
			}

			source.remove(toBeTransfer);
			destination.add(toBeTransfer);

			lastTransfer = toBeTransfer;
			break;
		}
	}

	private static boolean isSomethingWillBeEaten(ArrayList<String> list) {
		boolean wolfAndSheetTogether = list.contains(WOLF)
				&& list.contains(SHEET);
		boolean sheetAndCabbageTogether = list.contains(CABBAGE)
				&& list.contains(SHEET);
		return list.size() == 2
				&& (wolfAndSheetTogether || sheetAndCabbageTogether);
	}

	private static void printList(ArrayList<String> list) {
		for (String currentStr : list) {
			System.out.print(currentStr + ",");
		}
	}

	private static void printStatus() {
		printList(source);
		System.out.print("------");
		printList(destination);
		System.out.println("");
	}

}
