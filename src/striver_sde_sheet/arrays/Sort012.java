package striver_sde_sheet.arrays;

import java.util.Arrays;

public class Sort012 {

    private void sort(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid < high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 1, 0};

        Sort012 sort012 = new Sort012();
        sort012.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
