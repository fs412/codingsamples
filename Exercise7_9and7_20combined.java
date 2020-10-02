/* 7.9 (Find the smallest element) Write a method that finds the smallest
element in an array of double values using the following header:
public static double min(double[] array)
Write a test program that prompts the user to enter 10 numbers, invokes
this method to return the minimum value, and displays the minimum
value. Here is a sample run of the program:
Enter 10 numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
The minimum number is 1.5

7.10 (Find the index of the smallest element) Write a method that returns
the index of the smallest element in an array of integers. If the number of
such elements is greater than 1, return the smallest index. Use the
following header:

public static int indexOfSmallestElement(double[] array)
Write a test program that prompts the user to enter 10 numbers, invokes
this method to return the index of the smallest element, and displays the
index.

*/

import java.util.Scanner;
public class Exercise7_9and7_20combined {
    public static void main(final String[] args) {
        System.out.print("Enter ten numbers and the minimum, index of minimum number will be printed that will be sorted: "); 
        final Scanner input = new Scanner(System.in);
        final double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }
            sortednumbers(numbers);
		    for (double e: numbers) 
			    System.out.print(e + " ");
		    System.out.println();

        System.out.println("The minimum number is: " + min(numbers));
        System.out.println("The index of minimum number is: " + indexOfSmallestElement(numbers));
    }

    public static double min(final double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];

            }
        }
        return min;
    }

    public static int indexOfSmallestElement(final double[] array) {
        final double min = array[0];
        int minIndex=0;
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
        }

    
    public static void sortednumbers(final double[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			double currentMax = list[i];
			int currentMaxIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}
			if (currentMaxIndex != i) {
				list[currentMaxIndex] = list[i];
                list[i] = currentMax;}


			}
		}
	}
