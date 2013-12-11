package algorithmsDesignAnalysis;

import java.util.Scanner;

public class SplitSortingQuick {

	public static void main(String[] args){
		SplitSortingQuick BCA = new SplitSortingQuick();
		
		System.out.print("How many elements do you want in the array? \n");
		Scanner input = new Scanner(System.in);
		int NumOfList = input.nextInt();
		// input how many numbers in the array.
		input.close();
		
		int[] arrayList = BCA.Generate(NumOfList);
		System.out.println("\n Print the original Array.");
		BCA.PrintArray(arrayList);
		// generate the array.
		
		int start=0;
		int end= arrayList.length-1;
		BCA.SplitArray(arrayList, start, end);
		
		System.out.println("After arrangement:");
		BCA.PrintArray(arrayList);
		
	}

	private void SplitArray(int[] Array, int start, int end) {
	 	if (start >= end)
	 		return;
		
		// TODO Auto-generated method stub
		int index =start;
		int pivot = Array[start];
		for (int i=1; i<=Array.length; i++){
			if (Array[i] < pivot){
				index++;
				Swap(Array, i, index);
			}
		}
		
		Swap(Array, start, index);
		
		System.out.println("The new index of Array[0] is Array[" + index + "];  // The new Array["+index+"]= "+ Array[index]);
		
		
		
		SplitArray(Array, start, index-1);
					
		SplitArray(Array, index+1, end);
		
	
		
		// return Array;
	}

	private void Swap(int[] Array, int i, int j) {
		// TODO Auto-generated method stub
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

