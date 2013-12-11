package algorithmsDesignAnalysis;

/**************
 * There's a txt file on desktop, IntegerArry.txt.
 * This file contains 402 of the 100,000 integers between 1 and 100 (inclusive) 
 * in some order, with no integer repeated. This program is to compute the number of inversions
 * in the file given, where the ith row of the file indicates the ith entry of an array.
 * Due to the size of the numlist[], have to implement the fast divide-and-conquer algorithm
 * Use BufferedReader to read all the integers in the numList, assign them to an array array[402]; 
 * use Integer.parseInt() to transfer all chars into integers.
 * 
 * ***************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 
public class Inversion2 {
 
    static long count = 0;
 
    public static void main(String[] args) throws IOException {
    	
    	Inversion2 InMeSort = new Inversion2(); 
    	// InMeSort = Inversion by merge sorting;
    	
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/IntegerArray1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("No such file!");
            e.printStackTrace();
            return;
        }
       // bf.close();
 
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            try {
                array[i] = Integer.parseInt(bf.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                bf.close();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                bf.close();
                return;
            }
        } //end for loop.
 
       InMeSort.getInversion(array);
          // this is the main method to calculate the inversions;
        
        System.out.println(count);
 
        try {
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }  // end main() class
 
    private void getInversion(int[] array) {
        if (array.length == 1)
            return;
        	// base case!
        
        int left = array.length / 2;
        int right = array.length - left;
        int[] leftArray = Arrays.copyOfRange(array, 0, left);
        int[] rightArray = Arrays.copyOfRange(array, left, left + right);
        	// break the original to two parts.
 
         getInversion(leftArray);
        	// Recursion the left part of the array.
        getInversion(rightArray);
        	// Recursion the right part of the array.
        MergeLeftRight(leftArray, rightArray);
        


         // end while
         // combine leftarray and rightarray together, lower sorting  to higher sorting from left.
         // everytime, right number is bigger than the left, swap them
         // then count++, that's the key algorith of this program.
		return ;
        
         //  System.out.println(" i= " +i +" Left="+left+" j=" +j+ " right="+ right + "  k=" + k +"  Array[" +(k-1)+ "]=" + array[k-1] +"  count=" + count);
       
         /* 
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
      */  
       
    } // end getInversion(int[] array) method.

	private void MergeLeftRight(int[] leftArray, int[] rightArray) {
		// TODO Auto-generated method stub
		

        int i = 0, j = 0, k=0, Length = leftArray.length+rightArray.length;
        int[] newArray = new int[Length];
        
        for ( k=0; k < Length; k++) {
       	 
            if(i== leftArray.length) {
            	newArray[k] = rightArray[j];
            //	count +=left -i;
            	j++;
            }
            else if (j== rightArray.length) {
            	newArray[k] = leftArray[i];
            	i++;
            }
       	 
           if (leftArray[i] < rightArray[j]) {
               newArray[k] = leftArray[i];
               i++;
             // k++;  
           } else {
               newArray[k] = rightArray[j];
               count += leftArray.length - i;
               // The core algorithm, the split inversions involving an element rightarray[j] of the Right array are precisely
               // the numbers left in the 1st array, when rightarray[j] is copied to the output array.
               
               j++;
               
               //     k++;
               //      System.out.print(" array[k]= " +array[k]);
           }
        }
	}
}