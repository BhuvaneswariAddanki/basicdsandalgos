package sortings;

/**
 * Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its correct position in a sorted portion of the list.
 * It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.
 * <p>
 * Insertion sort is like sorting playing cards in your hands. You split the cards into two groups:
 * the sorted cards and the unsorted cards. Then, you pick a card from the unsorted group and put it in the right place in the sorted group.
 * <p>
 * geekForGeeks link : https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort implements Sort {
    /**
     * To achieve insertion sort, follow these steps:
     * <p>
     * We have to start with second element of the array as first element in the array is assumed to be sorted.
     * Compare second element with the first element and check if the second element is smaller then swap them.
     * Move to the third element and compare it with the second element, then the first element and swap as necessary to put it in the correct position among the first three elements.
     * Continue this process, comparing each element with the ones before it and swapping as needed to place it in the correct position among the sorted elements.
     * Repeat until the entire array is sorted.
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // int[] a = new int[]{12, 11, 13, 5, 6, 7};
        int[] a = new int[]{10, 80, 30, 90, 40, 70, 50};
        Sort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

}
