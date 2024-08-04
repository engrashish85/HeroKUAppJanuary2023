package practice;

import java.util.Arrays;

public class OperationCounters {
    public void increaseCounter(int[] inputArray, int[] array) {
        int maxCounter = 0;
        int currentCounter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < array.length + 1) {
                array[inputArray[i]-1] = array[inputArray[i]-1] + 1;
                currentCounter = array[inputArray[i]-1] + 1;
                if (maxCounter <= currentCounter) {
                    maxCounter = currentCounter;
                }
            } else if (inputArray[i] == array.length + 1) {
                Arrays.fill(array, maxCounter);
            } else {
                System.out.println("Invalid integer value given");
            }
        }
        new CyclicArrayRotation().printArray(array);
    }

    public static void main(String[] args) {
        new OperationCounters().increaseCounter(new int[]{2,5,5,5,3,4,6,7,8}, new int[]{0,0,0,0,0,0,0});
    }
}
