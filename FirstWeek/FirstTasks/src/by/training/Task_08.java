package by.training;

import java.math.BigInteger;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// В массив A [N] занесены натуральные числа.
// Найти сумму тех элементов, которые кратны данному К.

public class Task_08 {

    public BigInteger calculateSum(int multiplier, int... array) {
        BigInteger sum = BigInteger.ZERO;
        for (int k: array) {
            if (k % multiplier == 0) {
                sum = sum.add(BigInteger.valueOf(k));
            }
        }
        return sum;
    }
}
