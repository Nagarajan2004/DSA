package striver_sde_sheet.arrays2;

import java.util.Arrays;

public class RotateMatrix {

    void rotate90Degree(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        for(int r = 0; r < row; r++){
            for(int c = r+1; c < col; c++){
                int temp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = temp;
            }
        }
        for(int r = 0; r < row; r++){
            int left = 0;
            int right = col-1;
            while(left < right){
                int temp = mat[r][left];
                mat[r][left] = mat[r][right];
                mat[r][right] = temp;
                left++;
                right--;
            }
        }
        display(mat);
    }

    void rotateMatrix(int[][] mat){
        int left = 0, right = mat[0].length-1;
        int top = 0, bottom = mat.length-1;
        while(left < right && top < bottom){
            int prev = mat[top+1][left];
            for (int i = left; i <= right; i++) {
                int temp = mat[top][i];
                mat[top][i] = prev;
                prev = temp;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                int temp = mat[i][right];
                mat[i][right] = prev;
                prev = temp;
            }
            right--;
            for(int i = right; i >= left; i--){
                int temp = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = temp;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                int temp = mat[i][left];
                mat[i][left] = prev;
                prev = temp;
            }
            left++;
        }
        display(mat);
    }

    void display(int[][] mat){
        for(int[] m : mat){
            System.out.println(Arrays.toString(m));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        RotateMatrix rotateMatrix = new RotateMatrix();

        rotateMatrix.display(mat);

        rotateMatrix.rotate90Degree(mat.clone());

        rotateMatrix.rotateMatrix(mat.clone());
    }
}
