/* 6.23 (Occurrences of a specified character) Write a method that finds
the number of occurrences of a specified character in a string using the
following header:
public static int count(String str, char a)
For example, count("Welcome", 'e') returns 2 . Write a test program that
prompts the user to enter a string followed by a character then displays
the number of occurrences of the character in the string. */

import java.util.Scanner;
public class occurencesofaspecified {
    public static void main(String[] args) {
        try {
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("Welcome, type 'e' to continue. ");
                String stringprogram = input.nextLine();
                if (stringprogram.equals("e")) {
                    System.out.println("Please enter a string only containing letters. No spaces, special characters, or numbers. ");
                    String thestring = input.nextLine();
                    if(!thename(thestring)) throw new IllegalArgumentException("Please enter a valid string.");
                    System.out.println("Type in one letter to continue: ");
                    String search = input.next();
                    char c = search.charAt(0);
                    if(search.length() != 1) throw new IllegalArgumentException("Please enter a valid string.");
                    if(!thesymbol(c)) throw new IllegalArgumentException("Please enter a valid string.");
                    int numb = count(thestring, c);

                    System.out.println("The occurrence(s) for " + c +  " in " + thestring + " is " + numb + " .");

                } else  {
                    System.out.print("This is the end of the program.");
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static int count(String str, char a) {
        int count = 0;
        for (int n = 0; n < str.length(); n++) {
            if (str.charAt(n) == a) count++;
        }
        return count;
    }
    public static boolean thesymbol(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
    public static boolean thename(String name) {
        return name.matches("[a-zA-Z]+");
    }
}