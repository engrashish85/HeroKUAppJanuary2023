package sorting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Factorial {

    @BeforeClass
    public void beforeFactorial() {
        System.out.println("Before factorial Test");
    }

    @Test(groups = "factorial")
    public void factorial(){
        System.out.println("Method name is - factorial");
        int number = recursiveFactorial(10);
        System.out.println(number);
    }

    @AfterClass
    public void afterFactorialTest() {
        System.out.println("After factorial test");
    }

    public static int recursiveFactorial (int num) {
        if (num == 0) {
            return 1;
        }
        return num*recursiveFactorial(num - 1);
    }

}
