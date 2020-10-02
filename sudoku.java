/*
CS 501 WS
Farnaz Sabetpour
Austin Luo
Assignment 8
Final Project
Check Multiple Sudoku Solutions
*/

import java.util.Scanner;
import java.io.File;
import java.util.HashSet;

public class sudoku {
    private static boolean numberset(int[][] a) { 
        // We are testing to see if the number range is 1-9.
        for (int n = 0; n < 9; n++) {
            for (int k = 0; k < 9; k++) {
                if (a[n][k] <= 0 || a[n][k] > 9) { 
                    // If a number never occurs or occurs more than 10 times, this will be invalid.
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checking(int[][] a) { 
        // We are checking to see if the solution provided is a valid sudoku solution.
        for (int column = 0; column < 9; column++) { 
            // column
            HashSet<Integer> set = new HashSet<>();
            for (int otherline = 0; otherline < 9; otherline++) {
                if (set.contains(a[otherline][column])) {
                    return false;
                }
                set.add(a[otherline][column]);
            }
        }
        for (int[] line : a) { 
            // diagonal
            HashSet<Integer> set = new HashSet<>();
            for (int n = 0; n < 9; n++) {
                if (set.contains(line[n])) {
                    return false;
                }
                set.add(line[n]);
            }
        }
        for (int otherline = 0; otherline <= 6; otherline += 3) { 
            // row
            for (int column = 0; column <= 6; column += 3) {
                HashSet<Integer> set = new HashSet<>();
                for (int offset_otherline = 0; offset_otherline < 3; offset_otherline++) {
                    for (int offset_column = 0; offset_column < 3; offset_column++) {
                        int curr_otherline = otherline + offset_otherline;
                        int curr_column = column + offset_column;
                        if (set.contains(a[curr_otherline][curr_column])) {
                            return false;
                        }
                        set.add(a[curr_otherline][curr_column]);
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int repeat = 1;
        while (repeat != 0) {
            System.out.println("Welcome to Multiple Sudoku Solutions Checker!");
            System.out.println("Please have a .txt file named 'sudokusolutions.txt' named in the same source folder as this file.");
            System.out.println("Also, have 1 line after the final sudoku solution to contain the word 'end' to indicate the final sudoku solution.");
            System.out.println("Have a space in between each of the numbers as well. Have a line in between the different solutions too.");
            System.out.println("Now, let's get started!");
            System.out.println("Checking if the file (sudokusolutions.txt) contains valid sudoku solutions...");
            String fileName = ("sudokusolutions.txt"); // Name of the file that contains the sudoku solutions.
            File file = new File(fileName);
            Scanner sources;
            String line = null;
            int num = 1;
            try {
                sources = new Scanner(file);

            } catch (Exception e) {
                System.out.println("Error. Could not find the .txt file. Make sure to save the file in the same folder as this java file.");
                System.out.print("Try again? Hit '1' for yes or '0' for no: ");
                repeat = input.nextInt();
                continue;
            }
            try {
                while (sources.hasNextLine()) {
                    if (line != null && line.equals("last")) {
                        return;
                    }
                    line = sources.nextLine();
                    int[][] a = new int[9][9];
                    for (int n = 0; n < 9; n++) {
                        Scanner lins = new Scanner(line);
                        for (int k = 0; k < 9; k++) {
                            a[n][k] = lins.nextInt();
                        }
                        line = sources.nextLine();
                    }
                    if (!numberset(a)) {
                        System.out.println("Solution #" + num + ": Only single digit integers from 1-9 are considered to be valid in sudoku. Please check your numbers."); 
                        // If you have a number that is not 1-9, you will get an error message.
                        return;
                    }
                    if (checking(a)) {
                        System.out.println("Solution #" + num + ": This is a valid sudoku solution."); 
                        //If a solution is valid, it will be indicated here.
                    } else {
                        System.out.println("Solution #" + num + ": This is an invalid sudoku solution. Make sure to check that each column and row of the solution are unique from 1 - 9."); 
                        //If a solution is invalid, it will be indicated here.
                    }
                    num += 1;
                }
            } catch (Exception e) {
                System.out.println("Error. The file can only be a .txt file only.");
            } finally {
                System.out.print("Try again? Hit '1' for yes or '0' for no: ");
                repeat = input.nextInt();
            }
        }
    }
}