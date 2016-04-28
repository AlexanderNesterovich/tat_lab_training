package by.training;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Для данных областей составить линейную программу,
// которая печатает true,
// если точка с координатами (х, у) принадлежит закрашенной области,
// и false — в противном случае:

public class Task_04 {

    public boolean check(int x, int y, Rectangle... arr) {
        for (Rectangle r : arr) {
            if ((x >= r.getX1() && x <= r.getX2()) && (y >= r.getY1() && y <= r.getY2())) {
                return true;
            }
        }
        return false;
    }

}

class Rectangle{
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Rectangle(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
