import java.util.ArrayList;

public class recursive_binom_class {

	public static void main(String[] args) {
		int nthLevel = 8;

		ArrayList<Integer> list = recursive_binom(nthLevel);

		int catchUp = 1;
		int mark = 1;
		int i = 0;

		while (i != list.size()) {
			System.out.print(list.get(i) + ", ");

			if (catchUp == mark) {
				System.out.println();
				catchUp = 0;
				mark++;
			}

			i++;
			catchUp++;
		}

		System.out.println("\nList Size: " + list.size());
	}

	static ArrayList<Integer> recursive_binom(int nthLevel) {
		ArrayList<Integer> binomVector = new ArrayList<>();

		if (nthLevel < 0) {

			System.err.println("ERROR");

		} else if (nthLevel == 0) {
			binomVector.add(1);
		} else {
			if (nthLevel < 3) {
				binomVector.add(1);

				if (nthLevel == 2) {
					binomVector.add(1);
					binomVector.add(1);
				}

				return binomVector;
			} else {
				ArrayList<Integer> previousLine = recursive_binom(nthLevel - 1);
				binomVector.addAll(previousLine);
				binomVector.add(1);

				for (int i = 0; i < nthLevel - 2; i++) {
					int first = binomVector.get((binomVector.size() - 1) - nthLevel + 1);
					int second = binomVector.get((binomVector.size() - 1) - nthLevel + 2);
					binomVector.add(first + second);
				}

				binomVector.add(1);
			}
		}

		return binomVector;
	}

}
