package algorithmsDesignAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class QuickSort {
 
    static long count = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("C:/Users/Yan/Desktop/QuickSort.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("No such file!");
            e.printStackTrace();
            return;
        }
 
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
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

        
        int[] array1 = new int[10000];
        for(int i=0; i<array.length; i++){
        		array1[i] = array[i];
        }
        
        count = 0;
        qsort(array1, 0, array1.length - 1, 1);
        System.out.println(count);
        
        int[] array2 = new int[10000];
        for(int i=0; i<array.length; i++){
        		array2[i] = array[i];
        }
 
        count = 0;
        		
        qsort(array2, 0, array2.length - 1, 2);
        System.out.println(count);
 
        int[] array3 = new int[10000];
        for(int i=0; i<array.length; i++){
        		array3[i] = array[i];
        }
        count = 0;
        qsort(array3, 0, array3.length - 1, 3);
        System.out.println(count);
 
        try {
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
 
    static void qsort(int[] array, int start, int end, int type) {
        if (start < end) {
            count += end - start;
            // this is what we were told in the lecture; count= count+(end-start);
            
            int mid = 0;
            switch (type) {
            case 1:
                mid = firstPartition(array, start, end);
                break;
            case 2:
                mid = lastPartition(array, start, end);
                break;
            case 3:
                mid = medianPartition(array, start, end);
                break;
            }
 
            qsort(array, start, mid - 1, type);
            qsort(array, mid + 1, end, type);
        }
        // break the array into two arrays, array[0] to array[mid-1], and array[mid+1] to array[end];
    }
 
    static int firstPartition(int[] array, int start, int end) {
        int index = start;
        int pivot = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < pivot) {
                index++;
                swap(array, i, index);
            }
        }
        swap(array, index, start);
        // why swap these two elements after for loop?
        return index;
    }
 
    static int lastPartition(int[] array, int start, int end) {
        swap(array, start, end);
        return firstPartition(array, start, end);
    }
 
    static int medianPartition(int[] array, int start, int end) {
        int mid;
        if ((end - start + 1) % 2 == 0) {
            mid = start + (end - start + 1) / 2 - 1;
        } else {
            mid = start + (end - start + 1) / 2;
        }
 
        if ((array[start] > array[end] && array[start] < array[mid]) || (array[start] < array[end] && array[start] > array[mid])) {
            return firstPartition(array, start, end);
        } else if ((array[end] > array[start] && array[end] < array[mid]) || (array[end] < array[start] && array[end] > array[mid])) {
            swap(array, start, end);
            return firstPartition(array, start, end);
        } else {
            swap(array, start, mid);
            return firstPartition(array, start, end);
        }
    } // end of medianPartition() method;
 
    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    } // end f swap; 
}
