package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class TwoSumHashSet {

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
         
         int min = -10000;
         int max = 10000;
         int count= calculate(array, min, max);
 
       
         System.out.println("The number of valid sums is " +count);
    }

    /**
     * Ideally to solve this problem, we will create a hashtable 
     * that keep as Key the array[i] and the value
     * the difference between the array[i] and the sum.
     */
    
    static int calculate(long[] array, int min, int max) {
        int result =0;
        HashSet<Long> HSet = new HashSet<Long>();
        
		for(int i=0; i<1000000; i++){
		//	System.out.println("i= " + i);
			HSet.add(array[i]);
		}
		
	for(long sum=min; sum<=max; sum++){
			
        for(int i=0; i<1000000; i++){	
			//long key = array[i];
			long diff = sum-array[i];
        	
			if(HSet.contains(diff) ){
				System.out.println("Sum= " + sum+ "; Array["+i+"]=  " + array[i]+ "; diff = "+ diff);
				result+= 1;
				break; 
				}
			}
        } //end inner for;
      
        return result;
    }
    
}

