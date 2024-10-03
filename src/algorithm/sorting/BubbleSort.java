package algorithm.sorting;

import java.util.Arrays;

//ascending order using bubble
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,1,6};
        int temp;
        boolean swapHapped = false;
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){  // swap if current element is bigger to this right element
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapHapped = true;
                }
            }
            if(!swapHapped) break;
        }
        System.out.println("Bubble Sort");
        System.out.println(Arrays.toString(arr));
    }
}

/*
Time Complexity :
Best Case -> O(n)
Worst Case -> O(n^2)
Average Case -> O(n^2)

Space Complexity : O(1)
*/