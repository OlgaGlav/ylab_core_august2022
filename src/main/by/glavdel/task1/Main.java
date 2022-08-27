package main.by.glavdel.task1;

public class Main {
    public static final int ROW_LENGHT = 5;
    private static final int COLUMN_LENGHT = 5;
    private static final int[][] array = new int[ROW_LENGHT][COLUMN_LENGHT];

    public static int multiplierForRandom = 37;
    public static int summandForRandom = 119;
    public static int dividerForRandom = 113;
    public static int randomNumber = 1;


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
        for (int i = 0; i < ROW_LENGHT; i++) {
            for (int j = 0; j < COLUMN_LENGHT; j++) {
                array[i][j] = getNextInt();
            }
        }
    }

    private static int getNextInt() {
        randomNumber = (multiplierForRandom * randomNumber + summandForRandom)
                * (-1) % dividerForRandom;
        return randomNumber;
    }
}
