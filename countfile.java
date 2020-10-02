/* 12.13 (Count characters, words, and lines in a file) Write a
program that will count the number of characters, words, and lines
in a file. Words are separated by whitespace characters. The file
name should be passed as a command-line argument, as shown
in Figure 12.13 .
Figure 12.13
The program displays the number of characters, words, and lines
in the given file.
*/

import java.util.Scanner;
import java.io.File;
import javax.swing.JFileChooser;

public class countfile {
	public static void main(String[] args) {
		int thenumber = 1;
		while(thenumber == 1) {
			try {
				JFileChooser chooser = new JFileChooser();
				int valuelabel = chooser.showOpenDialog(null);
				String filename = chooser.getSelectedFile().getName();
				if (valuelabel == JFileChooser.APPROVE_OPTION) {
					System.out.println("Name of file: " + filename);
				}
				File file = chooser.getSelectedFile();
				Scanner fileInput = new Scanner(file);
				int totalcharacter = 0;
				int totalword = 0;
				int totaline = 0;
				int characterwithspace = 0;
				while (fileInput.hasNext()) {
					String s = fileInput.nextLine();
					totalword = totalwordFunc(s) + totalword; 
					totalcharacter = s.length() + totalcharacter;
					characterwithspace = characterwithspaceFunc(s) + characterwithspace;
					totaline++;
				}
                int chartotal = totalcharacter - characterwithspace;
                System.out.println("Number of characters: " + chartotal);
				System.out.println("Number of words: " + totalword);
				System.out.println("Number of lines: " + totaline);
				fileInput.close();
			}
			catch (Exception e) {
				System.out.println("Error opening file. File not opened.");
			}
			Scanner intInput = new Scanner(System.in);
			System.out.print("Would you like to run another file? Type 1 to continue, 0 to end. ");
			thenumber = intInput.nextInt();
		}
		System.out.println("End of program.");
	}
	public static int totalwordFunc(String s) {
		int countofthewords = 0;
		Scanner inputofword = new Scanner(s);
		
		while (inputofword.hasNext()) {
			String word = inputofword.next();
			countofthewords++;
		}
		return countofthewords;
	}
	public static int characterwithspaceFunc(String s) {
		int countofspace = 0;
		for(int n = 0;n < s.length(); n++) {
			char ch = s.charAt(n);
			if(ch == ' ') {
				countofspace++;
			}		
		}
		return countofspace;
	}
}