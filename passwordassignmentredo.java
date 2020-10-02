/* 6.18 (Check password) Some Websites impose certain rules for
passwords. Write a method that checks whether a string is a valid
password. Suppose the password rules are as follows:
A password must have at least eight characters.
A password must contain only letters and digits.
A password must contain at least two digits.
Write a program that prompts the user to enter a password and displays
Valid Password if the rules are followed, or Invalid Password otherwise.
*/

import java.util.Scanner;

public class passwordassignmentredo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("Enter a password: The password must have at least eight characters, only letters and digits, and at least two digits. ");
            String s = input.nextLine();
            if (thepassword(s)) {
                System.out.println("Valid Password");
                continue;
            } else {
                System.out.println("Invalid Password");
            }
        }
    }
    public static boolean thepassword(String password) {
        boolean thepassword = true;
    if (password.length() < 8) {
        thepassword = false;
    } else { 
        int totaldigits = 0;
        for (int n = 0; n < password.length(); n++) {
            if (thedigit(password.charAt(n)) || theletter(password.charAt(n))) {
                if (thedigit(password.charAt(n))) {
            totaldigits++;
            }
            } else { 
            thepassword = false;
            break;
            }
        }
        if (totaldigits < 2) { 
            thepassword = false;
        }
    }
    return thepassword;
}
public static boolean theletter(char c) {
    return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
}
public static boolean thedigit(char c) {
    return (c >= '0' && c <= '9');
    }
}