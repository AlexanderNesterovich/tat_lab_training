package by.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_04 {

    private int checkX;
    private int checkY;
    private List<Rectangle> list = new ArrayList<Rectangle>();

    public Task_04(int x, int y) {
        checkX = x;
        checkY = y;
        list.add(new Rectangle(-2, 2, 0, 4));
        list.add(new Rectangle(-4, 4, 0, -3));
    }

    public boolean check() {
        for(Rectangle r: list) {
            if ((checkX >= r.getX1() && checkX <= r.getX2()) && (checkY >= r.getY1() && checkY <= r.getY2())) {
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
