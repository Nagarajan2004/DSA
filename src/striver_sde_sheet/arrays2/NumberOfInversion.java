package striver_sde_sheet.arrays2;

public class NumberOfInversion {

    private int bruteForce(int[] arr, int n){
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            int A = arr[i];
            for (int j = i+1; j < n; j++) {
                if(A > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    private int mergeSort(int[] arr, int left, int right){
        int count = 0;
        if(left >= right) return count;

        int mid = left + (right - left) / 2;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid+1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    private int merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int l = left; // for array left[low...mid]
        int r = mid+1; // for array right[mid+1....high]
        int index = 0;

        int count = 0;
        while(l <= mid && r <= right){
            if(arr[l] <= arr[r]){
                temp[index++] = arr[l++];
            } else {
                count += mid - l + 1; // left array of that element will be paired with the at right element
                temp[index++] = arr[r++];
            }
        }

        while (l <= mid){
            temp[index++] = arr[l++];
        }

        while (r <= right){
            temp[index++] = arr[r++];
        }

        for (int i = left; i <= right ; i++) {
            arr[i] = temp[i-left];
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {5, 2, 4, 7, 1, 3, 2, 6}; // ans 14
        int[] arr = {6, 4, 7, 2, 7, 2, 4, 2, 5, 5};  // ans : 22

        NumberOfInversion numberOfInversion = new NumberOfInversion();
        int inversions;

//        inversions = numberOfInversion.bruteForce(arr, arr.length); // O(N*N)

        inversions = numberOfInversion.mergeSort(arr, 0, arr.length-1);

        System.out.println("inversions = " + inversions);
    }
}
