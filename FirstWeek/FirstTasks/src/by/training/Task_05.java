package by.training;

import java.math.BigDecimal;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_05 {


    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;

    public Task_05(Number a, Number b, Number c) {
        this.a = new BigDecimal(a.toString());
        this.b = new BigDecimal(b.toString());
        this.c = new BigDecimal(c.toString());
    }

    public BigDecimal getPowA() {
        return calculate(a);
    }
    public BigDecimal getPowB() {
        return calculate(b);
    }
    public BigDecimal getPowC() {
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


