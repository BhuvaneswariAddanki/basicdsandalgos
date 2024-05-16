package sortings;

/**
 *
 */
public class QuickSort {

    public static void main(String[] args) {
       // int[] a = new int[]{12, 11, 13, 5, 6, 7};
        int[] a = new int[] {10, 80, 30, 90, 40,70,50};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        quickSort(a, 0, a.length-1);

    }

    private void quickSort(int[] a, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int pivotEle = a[low];
        while (i < j) {
            while (i <= high && a[i] <= pivotEle) {
                i++;
            }
            while (j >= 0 && a[j] > pivotEle) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, j, low);
        return j;

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
