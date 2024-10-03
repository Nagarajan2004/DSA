package algorithm.sorting;

import java.util.Arrays;

//ascending order using Selection Sort
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{47,57,21,3,6,71};
        for (int i = 0; i < arr.length-1; i++) {
            int minValueIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minValueIndex] > arr[j]){
                    minValueIndex = j;
                }
            }
            int temp = arr[minValueIndex];
            arr[minValueIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Selection Sort : ");
        System.out.println(Arrays.toString(arr));
    }
}

/*
--> A small array to be sorted
--> Swapping cost doesn't matter

Time Complexity :
Best Case -> O(n)
Average Case -> O(n^2)
Worst Case -> O(n^2)

Space Complexity : O(1)
*/