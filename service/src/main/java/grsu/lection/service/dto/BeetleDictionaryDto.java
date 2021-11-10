package grsu.lection.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BeetleDictionaryDto {
    private Long id;
    private String name;
}
