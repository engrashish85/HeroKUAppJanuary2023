package practice;

public class SwapNumbers {
    int c = 0;
    int a = 12;
    int b = 15;

    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        swapNumbers.swapNumbers();
        swapNumbers.swapNumbersWithoutThirdVariable();
    }

    private void swapNumbers() {
        c = a;
        a = b;
        b = c;
        System.out.println("a is - "+a);
        System.out.println("b is - "+b);
    }

    private void swapNumbersWithoutThirdVariable() {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a is - "+a);
        System.out.println("b is - "+b);
    }


}
