package by.training;

import java.math.BigInteger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_08 {

    private int[] array;
    private int multiplier;

    public Task_08(int multiplier, int... arr ) {
        this.array = arr;
        this.multiplier = multiplier;
    }

    public BigInteger getSpecialSum() {
        BigInteger sum = BigInteger.ZERO;
        for (int k: array) {
            if (k % multiplier == 0) {
                sum = sum.add(BigInteger.valueOf(k));
            }
        }
        return sum;
    }
}
