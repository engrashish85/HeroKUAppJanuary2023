package practice;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        System.out.println("Please enter 1st side - ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Please enter 2nd side - ");
        scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        System.out.println("Please enter 3rd side - ");
        scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        if ((a+b > c) && (b+c > a) && (c+a > b)) {
            System.out.println("These sides can form a triangle");
        } else {
            System.out.println("These sides can't form a triangle");
        }
    }
    
    
}
