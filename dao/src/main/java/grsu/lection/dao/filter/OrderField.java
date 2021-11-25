package grsu.lection.dao.filter;

import grsu.lection.dao.util.OrderEnum;
import lombok.Data;

@Data
public class OrderField {
    private String field;
    private OrderEnum order;
}
