package algorithm.sorting;

import java.util.Arrays;

//ascending order using Radix Sort
class RadixSort {
    public static void countingSort(int[] arr, int n, int place){
        int[] sortedArray = new int[n+1];
        int[] count = new int[10];   // frequency count
        for(int el : arr){
            count[(el/place)%10]++; // it will count the place of digit frequency
        }
        for(int i = 1; i < 10; i++){
            count[i] += count[i-1]; // it will set all the count arr element to fix the position of index
        }
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        if (n >= 0) System.arraycopy(sortedArray, 0, arr, 0, n);
    }
    public static void main(String[] args) {
        int[] arr = {151, 259, 360, 91, 115, 706, 34, 858, 2};
        int maxElement = findMax(arr);  // maxElement --> digit count for number of iteration(sort)
        System.out.println("Original Array");
        System.out.println(Arrays.toString(arr));
        for(int place = 1; maxElement/place > 0; place *= 10){
            countingSort(arr, arr.length, place);
        }
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int el : arr){
            if(max < el){
                max = el;
            }
        }
        return max;
    }
}

/*
Time Complexity :
Best Case -> O(n+k)
Average Case -> O(n*k)
Worst Case -> O(n*2)

Space Complexity : O(n+k)

Where we use --> large dataset int or string like phone number or postal code
*/
