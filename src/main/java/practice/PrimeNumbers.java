package practice;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        boolean prime = true;
        System.out.println("Please enter the number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 2; i <=  number/2; i++) {
            if ((number%i)==0) {
                prime = false;
                System.out.println("Number "+ number + " is not prime");
                break;
            }
        }
        if (prime) {
            System.out.println("Number "+ number + " is prime");
        }
    }
}
