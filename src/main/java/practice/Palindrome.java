package practice;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Please enter String - ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Palindrome palindrome = new Palindrome();
        palindrome.validatePalindrome(str);
    }

    public void validatePalindrome(String str) {
        int strLength = str.length();
        String reverseStr = "";
        for (int i = (strLength -1); i >= 0; i--) {
            reverseStr = reverseStr + str.charAt(i);
        }
        if (str.toUpperCase().equals(reverseStr.toUpperCase())) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is NOT palindrome");
        }
    }
}
