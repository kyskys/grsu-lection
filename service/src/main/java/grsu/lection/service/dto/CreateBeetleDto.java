package grsu.lection.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBeetleDto {
    private String name;
    private Integer legsCount;
    private String color;
    private Long bakery;
}
