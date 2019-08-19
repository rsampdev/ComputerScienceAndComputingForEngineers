
public class Main2 {

	public static void main(String[] args) {
		int[] clist = {-3,5,4,-6,7};
		int xval = 2;
		
		System.out.println(evalPoly(clist, xval));
	}
	
	static int evalPoly(int[] clist, int xval) {
		int N = clist.length-1;
		
		int pval = clist[0];
		
		for (int idx = 0; idx < N; idx++) {
			pval = clist[idx + 1] + xval * pval;
		}
		
		return pval;
	}

}
