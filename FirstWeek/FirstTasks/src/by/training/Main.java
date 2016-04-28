package by.training;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Task_01 task = new Task_01();
        System.out.println("Task_01: sum of first and last two digits: " + task.calculate(-111.1) + "\n");

        Task_02 task2 = new Task_02();
        System.out.println("Task_02: formula calc: " + task2.calculate(-123123_1231, 1.23232, 1.32323) + "\n");

        Task_03 task3 = new Task_03();
        System.out.println("Task_03: Triangle area: " + task3.getArea(5, 10));
        System.out.println("Task_03: Triangle perimeter: " + task3.getPeremiter(5, 10) + "\n");

        Task_04 task4 = new Task_04();
        System.out.println("Task_04: check range of coordinates: " + task4.check(-2, 0) + "\n");

        Task_05 task5 = new Task_05();
        System.out.println("Task_05: pow2 if positive pow4 if negative: " + task5.getPowA(-2));
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowB(0));
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowC(3) + "\n");

        Task_06 task6 = new Task_06();
        System.out.println("Task_06: sum of max and min: " + task6.getSpecialSum(-2, -4, 3) + "\n");

        Task_07 task7 = new Task_07();
        System.out.println("Task_07: formula calc within range: ");
        Utils.arrayPrinter(task7.getTable(0d, 10d, 2d), 7);


        Task_08 task8 = new Task_08();
        System.out.println("Task_08: sum of multi: " + task8.getSpecialSum(2, 2, 4, 6, 3, 3, 3) + "\n");

        Task_09 task9 = new Task_09();
        System.out.println("Task_09: array: " + Arrays.toString(task9.merge(new Integer[]{1, 1, 1, 1, 1, 1, 1}, new Integer[]{3, 2, 3, 3}, 3)) + "\n");

        Task_10 task10 = new Task_10();
        System.out.println("Task_10: matrix");
        Utils.arrayPrinter(task10.generateMatrix(6), 3);
    }
}