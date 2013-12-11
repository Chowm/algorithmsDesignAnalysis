package algorithmsDesignAnalysis;

import java.util.Scanner;

public class QuickSort0717 {
	
	public static void main(String[] args){
		
		QuickSort0717 QS = new QuickSort0717();
		

		int numOfArray = QS.inputNumOfArray();
		int[] qsArray = QS.geneArray(numOfArray);
		
		QS.printArray(qsArray);
		
		int start = 0;
		int end = qsArray.length-1;
		
		QS.QuickSort(qsArray, start, end);
		
		QS.printArray(qsArray);
	}



	private void QuickSort(int[] Array, int start, int end) {
		// TO quick sort
		if (start < end) {
			int index = split(Array, start, end);
				
		QuickSort(Array, start, index-1);
		QuickSort(Array, index+1, end);
		
		}
	}



	private int split(int[] array, int start, int end) {
		// split the array, get the index;
		int pivot = array[start];
		int index = start;
		
		for(int i=start; i<= end; i++){
			if(array[i] < pivot){
				index++;
				Swap(array, i, index);
			}
			
		}
		Swap(array, start, index);
		
		return index;
	}



	private void Swap(int[] array, int i, int j) {
		// swap two elements in an array;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}



	private void printArray(int[] Array) {
		// TO print an array
	
		for (int i=0; i<Array.length; i++){
			System.out.print(Array[i] + " ");
		}
		System.out.println();
	}



	private int[] geneArray(int num) {
		// generate num elements for an array;
		int[] Array = new int[num];
		for (int i=0; i<num; i++){
			Array[i] = (int) (Math.random()*100);
			for (int j=0; j<i; j++){
				if (Array[i] == Array[j])
					i--;
			}
		}
		return Array;
	}



	private int inputNumOfArray() {
		// input the number of elements in an array;
		System.out.println("How many elements do you want to generate for the array?");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		return num;
	}

}
