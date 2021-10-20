package dao.comparator;

import grsu.lection.model.Beetle;

import java.util.Comparator;

public class BeetleColorComparator implements Comparator<Beetle> {
    @Override
    public int compare(Beetle o1, Beetle o2) {
        return Integer.compare(o1.getColor().getRGB(), o2.getColor().getRGB());
    }
}
