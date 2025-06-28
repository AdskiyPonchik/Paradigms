package Blatt_11;
import java.util.Arrays;

interface Map<T> {
    T map(T elem);
}

class Mapper<T> implements Runnable {
    private final T[] arr;
    private final int start;
    private final int count;
    private final Map<T> mapFunc;

    public Mapper(T[] arr, int startIndex, int count, Map<T> mapFunc) {
        this.arr = arr;
        this.start = startIndex;
        this.count = count;
        this.mapFunc = mapFunc;
    }

    public void run() {
        for (int i = start; i < start + count && i < arr.length; i++) {
            arr[i] = mapFunc.map(arr[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[100];
        Arrays.setAll(data, i -> i); // [0, 1, 2, ..., 99] generator

        Map<Integer> squareFunc = x -> x * x;  //test quadratic function

        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        int chunk = (int) Math.ceil((double) data.length / cores);

        for (int i = 0; i < cores; i++) {
            int start = i * chunk;
            int len = Math.min(chunk, data.length - start);
            threads[i] = new Thread(new Mapper<>(data, start, len, squareFunc));
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Ergebnis: " + Arrays.toString(data));
    }
}
