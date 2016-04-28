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

    public String calculate(Number numA, Number numB, Number numC) {
        BigDecimal a = new BigDecimal(numA.toString());
        BigDecimal b = new BigDecimal(numB.toString());
        BigDecimal c = new BigDecimal(numC.toString());
        MathContext mc = new MathContext(150);
        BigDecimal top = new BigDecimal(4).multiply(a).multiply(c);
        top = top.add(b.pow(2));

        try {
            top = Utils.bigSqrt(top, mc);
        } catch (ArithmeticException e) {
            return "SQUARE ROOT OF A NEGATIVE NUMBER";
        }

        top = top.add(b);

        BigDecimal bottom = a.multiply(new BigDecimal(2));
        if (bottom.equals(BigDecimal.ZERO)) {
            return "DIVISION BY ZERO";
        }

        BigDecimal tail = a.pow(3).multiply(c);
        tail = tail.add(b.pow(-2, mc));

        BigDecimal result = top.divide(bottom, RoundingMode.HALF_UP).subtract(tail);
        return result.setScale(9, ROUND_HALF_UP).toString();

    }

}