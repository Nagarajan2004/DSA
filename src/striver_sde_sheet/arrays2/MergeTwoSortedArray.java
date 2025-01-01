package striver_sde_sheet.arrays2;

import java.util.Arrays;

public class MergeTwoSortedArray {

    /* Time : O(min(n, m)) + O(n log(n)) */
    private void mergeByTwoPointer(int[] arr1, int[] arr2){
        int left = arr1.length-1;
        int right = 0;
        while(left >= 0 && right < arr2.length){
            if(arr1[left]  > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
            }
            left--;
            right++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    /* Time : O(log2(n+m)) * O(n+m) */
    private void mergeByGapMethod(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int len = n+m;
        int gap = (len/2)+(len%2);
        // shell sort (gap method)
        while(gap > 0){
            int left = 0;
            int right = gap + left;
            while(right < len){
                if(left < n && right >= n){// left and right are in arr1 and arr2
                    swap(arr1, arr2, left, right-n);
                } else if(left >= n){ // left and right are in arr2
                    swap(arr2, arr2, left-n, right-n);
                } else { // left and right are in arr1
                    swap(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1)break;
            gap = (gap/2) + (gap%2);
        }
    }

    private void swap(int[] arr1, int[] arr2, int ind1, int ind2){
        if(arr1[ind1] > arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 8};
        int[] arr2 = {2, 3, 4, 5};

        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();

//        mergeTwoSortedArray.mergeByTwoPointer(arr1, arr2);
        mergeTwoSortedArray.mergeByGapMethod(arr1, arr2);

        System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
    }
}
