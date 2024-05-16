package sortings;

public interface Sort {

    void sort(int[] a);

    default void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
