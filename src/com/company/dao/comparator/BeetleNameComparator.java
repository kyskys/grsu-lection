package com.company.dao.comparator;

import com.company.model.Beetle;

import java.util.Comparator;

public class BeetleNameComparator implements Comparator<Beetle> {

    @Override
    public int compare(Beetle o1, Beetle o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
