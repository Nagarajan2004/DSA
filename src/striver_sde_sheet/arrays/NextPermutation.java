package striver_sde_sheet.arrays;

import java.util.*;

public class NextPermutation {
    /**
     * solution 1 :- generate all permutation and find the next one
     * solution 2 :- find the break point then swap it to next nearest element then reverse it from the break point
     * */

    /* solution 1 */
    void generatePermutation(int[] arr, int index, List<int[]> allPermutation){
        if(index == arr.length){
            allPermutation.add(arr.clone());
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            generatePermutation(arr, index+1, allPermutation);
            swap(arr, i, index);
        }
    }

    /* solution 2 */
    void findNextPermutation(int[] arr){
        int length = arr.length;
        // find break point
        int i = length-2;
        while(i >= 0) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
            i--;
        }
        if(i == -1){
            reverse(arr, 0, length-1);
            return;
        }
        // find the nearest element
        int j = length - 1;
        while(j > i){
            if(arr[i] < arr[j]){
                swap(arr, i, j);
                break;
            }
            j--;
        }
        reverse(arr, i+1, length-1);
    }

    void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NextPermutation nextPermutation = new NextPermutation();

        int[] arr = new int[]{2, 1, 5, 4, 3, 0, 0};
        //generate all permutation
//        List<int[]> allPermutation = new ArrayList<>();
//        int[] arrSorted = new int[]{0, 0, 1, 2, 3, 4, 5};
//        nextPermutation.generatePermutation(arrSorted, 0, allPermutation);
//        allPermutation.sort(Arrays::compare);
//        for(int i = 0; i < allPermutation.size(); i++){
//            if(i < allPermutation.size()-1 && Arrays.equals(allPermutation.get(i), allPermutation.get(i+1))) continue;
//            if(Arrays.equals(arr, allPermutation.get(i))){
//                if(i == allPermutation.size() - 1){
//                    System.out.println(Arrays.toString(allPermutation.get(0)));
//                } else {
//                    System.out.println(Arrays.toString(allPermutation.get(i+1)));
//                }
//                break;
//            }
//        }


        /* optimal solution to get next permutation */
        nextPermutation.findNextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        scanner.close();
    }
}

/*
 [1, 2, 3] ==> [1, 3, 2]
 [a, b, c] ==> [a, c, b]
 */