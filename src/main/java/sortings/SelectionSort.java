package sortings;

/**
 * Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest)
 * element from the unsorted portion of the list and moving it to the sorted portion of the list.
 * geekForgeeks link : https://www.geeksforgeeks.org/selection-sort/
 */
public class SelectionSort implements Sort {
    public static void main(String[] args) {
        // int[] a = new int[]{12, 11, 13, 5, 6, 7};
        int[] a = new int[]{10, 80, 30, 90, 40, 70, 50};
        Sort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    @Override
    public void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    //Selecting the maximum ele and placing it at the end
    public void sort2(int[] a) {

        for (int i = a.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(a, i, maxIndex);
        }
    }

}
