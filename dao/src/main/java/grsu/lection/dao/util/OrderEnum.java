package grsu.lection.dao.util;

import java.util.Optional;

public enum OrderEnum {
    ASC,
    DESC;

    public static boolean isDesc(OrderEnum order) {
        return Optional.ofNullable(order).orElse(OrderEnum.DESC) == OrderEnum.DESC;
    }
}
