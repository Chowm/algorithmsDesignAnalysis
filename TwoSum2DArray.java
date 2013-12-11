package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class site{
	 
	int[] link = new int[0];
}

public class TwoSum2DArray {

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
         
         // get the max of the array, even count after sum-array[i];
         for(int i=0; i<1000000; i++){
        	 if (array[i] > arrayMax)
        		 arrayMax = array[i];
        	 if (array[i] < arrayMin)
        		 arrayMin = array[i];
         }
         
         // use the following function to get the mininum value in both original and new-array;
         // to make sure after sum-array[i].max - arrayMin is positive.
         arrayMin = Math.min((-10000-arrayMax), arrayMin);
         
         System.out.println("ArrayMax= " + arrayMax +" \narrayMin= " +arrayMin);
         
         // generate newArray1 to store all the value of first half: array[i]/1000000;
         int[] newArray1 = new int[1000000];
         for(int i=0; i<1000000; i++){
        	 newArray1[i] = -1;
         }
   
         // generate newArray2 to store all value of second half: array[i]%1000000;
         int[] newArray2 = new int[1000000];
         for(int i=0; i<1000000; i++){
        	 newArray2[i] =-1;
         }


         int min = -10000;
         int max = 10000;
         int count = 0;
         for(int sum= min; sum<=max; sum++){
        	 
        	 if(sum%200 == 0){
        		 System.out.println("Sum= " + sum + "...");
        	 }

        	 long[] tempArray = new long[1000000];
        	 
        	 for(int i=0; i<1000000; i++){
        		 tempArray[i] = sum - array[i] - arrayMin;

        		 int a = (int) (tempArray[i]/1000000);
        		 int b = (int) (tempArray[i]%1000000);
     
        		 newArray1[a] = a;
        		 newArray2[b] = b;

        	}
         } // enf for sum loop;
         
     	
         for(int i=0; i<1000000; i++){
        	 int a = (int) ((array[i] - arrayMin)/1000000);
        	 int b = (int) ((array[i] - arrayMin)%1000000);
 
        	 
        	 if(newArray1[a]>=0 && newArray2[b]>=0){
        		 count++;
        	 } // end if;

         } // end for i checking original loop;

         System.out.println("The number of valid 2-sums is: " +count);
    } // end main();
    
}