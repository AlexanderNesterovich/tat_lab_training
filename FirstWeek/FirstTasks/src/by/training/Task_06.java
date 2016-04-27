package by.training;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */

// Написать программу нахождения суммы большего и меньшего из трех чисел.

public class Task_06 {

    private List<BigDecimal> list = new LinkedList<>();

    public Task_06(Number... args) {
        for(Number n: args) {
            list.add(new BigDecimal(n.toString()));
        }
    }

    public BigDecimal getSpecialSum() {
        if (list.size() < 2) {
            throw new IllegalArgumentException("Not enough arguments!");
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0).add(list.get(list.size()-1));
    }



}
