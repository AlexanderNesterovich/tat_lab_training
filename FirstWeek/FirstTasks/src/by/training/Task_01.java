package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_01 {

    private int[] num;
    private String tmp;

    public Task_01(Number number) {
        tmp = number.toString();
        tmp = tmp.replaceAll("\\D+","");
    }

    public boolean calculate() {
        if(tmp.length() != 4) {
            return false;
        }

        num = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++){
            num[i] = tmp.charAt(i);
        }

        return num[0] + num[1] == num[tmp.length() - 1] + num[tmp.length() - 2];

    }

}
