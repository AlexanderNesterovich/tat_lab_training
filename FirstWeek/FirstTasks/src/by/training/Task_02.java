package by.training;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Вычислить значение выражения по формуле (все переменные принимают действительные значения):
public class Task_02 {

    private int precision = 1000;
    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;

    public Task_02(Number a, Number b, Number c) {
        this.a = new BigDecimal(a.toString());
        this.b = new BigDecimal(b.toString());
        this.c = new BigDecimal(c.toString());
    }

    public String calculate() {
        MathContext mc = new MathContext(precision);
        BigDecimal top = new BigDecimal(4).multiply(a).multiply(c);
        top = top.add(b.pow(2));

        try {
            top = Utils.bigSqrt(top, mc);
        } catch (ArithmeticException e) {
            return "SQUARE ROOT OF A NEGATIVE NUMBER";
        }

        top = top.add(b);

        BigDecimal bottom = a.multiply(new BigDecimal(2));
        if(bottom.equals(BigDecimal.ZERO)) {
            return "DIVISION BY ZERO";
        }

        BigDecimal tail = a.pow(3).multiply(c);
        tail = tail.add(b.pow(-2, mc));

        BigDecimal result = top.divide(bottom, RoundingMode.HALF_UP).subtract(tail);
        return result.setScale(9, ROUND_HALF_UP).toString();

    }

}
