package algorithmsDesignAnalysis;

import java.util.Scanner;

public class BreakCombineArray {

	public static void main(String[] args){
		BreakCombineArray BCA = new BreakCombineArray();
		
		System.out.print("How many elements do you want in the array? \n");
		Scanner input = new Scanner(System.in);
		int NumOfList = input.nextInt();
		
		input.close();
		
		int[] arrayList = BCA.Generate(NumOfList);
		System.out.println("\n Print the original Array.");
		BCA.PrintArray(arrayList);
		
		arrayList = BCA.SplitArray(arrayList);
		
		System.out.println("After arrangement:");
		BCA.PrintArray(arrayList);
		
	}

	private int[] SplitArray(int[] Array) {
	 	if (Array.length <= 1) 
	 		return Array;
	 // the Base Case. when sub-array has only 1 element, return.
	 	
		int index =0;
		int pivot = Array[0];
		// take Array[0] as the pivot;
		
		for (int i=1; i<Array.length; i++){
			if (Array[i] < pivot){
				index++;
				Swap(Array, i, index);
			}
		}
		Swap(Array, 0, index);
		
		System.out.println("The new index of Array[0] is old Array[" + index + "];  // The new Array["+index+"]= "+ Array[index]);
		
		
		// creat leftArray
		int left=index+1;
		int[] leftArray = new int[left];
		
		for(int i=0; i<left; i++){
			leftArray[i] = Array[i];
		}
		
		System.out.print("The leftArray is:   ");
		PrintArray(leftArray);
		
		// System.out.print("The mid element is:  " +Array[index]);
		
		// creat rightArray
		int Right = Array.length-left;  // something wrong here; ==!
			
		int[] rightArray = new int[Right];
		for(int i=0; i< Right; i++){
			rightArray[i] = Array[left +i];
		}
		
		System.out.print("The rightArray is:  ");
		PrintArray(rightArray);
			
		System.out.println("The whole array is: ");
		PrintArray(Array);
		
		
		
		leftArray = SplitArray(leftArray);
		rightArray = SplitArray(rightArray);
		
		Array = comBine(leftArray, rightArray);
		// if I do not combine the two arrays, the original array would be the one after first sorting.
		// any further step will not be recursed back to the original array.
		
		return Array;
		
	}

	private int[] comBine(int[] Array1, int[] Array2) {
		// TODO Auto-generated method stub
		int left = Array1.length;
		int right = Array2.length;
		int comLength= left + right;
		int[] comArray = new int[comLength];
		for(int i=0; i<left; i++){
			comArray[i] = Array1[i];
		}
		for(int j=left; j< comLength; j++){
			comArray[j] = Array2[j-left];
		}
		return comArray;
	}

	private void Swap(int[] Array, int i, int j) {
		// Swap two elements in a array.
		int temp;
		temp = Array[i];
		Array[i] = Array[j];
		Array[j] = temp;
		
	}

	private void PrintArray(int[] Array) {
		// Print each element in the array list.
		for (int i=0; i<Array.length; i++)
			System.out.print(" "+ Array[i]);
		System.out.println();
		
	}

	private int[] Generate(int num) {
		// this method will generate an array with num elements;
		int[] Array = new int[num];
		for (int i=0; i<num; i++){
			Array[i] = (int) (Math.random()*100);
			System.out.print(" " + Array[i]);
			for (int j=0; j<i; j++){
				if (Array[i] == Array[j])
					i--;
			}
		}
		return Array;
	}
}
