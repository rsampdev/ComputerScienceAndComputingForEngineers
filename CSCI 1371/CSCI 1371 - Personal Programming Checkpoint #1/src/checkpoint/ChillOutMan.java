package checkpoint;

public class ChillOutMan {

	public static void main(String[] args) {
		System.out.println(chillOutMan(30, 10));
		System.out.println(chillOutMan(5, 10));
		System.out.println(chillOutMan(40, 10));
		System.out.println(chillOutMan(30, 5));
		System.out.println(chillOutMan(30, 20));
		System.out.println(chillOutMan(35, 15));
	}
	
	static double chillOutMan(int temp, int speed) {
		double chillFactor = 35.7 + (0.6 * temp) + (0.43 * temp - 35.7) * Math.pow(speed, 0.16);
		return chillFactor;
	}

}
