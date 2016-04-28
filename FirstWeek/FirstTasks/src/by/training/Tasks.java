package by.training;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/28/2016.
 */
public class Tasks {

    public boolean calculateTask01(Number number) {
        String tmp = number.toString();
        tmp = tmp.replaceAll("\\D+", "");
        if (tmp.length() != 4) {
            return false;
        }
        int[] num = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++) {
            num[i] = tmp.charAt(i);
        }

        return num[0] + num[1] == num[tmp.length() - 1] + num[tmp.length() - 2];

    }

    public String calculateTask02(Number a1, Number b1, Number c1) {
        int precision = 1000;
        BigDecimal a = new BigDecimal(a1.toString());
        BigDecimal b = new BigDecimal(b1.toString());
        BigDecimal c = new BigDecimal(c1.toString());
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
        if (bottom.equals(BigDecimal.ZERO)) {
            return "DIVISION BY ZERO";
        }

        BigDecimal tail = a.pow(3).multiply(c);
        tail = tail.add(b.pow(-2, mc));

        BigDecimal result = top.divide(bottom, RoundingMode.HALF_UP).subtract(tail);
        return result.setScale(9, ROUND_HALF_UP).toString();

    }


}
