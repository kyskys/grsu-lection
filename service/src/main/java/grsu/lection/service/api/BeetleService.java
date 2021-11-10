package grsu.lection.service.api;

import grsu.lection.service.dto.BeetleDictionaryDto;
import grsu.lection.service.dto.CreateBeetleDto;
import grsu.lection.service.dto.GetBeetleDto;
import grsu.lection.service.dto.UpdateBeetleDto;

import java.util.List;

public interface BeetleService {
    void save(CreateBeetleDto entity);
    void update(UpdateBeetleDto entity);
    void delete(Long id);
    GetBeetleDto getById(Long id);
    List<GetBeetleDto> getAll();
    List<GetBeetleDto> getAllSortedBy(String name);
    String eatBread(Long beetleId, Long breadId);

    List<BeetleDictionaryDto> getDictionary();
}
