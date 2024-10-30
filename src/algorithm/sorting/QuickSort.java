package algorithm.sorting;

import java.util.Arrays;

//ascending order using QuickSort
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,3,40,70,21};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int start, int end){
        if(start < end){
            int p = partition(arr, start, end);
            sort(arr, start, p-1);  // left part of array
            sort(arr, p+1, end);    // right part of array
        }
    }
    static int partition(int[] arr, int left, int right){
        int pivot = arr[right]; // set the pivot
        int temp;
        int i = left-1; // this the pointer for lesser then pivot
        int j = left;   // this the pointer for higher then pivot
        while(j < right){
            if(pivot > arr[j]){ // swap the next to the current pivot lesser element(i) and current element(j)
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        // current i--> lesser element to the pivot so we swap to the next of i
        temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1; // return breaking position
    }
}
/*
Time Complexity :
Best Case -> O(n*Log(n))
Average Case -> O(n*Log(n))
Worst Case -> O(n^2)

Space Complexity : O(1)

Where we use --> in-memory sorting for large dataset
*/
