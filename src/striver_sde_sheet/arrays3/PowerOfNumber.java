package striver_sde_sheet.arrays3;

import java.util.Scanner;

/* Pow(x, n)*/
public class PowerOfNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("X : ");
        double x = scanner.nextDouble();
        System.out.println("N : ");
        int n = scanner.nextInt();

        double result = 1.0;
        int pow = n;
        if(pow < 0){
            pow = -pow;
        }
        while(pow > 0){
            if((pow & 1) == 1){
                result *= x;
                pow--;
            } else {
                x *= x;
                pow /= 2;
            }
        }
        System.out.println(
                (n < 0) ? (double)1/result : result
        );
    }
}
