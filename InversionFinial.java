package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
/************
 * http://www.youtube.com/all_comments?v=J-n_nOBDLd4&page=1
 * ************/

public class InversionFinial {
 
    static long count = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = null;
        bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/IntegerArray1.txt"));
        // read the document containing 10,000 integers;
        
        int[] array10K = new int[100000];
        for (int i = 0; i < 100000; i++) {
             array10K[i] = Integer.parseInt(bf.readLine());
        }
        // assign each integer to a array.
        bf.close();
        
        mergeSort(array10K);
        System.out.println(count);

    }
 
    static int[] mergeSort(int[] Array) {
        if (Array.length == 1)
            return Array;
        int leftArrayL = (int) (Array.length / 2); // the length of left array;
        int rightArrayL = (int) (Array.length - leftArrayL); // the length of right array;

        int[] leftArray = new int[leftArrayL]; // declare leftArray;
        int[] rightArray = new int[rightArrayL]; // declare rightArray;
        for(int i=0; i< leftArrayL; i++){
        	leftArray[i] = Array[i];
        }
        for(int j=0; j< rightArrayL; j++){
        	rightArray[j] = Array[leftArrayL+j];
        }
        // Split the Array into two arrays: leftArray and rightArray;
 
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        // Recursion left and right arrays.
 
        return Array = mergInversion(leftArray, rightArray);
        // Merge left and right arrays, and count the Inversion!
        
    }

	private static int[] mergInversion(int[] ArrayL, int[] ArrayR) {
		// TODO Auto-generated method stub
		int left = ArrayL.length;
		int right = ArrayR.length;
		int arrayL = left + right;
		int[] ComArray = new int[arrayL];
		// combine two arrays into one array: ComArray;
		
        int i = 0, j = 0, k = 0;
        while (i != left && j != right) {
            if (ArrayL[i] < ArrayR[j]) {
                ComArray[k] = ArrayL[i];
                i++;
                k++;
            } else {
                ComArray[k] = ArrayR[j];
                count += left - i;
                // this is what the teacher said in his lecture.
                
                j++;
                k++;
            }
        } // When either i nor j reach limit/ one of the array reached it's end;
 
        while (i != left) {
            ComArray[k] = ArrayL[i];
            i++;
            k++;
        } //if there's any element left in the left array, send them to the back of the new array.
 
        while (j != right) {
            ComArray[k] = ArrayR[j];
            j++;
            k++;
        } // if there's any element left in the right array, send them to the back of the new array.
		return ComArray;
		
	}
}
