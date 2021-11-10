package grsu.lection.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
public class UpdateBeetleDto {
    private String name;
    private Integer legsCount;
    private String color;
    private Long bakeryId;
}
