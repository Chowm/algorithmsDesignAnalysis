package algorithmsDesignAnalysis;
/**************
 * There's a txt file on desktop, IntegerArry.txt.
 * This file contains 402 of the 100,000 integers between 1 and 20 (inclusive) 
 * in some order, with no integer repeated. This program is to compute the number of inversions
 * in the file given, where the ith row of the file indicates the ith entry of an array.
 * Due to the size of the numlist[], have to implement the fast divide-and-conquer algorithm
 * Use BufferedReader to read all the integers in the numList, assign them to an array array[402]; 
 * use Integer.parseInt() to transfer all chars into integers.
 * 
 * ***************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 
public class Inversion03 {
 
    static long count = 0;
 
    public static void main(String[] args) throws IOException{
        BufferedReader bf = null;
        bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/IntegerArray.txt"));

        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            
                array[i] = Integer.parseInt(bf.readLine());
        } //end for loop.
 
        getInversion(array);
          // this is the main method to calculate the inversions;
        System.out.println(count);
             bf.close();
             
    }  // end main() class
 
    static void getInversion(int[] array) {
        if (array.length == 1)
            return;
        	// base case!
        
        int left = array.length / 2;
        int right = array.length - left;
        int[] leftarray = Arrays.copyOfRange(array, 0, left);
        int[] rightarray = Arrays.copyOfRange(array, left, left + right);
        	// break the original to two parts.
        
        PrintArray(array);
        getInversion(leftarray);
        	// Recursion the left part of the array.
        getInversion(rightarray);
        	// Recursion the right part of the array.
        mergeInversion(leftarray, rightarray);
        
        PrintArray(array);
        System.out.println(" count=" +count);
    } // end getInversion(int[] array) method.

	private static void PrintArray(int[] Array) {
		// TODO Auto-generated method stub
		for(int i=0; i<Array.length; i++){
			System.out.print(" " + Array[i]);
		}
		
		System.out.println();
		
	}

	private static void mergeInversion(int[] leftarray, int[] rightarray) {
		// TODO Auto-generated method stub
		int left = leftarray.length;
		int right = rightarray.length;
		int newarrayL= left+right;
		int[] array = new int[newarrayL];
		
		int i = 0, j = 0, k=0;

	      while (i != left && j != right) {
	       
	            if (leftarray[i] < rightarray[j]) {
	                array[k] = leftarray[i];
	                i++;
	                k++;  
	            } else {
	                array[k] = rightarray[j];
	                count += left - i;
	                // The core algorithm, the split inversions involving an element rightarray[j] of the Right array are precisely
	                // the numbers left in the 1st array, when rightarray[j] is copied to the output array.
	                
	                j++;
	           //     k++;
	          //      System.out.print(" array[k]= " +array[k]);
	            }

	        } // end while
	        // combine leftarray and rightarray together, lower sorting  to higher sorting from left.
	        // everytime, if right number is bigger than the left, swap them
	        // then count++, that's the key algorith of this program.
	        
	      //  System.out.println(" i= " +i +" Left="+left+" j=" +j+ " right="+ right + "  k=" + k +"  Array[" +(k-1)+ "]=" + array[k-1] +"  count=" + count);
	       
	      
	        while (i != left) {
	            array[k] = leftarray[i];
	            i++;
	            k++;
	        }
	      
	     //   System.out.println("i= " +i+ " left= "+ left + " j= " +j+ " right="+ right + "  k=" +k);
	      
	        
	        while (j != right) {
	            array[k] = rightarray[j];
	            j++;
	            k++;
	        }
		
	}
}
