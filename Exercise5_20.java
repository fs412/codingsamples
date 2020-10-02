/* *5.20 (Display prime numbers between 2 and 1,000) Modify the program
given in Listing 5.15 to display all the prime numbers between 2 and
1,000, inclusive. Display eight prime numbers per line. Numbers are
separated by exactly one space.

5.20/6.10 as a single program to display the first 50 primes numbers

*/
public class Exercise5_20 {
    public static void main(String[] args) {
        final int maxnumber = 50;
        final int primenumber = 8;
        int count = 0;
        int number = 2;
        System.out.println("The first 50 primes numbers: ");
        while (number <= maxnumber) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false; 
                    break;
                }
            }
            if (isPrime) {
                count++;
                if (count % primenumber == 0) {
                    System.out.println(number);
                }
                else
                System.out.print(number + " ");
            }
            number++;
        }
    }
}

