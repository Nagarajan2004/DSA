package algorithm.sorting;

import java.util.Arrays;

//ascending order using Insertion Sort
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{47,57,21,3,6,71};
        int temp;
        for(int i = 1; i < arr.length; i++){
            temp = arr[i];
            int j = i-1;
            while(j >= 0 && temp <= arr[j]){ //the loop run till current element(temp) is smaller then previous of that element
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println("Insertion Sort");
        System.out.println(Arrays.toString(arr));
    }
}

/*
--> Efficient for small datasets

Time Complexity :
Best Case -> O(n)
Average Case -> O(n^2)
Worst Case -> O(n^2)

Space Complexity : O(1)
*/
