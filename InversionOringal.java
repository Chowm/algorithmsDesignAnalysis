package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 
public class InversionOringal {
 
    static long count = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/IntegerArray1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("No such file!");
            e.printStackTrace();
            return;
        }
 
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
        }
 
        getInversion(array);
        System.out.println(count);
 
        try {
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
 
    static int[] getInversion(int[] array) {
        if (array.length == 1)
            return array;
        int left = array.length / 2;
        int right = array.length - left;
        int[] leftarray = Arrays.copyOfRange(array, 0, left);
        int[] rightarray = Arrays.copyOfRange(array, left, left + right);
 
        leftarray = getInversion(leftarray);
        rightarray = getInversion(rightarray);
 
        return array = mergInversion(leftarray, rightarray);
        
    }

	private static int[] mergInversion(int[] leftarray, int[] rightarray) {
		// TODO Auto-generated method stub
		int left = leftarray.length;
		int right = rightarray.length;
		int arrayL = left + right;
		int[] array = new int[arrayL];
		
        int i = 0, j = 0, k = 0;
        while (i != left && j != right) {
            if (leftarray[i] < rightarray[j]) {
                array[k] = leftarray[i];
                i++;
                k++;
            } else {
                array[k] = rightarray[j];
                count += left - i;
                j++;
                k++;
            }
        }
 
        while (i != left) {
            array[k] = leftarray[i];
            i++;
            k++;
        }
 
        while (j != right) {
            array[k] = rightarray[j];
            j++;
            k++;
        }
		return array;
		
	}
}
