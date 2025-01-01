package striver_sde_sheet.arrays;

import java.util.Scanner;

public class PascalTriangle {
    /**
     * variant 1 :- find the value of the position(row, col)
     * variant 2 :- find the values of the given row
     * variant 3 :- print the pascal triangle (it means print the all the row)
     */

    /* variant 1 */
    int positionValue(int row, int col){
        if(row < col){
            return -1;
        }
        int value = 1;
        for(int c = 1; c < col; c++){
            value *= (row-c);
            value /= c;
        }
        return value;
    }

    /* variant 2*/
    void findTheRowValues(int row){
        int value = 1;
        System.out.print(value + " ");
        for(int c = 1; c < row; c++){
            value *= (row-c);
            value /= c;
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /* Variant 3 */
    void generatePascalTriangle(int row){
        int value;
        int space = row-1;
        for (int r = 1; r <= row; r++) {
            for(int sp = 0; sp < space; sp++){
                System.out.print(" ");
            }
            space--;
            value = 1;
            System.out.print(value + " ");
            for (int c = 1; c < r; c++) {
                value *= (r - c);
                value /= c;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PascalTriangle pascalTriangle = new PascalTriangle();

        // Variant - 1
//        System.out.println("Enter the Position : ");
//        int val = pascalTriangle.positionValue(scanner.nextInt(), scanner.nextInt());
//        System.out.println(val);

        // Variant - 2
//        System.out.println("Enter the row : ");
//        pascalTriangle.findTheRowValues(scanner.nextInt());

        // Variant - 3
        System.out.print("enter the number of rows to generate Pascal Triangle : ");
        int numberOfRow = scanner.nextInt();
        pascalTriangle.generatePascalTriangle(numberOfRow);

        scanner.close();
    }
}

 /*

 NcR ==> n! / r! * (n - r!)
 1->        1
 2->       1 1
 3->      1 2 1
 4->     1 3 3 1
 5->    1 4 6 4 1
 NcR --> (n-1)! / ( (r-1)! * (n-1-r-1)! )
 for 5 row and 2nd value ==> (5-1)! / ( (2-1)! * ((5-1)-(2-1))! ) ==> 4! / 1! * 3!

 */
