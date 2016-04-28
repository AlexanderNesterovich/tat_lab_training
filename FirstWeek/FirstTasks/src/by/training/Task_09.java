package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Заданы два одномерных массива с различным количеством элементов и натуральное число k.
// Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого.

public class Task_09 {

    public Object[] merge(Object[] arr1, Object[] arr2, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Negative index!");
    }
    Object[] arr3 = new Object[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, position);
        System.arraycopy(arr2, 0, arr3, position, arr2.length);
        System.arraycopy(arr1, position, arr3, position + arr2.length, arr1.length-position);
        return arr3;
    }
}
