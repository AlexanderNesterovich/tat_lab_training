package by.training;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Вычислить периметр и площадь прямоугольного треугольника по длинам а и b  двух катетов.

public class Task_03 {

    public BigDecimal getPeremiter(Number numA, Number numB) {
        BigDecimal a = new BigDecimal(numA.toString());
        BigDecimal b = new BigDecimal(numB.toString());
        checkPositive(a, b);
        BigDecimal c = getHypotenuse(a, b);
        return a.add(b).add(c).setScale(9, ROUND_HALF_UP);
    }


    public BigDecimal getHypotenuse(Number numA, Number numB) {
        BigDecimal a = new BigDecimal(numA.toString());
        BigDecimal b = new BigDecimal(numB.toString());
        checkPositive(a, b);
        BigDecimal c = a.pow(2).add(b.pow(2));
        c = Utils.bigSqrt(c, new MathContext(150));
        return c;
    }

    public BigDecimal getArea(Number numA, Number numB) {
        BigDecimal a = new BigDecimal(numA.toString());
        BigDecimal b = new BigDecimal(numB.toString());
        checkPositive(a, b);
        return a.multiply(b).multiply(new BigDecimal("1.5"));
    }

    private void checkPositive(BigDecimal a, BigDecimal b) {
        if (a.compareTo(BigDecimal.ZERO) > 0 & b.compareTo(BigDecimal.ZERO) > 0) {

        } else {
            throw new IllegalArgumentException();
        }
    }

}