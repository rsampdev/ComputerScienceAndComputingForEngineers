package checkpoint;

public class ShiftyEyes {

	public static void main(String[] args) {
		System.out.println(shiftyEyes(8));
		System.out.println(shiftyEyes(19.78));
		System.out.println(shiftyEyes(25.9));
	}

	static int shiftyEyes(double hour) {
		int shift = -1;

		if (0 <= hour && hour < 8) {
			shift = 3;
		} else if (8 <= hour && hour < 16) {
			shift = 1;
		} else if (16 <= hour && hour < 24) {
			shift = 2;
		}
		
		return shift;
	}

}
