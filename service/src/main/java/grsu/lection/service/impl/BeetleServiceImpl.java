package grsu.lection.service.impl;

import grsu.lection.common.util.RandomUtil;
import grsu.lection.dao.api.BakeryDao;
import grsu.lection.dao.api.BeetleDao;
import grsu.lection.dao.api.BreadDao;
import grsu.lection.model.Bakery;
import grsu.lection.model.Beetle;
import grsu.lection.model.Bread;
import grsu.lection.service.api.BeetleService;
import grsu.lection.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeetleServiceImpl implements BeetleService {

    private final BeetleDao beetleDao;
    private final BreadDao breadDao;
    private final BakeryDao bakeryDao;

    @Override
    @Transactional
    public void save(CreateBeetleDto dto) {
        Bakery bakery = bakeryDao.getById(dto.getBakery());
        Beetle beetle = Beetle.builder()
                .name(dto.getName())
                .legsCount(dto.getLegsCount())
                .color(dto.getColor())
                .bakery(bakery)
                .build();
        beetleDao.save(beetle);
    }

    @Override
    public void update(UpdateBeetleDto entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public GetBeetleDto getById(Long id) {
        Beetle beetle = beetleDao.getById(id);
        return GetBeetleDto.builder()
                .id(beetle.getId())
                .color(Optional.ofNullable(beetle.getColor()).map(Objects::toString).orElse(null))
                .legsCount(beetle.getLegsCount())
                .name(beetle.getName())
                .bakery(
                        BeetleBakeryDto.builder()
                                .id(beetle.getBakery().getId())
                                .name(Optional.ofNullable(beetle.getBakery()).map(Bakery::getName).orElse(null))
                                .build()
                )
                .build();
    }

    @Override
    public List<GetBeetleDto> getAll() {
        return beetleDao.getAll().stream().map(
                beetle -> GetBeetleDto.builder()
                        .id(beetle.getId())
                        .color(Optional.ofNullable(beetle.getColor()).map(Objects::toString).orElse(null))
                        .legsCount(beetle.getLegsCount())
                        .name(beetle.getName())
                        .bakery(
                                BeetleBakeryDto.builder()
                                        .id(beetle.getBakery().getId())
                                        .name(Optional.ofNullable(beetle.getBakery()).map(Bakery::getName).orElse(null))
                                        .build()
                        )
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<GetBeetleDto> getAllSortedBy(String name) {
        return null;
    }

//    @Override
//    public List<BeetleDto> getAllSortedBy(String columnName) {
//        if ("name".equals(columnName)) {
//            return beetleDao.getAllSortedByName();
//        } else if ("legsCount".equals(columnName)) {
//            return beetleDao.getAllSortedByLegsCount();
//        } else if ("color".equals(columnName)) {
//            return beetleDao.getAllSortedByColor();
//        }
//
//        return null;
//    }

    @Override
    public String eatBread(Long beetleId, Long breadId) {
        Beetle beetle = beetleDao.getById(beetleId);
        Bread bread = breadDao.getById(breadId);

        if (Math.random() > 0.5) {
            return "Жук " + beetle.getName() + " подорвался на мине (хлебушке)!";
        } else {
            breadDao.delete(breadId);
            int numberOfClones = RandomUtil.randomInt(0, 5);
            for (int i = 0; i < numberOfClones; i++) {
                Beetle cloneBeetle = new Beetle(beetle);
                cloneBeetle.setName(cloneBeetle.getName() + i);
                beetleDao.save(cloneBeetle);
            }
            return "Жук " + beetle.getName() + "скушал хлеб и размножился! Теперь у него личная армия!";
        }
    }

    @Override
    public List<GetBeetleDto> findAllByName(String name) {
        return beetleDao.findAllByName(name).stream().map(
                beetle -> GetBeetleDto.builder()
                        .id(beetle.getId())
                        .color(Optional.ofNullable(beetle.getColor()).map(Objects::toString).orElse(null))
                        .legsCount(beetle.getLegsCount())
                        .name(beetle.getName())
                        .bakery(
                                BeetleBakeryDto.builder()
                                        .id(beetle.getBakery().getId())
                                        .name(Optional.ofNullable(beetle.getBakery()).map(Bakery::getName).orElse(null))
                                        .build()
                        )
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<BeetleDictionaryDto> getDictionary() {
        return beetleDao.getAll().stream().map(beetle ->
                BeetleDictionaryDto.builder()
                        .id(beetle.getId())
                        .name(beetle.getName())
                        .build()).collect(Collectors.toList());
    }
}
