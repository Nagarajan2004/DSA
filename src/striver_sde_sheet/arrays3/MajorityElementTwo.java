package striver_sde_sheet.arrays3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {


    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 3, 3, 3, 1, 1};

        int majority1 = 0;
        int majority2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int n : arr){
            if(majority1 == n){
                count1++;
            } else if(majority2 == n){
                count2++;
            } else if(count1 == 0 && majority2 != n){
                count1++;
                majority1 = n;
            } else if(count2 == 0 && majority1 != n){
                count2++;
                majority2 = n;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> majority = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int n : arr){
            if(n == majority1) count1++;
            else if(n == majority2) count2++;
        }
        if(count1 > arr.length/3) majority.add(majority1);
        if(count2 > arr.length/3) majority.add(majority2);
        System.out.println(majority);
    }
}
