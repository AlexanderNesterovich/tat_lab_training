package by.training;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_07 {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal step;

    public Task_07(Number min, Number max, Number step) {

        this.min = new BigDecimal(min.toString());
        this.max = new BigDecimal(max.toString());
        this.step = new BigDecimal(step.toString());

        if (this.max.compareTo(this.min) > 0) {
            throw new IllegalArgumentException("Negative Triangle Side");
        }
    }

    public String[][] printTable() {
        BigDecimal tmp = min;
        String[][] table = new String[max.subtract(min).divide(step, RoundingMode.HALF_UP).add(new BigDecimal(2)).abs().intValue()][];
            table[0] = new String[] { "argument", "result"};
            for (int count = 0; tmp.compareTo(max) <= 0;) {
                count = count + 1;
                table[count] = new String[] { tmp.setScale(6, ROUND_HALF_UP).toString(), calculate(tmp).setScale(6, ROUND_HALF_UP).toString()};
                tmp = tmp.add(step);
            }
        return table;
    }

    private BigDecimal calculate(BigDecimal arg) {
        return new BigDecimal(0);
    }


}
