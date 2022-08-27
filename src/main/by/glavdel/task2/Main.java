package main.by.glavdel.task2;

import java.util.Arrays;

public class Main {

    public static final int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
    public static boolean isSort = false;

    public static void main(String[] args) {
        sort(array, 0, array.length - 1);

        assert isSort : "array not sorted";
        assert array[2] == 3 : "the third element isn't right";
        assert Arrays.equals(array, new int[]{1, 2, 3, 4, 5, 5, 6, 9});
    }

    public static void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int point = split(array, begin, end);
        sort(array, begin, point - 1);
        sort(array, point + 1, end);
        isSort = true;
    }

    static int split(int[] array, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;

        return counter;
    }
}
