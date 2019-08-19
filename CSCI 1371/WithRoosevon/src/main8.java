
public class main8 {
	
	public static void main(String[] args) {
		
		double charges, rate = 7.00;
		int time = 180;
		charges = time <= 119 ? rate * 2 : time / 60.0 * rate;
		
		System.err.println(charges);
		
	}

}
