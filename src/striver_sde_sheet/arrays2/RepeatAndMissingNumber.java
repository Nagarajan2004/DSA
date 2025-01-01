package striver_sde_sheet.arrays2;

import java.util.ArrayList;
import java.util.List;

/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.
*/

public class RepeatAndMissingNumber {

    private List<Integer> solveByMath(int[] nums){
        long n = nums.length;
        long s = 0, sn = n * (n+1) / 2;
        long s2 = 0, s2N = n * (n+1) * (2*n+1) / 6;
        for(int num : nums){
            s += num;
            s2 += (long)num * (long)num;
        }
        long val1 = s - sn;
        long val2 = (s2 - s2N) / val1;
        long A = (val1 + val2) / 2;
        long B = val2 - A;
        return new ArrayList<>(List.of((int)A, (int)B));
    }

    private List<Integer> solveByBitManipulation(int[] nums){
        int n = nums.length;
        int xr = 0;
        for(int i = 0; i < n; i++){
            xr ^= nums[i];
            xr ^= i+1;
        }
        int bitNo = 0;
        while ((xr & (1 << bitNo)) == 0) {
            bitNo++;
        }
        int zeros = 0;
        int ones = 0;
        for(int i = 0; i < n; i++){
            // the array numbers
            if((nums[i] & (1 << bitNo)) != 0){
                ones ^= nums[i];
            } else{
                zeros ^= nums[i];
            }
            // for all natural numbers
            if(((i+1) & (1 << bitNo)) != 0){
                ones ^= i+1;
            } else{
                zeros ^= i+1;
            }
        }
        int count = 0;
        for(int num : nums){
            if(num == zeros){
                count++;
                if(count == 2){
                    return new ArrayList<>(List.of(zeros, ones));
                }
            }
        }
        return new ArrayList<>(List.of(ones, zeros));
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,1,3,6};

        RepeatAndMissingNumber repeatAndMissingNumber = new RepeatAndMissingNumber();

//        List<Integer> numbers = repeatAndMissingNumber.solveByMath(nums);
        List<Integer> numbers = repeatAndMissingNumber.solveByBitManipulation(nums);

        System.out.println(numbers);
    }
}
