package striver_sde_sheet.arrays2;

import java.util.ArrayList;
import java.util.List;

public class MergedInterval {

    public static List<List< Integer >> mergeOverlappingIntervals(int [][]arr){
        List<List<Integer>> mergedInterval = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(arr[0][0]);
        li.add(arr[0][1]);
        mergedInterval.add(li);
        if(arr.length == 1){
            return mergedInterval;
        }
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            List<Integer> interval = mergedInterval.get(index);
            int[] a = arr[i];
            if(interval.get(1) >= a[0]){
                if(interval.get(1) < a[1]){
                    mergedInterval.get(index).set(1, a[1]);
                }
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(a[0]);
                l.add(a[1]);
                mergedInterval.add(l);
                index++;
            }
        }
        return mergedInterval;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6},{7, 7}};
        List<List<Integer>> mergedIntervals = mergeOverlappingIntervals(intervals);
        System.out.println(mergedIntervals);
    }
}
