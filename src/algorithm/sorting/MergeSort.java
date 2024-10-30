package algorithm.sorting;

import java.util.Arrays;

//ascending order using Merge Sort
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,57,21,3,6,71};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2; // find the mid to divide the array
            sort(arr, low, mid);    // left part of the recursion
            sort(arr, mid+1, high); // right part of the recursion
            merge(arr, low, mid, high);
        }
    }
    static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low; // left[low...mid]
        int right = mid+1; // right[mid+1....high]
        int tempIndex = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[right++];
            }
        }
        while (left<=mid){  // if we have elements left in left array
            temp[tempIndex++] = arr[left++];
        }
        while (right<=high){ // if we have elements right in left array
            temp[tempIndex++] = arr[right++];
        }
        for(int i = low; i <= high; i++){ // copy the sorted element in origin array
            arr[i] = temp[i-low];
        }
    }
}


/*
Dived and Conquer method
Time Complexity :
Best Case -> O(n*Log(n))
Average Case -> O(n*Log(n))
Worst Case -> O(n*Log(n))

Space Complexity : O(n)

Where we use --> large dataset with external memorizing
*/
