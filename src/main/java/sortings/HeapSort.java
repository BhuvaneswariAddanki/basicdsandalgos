package sortings;

public class HeapSort implements Sort {
    public static void main(String[] args) {
        // int[] a = new int[]{12, 11, 13, 5, 6, 7};
        int[] a = new int[]{10, 80, 30, 90, 40, 70, 50};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
    @Override
    public void sort(int[] a) {

        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            heapify(a, i, 0);
        }
    }

    private void heapify(int[] a, int length, int i) {
        int parent = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && a[left] > a[parent]) {
            parent = left;
        }
        if (right < length && a[right] > a[parent]) {
            parent = right;
        }
        if (parent != i) {
            swap(a, parent, i);
            heapify(a, length, parent);
        }

    }
}
