package algorithm.sorting;

import java.util.Arrays;

//ascending order using Counting Sort
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 9, 7, 4, 1, 8, 4};
        int maxElement = findMaxElement(arr);   // max = 9
        int[] countArray = new int[maxElement+1]; // frequency of the array elements ==> {0, 1, 1, 0, 2, 0, 0, 1, 1, 1}
        for(int el : arr)
            countArray[el]++;
        for(int i = 1; i <= maxElement; i++) {  // cumulative count array ==> {0, 1, 2, 2, 4, 4, 4, 5, 6, 7}
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        int[] sortedArray = new int[arr.length];
        for(int el : arr){  //insert the element correct position in the sorted Array
            sortedArray[countArray[el]-1] = el;
            countArray[el]--;  // decrement the frequency count to get the previous index to insert
        }
        System.out.println(Arrays.toString(sortedArray));
    }
    private static int findMaxElement(int[] arr){
        int max = arr[0];
        for(int el : arr)
            if(el > max)
                max = el;
        return max;
    }
}

/*
Time Complexity :
Best Case -> O(n+k)
Average Case -> O(n+k)
Worst Case -> O(n+k)

Space Complexity : O(maxElement)

Where we use --> fixed range
*/