package by.training;

import java.util.Arrays;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_09 {

    private int[] arr1;
    private int[] arr2;
    private int position;

    public Task_09(int[] arr1, int[] arr2, int position) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.position = position;
    }

//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    public int[] merge() {
        int[] arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, position);
        System.arraycopy(arr2, 0, arr3, position, arr2.length);
        System.arraycopy(arr1, position, arr3, position + arr2.length, arr1.length-position);
        return arr3;
    }
}
