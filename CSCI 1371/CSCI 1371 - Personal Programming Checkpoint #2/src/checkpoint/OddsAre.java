package checkpoint;

public class OddsAre {

	public static void main(String[] args) {
		int[] vec1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		int[] vec2 = new int[] {-2,3,0,9,4,-5};
		int[] vec3 = new int[] {-8,-1,0,2};
		int[] vec4 = new int[] {2,4,6,8,10};
		
		System.out.println(oddsAreFor(vec1));
		System.out.println(oddsAreFor(vec2));
		System.out.println(oddsAreFor(vec3));
		System.out.println(oddsAreFor(vec4));
		
		System.out.println(oddsAreWhile(vec1));
		System.out.println(oddsAreWhile(vec2));
		System.out.println(oddsAreWhile(vec3));
		System.out.println(oddsAreWhile(vec4));
	}

	static int oddsAreFor(int[] vector) {
		int oddProduct = 1;
		
		for (int index = 0; index < vector.length; index++) {
			int number = vector[index];
			
			if ((number >= 1) && (number % 2 == 1)) {
				oddProduct *= number;
			}
		}
		
		return oddProduct;
	}
	
	static int oddsAreWhile(int[] vector) {
		int oddProduct = 1;
		int index = 0;
		
		while (index < vector.length) {
			int number = vector[index];
			
			if ((number >= 1) && (number % 2 == 1)) {
				oddProduct *= number;
			}
			
			index++;
		}
		
		return oddProduct;
	}
	
}
