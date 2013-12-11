package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TwoSum1115 {

    public static void main(String[] args) throws IOException {
    	
    	 BufferedReader bf = null;
         try {
             bf = new BufferedReader(new FileReader("C:/Users/Yan/workspace/princeton Algorithm/prob2sum.txt"));
           //  C:\Users\Yan\workspace\princeton Algorithm\prob2sum.txt
         } catch (FileNotFoundException e) {
             System.out.println("No such file!");
             e.printStackTrace();
             return;
         }
    	
         long[] array = new long[1000000];
         for (int i = 0; i < 1000000; i++) {
             try {
                 array[i] = Long.parseLong(bf.readLine());
             } catch (NumberFormatException e) {
                 e.printStackTrace();
                 bf.close();
                 return;
             } catch (IOException e) {
                 e.printStackTrace();
                 bf.close();
                 return;
             }
         }
         bf.close();

         Arrays.sort(array);
         System.out.println("ArrayMax= " + array[999999] +" \narrayMin= " +array[0]);
         System.out.println("new index is: " + ((int)Math.sqrt(array[999999]) + 999999 + array[999999]%1000*100) );
         
         int sumH = 10000;
         int sumL = -10000; // the value of sum should between [-10000, +10000];
    	 int count = calculate2sum(array, sumL, sumH);
 
         System.out.println("The number of valid sums is " +count);
    }


	private static int calculate2sum(long[] array, int sumL, int sumH) {
		// TODO Auto-generated method stub
    	int match = 0;
    	int Len = array.length;
    	int sum = sumH-sumL;
    	int[] sums = new int[sum];
    	for(int i=0; i<sum; i++){
    		sums[i] = 0;
    	}
    	
       	long[] newArray = new long[Len];
    	for(int i=0; i<Len; i++){
    		newArray[i] = -array[i];
    	}
    	System.out.println("the new array is ready.");
    	
    	/**********************************************
    	 * use sum-array[i] to generate a new array;
    	 * break the newArray[i] into two parts; 
    	 * the back part array[i]/10000000 will be the index of new array.
    	 * the front part array[i]%10000000 will be assigned as a new value to the new array.index. 
    	 */
    	for(int i=0; i<Len; i++){
    		for(int k=0; k<Len; k++){
    			if(array[i] >= newArray[k]-10000 && array[i]<= newArray[k]+10000){
    				 System.out.println("array[" + i +"]= " + array[i] + " matches. Now 2sum=" + (array[i] - newArray[k]));
    				
    				/***************
    				 *  use (array[i] - newArray[k] +9999) as the index of sums[];
    				 *  if we got array[i] - newArray[k] = -10000, which is the lower bound, then sums[0]=1;
    				 */
    				sums[ (int) (array[i] - newArray[k]) +10000 ] = 1; 
    			} // end if;
    		} // enf for k loop

    	} // end for i loop;
    	
    	
    	for(int i=0; i<20000; i++){
    		match += sums[i];
    	}
		return match;
	}
}

