package checkpoint;

public class SkipToMyLoop {

	public static void main(String[] args) {
		System.out.println(skipToMyLoop(7, 1));
		System.out.println(skipToMyLoop(23, 3));
		System.out.println(skipToMyLoop(193, 37));
		System.out.println(skipToMyLoop(9.2, 3));
		System.out.println(skipToMyLoop(-9.2, 3));
		System.out.println(skipToMyLoop(-8, 3));
	}

	static long skipToMyLoop(double nVal, double kVal) {
		long skipFactorial = 1;

		if ((nVal != (int) nVal) || (kVal != (int) kVal)) {
			return -1;
		} else if ((nVal <= 0) || (kVal <= 0)) {
			return -2;
		}

		for (int factor = (int) nVal; factor > 0; factor -= kVal) {
			skipFactorial *= factor;

		}

		return skipFactorial;
	}

}
