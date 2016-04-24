package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Заданы два одномерных массива с различным количеством элементов и натуральное число k.
// Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого.

public class Task_09 {

    private Object[] arr1;
    private Object[] arr2;
    private int position;

    public Task_09(Object[] arr1, Object[] arr2, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("negative index");
        }
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.position = position;
    }

//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
public Object[] merge() {
    position = position;
    Object[] arr3 = new Object[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, position);
        System.arraycopy(arr2, 0, arr3, position, arr2.length);
        System.arraycopy(arr1, position, arr3, position + arr2.length, arr1.length-position);
        return arr3;
    }
}
