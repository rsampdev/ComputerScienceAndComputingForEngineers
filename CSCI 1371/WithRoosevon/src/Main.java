
public class Main {

	public static void main(String[] args) {
		int[] list1 = {1,2,3,4,5,6,7};
		int[] list2 = {-2,3,0,9,4,-5};
		int[] list3 = {-8,-1,0,2};
		int[] list4 = {2,4,6,8,10};
		
		System.out.println(oddsAreFor(list1));
		System.out.println(oddsAreFor(list2));
		System.out.println(oddsAreFor(list3));
		System.out.println(oddsAreFor(list4));
		
		System.out.println(oddsAreWhile(list1));
		System.out.println(oddsAreWhile(list2));
		System.out.println(oddsAreWhile(list3));
		System.out.println(oddsAreWhile(list4));
	}
	
	static int oddsAreFor(int[] list) {	
		int N = list.length;
		int oddProduct = 1;
		
		for (int idx = 0; idx < N; idx++) {
			if(list[idx] > 0) {
				if ((list[idx] % 2) == 1) {
					oddProduct *= list[idx];
				}
			}
		}
		
		return oddProduct;
	}
	
	static int oddsAreWhile(int[] list) {	
		int N = list.length;	
		int oddProduct = 1;
		
		int idx = 0;
		
		while (idx < N) {
			if(list[idx] > 0 && (list[idx] % 2) == 1) {
				oddProduct *= list[idx];	
			}
			
			idx++;
		}
		
		return oddProduct;
	}
	

}
