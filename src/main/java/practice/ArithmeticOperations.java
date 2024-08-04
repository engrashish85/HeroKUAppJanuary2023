package practice;

public class ArithmeticOperations {

    int result;
    public static void main(String[] args) {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        arithmeticOperations.assignment1();
        arithmeticOperations.assignment2();
    }

    private int sum(int a, int b) {
        return a+b;
    }

    private int multiply(int a, int b) {
        return a*b;
    }

    private int divide(int a, int b) {
        return a/b;
    }

    private int subtract (int a, int b) {
        return a-b;
    }

    private void assignment1() {
        result = sum(10, 2);
        result = sum(result, 2);
        result = subtract(result, 2);
        result = multiply(result, 2);
        result = divide(result, 2);
        System.out.println("Assignment 1 result is - "+result);
    }

    private void assignment2() {
        result = multiply(10, 2);
        result = sum(result, 2);
        result = subtract(result, 2);
        result = subtract(result, 2);
        result = divide(result, 2);
        System.out.println("Assignment 2 result is - "+result);
    }
}
