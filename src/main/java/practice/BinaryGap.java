package practice;

import java.util.Scanner;

public class BinaryGap {
    public int returnGap(int n) {
        int maxGap = 0;
        int currentGap = 0;
        String binaryNumber = Integer.toBinaryString(n);
        System.out.println("Binary number is - "+binaryNumber);
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '1') {
                if (currentGap >= maxGap) {
                    maxGap = currentGap;
                }
            } else {
                currentGap = currentGap + 1;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number - ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Gap is - "+new BinaryGap().returnGap(number));
    }
}
