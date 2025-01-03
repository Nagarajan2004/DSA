package striver_sde_sheet.arrays3;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 3, 3, 3, 1, 1};

        int element = majorityElement(arr);
        System.out.println(element);
    }

    private static int majorityElement(int[] arr) {
        int count = 1;
        int element  = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(count == 0){
                count = 1;
                element = arr[i];
            } else if(element == arr[i]){
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
