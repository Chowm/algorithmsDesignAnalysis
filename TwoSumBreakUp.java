package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TwoSumBreakUp {

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
         
         long arrayMax = 0;
         long arrayMin = 0;
         for(int i=0; i<1000000; i++){
        	 if (array[i] > arrayMax)
        		 arrayMax = array[i];
        	 if (array[i] < arrayMin)
        		 arrayMin = array[i];
         }
         System.out.println("ArrayMax= " + arrayMax +" \narrayMin= " +arrayMin);
         
         
         int min = -10000;
         int max = 10000;
         int count = 0;
         
         for(int sum= min; sum<max; sum++){
        	 count += calculate2sum(array, sum, arrayMax, arrayMin);
        	 if(sum%200 == 0)
        		 System.out.println("Sum= " + sum + ". Count= " + count);
         }
  
         System.out.println("The number of valid sums is " +count);
    }


	private static int calculate2sum(long[] array, int sum, long arrayMax, long arrayMin) {
		// TODO Auto-generated method stub
    	int match = 0;
    	long Min = Math.min(arrayMin, sum-arrayMax);
    	
    	int Len = array.length;
       	int[] newArray = new int[10000000];
    	for(int i=0; i<10000000; i++){
    		newArray[i] = -1;
    	}
    	
    	/**********************************************
    	 * use sum-array[i] to generate a new array;
    	 * break the newArray[i] into two parts; 
    	 * the back part array[i]/10000000 will be the index of new array.
    	 * the front part array[i]%10000000 will be assigned as a new value to the new array.index. 
    	 */
    	for(int i=0; i<Len; i++){
    		long temp = sum - array[i] - Min;
    		int index =  (int) (temp%10000000);
    		int value =  (int) (temp/10000000);
    		newArray[index] = value;
    	} // end for loop;
    	
    	for(int i=0; i<Len; i++){
    		int index = (int) ((array[i] -Min) % 10000000); 
    		int value =  (int) ((array[i] -Min) / 10000000);

    		if(newArray[index] == value){
    			match = 1;
    			i=Len;
    		} // end if.
    	} // enf for loop;
		return match;
	}

    
}

