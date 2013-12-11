package algorithmsDesignAnalysis;

import java.util.Scanner;


public class QuickSorting {
	
	public static void main(String[] args){
		
		QuickSorting QS = new QuickSorting();
		
		System.out.println("How many elements do you want to creat for the array?");
		Scanner input = new Scanner(System.in);
		int NumOfList = input.nextInt();
		input.close();
		
		int[] arrayList = QS.GenerateArray(NumOfList);
		System.out.println("Below is the Array generated.");
		
		QS.PrintArray(arrayList);
		arrayList = QS.QuickSort(arrayList);
		
		
		QS.PrintArray(arrayList);;
	}

	private int[] QuickSort(int[] Array) {
		if (Array.length == 0)
			return Array;

		int index =0;
		int pivot = Array[0];
		for (int i=1; i< Array.length; i++){
			if(Array[i] < pivot){
				index++;
				Swap(Array, i, index);
			}
		} // end for loop;
		
		Swap(Array, 0, index);
		
		
		int Left = index;
		int Right = Array.length - index-1;
		
		int[] leftArray = new int[Left];
		for(int i=0; i<Left; i++){
			leftArray[i] = Array[i];
			PrintArray(leftArray);
		}
		
		int[] rightArray = new int[Right];
		for(int i=0; i<Right; i++){
			rightArray[i] = Array[index+1+i];
		}
		
		leftArray = QuickSort(leftArray);
		rightArray = QuickSort(rightArray);
		// int temp = Array[mid];
		
		// Array = CombineLeftRight(leftArray, rightArray, temp);
		// NOT necessary to combine the array again!
		// TODO Auto-generated method stub
		return Array;
	}

	private int[] CombineLeftRight(int[] Array1, int[] Array2, int midElement){
		// TODO Auto-generated method stub
		int Left = Array1.length;
		int Right = Array2.length;
		int[] Array = new int[Left + Right +1];
		for(int i=0; i< Left; i++){
			Array[i] = Array1[i];
		}
		
		Array[Left] = midElement;
		
		for(int j=Left+1; j<Array.length; j++){
			Array[j] = Array2[j-Left-1];
		}
		return Array;
	}

	private int splitArray(int[] Array) {
		int index =0;
		int pivot = Array[0];
		for (int i=1; i<Array.length; i++){
			if(Array[i] < pivot){
				index++;
				Swap(Array, i, index);
			}
			
			Swap(Array, 0, index);
		}
		// TODO Auto-generated method stub
		return index;
	}

	private void Swap(int[] Array, int i, int j) {
		// TODO Auto-generated method stub
		int temp;
		temp = Array[i];
		Array[i] = Array[j];
		Array[j] = temp;
		
	}

	private void PrintArray(int[] Array) {
		for(int i=0; i<Array.length; i++)
			System.out.print(" " + Array[i]);
		// TODO Auto-generated method stub
		
	}

	private int[] GenerateArray(int num) {
		// TODO Auto-generated method stub
		int[] Array = new int[num];
		for (int i=0; i<num; i++){
			Array[i] = (int) (Math.random()*100);
			System.out.print(" " + Array[i]);
			
			for (int j=0; j<i; j++){
				if (Array[j] == Array[i]){
					i--;
				}
			} // end of inner for loop;
		} // end out for;
		
		System.out.println();
		return Array;
	}

}
