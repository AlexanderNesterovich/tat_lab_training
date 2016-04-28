package by.training;

import java.math.BigDecimal;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Даны три действительных числа.
// Возвести в квадрат те из них,
// значения которых неотрицательны,
// и в четвертую степень — отрицательные.

public class Task_05 {

    public BigDecimal getPowA(Number numA) {
        BigDecimal a = new BigDecimal(numA.toString());
        return calculate(a);
    }

    public BigDecimal getPowB(Number numB) {
        BigDecimal b = new BigDecimal(numB.toString());
        return calculate(b);
    }

    public BigDecimal getPowC(Number numC) {
        BigDecimal c = new BigDecimal(numC.toString());
        return calculate(c);
    }

    private BigDecimal calculate(BigDecimal tmp) {
        if (tmp.compareTo(BigDecimal.ZERO) > 0) {
            return tmp.pow(2);
        }else if(tmp.compareTo(BigDecimal.ZERO) < 0) {
            return tmp.pow(4);
        }else{
            return tmp;
        }
    }
}


