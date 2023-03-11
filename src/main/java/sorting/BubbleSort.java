package sorting;

public class BubbleSort {
    static int[] a = {20, 35, -15, 7, 55, 1, -22};

    public static void main(String[] args) {

        for (int lastUnsortedIndex = a.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex --) {
            for (int i = 0; i < lastUnsortedIndex; i ++) {
                if (a[i] > a[i+1]) {
                    swap(a, i, i+1);
                }
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
        }

    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
