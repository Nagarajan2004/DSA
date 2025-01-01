package algorithm.dp;

public class KadanesAlgorithm {

    int maximumSum(int[] arr){
        int maximumSum = arr[0];
        int sum = 0, start = 0, end = 0, currStart = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum == 0){
                currStart = i;
            }
            sum += arr[i];
            if(sum > maximumSum){
                start = currStart;
                end = i;
                maximumSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return maximumSum;
    }

    public static void main(String[] args) {
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
        int[] arr = {-2, 1, -3, 4, -1, -2, 1, 5, -3};
        int maximumSum = kadanesAlgorithm.maximumSum(arr);
        System.out.println(maximumSum);
    }
}
