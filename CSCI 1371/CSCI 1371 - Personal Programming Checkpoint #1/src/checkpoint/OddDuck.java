package checkpoint;

public class OddDuck {

	public static void main(String[] args) {		
		int[] vec1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		int[] vec2 = new int[] {-2,3,0,9,4,-5};
		int[] vec3 = new int[] {-8,-1,0,2};
		int[] vec4 = new int[] {2,4,6,8,10};

		System.out.println(oddDuck(vec1));
		System.out.println(oddDuck(vec2));
		System.out.println(oddDuck(vec3));
		System.out.println(oddDuck(vec4));
	}
	
	static int oddDuck(int[] vector) {
		int oddProduct = 1;
		
		for (int number : vector) {
			if ((number >= 1) && (number % 2 == 1)) {
				oddProduct *= number;
			}
		}
		
		return oddProduct;
	}

}
