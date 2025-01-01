package striver_sde_sheet.arrays;

import java.util.Arrays;

public class SetMatrixToZero {

    /* Brute Force */
    void bruteForeApproach(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    setRow(matrix, r);
                    setCol(matrix, c);
                }
            }
        }
        setZeros(matrix);
    }

    void setRow(int[][] matrix, int row) {
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[row][c] != 0)
                matrix[row][c] = -1;
        }
    }

    void setCol(int[][] matrix, int col) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][col] != 0)
                matrix[r][col] = -1;
        }
    }

    void setZeros(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == -1) {
                    matrix[r][c] = 0;
                }
            }
        }
    }


    /* Better Approach */
    void betterApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] = true;
                }
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (row[r] || col[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }


    /* Optimal Approach */
    void optimalApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean col0 = false;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    if (c != 0) {
                        matrix[0][c] = 0;
                    } else {
                        col0 = true;
                    }
                }
            }
        }
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int c = 0; c < m; c++) {
                matrix[0][c] = 0;
            }
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        } else if (col0) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    void display(int[][] matrix) {
        for (int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        SetMatrixToZero setMatrixToZero = new SetMatrixToZero();
//        setMatrixToZero.bruteForeApproach(matrix);
//        setMatrixToZero.betterApproach(matrix);
        setMatrixToZero.optimalApproach(matrix);
        setMatrixToZero.display(matrix);
    }
}

