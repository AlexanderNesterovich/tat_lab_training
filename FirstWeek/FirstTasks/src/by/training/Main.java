package by.training;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        System.out.println("Task_01: sum of first and last two digits: " + tasks.calculateTask01(1234) + "\n");
        System.out.println("Task_02: formula calc: " + tasks.calculateTask02(-123123_1231, 1.23232, 1.32323) + "\n");

        Task_03 task3 = new Task_03(5, 10);
        System.out.println("Task_03: Triangle area: " + task3.getArea());
        System.out.println("Task_03: Triangle perimeter: " + task3.getPeremiter() + "\n");

        Task_04 task4 = new Task_04(-2, 0);
        System.out.println("Task_04: check range of coordinates: " + task4.check() + "\n");

        Task_05 task5 = new Task_05(-2, 0, 3);
        System.out.println("Task_05: pow2 if positive pow4 if negative: " + task5.getPowA());
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowB());
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowC() + "\n");

        Task_06 task6 = new Task_06(-2, -4, 3);
        System.out.println("Task_06: sum of max and min: " + task6.getSpecialSum() + "\n");

        Task_07 task7 = new Task_07(0d, 10d, 2d);
        System.out.println("Task_07: formula calc within range: ");
        Utils.arrayPrinter(task7.getTable(), 7);


        Task_08 task8 = new Task_08(2, 2, 4, 6, 3, 3, 3);
        System.out.println("Task_08: sum of multi: " + task8.getSpecialSum() + "\n");

        Task_09 task9 = new Task_09(new Integer[]{1, 1, 1, 1, 1, 1, 1}, new Integer[]{3, 2, 3, 3}, 3);
        System.out.println("Task_09: array: " + Arrays.toString(task9.merge()) + "\n");

        Task_10 task10 = new Task_10(6);
        System.out.println("Task_10: matrix");
        Utils.arrayPrinter(task10.generateMatrix(), 3);
    }
}
