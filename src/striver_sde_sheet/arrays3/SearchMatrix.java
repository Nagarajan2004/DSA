package striver_sde_sheet.arrays3;

public class SearchMatrix {

    private boolean isTargetPresent(int[][] matrix, int n, int m, int target){
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int r = mid / m;
            int c = mid % m;
            if(matrix[r][c] == target){
                return true;
            } else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 8;

        SearchMatrix searchMatrix = new SearchMatrix();

        boolean isTargetPresent = searchMatrix.isTargetPresent(matrix, matrix.length, matrix[0].length, target);

        System.out.printf("%B", isTargetPresent);
    }
}
