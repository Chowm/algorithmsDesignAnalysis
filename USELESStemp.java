package algorithmsDesignAnalysis;

public class USELESStemp {
	public static void main(String[] args){
		int A[] = {6, 8, 7, 5, 3, 11, 10}; 
		
		int sum = 12;
		int[] B = new int[A.length];
		int Max =A.length; 
		
		for(int i=0; i<A.length; i++){
			B[i] = sum - A[i];
			if(B[i] > Max)
				Max = B[i];
			if(A[i] > Max)
				Max = A[i];
			
			System.out.print(" " + B[i] + "");
			
		} // O(n) here; 
		
		System.out.println("\n Max = " + Max);
		
		int[] Array = new int[Max+1];
		for(int i=0; i<B.length; i++){
			Array[B[i]] = B[i];
		} // O(n) here;
	
		for(int i=0; i<A.length; i++){	
	    if (Array[A[i]] >= 0)
	        System.out.println("We got one: " + A[i] +" and " + (sum-A[i]));
		} // O(n) here;
		
	} // end main();

	/******
	Running time: 3*O(n)
	*******/
}