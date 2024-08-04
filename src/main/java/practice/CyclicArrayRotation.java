package practice;

import java.util.Scanner;

public class CyclicArrayRotation {
    public static void main(String[] args) {
        int[]array = new int[]{1,2,3,4};
        System.out.println("Enter number of times array should be rotated");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            array = new CyclicArrayRotation().shiftByOne(array);
            new CyclicArrayRotation().printArray(array);
        }
    }

    private int[] shiftByOne(int[] array) {
        int lastElement = array[array.length - 1];
        for (int i = array.length-1; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = lastElement;
        return array;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + ",");
        }
    }
}
