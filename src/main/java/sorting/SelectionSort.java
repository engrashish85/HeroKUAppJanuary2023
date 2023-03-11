package sorting;

public class SelectionSort extends BubbleSort {
    public static void main(String[] args) {
        for (int unsortedIndex = a.length - 1; unsortedIndex > 0; unsortedIndex --) {
            int largest = 0;
            for (int i = 1; i <= unsortedIndex; i++) {
                if (a[i] > a[largest]) {
                    largest = i;
                }
            }
            swap(a, largest, unsortedIndex);
        }
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
        }
    }

}
