package grsu.lection.dao.filter;

import lombok.Data;

@Data
public class BeetleSearch {
    private Long id;
    private String name;
    private Integer legsCount;
    private String color;
    private Long bakeryId;
    private OrderField order;
}
