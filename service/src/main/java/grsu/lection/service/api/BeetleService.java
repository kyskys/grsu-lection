package grsu.lection.service.api;

import grsu.lection.service.dto.*;

import java.util.List;

public interface BeetleService {
    void save(CreateBeetleDto entity);

    void update(UpdateBeetleDto entity);

    void delete(Long id);

    GetBeetleDto getById(Long id);

    List<GetBeetleDto> getAll();

    List<GetBeetleDto> getAllSortedBy(String name);

    String eatBread(Long beetleId, Long breadId);

    List<GetBeetleDto> findAllByName(String name);

    List<BeetleDictionaryDto> getDictionary();
}
