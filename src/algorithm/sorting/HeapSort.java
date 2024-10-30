package algorithm.sorting;

/* first build max heap then remove the elements to get ascending order */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {81, 89, 9, 11, 14, 76, 54, 22};
        buildMinHeap(arr, arr.length);

    }
    public static void buildMinHeap(int[] arr, int n){
        int[] minHeap = new int[n];
        for(int i = 0; i < n; i++){
            int j = ;
            while(minHeap[i] )
        }
    }
}

/*

Time Complexity :
Best Case -> O(n*Log(n))
Average Case -> O(n*Log(n))
Worst Case -> O(n*Log(n))

Space Complexity : O(1)
*/
