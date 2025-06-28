package Blatt_11;
import java.io.InterruptedIOException;
import java.util.*;

public class MergeSort {
    private static final Random RNG = new Random(42); // random number generator

    public static void main(String[] args) {
        int LENGTH = 1024; // initial length of array to sort
        int RUNS = 12; // how many times to grow by 2?

        for (int i = 1; i <= RUNS; i++) {
            int[] a = createRandomArray(LENGTH);

            // run the algorithm and time how long it takes
            long start = System.currentTimeMillis();
            parallelMergeSort(a, 1);
            long duration = System.currentTimeMillis() - start;

            if (!isSorted(a)) {
                throw new RuntimeException("not sorted afterward: " + Arrays.toString(a));
            }

            System.out.printf("%10d elements  =>  %6d ms%n", LENGTH, duration);
            LENGTH *= 2; // double size of array for next time
        }
    }

    public static void parallelMergeSort(int[] a, int threadCount) {
        if (threadCount <= 1) {
            mergeSort(a);
        } else if (a.length >= 2) {
            // TODO: implement multithreading
            int mid = a.length/2;
            int[] left = Arrays.copyOfRange(a, 0, mid);
            int[] right = Arrays.copyOfRange(a, mid, a.length);
            Thread leftthread = new Thread(() -> parallelMergeSort(left, threadCount/2));
            Thread rightthread = new Thread(()-> parallelMergeSort(right, threadCount/2));
            leftthread.start();
            rightthread.start();
            try{
                leftthread.join();
                rightthread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            merge(left, right, a);
        }
    }

    // Arranges the elements of the given array into sorted order
    // using the "merge sort" algorithm, which splits the array in half,
    // recursively sorts the halves, then merges the sorted halves.
    // It is O(N log N) for all inputs.
    public static void mergeSort(int[] a) {
        if (a.length >= 2) {
            // split array in half
            int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            // sort the halves
            mergeSort(left);
            mergeSort(right);

            // merge them back together
            merge(left, right, a);
        }
    }

    // Combines the contents of sorted left/right arrays into output array a.
    // Assumes that left.length + right.length == a.length.
    public static void merge(int[] left, int[] right, int[] a) {
        int j = 0;
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (k >= right.length || (j < left.length && left[j] < right[k])) {
                a[i] = left[j];
                j++;
            } else {
                a[i] = right[k];
                k++;
            }
        }
    }

    // Returns true if the given array is in sorted ascending order.
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Creates an array of the given length, fills it with random
    // non-negative integers, and returns it.
    public static int[] createRandomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = RNG.nextInt(1_000_000);
        }
        return a;
    }
    
    
}