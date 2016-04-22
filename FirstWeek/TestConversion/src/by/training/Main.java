package by.training;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //precision loss long to double
        long max = 9223372036854315137L;
        double same = max;

        System.out.println("actual long:   " + max);
        System.out.println("actual double: " + new BigDecimal(same).toString());
        System.out.println("sysout double: " + same);

        System.out.println("difference: " + (max - (long)same));

        System.out.println();


        //precision float to double
        float f = 1.123456789123456789123456789123456781234567890f;
        double sameD = f;

        System.out.println("sysout float:  " + f); //tricky printing
        System.out.println("sysout double: " + sameD); //tricky printing

        System.out.println("actual float:  " + new BigDecimal(f).toString()); //raw numbers
        System.out.println("actual double: " + new BigDecimal(sameD).toString()); //raw numbers

        System.out.println("difference1: " + new BigDecimal(sameD - f).toString());
        System.out.println("difference2: " + (sameD - f));

    }
}