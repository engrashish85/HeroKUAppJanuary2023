package practice;

public class ConstructorPractice {
    public static void main(String[] args) {
        ConstructorPractice constructorPractice = new ConstructorPractice();
        ConstructorPractice constructorPractice1 = new ConstructorPractice(10);
    }

    public ConstructorPractice() {
        this(1, 2, 3);
        System.out.println("default constructor");
    }
    public ConstructorPractice(int a) {
        this(1, 2);
        System.out.println("one parameterized constructor");
    }
    public ConstructorPractice(int a, int b) {
        System.out.println("Two parameterized constructor");
    }
    public ConstructorPractice(int a, int b, int c) {
        System.out.println("Three parameterized constructor");
    }
}
