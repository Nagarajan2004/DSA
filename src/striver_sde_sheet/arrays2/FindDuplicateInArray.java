package striver_sde_sheet.arrays2;
/*
Given an array of integers arrays containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in array, return this repeated number.

You must solve the problem without modifying the array and using only constant extra space.

*/
public class FindDuplicateInArray {

    private int findDuplicate(int[] arr){
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);
        fast = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,3,2};

        FindDuplicateInArray findDuplicateInArray = new FindDuplicateInArray();

        int duplicateNumber = findDuplicateInArray.findDuplicate(arr);

        System.out.println(duplicateNumber);
    }
}
