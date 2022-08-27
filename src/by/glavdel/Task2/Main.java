package by.glavdel.Task2;

public class Main {

    public static final int[] array = {5, 6, 3, 2, 5, 1, 4, 9};

    public static void main(String[] args) {
        sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int point = split(array, begin, end);
        sort(array, begin, point - 1);
        sort(array, point + 1, end);
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
