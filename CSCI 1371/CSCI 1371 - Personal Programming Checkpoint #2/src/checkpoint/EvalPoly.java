package checkpoint;

public class EvalPoly {

	public static void main(String[] args) {
		int[] clist = { -3, 5, 4, -6, 7 };
		int[] xVals = { 1, 2, 3, 4, 5 };
		int[] pVals = evalPoly(clist, xVals);

		for (int number : pVals) {
			System.out.println(number);
		}
	}

	static int[] evalPoly(int[] cList, int[] xVals) {
		int[] pVals = new int[xVals.length];

		for (int i = 0; i < xVals.length; i++) {
			int xVal = xVals[i];
			int result = cList[0];

			for (int index = 0; index < cList.length - 1; index++) {
				result = xVal * result + cList[index + 1];
			}

			pVals[i] = result;
		}

		return pVals;
	}

}
