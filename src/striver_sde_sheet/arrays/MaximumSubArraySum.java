package striver_sde_sheet.arrays;

import java.util.Scanner;

public class MaximumSubArraySum {

    /* Time O(N*N), Space O(1)*/
    int bruteForce(int[] arr){
        int maximumSum = arr[0];
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                maximumSum = Math.max(maximumSum, sum);
            }
        }
        return maximumSum;
    }

    /* Time O(N), Space O(1)*/
    int KadanesAlgoritham(int[] arr){
        int maximumSum = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(maximumSum < sum){
                maximumSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MaximumSubArraySum maximumSubArraySum = new MaximumSubArraySum();

//        int[] arr = {-2, 1, -3, 4, -1, -2, 1, 5, -3};
//        int[] arr = {5,4,-1,7,8};
        int[] arr = {-2, -1};

//        int maximumSum = maximumSubArraySum.bruteForce(arr);
        int maximumSum = maximumSubArraySum.KadanesAlgoritham(arr);
        System.out.println(maximumSum);



        scanner.close();
    }
}
