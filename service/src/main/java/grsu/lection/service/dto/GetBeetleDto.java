package grsu.lection.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetBeetleDto {
    private Long id;
    private String name;
    private Integer legsCount;
    private String color;
    private BeetleBakeryDto bakery;
}
