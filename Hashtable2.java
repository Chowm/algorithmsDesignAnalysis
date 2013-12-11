package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Hashtable2 {

    public static void main(String[] args) throws IOException {
    	
    	 BufferedReader bf = null;
         try {
             bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/cpp/prob2sum.txt"));
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
         
         int count=0;
         for( long sum =-10000; sum<10001; sum++){
        	 int key= calculate(array, sum);
        	 count+=key; 
         }
       
         System.out.println("The number of valid sums is " +count);
    }

    /**
     * Ideally to solve this problem, we will create a hashtable 
     * that keep as Key the array[i] and the value
     * the difference between the array[i] and the sum.
     */
    
    static int calculate(long[] array, long sum) {
        int result =0;
        Hashtable<Long, Long> table = new Hashtable<Long, Long>();
      
        for(int i=0; i<array.length; i++){
        	long diff = sum - array[i];
        	long key = array[i];
        	
        	if(!table.containsKey(key) && (key!=diff)){
        		table.put(key, diff);
        		
        		if(table.containsKey(diff)){
        			System.out.println("Sum= " + sum +" key  " +key+ "  diff " + diff);
        			result =1;
        			break; 
        		}
        	}
        }

        return result;
    }
    
}
