package by.training;

import java.text.DecimalFormat;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

//Составить программу для вычисления значений функции  F(x) на отрезке [а, b] с шагом h.
// Результат представить в виде таблицы,
// первый столбец которой – значения  аргумента,
// второй - соот­ветствующие значения функции:

public class Task_07 {

    private Double min;
    private Double max;
    private Double step;

    public Task_07(Double min, Double max, Double step) {

        this.min = min;
        this.max = max;
        this.step = step;

        if (max < min) {
            throw new IllegalArgumentException("Negative Range");
        }
    }

    public String[][] getTable() {
        Double size = max-min/step;
        Double tmp = min;
        String[][] table = new String[size.intValue() - 3][];
        table[0] = new String[] { "argument", "result"};
            for (int count = 0; tmp <= max; tmp = tmp + step) {
                count = count + 1;
                table[count] = new String[] { Double.toString(tmp), calculate(tmp)};
            }
        return table;
    }

    private String calculate(double arg) {
        double result;
        result = Math.sin(Math.toRadians(arg));
        result = Math.pow(result, 2);
        result = result - Math.cos(Math.toRadians(arg)*2);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(result);
    }


}
