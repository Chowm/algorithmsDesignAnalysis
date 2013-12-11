package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Hashtable1118ArrayList {

	public static void main(String[] args) throws IOException {
		/**********************************************************
	     * Ideally to solve this 2-sum problem, we will create a hashtable 
	     * that keep as Key= -array[i]/10000 and the value= -array[i]%10000
	     * If we can find the value of sum-key in the hashtable, we got one pair!
	     */
		
    	Stopwatch stopwatch = new Stopwatch(); // this is a method to monitor the time used.
    	
    	// use BufferedReader to readin 1M long integers into an array.
    	BufferedReader bf = null;
        try {
             bf = new BufferedReader(new FileReader("prob2sum.txt"));
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
        
        // after reading and building array, remember to close the BufferedReader.
        bf.close();
         
        double timeRead = stopwatch.elapsedTime();
        System.out.println("After reading, the time used is: " + timeRead +"s. ");


        /***********************************
         * Build a hash table, take array[i]/10000 as the key,
         * array[i]%10000 as the value;
         */
        Hashtable<Long, ArrayList<Integer>> Htable = buildHash(array);
         
        double timeHash = stopwatch.elapsedTime();
        System.out.println("Building Hash table, the time used is: " + timeHash +"s. \n");
         
         
        /**********************************************
          * the range of sum, between -10000 and +10000;
          * the searchHash() method will calculate the total
          * number of pairs in original array, whose sum
          * will rank between (min, max);
          */
        int min = -10000;
        int max = 10000;
        searchHash(Htable, array, min, max);
         
        double timeSearch = stopwatch.elapsedTime();
        System.out.println("Searching the Hash, the time used is: " + timeSearch +"s. \n");
        System.out.println("Bingle! ^_^ ");
    } // end of main();

    private static void searchHash(Hashtable<Long, ArrayList<Integer>> table, long[] array, int min, int max) {
		// TO check if array[j]/10000, array[j]/10000+1, array[j]/10000-1 in the hashtable.
    	
    	int[] sums = new int[max-min+1];
        
 		for(int i=0; i<array.length; i++){
 			
 			/****************************************************************************
 			 * take array[i]/10000 as the keys;
 			 * array[i]%10000 as the values;
 			 * There are three boundaries of keys, after array[i]/10000(+10000 to -10000);
 			 * array[i]/10000 - 1, array[i]/10000, array[i] + 1;
 			 * 1st, when array[i]/10000 == -array[j]/10000, this means array[i]+array[j] belongs to (-10000, +10000);
 			 */
 			long key = array[i]/10000;
 			int value = (int) (array[i]%10000);

 			if(table.containsKey(key)){
 				for(int k=0; k<table.get(key).size(); k++){
 					int diff = value - table.get(key).get(k);
 					if(diff<=max && diff>=min){
 					//	System.out.println("key1= " +key+ ". value2=" + value +".  sum= " + diff);
 						sums[diff+10000] = 1;
 					
 					} // end if diff (-10000, +10000);
 				} // end for k loop;
  
 			} // end if table.containsKey();
 			
 			long key2 = array[i]/10000 +1;
 			int value2 = (int) (array[i]%10000);
 			if(table.containsKey(key2)){
 				for(int k=0; k<table.get(key2).size(); k++){
 					int diff = value2 - table.get(key2).get(k) - 10000;
 					if(diff<max && diff>=min){
 					//	System.out.println("key2= " +key2+ ". value2=" + value2 +".  sum= " + diff);
 						sums[diff+10000] = 1;
 						//break;
 					} // end if diff;
 				}  // end for k loop;
 			} // end if table.containsKey(key2);
 			
 			long key3 = array[i]/10000 -1;
 			int value3 = (int) (array[i]%10000);
 			if(table.containsKey(key3)){
 				for(int k=0; k<table.get(key3).size(); k++){
 					int diff = value3 - table.get(key3).get(k) +10000;
 					if(diff<=max && diff>=min){
 						//	System.out.println("key3= " +key3+ ". value3= " + value3+".  sum= " + diff);
 							sums[diff+10000] = 1;
 							//break;
 						}
 				}
 			} // end if;
 		} // end for i loop;
 			
 			int sum = 0;
 			for(int i=0; i<20000; i++){
 				sum += sums[i];
 			}
 			System.out.println("Sums at the end: " + sum +". ");
	} // end of searching hash table; 

	private static Hashtable<Long,ArrayList<Integer>> buildHash(long[] array) {
		// TO build a hash table;
    	 Hashtable<Long, ArrayList<Integer>> table = new Hashtable<Long, ArrayList<Integer>>();
         /***
          * build a hashtable, then put every element in the array to the table
          * BUT, I am not familiar with the data structure of the table
          * So, this is really a bad table I built, ==!
          * A lot of extra work need to be done later.
          */
            
            System.out.println("Building Hashing table!");
            for(int i=0; i<array.length; i++){
            	long key = -array[i]/10000;
            	int value = (int) (-array[i]%10000);
            	if(!table.containsKey(key)){
            		ArrayList<Integer> tempList = new ArrayList<Integer>();
            		tempList.add(value);
            		table.put(key, tempList);
            	//	table.get(key).add(value);
            	} else {
            		if(!table.get(key).contains(value))
            			table.get(key).add(value);
            	}
            	
            } //end inner for;

            System.out.println("Hashing table ready------");
    	
		return table;
	} // end of build hash table method; 


} // end of all

/************
* After reading, the time used is: 0.384s. 
* Building Hashing table!
* Hashing table ready------
* Building Hash table, the time used is: 2.802s. 
*
* Sums at the end: 427. 
* Searching the Hash, the time used is: 3.848s. 
*
* Bingle! ^_^ 
*/