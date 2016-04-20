package by.training;

public class Main {

    public static void main(String[] args) {
        Task_01 task = new Task_01(-111.1);
        System.out.println("Task_01: sum of first and last two digits: " + task.calculate());

        Task_02 task2 = new Task_02(-123123_1231, 1.23232, 1.32323);
        System.out.println("Task_02: formula calc: " + task2.calculate());

        Task_03 task3 = new Task_03(5, 10);
        System.out.println("Task_03: Triangle area: " + task3.getArea());
        System.out.println("Task_03: Triangle peremiter: " + task3.getPeremiter());

        Task_04 task4 = new Task_04(-2, 0);
        System.out.println("Task_04: check range of coordinates: " + task4.check());

        Task_05 task5 = new Task_05(-2, 0, 3);
        System.out.println("Task_05: pow2 if positive pow4 if negative: " + task5.getPowA());
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowB());
        System.out.println("Task_05: pow2 if positive pow4 if negative:: " + task5.getPowC());

        Task_06 task6 = new Task_06(-2, -4, 3);
        System.out.println("Task_06: sum of max and min: " + task6.getSpecialSum());

        Task_07 task7 = new Task_07(-3, 6, 3);
        System.out.println("Task_07: formula calc within range: ");
        task7.printTable();

        Task_08 task8 = new Task_08(new int[]{2, 4, 6, 3, 3, 3}, 2);
        System.out.println("Task_06: sum of multi: " + task8.getSpecialSum());
    }
}
