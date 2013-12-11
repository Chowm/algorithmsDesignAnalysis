package algorithmsDesignAnalysis;
import java.util.Scanner;


public class MergeSorting {
	
	public static void main(String[] args){
		MergeSorting MS = new MergeSorting();
		
		System.out.println("How many integers do you want in the array?");
		Scanner input = new Scanner(System.in);
		int NofList = input.nextInt();
		
		int [] arrayList = MS.GenerateArray(NofList);
		
		System.out.println("Below is the original array, without duplicate.");
		MS.PrintArray(arrayList);
		
		MS.MergeSort(arrayList);
		
		// MS.PrintArray(AfterSortedArray);
		input.close();
	}

	private void MergeSort(int[] array) {
		// TODO Auto-generated method stub
		int length = array.length;
		if (length==1)
			return;
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
		
		MergeSort(leftArray);
		MergeSort(rightArray);
		
		int i=0, j=0, k=0;
		while (i!= leftArray.length && j!= rightArray.length){
			if (leftArray[i] < rightArray[j]){
				array[k] = leftArray[i];
				k++;
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
				k++;
			}
		}
		
		while (i != leftArray.length){
			array[k] = leftArray[i];
			i++;
			k++;
		}
		
		while (j != rightArray.length){
			array[k] = rightArray[j];
			j++;
			k++;
		}
		
		//newArray = MergeLeftRight(leftArray, rightArray);
		
		// recursion both left and right arrays.
		// merging the left and right arrays into one array, in lower sort patten. 
		
		
		System.out.println("\n below is the array after merge sorting: ");
		PrintArray(array);
		// return newArray;
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
