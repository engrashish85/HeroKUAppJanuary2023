package practice;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println("Please enter number - ");
        Scanner scanner = new Scanner(System.in);
        String str = String.valueOf(scanner.nextInt());
        Integer[] arrStr = new Integer[str.length()];
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            arrStr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            number = (int) (number + Math.pow(arrStr[i], 3));
        }
        if (Integer.parseInt(str) == number) {
            System.out.println("Number is armstrong");
        } else {
            System.out.println("Number is NOT armstrong");
        }
    }
}
