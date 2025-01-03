package algorithm.others;

public class MooreAlgorithm {

    /*
    * This algorithm return the element frequency count that exist the half of the length of array
    * */
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 1, 1, 3, 1, 1};

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
        System.out.println(element);
    }

}
