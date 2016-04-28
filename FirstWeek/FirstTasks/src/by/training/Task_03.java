package by.training;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Вычислить периметр и площадь прямоугольного треугольника по длинам а и b  двух катетов.

public class Task_03 {

    private int precision = 150;
    private MathContext mc = new MathContext(precision);
    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;

    public Task_03(Number a, Number b) {
        this.a = new BigDecimal(a.toString());
        this.b = new BigDecimal(b.toString());
        if(!checkPositive()) {
            throw new IllegalArgumentException("Negative Triangle Side");
        }
    }

    public BigDecimal getPeremiter(Number a, Number b) {
        getHypotenuse();
        return a.add(b).add(c).setScale(9, ROUND_HALF_UP);
    }


    private BigDecimal getHypotenuse() {
        if (c == null) {
            c = a.pow(2).add(b.pow(2));
            c = Utils.bigSqrt(c, mc);
            return c;
        }
            return c;
    }

    public BigDecimal getArea() {
        getHypotenuse();
        return a.multiply(b).multiply(new BigDecimal("1.5"));
    }

    private boolean checkPositive() {

        return a.compareTo(BigDecimal.ZERO) > 0 & b.compareTo(BigDecimal.ZERO) > 0;
    }

}
