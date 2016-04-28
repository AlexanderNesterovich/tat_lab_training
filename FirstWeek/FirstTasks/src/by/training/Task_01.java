package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Составить линейную программу, печатающую значение true,
// если указанное высказывание является истинным,
// и false — в противном случае:
// Сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр.

public class Task_01 {

    public boolean calculate(Number number) {
        int[] num;
        String tmp;
        tmp = number.toString();
        tmp = tmp.replaceAll("\\D+", "");
        if (tmp.length() != 4) {
            return false;
        }
        num = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++) {
            num[i] = tmp.charAt(i);
        }

        return num[0] + num[1] == num[tmp.length() - 1] + num[tmp.length() - 2];

    }

}
