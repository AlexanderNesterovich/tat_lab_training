package by.training;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //precision loss long to double
        long max = 9223372036854315137L;
        double same = max;

        System.out.println("long: " + max);
        System.out.println("actual double: " + new BigDecimal(same).toString());
        System.out.println("sysout double: " + same);

        System.out.println("difference: " + (max - (long)same));

        System.out.println();
        //precision float to double

        float f = 12.1234567890123456789345674567f;
        double d = f;

        System.out.println("sysout float: " + f); //System.out.println tricks for "cool" printing
        System.out.println("sysout double: " + d); //System.out.println tricks for "cool" printing

        System.out.println("actual float: " + new BigDecimal(f).toString()); //actual numbers
        System.out.println("actual double: " + new BigDecimal(d).toString()); //actual numbers

        System.out.println("difference1: " + new BigDecimal(d - f).toString());
        System.out.println("difference2: " + (d - f));

    }
}