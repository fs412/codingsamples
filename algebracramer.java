/* 3.3 (Algebra: solve linear equations) A linear equation can be
solved using Cramer’s rule given in Programming Exercise 1.13
. Write a program that prompts the user to enter a, b, c, d, e, and f
and displays the result. If is 0 , report that “The equation
has no solution.”
*/

import java.util.Scanner;
public class algebracramer {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, f: (These letters refer to the numbers from left to right and top to bottom of Cramer's Rule.) ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        if ((a * d - b * c) == 0) 
            System.out.println("The equation has no solution.");
        else
        {
            double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
            double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
            System.out.println("x = " + x + " and y = " + y);
        }
    }
}