package grsu.lection.dao.comparator;

import grsu.lection.model.Beetle;

import java.util.Comparator;

public class BeetleNameComparator implements Comparator<Beetle> {

    @Override
    public int compare(Beetle o1, Beetle o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
