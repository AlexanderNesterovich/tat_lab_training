package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):

public class Task_10 {

    private int n;

    public Task_10(int n) {
        if (n < 0 | n % 2 != 0) {
            throw new IllegalArgumentException("order is odd or less than 0");
        }
        this.n = n;
    }

    public String[][] generateMatrix() {
        String[][] tmp = new String[n][n];
        for (int k = 0; k < n; k = k + 2) {
            for (int l = 0; l < n; l++) {
                tmp[k][l] = Integer.toString(l + 1);
                tmp[k + 1][l] = Integer.toString(n - l);
            }
        }
        return tmp;
    }
}
