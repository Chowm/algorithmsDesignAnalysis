package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class sites{
	int elements=0;
	ArrayList<Integer> List = new ArrayList<Integer>();
}

public class TwoSum1115HashArray {
	
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
        
         long Mody = 100000000000L;
         sites[] ArraySite = new sites[1000000];
         for(int i=0; i<1000000; i++){
        	 ArraySite[i] = new sites();
         }
         
         int Max = 0;
         
         for(int i=0; i<1000000; i++){
        	 int index = (int) ((Mody+array[i])%1000000);
        	 ArraySite[index].List.add((int) ((Mody+array[i])/1000000));
        	 ArraySite[index].elements++;
        	 if (ArraySite[index].elements > Max){
        		 Max = ArraySite[index].elements;
        	 }
         } // end for, finished putting all array[i] into sites();
         System.out.println("The longest arrarlist has " + Max +" elements;");
         
         int count =0;
         for(int sum=-10000; sum<10000; sum++){
        	 
        	 count += countSums(array, sum, ArraySite);
        	  
         } // end for sum loop;
         
         System.out.println("Total count: " + count);
    }// end main(); 

	private static int countSums(long[] array, int sum, sites[] ArraySite) {
		// TODO Auto-generated method stub
        long Mody = 100000000000L;
        
   	 for(int i=999999; i>=0; i--){
   		 long temp = sum-array[i] + Mody;
   		 int index = (int) (temp%1000000);
   		 if(ArraySite[index].elements>0){
       		 int value = (int) (temp/1000000);
       		 for(int k=0; k< ArraySite[index].elements; k++){
       			 if(ArraySite[index].List.get(k) == value){
       				 
       				 System.out.println("Sum= " + sum +". We got one pair.");
       				 return 1;
       			 }
       		 }
   		 } // end if;
   	 } // end for i loop;
   	
		return 0;
	}
}

