package by.training;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

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
    }

    public void printTable() {
        BigDecimal tmp = min;
        if (max.compareTo(min) > 0) {
            Object[][] table = new String[max.subtract(min).divide(step, RoundingMode.HALF_UP).add(new BigDecimal(2)).abs().intValue()][];
            table[0] = new String[] { "argument", "result"};
            for (int count = 0; tmp.compareTo(max) <= 0;) {
                count = count + 1;
                table[count] = new String[] { tmp.setScale(6, ROUND_HALF_UP).toString(), calculate(tmp).setScale(6, ROUND_HALF_UP).toString()};
                tmp = tmp.add(step);
            }
            for (final Object[] row : table) {
                System.out.format("%15s%15s\n", row);
            }
        }


    }

    private BigDecimal calculate(BigDecimal arg) {
        return arg.add(new BigDecimal(1));
    }


}
