package grsu.lection.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBeetleDto {
    private String name;
    private Integer legsCount;
    private String color;
    private Long bakery;
}
