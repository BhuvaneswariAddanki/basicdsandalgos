package sortings;

/**
 * Merge sort is a popular sorting algorithm known for its efficiency and stability. It follows the divide-and-conquer approach to sort a given array of elements.
 * <p>
 * Here’s a step-by-step explanation of how merge sort works:
 * <p>
 * Divide: Divide the list or array recursively into two halves until it can no more be divided.
 * Conquer: Each subarray is sorted individually using the merge sort algorithm.
 * Merge: The sorted subarrays are merged back together in sorted order.
 * The process continues until all elements from both subarrays have been merged.
 *
 * GeekForgeeks link : https://www.geeksforgeeks.org/merge-sort/
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{12, 11, 13, 5, 6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);

    }

    private void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int l1 = low;
        int l2 = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while (l1 <= mid && l2 <= high) {
            if (a[l1] > a[l2]) {
                temp[k++] = a[l2++];
            } else {
                temp[k++] = a[l1++];
            }
        }
        while (l1 <= mid) {
            temp[k++] = a[l1++];
        }
        while (l2 <= high) {
            temp[k++] = a[l2++];
        }
        k = 0;
        for (int i = low; i <= high; i++) {
            a[i] = temp[k++];
        }
    }
}
