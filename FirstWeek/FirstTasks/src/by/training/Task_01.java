package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Составить линейную программу, печатающую значение true,
// если указанное высказывание является истинным,
// и false — в противном случае:
// Сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр.

public class Task_01 {

    private int[] num;
    private String tmp;

    public Task_01(Number number) {
        tmp = number.toString();
    }


    public boolean calculate() {
        if(tmp.length() != 4) {
            return false;
        }

        tmp = tmp.replaceAll("\\D+", "");
        num = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++){
            num[i] = tmp.charAt(i);
        }

        return num[0] + num[1] == num[tmp.length() - 1] + num[tmp.length() - 2];

    }

}
