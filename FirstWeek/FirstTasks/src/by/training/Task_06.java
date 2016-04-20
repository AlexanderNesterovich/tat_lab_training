package by.training;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/19/2016.
 */
public class Task_06 {

    List<BigDecimal> list = new LinkedList<BigDecimal>();

    public Task_06(Number... args) {
        for(Number n: args) {
            list.add(new BigDecimal(n.toString()));
        }
    }

    public BigDecimal getSpecialSum() {
        if (list.size() < 2) {
            return list.get(0);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0).add(list.get(list.size()-1));
    }



}
