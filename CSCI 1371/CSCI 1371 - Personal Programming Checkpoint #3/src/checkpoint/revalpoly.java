package checkpoint;

import java.util.ArrayList;

public class revalpoly {

	public static void main(String[] args) {
		ArrayList<Integer> cList = new ArrayList<>();
		cList.add(2);
		cList.add(-3);
		cList.add(4);
		cList.add(-7);
		cList.add(10);

		System.out.println(polynomialEval(cList, 2));
	}

	static int polynomialEval(ArrayList<Integer> cList, int xVal) {
		int result = 0;

		if (cList.size() > 0) {
			result = cList.get(cList.size() - 1);
			cList.remove(cList.size() - 1);
			result += polynomialEval(cList, xVal) * xVal;
		}

		return result;
	}

}
