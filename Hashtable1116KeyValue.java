package algorithmsDesignAnalysis;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Hashtable1116KeyValue {

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	
    	 BufferedReader bf = null;
         try {
             bf = new BufferedReader(new FileReader("C:/Users/Yan/workspace/princeton Algorithm/prob2sum.txt"));
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
         /******
          * Upper section will read the prob2sum.txt document into the program
          * And put each number in the txt document into an array;
          */
         
         int min = -10000;
         int max = 10000;
         /*****
          * the range of sum, between -10000 and +10000;
          */
         int count= calculate(array, min, max);
 
       
         System.out.println("The number of valid sums is " +count);
    }

    /**
     * Ideally to solve this problem, we will create a hashtable 
     * that keep as Key the array[i] and the value
     * the difference between the array[i] and the sum.
     * If we can find the value of sum-key in the hashtable, we got one pair!
     */
    
    static int calculate(long[] array, int min, int max) {
        Hashtable<Long, Integer> table = new Hashtable<Long, Integer>();
     /***
      * build a hashtable, then put every element in the array to the table
      * BUT, I am not familar with the data structure of the table
      * So, this is really a bad table I built, ==!
      * A lot of extra work need to be done later.
      */
        
        System.out.println("Building Hashing table!");
        for(int i=0; i<array.length; i++){
        	long key = -array[i]/10000;
        	int value = (int) (-array[i]%10000);
        	if(!table.containsKey(key)){
        		table.put(key, value);
        	} 
        } //end inner for;

        System.out.println("Hashing table ready, searching------");
        int[] sums = new int[20001];
        
			for(int i=0; i<array.length; i++){
			long key = array[i]/10000;
			int value = (int) (array[i]%10000);

			if(table.containsKey(key)){
					int diff = value - table.get(key)+ 10000;
				//	System.out.println("key= " +key+ "  sum= " + (diff-10000));
					sums[diff] = 1;
					//break;
 
				} // end if;
			} // end for i loop;
			
			int sum = 0;
			for(int i=0; i<20001; i++){
				sum += sums[i];
			}
			System.out.println("Sums at the end: " + sum);
        return sum;
    }
    
}

