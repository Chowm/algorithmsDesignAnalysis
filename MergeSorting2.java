package algorithmsDesignAnalysis;
import java.util.Scanner;


public class MergeSorting2 {
	
	public static void main(String[] args){
		MergeSorting2 MS = new MergeSorting2();
		
		System.out.println("How many integers do you want in the array?");
		Scanner input = new Scanner(System.in);
		int NofList = input.nextInt();
		
		int [] arrayList = MS.GenerateArray(NofList);
		
		System.out.println("Below is the original array, without duplicate.");
		MS.PrintArray(arrayList);
		
		arrayList = MS.MergeSort(arrayList);
		
		System.out.println("\n Below is the array after merge sorting.");
		MS.PrintArray(arrayList);
		input.close();
	}

	private int[] MergeSort(int[] array) {
		// TODO Auto-generated method stub
		int length = array.length;
		if (length==1)
			return array;
		// this is the base case;
		
		int left = (int)(length/2);
		int right = length-left;
		
		int[] leftArray = new int[left];
		int[] rightArray = new int[right];
		
		for (int i=0; i<left; i++){
			leftArray[i] = array[i];
		}
		for (int j=0; j<right; j++){
			rightArray[j] = array[left+j];
		}
		// this section split the original array into two arrays: left and right;
		
		leftArray = MergeSort(leftArray);
		rightArray = MergeSort(rightArray);
		array = MergeLeftRight(leftArray, rightArray);

		// recursion both left and right arrays.
		// merging the left and right arrays into one array, in lower sort pattern. 
		
		
		System.out.println("\n see the array piece after merge sorting: ");
		PrintArray(array);
		// return newArray;
		return array;
	}

	private int[] MergeLeftRight(int[] leftArray, int[] rightArray) {
		
		int length = rightArray.length + leftArray.length;
		int[] mergArray = new int[length];
		
		int i=0, j=0, k=0;
		while (i!= leftArray.length && j!= rightArray.length){
			if (leftArray[i] < rightArray[j]){
				mergArray[k] = leftArray[i];
				k++;
				i++;
			} else {
				mergArray[k] = rightArray[j];
				j++;
				k++;
			}
		}
		
		while (i != leftArray.length){
			mergArray[k] = leftArray[i];
			i++;
			k++;
		}
		
		while (j != rightArray.length){
			mergArray[k] = rightArray[j];
			j++;
			k++;
		}

		return mergArray;
	}

	private void PrintArray(int[] Array) {
		// this method will print all the elements in a array;
		for(int i=0; i<Array.length; i++){
			System.out.print(" " + Array[i]);
		}
		
		System.out.println();
	}

	private int[] GenerateArray(int m) {
		// this method will generate a array with m integers bwtween 0 and 100;
		int[] GeneArray = new int[m];
		
		for (int i=0; i<m; i++) {
			GeneArray[i] = (int) (Math.random()*100);
			System.out.print(" "+ GeneArray[i]);
			
			for (int j=0; j<i; j++){
				if (GeneArray[i] == GeneArray[j])
				i--;
			}	// end for, this for loop make sure no duplicate integer generated.
		}
		System.out.println();
		
		return GeneArray;
	} // end of GenerateArray method;

}
