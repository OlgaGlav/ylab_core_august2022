package by.glavdel.Task1;

import java.util.Random;

public class Main {
    public static final int ROW_LENGHT = 3;
    private static final int COLUMN_LENGHT = 5;
    public static final int MAX_VALUE_ELEMENT = 100;
    private static final int[][] array = new int[ROW_LENGHT][COLUMN_LENGHT];

    private static final double[] results = new double[3];


    public static void main(String[] args) {

        initArray();
        findResults();

        System.out.printf("Min is %d, max is %d, average is %f", (int) results[0], (int) results[1], results[2]);
    }

    private static void findResults() {
        int min = array[0][0];
        int max = array[0][0];
        int summ = 0;

        for (int i = 0; i < ROW_LENGHT; i++) {
            for (int j = 0; j < COLUMN_LENGHT; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                } else if (array[i][j] > max) {
                    max = array[i][j];
                }
                summ = summ + array[i][j];
            }
        }

        results[0] = min;
        results[1] = max;
        results[2] = (double) (summ) / (ROW_LENGHT + COLUMN_LENGHT);
    }

    private static void initArray() {
        Random random = new Random();
        for (int i = 0; i < ROW_LENGHT; i++) {
            for (int j = 0; j < COLUMN_LENGHT; j++) {
                array[i][j] = random.nextInt(MAX_VALUE_ELEMENT);
            }
        }
    }
}
